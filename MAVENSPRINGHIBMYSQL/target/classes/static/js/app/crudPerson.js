var app = angular.module('crudApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: '<a class="vglnk" href="http://localhost:8080/SpringBootCRUDApp" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>SpringBootCRUDApp</span><span>/</span><span>#</span><span>/</span></a>',
    USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/persons/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/person',
                controller:'PersonController',
                controllerAs:'ctrl',
                resolve: {
                    persons: function ($q, PersonService) {
                        console.log('Carga todos los registros');
                        var deferred = $q.defer();
                        PersonService.loadAllPersons().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);