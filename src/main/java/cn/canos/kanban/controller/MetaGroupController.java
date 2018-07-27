package cn.canos.kanban.controller;

import cn.canos.kanban.controller.request.*;
import cn.canos.kanban.controller.response.*;
import cn.canos.kanban.convertor.IMetaGroupConvertor;
import cn.canos.kanban.repository.IMetaGroupRepository;
import cn.canos.kanban.meta.IMetaGroupMeta;
import cn.canos.kanban.repository.entity.MetaGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author canos
 */
@RestController
@RequestMapping("/api/meta-group")
public class MetaGroupController extends BaseController {

    /**
     * 分页，每页个数
     */
    private final static int PAGE_SIZE = 15;

    @Autowired
    IMetaGroupRepository metaGroupRepository;

    @Autowired
    IMetaGroupConvertor metaGroupConvertor;

    @Autowired
    IMetaGroupMeta metaGroupMeta;

    @RequestMapping(path = "items", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupItemsResponse items(@RequestBody MetaGroupItemsRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupItemsResponse response = new MetaGroupItemsResponse();

        List<MetaGroupEntity> entityList = metaGroupRepository.getEntityList(request.getPageIndex(), PAGE_SIZE);

        response.setItems(metaGroupConvertor.toVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "count", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupCountResponse count(@RequestBody MetaGroupCountRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupCountResponse response = new MetaGroupCountResponse();

        int count = metaGroupRepository.getCount();

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "item", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupItemResponse item(@RequestBody MetaGroupItemRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupItemResponse response = new MetaGroupItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaGroupEntity entity = metaGroupRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(metaGroupConvertor.toVo(entity, false));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupCreateResponse create(@RequestBody MetaGroupCreateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupCreateResponse response = new MetaGroupCreateResponse();

        metaGroupRepository.create(metaGroupConvertor.toEntity(request.getItem()));

        metaGroupMeta.refresh();

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "editable", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupEditableResponse editable(@RequestBody MetaGroupEditableRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupEditableResponse response = new MetaGroupEditableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaGroupEntity entity = metaGroupRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(metaGroupConvertor.toVo(entity, true));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "update", method = RequestMethod.POST)
    @ResponseBody
    public MetaGroupUpdateResponse update(@RequestBody MetaGroupUpdateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaGroupUpdateResponse response = new MetaGroupUpdateResponse();

        if (request.getItem().getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaGroupEntity entity = metaGroupRepository.getById(request.getItem().getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        metaGroupRepository.update(metaGroupConvertor.toEntity(request.getItem()));

        metaGroupMeta.refresh();

        response.setStatus(1);
        return response;
    }
}
