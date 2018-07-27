package cn.canos.kanban.controller;

import cn.canos.kanban.controller.request.*;
import cn.canos.kanban.controller.response.*;
import cn.canos.kanban.filter.ITopicFilterProvider;
import cn.canos.kanban.convertor.ITopicConvertor;
import cn.canos.kanban.repository.ITopicRepository;
import cn.canos.kanban.repository.criteria.TopicCriteria;
import cn.canos.kanban.repository.entity.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author canos
 */
@RestController
@RequestMapping("/api/topic")
public class TopicController extends BaseController {

    /**
     * 分页，每页个数
     */
    private final static int PAGE_SIZE = 15;

    @Autowired
    ITopicRepository topicRepository;

    @Autowired
    ITopicConvertor topicConvertor;

    @Autowired
    ITopicFilterProvider topicFilterProvider;

    @RequestMapping(path = "items", method = RequestMethod.POST)
    @ResponseBody
    public TopicItemsResponse items(@RequestBody TopicItemsRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicItemsResponse response = new TopicItemsResponse();

        List<TopicEntity> entityList = topicRepository.getEntityListByCriteria(toTopicCriteria(request), request.getPageIndex(), PAGE_SIZE);

        response.setItems(topicConvertor.toVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "count", method = RequestMethod.POST)
    @ResponseBody
    public TopicCountResponse count(@RequestBody TopicCountRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicCountResponse response = new TopicCountResponse();
        int count = topicRepository.getCountByCriteria(toTopicCriteria(request));

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "item", method = RequestMethod.POST)
    @ResponseBody
    public TopicItemResponse item(@RequestBody TopicItemRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicItemResponse response = new TopicItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        TopicEntity entity = topicRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(topicConvertor.toVo(entity, false));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "filters", method = RequestMethod.POST)
    @ResponseBody
    public TopicFiltersResponse filters(@RequestBody TopicFiltersRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicFiltersResponse response = new TopicFiltersResponse();

        response.setFilterGroups(topicFilterProvider.getFilters());

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    @ResponseBody
    public TopicCreateResponse create(@RequestBody TopicCreateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicCreateResponse response = new TopicCreateResponse();

        topicRepository.create(topicConvertor.toEntity(request.getItem()));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "editable", method = RequestMethod.POST)
    @ResponseBody
    public TopicEditableResponse editable(@RequestBody TopicEditableRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicEditableResponse response = new TopicEditableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        TopicEntity entity = topicRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(topicConvertor.toVo(entity, true));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "update", method = RequestMethod.POST)
    @ResponseBody
    public TopicUpdateResponse update(@RequestBody TopicUpdateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        TopicUpdateResponse response = new TopicUpdateResponse();

        if (request.getItem().getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        TopicEntity entity = topicRepository.getById(request.getItem().getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        topicRepository.update(topicConvertor.toEntity(request.getItem()));

        response.setStatus(1);
        return response;
    }

    private static TopicCriteria toTopicCriteria(TopicCountRequest request) {

        TopicCriteria criteria = new TopicCriteria();

        criteria.setGroupIdList(request.getTheGroupIdList());
        criteria.setCategoryId(request.getTheCategoryId());

        return criteria;
    }
}
