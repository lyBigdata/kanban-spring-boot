package cn.canos.kanban.repository.mock;

import cn.canos.kanban.repository.IProjectRepository;
import cn.canos.kanban.repository.entity.ProjectEntity;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author canos
 */
@Repository
public class MockProjectRepository implements IProjectRepository {

    private final static List<ProjectEntity> ENTITY_LIST;

    private final static int ENTITY_LIST_SIZE = 15;

    static {
        ENTITY_LIST = Lists.newArrayListWithCapacity(32);

        Random random = new Random();
        for (int i = 0; i < ENTITY_LIST_SIZE; i++) {
            ProjectEntity entity = new ProjectEntity();

            entity.setId((long) (i + 1));
            entity.setProjectId(Math.abs(random.nextInt() % 6) + 1);
            entity.setTitle("Title" + random.nextInt() % 100);

            ENTITY_LIST.add(entity);
        }
    }

    @Override
    public List<ProjectEntity> getEntityList() {

        return ENTITY_LIST;
    }

    @Override
    public List<ProjectEntity> getEntityList(int pageIndex, int pageSize) {

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return ENTITY_LIST.subList(pageParam.getFromIndex(), pageParam.getToIndex());
    }

    @Override
    public ProjectEntity getById(long id) {

        for (ProjectEntity entity : ENTITY_LIST) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public int getCount() {

        return ENTITY_LIST.size();
    }

    @Override
    public void create(ProjectEntity entity) {

        entity.setId((long) ENTITY_LIST.size() + 1);
        ENTITY_LIST.add(entity);
    }

    @Override
    public void update(ProjectEntity entity) {

        ProjectEntity entityToUpdate = getById(entity.getId());
        if (entityToUpdate != null) {
            entityToUpdate.setProjectId(entity.getProjectId());
            entityToUpdate.setTitle(entity.getTitle());
        }
    }

    @Override
    public List<ProjectEntity> getEntityListBySample(ProjectEntity entity) {

        Stream<ProjectEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getProjectEntityStream(entity, returnValue);

        return returnValue.collect(Collectors.toList());
    }

    @Override
    public List<ProjectEntity> getEntityListBySample(ProjectEntity entity, int pageIndex, int pageSize) {

        Stream<ProjectEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getProjectEntityStream(entity, returnValue);

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return returnValue.skip(pageParam.getFromIndex()).limit(pageParam.getToIndex()).collect(Collectors.toList());
    }

    @Override
    public int getCountBySample(ProjectEntity entity) {

        Stream<ProjectEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getProjectEntityStream(entity, returnValue);

        return (int)returnValue.count();
    }

    private Stream<ProjectEntity> getProjectEntityStream(ProjectEntity entity, Stream<ProjectEntity> returnValue) {

        if (entity.getId() != null) {
            returnValue = returnValue.filter(v -> entity.getId().equals(v.getId()));
        }
        if (entity.getProjectId() != null) {
            returnValue = returnValue.filter(v -> entity.getProjectId().equals(v.getProjectId()));
        }
        if (entity.getTitle() != null) {
            returnValue = returnValue.filter(v -> entity.getTitle().equals(v.getTitle()));
        }

        return returnValue;
    }
}
