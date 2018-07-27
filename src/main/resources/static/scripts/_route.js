var route = function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when('', '/welcome').when('/', '/welcome');

    $stateProvider.state('app', {
        url: '/',
        views: {
            'header': { templateUrl: 'scripts/view/view_header.html?v=' + window.releaseNo, controller: HeaderController },
            'main-menu': { templateUrl: 'scripts/view/view_menu.html?v=' + window.releaseNo},
            'main-body': { template: '<div ui-view></div>' }
        }
    });

    $stateProvider.state('app.welcome', { url: 'welcome', templateUrl: 'scripts/view/view_welcome.html?v=' + window.releaseNo });

    $stateProvider.state('app.project-list', { url: 'project-list', templateUrl: 'scripts/view/view_project_list.html?v=' + window.releaseNo, controller: ProjectListController });
    $stateProvider.state('app.project-item', { url: 'project-item/:id', templateUrl: 'scripts/view/view_project_item.html?v=' + window.releaseNo, controller: ProjectItemController });
    $stateProvider.state('app.project-create', { url: 'project-create', templateUrl: 'scripts/view/view_project_create.html?v=' + window.releaseNo, controller: ProjectCreateController });
    $stateProvider.state('app.project-update', { url: 'project-update/:id', templateUrl: 'scripts/view/view_project_update.html?v=' + window.releaseNo, controller: ProjectUpdateController });

    $stateProvider.state('app.topic-list', { url: 'topic-list', templateUrl: 'scripts/view/view_topic_list.html?v=' + window.releaseNo, controller: TopicListController });
    $stateProvider.state('app.topic-item', { url: 'topic-item/:id', templateUrl: 'scripts/view/view_topic_item.html?v=' + window.releaseNo, controller: TopicItemController });
    $stateProvider.state('app.topic-create', { url: 'topic-create', templateUrl: 'scripts/view/view_topic_create.html?v=' + window.releaseNo, controller: TopicCreateController });
    $stateProvider.state('app.topic-update', { url: 'topic-update/:id', templateUrl: 'scripts/view/view_topic_update.html?v=' + window.releaseNo, controller: TopicUpdateController });

    $stateProvider.state('app.meta-group-list', { url: 'meta-group-list', templateUrl: 'scripts/view/view_meta_group_list.html?v=' + window.releaseNo, controller: MetaGroupListController });
    $stateProvider.state('app.meta-group-item', { url: 'meta-group-item/:id', templateUrl: 'scripts/view/view_meta_group_item.html?v=' + window.releaseNo, controller: MetaGroupItemController });
    $stateProvider.state('app.meta-group-create', { url: 'meta-group-create', templateUrl: 'scripts/view/view_meta_group_create.html?v=' + window.releaseNo, controller: MetaGroupCreateController });
    $stateProvider.state('app.meta-group-update', { url: 'meta-group-update/:id', templateUrl: 'scripts/view/view_meta_group_update.html?v=' + window.releaseNo, controller: MetaGroupUpdateController });

    $stateProvider.state('app.meta-category-list', { url: 'meta-category-list', templateUrl: 'scripts/view/view_meta_category_list.html?v=' + window.releaseNo, controller: MetaCategoryListController });
    $stateProvider.state('app.meta-category-item', { url: 'meta-category-item/:id', templateUrl: 'scripts/view/view_meta_category_item.html?v=' + window.releaseNo, controller: MetaCategoryItemController });
    $stateProvider.state('app.meta-category-create', { url: 'meta-category-create', templateUrl: 'scripts/view/view_meta_category_create.html?v=' + window.releaseNo, controller: MetaCategoryCreateController });
    $stateProvider.state('app.meta-category-update', { url: 'meta-category-update/:id', templateUrl: 'scripts/view/view_meta_category_update.html?v=' + window.releaseNo, controller: MetaCategoryUpdateController });

    $stateProvider.state('app.otherwise', {
        url: '*path',
        templateUrl: 'views/view_404.html?v=' + window.releaseNo
    });
}