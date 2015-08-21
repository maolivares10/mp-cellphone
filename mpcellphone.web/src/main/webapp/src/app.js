(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'cartItemModule',
        'cellPhoneModule',
        'clientModule',
        'productModule',
        'providerModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                .when('/cellPhone', {
                    templateUrl: tplUrl,
                    controller: 'cellPhoneCtrl',
                    controllerAs: alias
                })
                .when('/client', {
                    templateUrl: tplUrl,
                    controller: 'clientCtrl',
                    controllerAs: alias
                }).when('/products', {
                        templateUrl: tplUrl,
                        controller: 'productsCtrl',
                        controllerAs: alias                    
                }).when('/provider', {
                    templateUrl: tplUrl,
                    controller: 'providerCtrl',
                    controllerAs: alias
                }).when('/catalog', {
                        templateUrl: 'src/modules/product/product.tpl.html',
                        controller: 'productCtrl',
                        controllerAs: 'ctrl'
                    })
                .otherwise('/catalog');
        }]);
})(window.angular);
