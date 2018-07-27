//新建数据库
function TopicUpdateController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function topic_editable_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
        {
            $scope.groupIds = $scope.item.groupId;
            var items = [];
            for (var i = 0; i < $scope.item.groupId.length; i++) {
                if ($scope.item.groupId[i].selected) {
                    $scope.item.groupId_value = $scope.item.groupId[i];
                    break;
                }
            }
        }
        {
            $scope.categoryIds = $scope.item.categoryId;
            var items = [];
            for (var i = 0; i < $scope.item.categoryId.length; i++) {
                if ($scope.item.categoryId[i].selected) {
                    $scope.item.categoryId_value = $scope.item.categoryId[i];
                    break;
                }
            }
        }
    }

    function topic_update_callback(response) {
        if (response.status != 1) {
            return;
        }

        $state.go('app.topic-item', { id: $scope.id });
    }

    $scope.confirmUpdate = function () {

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

        KanBanService.topic_update(request).then(topic_update_callback)
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.topic_editable(request).then(topic_editable_callback);
    }
}
