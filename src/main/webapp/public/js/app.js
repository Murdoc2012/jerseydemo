'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', []).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {	  
    $routeProvider.when('/myapp/home', {templateUrl: '/myapp/partials/home.html', controller: HomeCtrl});
    $routeProvider.otherwise({redirectTo: '/myapp/home'});
    $locationProvider.html5Mode(true);
  }]);

function AppCtrl($scope, $http, $location,$templateCache) {
	console.log('appctrl in use');
	$scope.myMessage = '';
	$http({method: 'GET', url: '/myapp/api/myresource'}).success(function(data, status, headers, config) {
				console.log('success');
				$scope.myMessage = data;
	});
}

function HomeCtrl($scope) {
	console.log('homectrl in use');
};
