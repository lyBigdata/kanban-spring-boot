package cn.canos.kanban.controller;

import cn.canos.kanban.controller.request.*;
import cn.canos.kanban.controller.response.*;
import cn.canos.kanban.convertor.IMetaCategoryConvertor;
import cn.canos.kanban.repository.IMetaCategoryRepository;
import cn.canos.kanban.meta.IMetaCategoryMeta;
import cn.canos.kanban.repository.entity.MetaCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author canos
 */
@RestController
@RequestMapping("/api/meta-category")
public class MetaCategoryController extends BaseController {

    /**
     * 分页，每页个数
     */
    private final static int PAGE_SIZE = 15;

    @Autowired
    IMetaCategoryRepository metaCategoryRepository;

    @Autowired
    IMetaCategoryConvertor metaCategoryConvertor;

    @Autowired
    IMetaCategoryMeta metaCategoryMeta;

    @RequestMapping(path = "items", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryItemsResponse items(@RequestBody MetaCategoryItemsRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryItemsResponse response = new MetaCategoryItemsResponse();

        List<MetaCategoryEntity> entityList = metaCategoryRepository.getEntityList(request.getPageIndex(), PAGE_SIZE);

        response.setItems(metaCategoryConvertor.toVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "count", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryCountResponse count(@RequestBody MetaCategoryCountRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryCountResponse response = new MetaCategoryCountResponse();

        int count = metaCategoryRepository.getCount();

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "item", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryItemResponse item(@RequestBody MetaCategoryItemRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryItemResponse response = new MetaCategoryItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaCategoryEntity entity = metaCategoryRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(metaCategoryConvertor.toVo(entity, false));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryCreateResponse create(@RequestBody MetaCategoryCreateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryCreateResponse response = new MetaCategoryCreateResponse();

        metaCategoryRepository.create(metaCategoryConvertor.toEntity(request.getItem()));

        metaCategoryMeta.refresh();

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "editable", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryEditableResponse editable(@RequestBody MetaCategoryEditableRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryEditableResponse response = new MetaCategoryEditableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaCategoryEntity entity = metaCategoryRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(metaCategoryConvertor.toVo(entity, true));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "update", method = RequestMethod.POST)
    @ResponseBody
    public MetaCategoryUpdateResponse update(@RequestBody MetaCategoryUpdateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        MetaCategoryUpdateResponse response = new MetaCategoryUpdateResponse();

        if (request.getItem().getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        MetaCategoryEntity entity = metaCategoryRepository.getById(request.getItem().getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        metaCategoryRepository.update(metaCategoryConvertor.toEntity(request.getItem()));

        metaCategoryMeta.refresh();

        response.setStatus(1);
        return response;
    }
}
