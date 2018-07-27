//新建数据库
function MetaCategoryUpdateController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function meta_category_editable_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    function meta_category_update_callback(response) {
        if (response.status != 1) {
            return;
        }

        $state.go('app.meta-category-item', { id: $scope.id });
    }

    $scope.confirmUpdate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.meta_category_update(request).then(meta_category_update_callback)
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.meta_category_editable(request).then(meta_category_editable_callback);
    }
}
