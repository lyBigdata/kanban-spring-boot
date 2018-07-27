package cn.canos.kanban.controller;

import cn.canos.kanban.controller.request.*;
import cn.canos.kanban.controller.response.*;
import cn.canos.kanban.convertor.IProjectConvertor;
import cn.canos.kanban.repository.IProjectRepository;
import cn.canos.kanban.repository.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author canos
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController {

    /**
     * 分页，每页个数
     */
    private final static int PAGE_SIZE = 15;

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IProjectConvertor projectConvertor;

    @RequestMapping(path = "items", method = RequestMethod.POST)
    @ResponseBody
    public ProjectItemsResponse items(@RequestBody ProjectItemsRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectItemsResponse response = new ProjectItemsResponse();

        List<ProjectEntity> entityList = projectRepository.getEntityList(request.getPageIndex(), PAGE_SIZE);

        response.setItems(projectConvertor.toVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "count", method = RequestMethod.POST)
    @ResponseBody
    public ProjectCountResponse count(@RequestBody ProjectCountRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectCountResponse response = new ProjectCountResponse();

        int count = projectRepository.getCount();

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "item", method = RequestMethod.POST)
    @ResponseBody
    public ProjectItemResponse item(@RequestBody ProjectItemRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectItemResponse response = new ProjectItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ProjectEntity entity = projectRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(projectConvertor.toVo(entity, false));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    @ResponseBody
    public ProjectCreateResponse create(@RequestBody ProjectCreateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectCreateResponse response = new ProjectCreateResponse();

        projectRepository.create(projectConvertor.toEntity(request.getItem()));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "editable", method = RequestMethod.POST)
    @ResponseBody
    public ProjectEditableResponse editable(@RequestBody ProjectEditableRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectEditableResponse response = new ProjectEditableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ProjectEntity entity = projectRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(projectConvertor.toVo(entity, true));

        response.setStatus(1);
        return response;
    }

    @RequestMapping(path = "update", method = RequestMethod.POST)
    @ResponseBody
    public ProjectUpdateResponse update(@RequestBody ProjectUpdateRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        ProjectUpdateResponse response = new ProjectUpdateResponse();

        if (request.getItem().getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ProjectEntity entity = projectRepository.getById(request.getItem().getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        projectRepository.update(projectConvertor.toEntity(request.getItem()));

        response.setStatus(1);
        return response;
    }
}
