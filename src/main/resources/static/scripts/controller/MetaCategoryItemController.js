function MetaCategoryItemController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function meta_category_item_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.meta_category_item(request).then(meta_category_item_callback);
    }
}
