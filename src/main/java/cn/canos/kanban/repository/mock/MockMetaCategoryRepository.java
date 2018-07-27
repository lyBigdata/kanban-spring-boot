package cn.canos.kanban.repository.mock;

import cn.canos.kanban.repository.IMetaCategoryRepository;
import cn.canos.kanban.repository.entity.MetaCategoryEntity;
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
public class MockMetaCategoryRepository implements IMetaCategoryRepository {

    private final static List<MetaCategoryEntity> ENTITY_LIST;

    private final static int ENTITY_LIST_SIZE = 15;

    static {
        ENTITY_LIST = Lists.newArrayListWithCapacity(32);

        Random random = new Random();
        for (int i = 0; i < ENTITY_LIST_SIZE; i++) {
            MetaCategoryEntity entity = new MetaCategoryEntity();

            entity.setId((long) (i + 1));
            entity.setCategoryId(i + 1);
            entity.setCategoryName("CategoryName" + random.nextInt() % 100);

            ENTITY_LIST.add(entity);
        }
    }

    @Override
    public List<MetaCategoryEntity> getEntityList() {

        return ENTITY_LIST;
    }

    @Override
    public List<MetaCategoryEntity> getEntityList(int pageIndex, int pageSize) {

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return ENTITY_LIST.subList(pageParam.getFromIndex(), pageParam.getToIndex());
    }

    @Override
    public MetaCategoryEntity getById(long id) {

        for (MetaCategoryEntity entity : ENTITY_LIST) {
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
    public void create(MetaCategoryEntity entity) {

        entity.setId((long) ENTITY_LIST.size() + 1);
        ENTITY_LIST.add(entity);
    }

    @Override
    public void update(MetaCategoryEntity entity) {

        MetaCategoryEntity entityToUpdate = getById(entity.getId());
        if (entityToUpdate != null) {
            entityToUpdate.setCategoryId(entity.getCategoryId());
            entityToUpdate.setCategoryName(entity.getCategoryName());
        }
    }

    @Override
    public List<MetaCategoryEntity> getEntityListBySample(MetaCategoryEntity entity) {

        Stream<MetaCategoryEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaCategoryEntityStream(entity, returnValue);

        return returnValue.collect(Collectors.toList());
    }

    @Override
    public List<MetaCategoryEntity> getEntityListBySample(MetaCategoryEntity entity, int pageIndex, int pageSize) {

        Stream<MetaCategoryEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaCategoryEntityStream(entity, returnValue);

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return returnValue.skip(pageParam.getFromIndex()).limit(pageParam.getToIndex()).collect(Collectors.toList());
    }

    @Override
    public int getCountBySample(MetaCategoryEntity entity) {

        Stream<MetaCategoryEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getMetaCategoryEntityStream(entity, returnValue);

        return (int)returnValue.count();
    }

    private Stream<MetaCategoryEntity> getMetaCategoryEntityStream(MetaCategoryEntity entity, Stream<MetaCategoryEntity> returnValue) {

        if (entity.getId() != null) {
            returnValue = returnValue.filter(v -> entity.getId().equals(v.getId()));
        }
        if (entity.getCategoryId() != null) {
            returnValue = returnValue.filter(v -> entity.getCategoryId().equals(v.getCategoryId()));
        }
        if (entity.getCategoryName() != null) {
            returnValue = returnValue.filter(v -> entity.getCategoryName().equals(v.getCategoryName()));
        }

        return returnValue;
    }
}
