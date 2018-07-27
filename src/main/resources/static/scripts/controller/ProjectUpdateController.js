//新建数据库
function ProjectUpdateController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function project_editable_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    function project_update_callback(response) {
        if (response.status != 1) {
            return;
        }

        $state.go('app.project-item', { id: $scope.id });
    }

    $scope.confirmUpdate = function () {

        $scope.waiting = true;
        $scope.message = null;

        var request = {};
        request.item = $scope.item;

        KanBanService.project_update(request).then(project_update_callback)
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.project_editable(request).then(project_editable_callback);
    }
}
