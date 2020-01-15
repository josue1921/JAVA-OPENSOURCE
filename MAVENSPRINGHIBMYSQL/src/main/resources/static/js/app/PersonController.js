'use strict';
 
angular.module('crudApp').controller('PersonController',
    ['PersonService', '$scope',  function( PersonService, $scope) {
 
        var self = this;
        self.person = {};
        self.persons = [];
 
        self.submit = submit;
        self.getAllPersons = getAllPersons;
        self.createPerson = createPerson;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.person.id === undefined || self.person.id === null) {
                console.log('Nueva persona registrada', self.person);
                createUser(self.person);
            }
        }
 
        function createPerson(person) {
            console.log('Creando persona');
            PersonService.createPerson(person)
                .then(
                    function (response) {
                        console.log('Persona creada');
                        self.successMessage = 'Guardado exitoso';
                        self.errorMessage='';
                        self.done = true;
                        self.person={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Person');
                        self.errorMessage = 'Error while creating Person: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
        function getAllPersons(){
            return PersonService.getAllPersons();
        }
        
       function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.person={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);