'use strict';

var App = angular
.module('myApp',[])
.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
    	  templateUrl: 'ActorManagement.html',
          controller: 'ActorController'
        })
        .when('/countrytest', {
    	  templateUrl: 'view/CountryManagement.html',
          controller: 'CountryController'
        })
        .otherwise({
        redirectTo: '/'
        });
      };
