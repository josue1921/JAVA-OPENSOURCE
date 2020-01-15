<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">REGISTRO DE PERSONAS </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.person.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Nombre</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.person.name_person" id="uname" class="username form-control input-sm" placeholder="Ingresa tu nombre(s)" required />
                            </div>
                        </div>
                    </div>
 					
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Apellido Paterno</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.apat_person" id="apat" class="username form-control input-sm" placeholder="Ingresa tu apellido paterno" required/>
                            </div>
                        </div>
                    </div>
 					
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Apellido Materno</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.amat_person" id="apat" class="username form-control input-sm" placeholder="Ingresa tu apellido materno" required />
                            </div>
                        </div>
                    </div>
 					
     				<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.email" id="email" class="form-control input-sm" placeholder="Ingresa tu email." required />
                            </div>
                        </div>
                    </div>
     				
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phone">Telefono</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.tele_phone" id="phone" class="form-control input-sm" placeholder="Ingresa tu numero de telefono." required ng-pattern="ctrl.onlyNumbers"/>
                            </div>
                        </div>
                    </div>
 
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="rfc">RFC</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.rfc" id="rfc" class="form-control input-sm" placeholder="Ingresa RFC" required/>
                            </div>
                        </div>
                    </div>
 
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="estatus">Genero</label>
                            <div class="col-md-7">
                                <select ng-model="ctrl.persons.genero" id="gender" class="form-control select-sm" required>
  									<option value="" > -- Seleccionar -- </option>
  									<option value="1"> Masculino </option>
  									<option value="2"> Femenino </option>
								</select>
                            </div>
                        </div>
                    </div>
 					
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de personas </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>APELLIDO PATERNO</th>
                        <th>APELLIDO MATERNO</th>
                        <th>TELEFONO</th>
                        <th>EMAIL</th>
                        <th>GENERO</th>
                        <th>RFC</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllPersons()">
                        <td>{{u.name}}</td>
                        <td>{{u.apat}}</td>
                        <td>{{u.amat}}</td>
                        <td>{{u.phone}}</td>
                        <td>{{u.email}}</td>
                        <td>{{u.gender}}</td>
                        <td>{{u.rfc}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>