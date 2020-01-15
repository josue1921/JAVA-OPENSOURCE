'use strict';

angular
		.module('crudApp')
		.factory(
				'PersonService',
				[
						'$localStorage',
						'$http',
						'$q',
						'urls',
						function($localStorage, $http, $q, urls) {

							var factory = {
								loadAllPersons : loadAllPersons,
								getAllPersons : getAllPersons,
								getPerson : getPerson,
								getPersonRfc : getPersonRfc,
								createPerson : createPerson
							};

							return factory;

							function loadAllPersons() {
								console.log('Fetching all users');
								var deferred = $q.defer();
								$http
										.get(urls.USER_SERVICE_API)
										.then(
												function(response) {
													console
															.log('Fetched successfully all users');
													$localStorage.persons = response.data;
													deferred.resolve(response);
												},
												function(errResponse) {
													console
															.error('Error while loading users');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function getAllPersons() {
								return $localStorage.persons;
							}

							function getPerson(id) {
								var deferred = $q.defer();
								$http
										.get(urls.USER_SERVICE_API + id)
										.then(
												function(response) {
													console
															.log('Fetched successfully User with id :'
																	+ id);
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while loading user with id :'
																	+ id);
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function getPersonRfc(rfc) {
								var deferred = $q.defer();
								$http
										.get(urls.USER_SERVICE_API + rfc)
										.then(
												function(response) {
													console
															.log('Fetched successfully Person with rfc :'
																	+ rfc);
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while loading person with rfc :'
																	+ rfc);
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createPerson(person) {
								console.log('Creando persona');
								var deferred = $q.defer();
								$http
										.post(urls.USER_SERVICE_API, person)
										.then(
												function(response) {
													loadAllPersons();
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error al dar de alta a la persona : '
																	+ errResponse.data.errorMessage);
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
						} ]);