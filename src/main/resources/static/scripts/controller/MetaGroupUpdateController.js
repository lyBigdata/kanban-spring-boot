//新建数据库
function MetaGroupUpdateController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function meta_group_editable_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    function meta_group_update_callback(response) {
        if (response.status != 1) {
            return;
        }

        $state.go('app.meta-group-item', { id: $scope.id });
    }

    $scope.confirmUpdate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.meta_group_update(request).then(meta_group_update_callback)
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.meta_group_editable(request).then(meta_group_editable_callback);
    }
}
