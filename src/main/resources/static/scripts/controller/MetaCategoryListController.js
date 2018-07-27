function MetaCategoryListController($scope, $state, $stateParams, KanBanService) {

    function meta_category_items_callback(response) {

        $scope.items = response.items;
    }

    function meta_category_count_callback(response) {

        $scope.totalCount = response.totalCount;
    }

    //分页
    $scope.pageChanged = function () {

        var request = {};

        request.pageIndex = $scope.currentPage;

        KanBanService.meta_category_items(request).then(meta_category_items_callback);
    };

    {
        $scope.maxSize = 10;
        $scope.currentPage = 1;
        $scope.pageSize = 20;

        KanBanService.meta_category_count({}).then(meta_category_count_callback);
        KanBanService.meta_category_items({ pageIndex: $scope.currentPage }).then(meta_category_items_callback);
    }

}
