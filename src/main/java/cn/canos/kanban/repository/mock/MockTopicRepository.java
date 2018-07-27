package cn.canos.kanban.repository.mock;

import cn.canos.kanban.repository.ITopicRepository;
import cn.canos.kanban.repository.criteria.TopicCriteria;
import cn.canos.kanban.repository.entity.TopicEntity;
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
public class MockTopicRepository implements ITopicRepository {

    private final static List<TopicEntity> ENTITY_LIST;

    private final static int ENTITY_LIST_SIZE = 15;

    static {
        ENTITY_LIST = Lists.newArrayListWithCapacity(32);

        Random random = new Random();
        for (int i = 0; i < ENTITY_LIST_SIZE; i++) {
            TopicEntity entity = new TopicEntity();

            entity.setId((long) (i + 1));
            entity.setTitle("Title" + random.nextInt() % 100);
            entity.setGroupId(Math.abs(random.nextInt() % 6) + 1);
            entity.setCategoryId(Math.abs(random.nextInt() % 6) + 1);

            ENTITY_LIST.add(entity);
        }
    }

    @Override
    public List<TopicEntity> getEntityList() {

        return ENTITY_LIST;
    }

    @Override
    public List<TopicEntity> getEntityList(int pageIndex, int pageSize) {

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return ENTITY_LIST.subList(pageParam.getFromIndex(), pageParam.getToIndex());
    }

    @Override
    public TopicEntity getById(long id) {

        for (TopicEntity entity : ENTITY_LIST) {
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
    public void create(TopicEntity entity) {

        entity.setId((long) ENTITY_LIST.size() + 1);
        ENTITY_LIST.add(entity);
    }

    @Override
    public void update(TopicEntity entity) {

        TopicEntity entityToUpdate = getById(entity.getId());
        if (entityToUpdate != null) {
            entityToUpdate.setTitle(entity.getTitle());
            entityToUpdate.setGroupId(entity.getGroupId());
            entityToUpdate.setCategoryId(entity.getCategoryId());
        }
    }

    @Override
    public List<TopicEntity> getEntityListBySample(TopicEntity entity) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityStream(entity, returnValue);

        return returnValue.collect(Collectors.toList());
    }

    @Override
    public List<TopicEntity> getEntityListBySample(TopicEntity entity, int pageIndex, int pageSize) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityStream(entity, returnValue);

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return returnValue.skip(pageParam.getFromIndex()).limit(pageParam.getToIndex()).collect(Collectors.toList());
    }

    @Override
    public int getCountBySample(TopicEntity entity) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityStream(entity, returnValue);

        return (int)returnValue.count();
    }

    private Stream<TopicEntity> getTopicEntityStream(TopicEntity entity, Stream<TopicEntity> returnValue) {

        if (entity.getId() != null) {
            returnValue = returnValue.filter(v -> entity.getId().equals(v.getId()));
        }
        if (entity.getTitle() != null) {
            returnValue = returnValue.filter(v -> entity.getTitle().equals(v.getTitle()));
        }
        if (entity.getGroupId() != null) {
            returnValue = returnValue.filter(v -> entity.getGroupId().equals(v.getGroupId()));
        }
        if (entity.getCategoryId() != null) {
            returnValue = returnValue.filter(v -> entity.getCategoryId().equals(v.getCategoryId()));
        }

        return returnValue;
    }

    @Override
    public List<TopicEntity> getEntityListByCriteria(TopicCriteria criteria) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityCriteria(criteria, returnValue);

        return returnValue.collect(Collectors.toList());
    }

    @Override
    public List<TopicEntity> getEntityListByCriteria(TopicCriteria criteria, int pageIndex, int pageSize) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityCriteria(criteria, returnValue);

        PageParam pageParam = new PageParam(ENTITY_LIST.size(), pageIndex, pageSize).invoke();
        if (pageParam.isInvalid()) {
            return null;
        }

        return returnValue.skip(pageParam.getFromIndex()).limit(pageParam.getToIndex()).collect(Collectors.toList());
    }

    @Override
    public int getCountByCriteria(TopicCriteria criteria) {

        Stream<TopicEntity> returnValue = ENTITY_LIST.stream();

        returnValue = getTopicEntityCriteria(criteria, returnValue);

        return (int) returnValue.count();
    }

    private Stream<TopicEntity> getTopicEntityCriteria(TopicCriteria criteria, Stream<TopicEntity> returnValue) {

        if (criteria.getGroupIdList() != null && !criteria.getGroupIdList().isEmpty()) {
            returnValue = returnValue.filter(v -> criteria.getGroupIdList().contains(v.getGroupId()));
        }
        if (criteria.getCategoryId() != null) {
            returnValue = returnValue.filter(v -> criteria.getCategoryId().equals(v.getCategoryId()));
        }

        return returnValue;
    }
}
