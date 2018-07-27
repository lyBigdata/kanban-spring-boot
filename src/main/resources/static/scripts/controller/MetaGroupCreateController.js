function MetaGroupCreateController($scope, $state, $stateParams, KanBanService) {

    $scope.item = {};

    function meta_group_create_callback(response) {

        $scope.waiting = false;

        if (response.status != 1) {
            $scope.message = response.message;
            return;
        }

        $state.go('app.meta-group-list');
    }

    $scope.confirmCreate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.meta_group_create(request).then(meta_group_create_callback)
    }

}
