'use strict';
 
angular.module('crudApp').factory('UserService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                loadAllPersons: loadAllPersons,
                getAllPersons: getAllPersons,
                getPerson: getPerson,
                createPerson: createPerson,
                updatePerson: updatePerson,
                removePerson: removePerson
            };
 
            return factory;
 
            function loadAllPersons() {
                console.log('Fetching all users');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all persons');
                            $localStorage.persons = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading persons');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllPersons(){
                return $localStorage.persons;
            }
 
            function getPerson(id) {
                console.log('Fetching Person with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Person with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading person with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function createPerson(person) {
                console.log('Creating person');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, person)
                    .then(
                        function (response) {
                            loadAllPersons();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Persons : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function updatePerson(person, id_person) {
                console.log('Updating Person with id '+id_person);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id_person, person)
                    .then(
                        function (response) {
                            loadAllPersons();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Person with id :'+id_person);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removePerson(id) {
                console.log('Removing Person with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllPersons();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Person with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);