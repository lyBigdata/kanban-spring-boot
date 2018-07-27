<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="shortcut icon" href="/favicon.ico" />
    <title>This is a test</title>
    <link href="lib/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="lib/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="lib/angular-ui-bootstrap/2.5.0/css/ui-bootstrap-csp.css" rel="stylesheet" />
    <link href="lib/jquery-ui/1.12.1/css/jquery-ui.min.css" rel="stylesheet" />
    <link href="lib/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
    <link href="lib/icheck-bootstrap/1.0.7/icheck-bootstrap.min.css" rel="stylesheet" />
    <style type="text/css">
        .checkbox-inline, .radio-inline {
            margin-left: 10px;
        }
    </style>
</head>

<body ng-app="app">

    <div ui-view="header"></div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-1" ui-view="main-menu"></div>
            <div class="col-sm-11" ui-view="main-body"></div>
        </div>
    </div>

    <script src="lib/jquery/1.10.2/jquery.min.js"></script>
    <script src="lib/jquery-ui/1.12.1/js/jquery-ui-1.12.1.min.js"></script>
    <script src="lib/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="lib/angularjs/1.6.4/angular.min.js"></script>
    <script src="lib/angular-ui-router/1.0.5/angular-ui-router.min.js"></script>
    <script src="lib/angular-ui-sortable/0.19.0/angular-ui-sortable.min.js"></script>
    <script src="lib/angularjs/1.6.4/angular-resource.min.js"></script>
    <script src="lib/angular-ui-bootstrap/2.5.0/js/ui-bootstrap-tpls.min.js"></script>
    <script src="lib/sweetalert/1.1.3/sweetalert.min.js"></script>

    <script src="scripts/_route.js?v=${releaseNo}"></script>
    <script src="scripts/_service.js?v=${releaseNo}"></script>
    <script src="scripts/controller/HeaderController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/ProjectListController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/ProjectItemController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/ProjectCreateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/ProjectUpdateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/TopicListController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/TopicItemController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/TopicCreateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/TopicUpdateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaGroupListController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaGroupItemController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaGroupCreateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaGroupUpdateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaCategoryListController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaCategoryItemController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaCategoryCreateController.js?v=${releaseNo}"></script>
    <script src="scripts/controller/MetaCategoryUpdateController.js?v=${releaseNo}"></script>
    <script src="scripts/_app.js?v=${releaseNo}"></script>

    <script>
        window.releaseNo = "${releaseNo}";
    </script>

</body>

</html>
