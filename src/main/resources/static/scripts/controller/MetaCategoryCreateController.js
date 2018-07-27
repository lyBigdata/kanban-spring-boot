function MetaCategoryCreateController($scope, $state, $stateParams, KanBanService) {

    $scope.item = {};

    function meta_category_create_callback(response) {

        $scope.waiting = false;

        if (response.status != 1) {
            $scope.message = response.message;
            return;
        }

        $state.go('app.meta-category-list');
    }

    $scope.confirmCreate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.meta_category_create(request).then(meta_category_create_callback)
    }

}
