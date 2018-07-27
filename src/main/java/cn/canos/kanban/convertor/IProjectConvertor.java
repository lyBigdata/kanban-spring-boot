package cn.canos.kanban.convertor;

import cn.canos.kanban.repository.entity.ProjectEntity;
import cn.canos.kanban.vo.ProjectVo;

import java.util.List;

/**
 * @author canos
 */
public interface IProjectConvertor {

    /**
     * vo 转换为 entity
     * @param vo 需要转换的 vo
     * @return 转换之后的 entity
     */
    ProjectEntity toEntity(ProjectVo vo);

    /**
     * entity 转换为 vo
     * @param entity 需要转换的 entity
     * @param isEditable 使用用于编辑
     * @return 转换之后的 vo
     */
    ProjectVo toVo(ProjectEntity entity, boolean isEditable);

    /**
     * voList 转换为 entityList
     * @param voList 需要转换的 voList
     * @return 转换之后的 entityList
     */
    List<ProjectEntity> toEntityList(List<ProjectVo> voList);

    /**
     * entityList 转换为 voList
     * @param entityList 需要转换的 entityList
     * @return 转换之后的 voList
     */
    List<ProjectVo> toVoList(List<ProjectEntity> entityList);
}
