'use strict';
 
angular.module('crudApp').controller('UserController',
    ['UserService', '$scope',  function( UserService, $scope) {
 
        var self = this;
        self.person = {};
        self.persons=[];
 
        self.submit = submit;
        self.getAllPersons = getAllPersons;
        self.createPerson = createPerson;
        self.updatePerson = updatePerson;
        self.removePerson = removePerson;
        self.editPerson = editPerson;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.person.id_person === undefined || self.person.id_person === null) {
                console.log('Saving New Person', self.person);
                createPerson(self.person);
            } else {
                updatePerson(self.person, self.person.id_person);
                console.log('Person updated with id ', self.person.id_person);
            }
        }
 
        function createPerson(person) {
            UserService.createPerson(person)
                .then(
                    function (response) {
                        console.log('Person created successfully');
                        self.successMessage = 'Person created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.person={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Ocurrio un error en la alta de la persona.');
                        self.errorMessage = 'Ocurrio un error en el registro cantacta a un administrador de sistema: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
 
        function updatePerson(person, id_person){
            console.log('About to update person');
            UserService.updatePerson(person, id_person)
                .then(
                    function (response){
                        console.log('Person updated successfully');
                        self.successMessage='Person updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Person');
                        self.errorMessage='Error while updating Person '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
 
        function removePerson(id_person){
            console.log('About to remove Person with id '+id_person);
            UserService.removePerson(id_person)
                .then(
                    function(){
                        console.log('Person '+id_person + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing person '+id_person +', Error :'+errResponse.data);
                    }
                );
        }
 
 
        function getAllPersons(){
            return UserService.getAllPersons();
        }
 
        function editPerson(id) {
            self.successMessage='';
            self.errorMessage='';
            UserService.getPerson(id).then(
                function (person) {
                    self.person = person;
                },
                function (errResponse) {
                    console.error('Error while removing person ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.person={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);