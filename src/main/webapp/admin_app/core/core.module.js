/**
 * Created by jvillanueva on 12/21/15.
 */
define([
    'angular',
    'core/controller/RootController',
    'core/controller/DashboardController'
], function (angular, RootController, DashboardController) {
    console.debug('configuring core.module');
    angular.module('core.module', [])
        .config(['$stateProvider', '$urlRouterProvider', function ($state, $urlRouter) {

            $urlRouter.otherwise('/');

            $state.state('default', {
                url: '/',
                views: {
                    main: {
                        templateUrl: '/admin_app/core/views/main.html',
                        controller: RootController
                    }
                },
                abstract: true
            }).state('default.dashboard', {
                url: '',
                templateUrl: '/admin_app/core/views/dashboard.html',
                controller: DashboardController
            });
        }]);

});