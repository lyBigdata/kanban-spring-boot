package cn.canos.kanban.repository.mock;

import cn.canos.kanban.repository.IMetaGroupRepository;
import cn.canos.kanban.repository.entity.MetaGroupEntity;
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
public class MockMetaGroupRepository implements IMetaGroupRepository {

    private final static List<MetaGroupEntity> ENTITY_LIST;

    private final static int ENTITY_LIST_SIZE = 15;

    static {
        ENTITY_LIST = Lists.newArrayListWithCapacity(32);

        Random random = new Random();
        for (int i = 0; i < ENTITY_LIST_SIZE; i++) {
            MetaGroupEntity entity = new MetaGroupEntity();

            entity.setId((long) (i + 1));
            entity.setGroupId(i + 1);
            entity.setGroupName("GroupName" + random.nextInt() % 100);

            ENTITY_LIST.add(entity);
        }
    }

    @Override
    public List<MetaGroupEntity> getEntityList() {

        return ENTITY_LIST;
    }

    @Override
    public List<MetaGroupEntity> getEntityList(int pageIndex, int pageSize) {

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return ENTITY_LIST.subList(pageParam.getFromIndex(), pageParam.getToIndex());
    }

    @Override
    public MetaGroupEntity getById(long id) {

        for (MetaGroupEntity entity : ENTITY_LIST) {
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
    public void create(MetaGroupEntity entity) {

        entity.setId((long) ENTITY_LIST.size() + 1);
        ENTITY_LIST.add(entity);
    }

    @Override
    public void update(MetaGroupEntity entity) {

        MetaGroupEntity entityToUpdate = getById(entity.getId());
        if (entityToUpdate != null) {
            entityToUpdate.setGroupId(entity.getGroupId());
            entityToUpdate.setGroupName(entity.getGroupName());
        }
    }

    @Override
    public List<MetaGroupEntity> getEntityListBySample(MetaGroupEntity entity) {

        Stream<MetaGroupEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaGroupEntityStream(entity, returnValue);

        return returnValue.collect(Collectors.toList());
    }

    @Override
    public List<MetaGroupEntity> getEntityListBySample(MetaGroupEntity entity, int pageIndex, int pageSize) {

        Stream<MetaGroupEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaGroupEntityStream(entity, returnValue);

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return returnValue.skip(pageParam.getFromIndex()).limit(pageParam.getToIndex()).collect(Collectors.toList());
    }

    @Override
    public int getCountBySample(MetaGroupEntity entity) {

        Stream<MetaGroupEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaGroupEntityStream(entity, returnValue);

        return (int)returnValue.count();
    }

    private Stream<MetaGroupEntity> getMetaGroupEntityStream(MetaGroupEntity entity, Stream<MetaGroupEntity> returnValue) {

        if (entity.getId() != null) {
            returnValue = returnValue.filter(v -> entity.getId().equals(v.getId()));
        }
        if (entity.getGroupId() != null) {
            returnValue = returnValue.filter(v -> entity.getGroupId().equals(v.getGroupId()));
        }
        if (entity.getGroupName() != null) {
            returnValue = returnValue.filter(v -> entity.getGroupName().equals(v.getGroupName()));
        }

        return returnValue;
    }
}
