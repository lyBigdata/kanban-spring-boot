package cn.canos.kanban.meta;

import cn.canos.kanban.repository.IMetaGroupRepository;
import cn.canos.kanban.repository.entity.MetaGroupEntity;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author canos
 */
@Service
public class MetaGroupMeta implements IMetaGroupMeta {

    @Autowired
    IMetaGroupRepository metaGroupRepository;

    CacheLoader<String, List<MetaGroupEntity>> cacheLoader = new CacheLoader<String, List<MetaGroupEntity>>() {

        @Override
        public List<MetaGroupEntity> load(String s) throws Exception {

            return metaGroupRepository.getEntityList();
        }
    };

    LoadingCache<String, List<MetaGroupEntity>> loadingCache = CacheBuilder
            .newBuilder()
            .refreshAfterWrite(1, TimeUnit.HOURS)
            .build(cacheLoader);

    @Override
    public List<MetaGroupEntity> getEntityList() {

        try {

            return loadingCache.get("KEY");
        } catch (ExecutionException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void refresh() {

        loadingCache.refresh("KEY");
    }
}
