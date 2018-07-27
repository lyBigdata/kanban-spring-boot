function MetaGroupItemController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function meta_group_item_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.meta_group_item(request).then(meta_group_item_callback);
    }
}
