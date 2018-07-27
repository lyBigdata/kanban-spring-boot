function ProjectItemController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function project_item_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.project_item(request).then(project_item_callback);
    }
}
