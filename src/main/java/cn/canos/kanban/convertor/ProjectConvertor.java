package cn.canos.kanban.convertor;

import cn.canos.kanban.repository.entity.*;
import cn.canos.kanban.utility.StringJoiner;
import cn.canos.kanban.utility.StringSpliter;
import cn.canos.kanban.vo.*;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author canos
 */
@Component
public class ProjectConvertor implements IProjectConvertor {

    @Override
    public ProjectEntity toEntity(ProjectVo vo) {

        ProjectEntity entity = new ProjectEntity();

        entity.setId(vo.getId());
        entity.setProjectId(vo.getProjectId());
        entity.setTitle(vo.getTitle());

        return entity;
    }

    @Override
    public ProjectVo toVo(ProjectEntity entity, boolean isEditable) {

        ProjectVo vo = new ProjectVo();

        vo.setId(entity.getId());
        vo.setProjectId(entity.getProjectId());
        vo.setTitle(entity.getTitle());

        return vo;
    }

    @Override
    public List<ProjectEntity> toEntityList(List<ProjectVo> voList) {

        if (voList == null || voList.isEmpty()) {
            return null;
        }

        List<ProjectEntity> entityList = Lists.newArrayListWithCapacity(voList.size());
        for (ProjectVo vo : voList) {
            entityList.add(toEntity(vo));
        }

        return entityList;
    }

    @Override
    public List<ProjectVo> toVoList(List<ProjectEntity> entityList) {

        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<ProjectVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (ProjectEntity entity : entityList) {
            voList.add(toVo(entity, false));
        }

        return voList;
    }
}
