require.config({
    paths: {
        'angular': '../bower_components/angular/angular',
        'angular-animate': '../bower_components/angular-animate/angular-animate',
        'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router',
        'angular-resource': '../bower_components/angular-resource/angular-resource',
        'ng-table': '../bower_components/ng-table/dist/ng-table',
        'ui-select': '../bower_components/ui-select/dist/select',
        'angular-sanitize': '../bower_components/angular-sanitize/angular-sanitize',
        'angular-bootstrap': '../bower_components/angular-bootstrap/ui-bootstrap',
        'toaster': '../bower_components/AngularJS-Toaster/toaster',
        'bootstrap': '../bower_components/bootstrap/dist/js/bootstrap',
        'jquery': '../bower_components/jquery/dist/jquery',
        'metis-menu': '../bower_components/metisMenu/dist/metisMenu',
        'moment': '../bower_components/moment/moment',
        'angular-moment': '../bower_components/angular-moment/angular-moment',
        'ngstorage': '../bower_components/ngstorage/ngStorage',
        'sb-admin': '../bower_components/startbootstrap-sb-admin-2/dist/js/sb-admin-2'
    },
    shim: {
        'angular': {
            exports: 'angular',
            deps: ['jquery']
        },
        'angular-resource': {
            deps: ['angular']
        },
        'angular-ui-router': {
            deps: ['angular']
        },
        'angular-animate': {
            deps: ['angular']
        },
        'ng-table': {
            deps: ['angular']
        },
        'ui-select': {
            deps: ['angular']
        },
        'angular-sanitize': {
            deps: ['angular']
        },
        'angular-bootstrap': {
            deps: ['angular']
        },
        'angular-moment': {
            deps: ['angular', 'moment']
        },
        'ngstorage': {
            deps: ['angular']
        },
        'toaster': {
            deps: ['angular']
        },
        'metis-menu': {
            deps: ['jquery']
        },
        'sb-admin': {
            deps: ['jquery', 'metis-menu']
        },
        'bootstrap': {
            deps: ['jquery']
        }
    }
});

require([
    'angular',
    'angular-animate',
    'angular-ui-router',
    'angular-resource',
    'ng-table',
    'ui-select',
    'angular-sanitize',
    'angular-bootstrap',
    'toaster',
    'bootstrap',
    'jquery',
    'metis-menu',
    'moment',
    'angular-moment',
    'ngstorage',
    'sb-admin'
], function(angular){
    angular.element().ready(function(){
        angular.bootstrap(document, [
            'ui.router',
            'ngResource',
            'ngAnimate',
            'ngTable',
            'ui.select',
            'ngSanitize',
            'ui.bootstrap',
            'toaster',
            'angularMoment',
            'ngStorage'
        ]);
    });
});