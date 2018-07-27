function ProjectCreateController($scope, $state, $stateParams, KanBanService) {

    $scope.item = {};

    function project_create_callback(response) {

        $scope.waiting = false;

        if (response.status != 1) {
            $scope.message = response.message;
            return;
        }

        $state.go('app.project-list');
    }

    $scope.confirmCreate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.project_create(request).then(project_create_callback)
    }

}
