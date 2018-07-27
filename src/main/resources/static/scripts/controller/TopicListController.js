function TopicListController($scope, $state, $stateParams, KanBanService) {

    function topic_items_callback(response) {

        $scope.items = response.items;
    }

    function topic_count_callback(response) {

        $scope.totalCount = response.totalCount;
    }

    function topic_filters_callback(response) {

        $scope.filterGroups = response.filterGroups;
    }

    $scope.filterChanged = function () {

        var requestItems = {};
        var requestCount = {};
        for (var i = 0; i < $scope.filterGroups.length; i++) {

            //复选框
            if ($scope.filterGroups[i].multiSelect) {

                var items = [];
                for (var ij = 0; ij < $scope.filterGroups[i].filters.length; ij++) {
                    if ($scope.filterGroups[i].filters[ij].selected) {
                        items.push($scope.filterGroups[i].filters[ij].filterKey);
                    }
                }

                if (items.length > 0) {
                    requestItems[$scope.filterGroups[i].groupKey + 'List'] = items;
                    requestCount[$scope.filterGroups[i].groupKey + 'List'] = items;
                }
            }

            //单选框
            if (!$scope.filterGroups[i].multiSelect && $scope.filterGroups[i].filterKey) {

                requestItems[$scope.filterGroups[i].groupKey] = $scope.filterGroups[i].filterKey;
                requestCount[$scope.filterGroups[i].groupKey] = $scope.filterGroups[i].filterKey;
            }

        }

        requestItems.pageIndex = $scope.currentPage = 1;

        KanBanService.topic_count(requestCount).then(topic_count_callback);
        KanBanService.topic_items(requestItems).then(topic_items_callback);
    }

    //分页
    $scope.pageChanged = function () {

        var request = {};

        request.pageIndex = $scope.currentPage;

        KanBanService.topic_items(request).then(topic_items_callback);
    };

    {
        $scope.maxSize = 10;
        $scope.currentPage = 1;
        $scope.pageSize = 20;

        KanBanService.topic_count({}).then(topic_count_callback);
        KanBanService.topic_items({ pageIndex: $scope.currentPage }).then(topic_items_callback);

        KanBanService.topic_filters({}).then(topic_filters_callback);
    }

}
