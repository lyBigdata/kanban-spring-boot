function TopicCreateController($scope, $state, $stateParams, KanBanService) {

    $scope.item = {};

    function topic_create_callback(response) {

        $scope.waiting = false;

        if (response.status != 1) {
            $scope.message = response.message;
            return;
        }

        $state.go('app.topic-list');
    }

    function meta_group_items_for_group_id_callback(response) {

        if (response.status == 1) {
            $scope.groupIds = response.items;
        }
    }

    function meta_category_items_for_category_id_callback(response) {

        if (response.status == 1) {
            $scope.categoryIds = response.items;
        }
    }

    $scope.confirmCreate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;
        {
            var items = [];
            for (var i = 0; i < $scope.groupIds.length; i++) {
                if ($scope.groupIds[i] == $scope.item.groupId_value) {
                    items.push($scope.groupIds[i]);
                    $scope.groupIds[i].selected = true;
                    break;
                }
            }
            request.item.groupId = items;
        }
        {
            var items = [];
            for (var i = 0; i < $scope.categoryIds.length; i++) {
                if ($scope.categoryIds[i] == $scope.item.categoryId_value) {
                    items.push($scope.categoryIds[i]);
                    $scope.categoryIds[i].selected = true;
                    break;
                }
            }
            request.item.categoryId = items;
        }

        KanBanService.topic_create(request).then(topic_create_callback)
    }

    {
        var request = {};
        request.pageIndex = 1;

        KanBanService.meta_group_items(request).then(meta_group_items_for_group_id_callback)
    }
    {
        var request = {};
        request.pageIndex = 1;

        KanBanService.meta_category_items(request).then(meta_category_items_for_category_id_callback)
    }
}
