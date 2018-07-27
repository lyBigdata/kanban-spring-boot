package cn.canos.kanban.meta;

import cn.canos.kanban.repository.IMetaCategoryRepository;
import cn.canos.kanban.repository.entity.MetaCategoryEntity;
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
public class MetaCategoryMeta implements IMetaCategoryMeta {

    @Autowired
    IMetaCategoryRepository metaCategoryRepository;

    CacheLoader<String, List<MetaCategoryEntity>> cacheLoader = new CacheLoader<String, List<MetaCategoryEntity>>() {

        @Override
        public List<MetaCategoryEntity> load(String s) throws Exception {

            return metaCategoryRepository.getEntityList();
        }
    };

    LoadingCache<String, List<MetaCategoryEntity>> loadingCache = CacheBuilder
            .newBuilder()
            .refreshAfterWrite(1, TimeUnit.HOURS)
            .build(cacheLoader);

    @Override
    public List<MetaCategoryEntity> getEntityList() {

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
