function KanBanService($resource, $q) {

    var resource = $resource('api/search-support', {}, {

        project_items: { method: 'POST', url: 'api/project/items' },
        project_item: { method: 'POST', url: 'api/project/item' },
        project_count: { method: 'POST', url: 'api/project/count' },
        project_update: { method: 'POST', url: 'api/project/update' },
        project_enable: { method: 'POST', url: 'api/project/enable' },
        project_disable: { method: 'POST', url: 'api/project/disable' },
        project_create: { method: 'POST', url: 'api/project/create' },
        project_editable: { method: 'POST', url: 'api/project/editable' },

        topic_items: { method: 'POST', url: 'api/topic/items' },
        topic_item: { method: 'POST', url: 'api/topic/item' },
        topic_count: { method: 'POST', url: 'api/topic/count' },
        topic_update: { method: 'POST', url: 'api/topic/update' },
        topic_enable: { method: 'POST', url: 'api/topic/enable' },
        topic_disable: { method: 'POST', url: 'api/topic/disable' },
        topic_create: { method: 'POST', url: 'api/topic/create' },
        topic_editable: { method: 'POST', url: 'api/topic/editable' },
        topic_filters: { method: 'POST', url: 'api/topic/filters' },

        meta_group_items: { method: 'POST', url: 'api/meta-group/items' },
        meta_group_item: { method: 'POST', url: 'api/meta-group/item' },
        meta_group_count: { method: 'POST', url: 'api/meta-group/count' },
        meta_group_update: { method: 'POST', url: 'api/meta-group/update' },
        meta_group_enable: { method: 'POST', url: 'api/meta-group/enable' },
        meta_group_disable: { method: 'POST', url: 'api/meta-group/disable' },
        meta_group_create: { method: 'POST', url: 'api/meta-group/create' },
        meta_group_editable: { method: 'POST', url: 'api/meta-group/editable' },

        meta_category_items: { method: 'POST', url: 'api/meta-category/items' },
        meta_category_item: { method: 'POST', url: 'api/meta-category/item' },
        meta_category_count: { method: 'POST', url: 'api/meta-category/count' },
        meta_category_update: { method: 'POST', url: 'api/meta-category/update' },
        meta_category_enable: { method: 'POST', url: 'api/meta-category/enable' },
        meta_category_disable: { method: 'POST', url: 'api/meta-category/disable' },
        meta_category_create: { method: 'POST', url: 'api/meta-category/create' },
        meta_category_editable: { method: 'POST', url: 'api/meta-category/editable' },

        user_profile: { method: 'POST', url: 'api/user/profile' }
    });

    return {

        project_items: function (request) { var d = $q.defer(); resource.project_items({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_item: function (request) { var d = $q.defer(); resource.project_item({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_update: function (request) { var d = $q.defer(); resource.project_update({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_count: function (request) { var d = $q.defer(); resource.project_count({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_enable: function (request) { var d = $q.defer(); resource.project_enable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_disable: function (request) { var d = $q.defer(); resource.project_disable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_create: function (request) { var d = $q.defer(); resource.project_create({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        project_editable: function (request) { var d = $q.defer(); resource.project_editable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },

        topic_items: function (request) { var d = $q.defer(); resource.topic_items({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_item: function (request) { var d = $q.defer(); resource.topic_item({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_update: function (request) { var d = $q.defer(); resource.topic_update({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_count: function (request) { var d = $q.defer(); resource.topic_count({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_enable: function (request) { var d = $q.defer(); resource.topic_enable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_disable: function (request) { var d = $q.defer(); resource.topic_disable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_create: function (request) { var d = $q.defer(); resource.topic_create({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_editable: function (request) { var d = $q.defer(); resource.topic_editable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        topic_filters: function (request) { var d = $q.defer(); resource.topic_filters({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },

        meta_group_items: function (request) { var d = $q.defer(); resource.meta_group_items({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_item: function (request) { var d = $q.defer(); resource.meta_group_item({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_update: function (request) { var d = $q.defer(); resource.meta_group_update({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_count: function (request) { var d = $q.defer(); resource.meta_group_count({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_enable: function (request) { var d = $q.defer(); resource.meta_group_enable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_disable: function (request) { var d = $q.defer(); resource.meta_group_disable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_create: function (request) { var d = $q.defer(); resource.meta_group_create({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_group_editable: function (request) { var d = $q.defer(); resource.meta_group_editable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },

        meta_category_items: function (request) { var d = $q.defer(); resource.meta_category_items({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_item: function (request) { var d = $q.defer(); resource.meta_category_item({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_update: function (request) { var d = $q.defer(); resource.meta_category_update({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_count: function (request) { var d = $q.defer(); resource.meta_category_count({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_enable: function (request) { var d = $q.defer(); resource.meta_category_enable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_disable: function (request) { var d = $q.defer(); resource.meta_category_disable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_create: function (request) { var d = $q.defer(); resource.meta_category_create({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },
        meta_category_editable: function (request) { var d = $q.defer(); resource.meta_category_editable({}, request, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; },

        user_profile: function () { var d = $q.defer(); resource.user_profile({}, function (result) { d.resolve(result); }, function (result) { d.reject(result); }); return d.promise; }
    }
}
