function ProjectListController($scope, $state, $stateParams, KanBanService) {

    function project_items_callback(response) {

        $scope.items = response.items;
    }

    function project_count_callback(response) {

        $scope.totalCount = response.totalCount;
    }

    //分页
    $scope.pageChanged = function () {

        var request = {};

        request.pageIndex = $scope.currentPage;

        KanBanService.project_items(request).then(project_items_callback);
    };

    {
        $scope.maxSize = 10;
        $scope.currentPage = 1;
        $scope.pageSize = 20;

        KanBanService.project_count({}).then(project_count_callback);
        KanBanService.project_items({ pageIndex: $scope.currentPage }).then(project_items_callback);
    }

}
