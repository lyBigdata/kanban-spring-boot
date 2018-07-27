function MetaGroupListController($scope, $state, $stateParams, KanBanService) {

    function meta_group_items_callback(response) {

        $scope.items = response.items;
    }

    function meta_group_count_callback(response) {

        $scope.totalCount = response.totalCount;
    }

    //分页
    $scope.pageChanged = function () {

        var request = {};

        request.pageIndex = $scope.currentPage;

        KanBanService.meta_group_items(request).then(meta_group_items_callback);
    };

    {
        $scope.maxSize = 10;
        $scope.currentPage = 1;
        $scope.pageSize = 20;

        KanBanService.meta_group_count({}).then(meta_group_count_callback);
        KanBanService.meta_group_items({ pageIndex: $scope.currentPage }).then(meta_group_items_callback);
    }

}
