var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope,$http) {
  $scope.firstName = "John";
  $scope.lastName = "Doe";
	
  var autentication=window.btoa('admin:password');	
	
  $http.defaults.headers.common['Authorization'] = 'Basic ' + autentication;
	
	
	

	
	
  $scope.listaProductos=[];	

	
	cargarArticulos();
	
	function cargarArticulos(){
		
		var params=new Object();
		params.Pwarehouse="001";
		params.Pdate="2019-08-10";
		
		
		
	
		
		 $http({
		    method: 'GET',
			 params : {Pwarehouse: '001',Pdate:'2019-08-10'},
		     url: 'http://3.225.134.78:8000/services/inventory/getExistencesByWarehouseAndDate',
			 defaultHeaders: {
              'Content-Type': 'application/json;charset=UTF-8',
			  'Access-Control-Allow-Origin' : '*',
			  'Access-Control-Allow-Credentials': 'true',
			  'Access-Control-Allow-Methods': 'GET',
			  'Access-Control-Allow-Headers': 'Content-Type' 	 
	 
           }
		 }).then(function (response) {
			    // this callback will be called asynchronously
			    $scope.listaProductos=response;
			  }, function (response) {
			    // called asynchronously if an error occurs
			   alert('error');
			  });
		
		
		
		
	}
	
	
	
});
