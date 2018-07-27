function TopicItemController($scope, $state, $stateParams, KanBanService) {

    $scope.id = $stateParams.id;

    function topic_item_callback(response) {

        $scope.loaded = true;
        if (response.status != 1) {
            return;
        }

        $scope.item = response.item;
    }

    {
        var request = {};
        request.id = $scope.id;

        KanBanService.topic_item(request).then(topic_item_callback);
    }
}
