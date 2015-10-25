'use strict';

angular.module('c3aApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute',
  'ngMap',
  'ui.bootstrap'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/mapa', {
        templateUrl: 'views/mapa.html',
        controller: 'MapaCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/configuracao', {
        templateUrl: 'views/configuracao.html',
        controller: 'ConfiguracaoCtrl'
      })
      .when('/usuario', {
        templateUrl: 'views/usuario.html',
        controller: 'UsuarioCtrl'
      })
      .when('/cadastro', {
        templateUrl: 'views/cadastro.html',
        controller: 'CadastroCtrl'
      })
      .when('/mapa', {
        templateUrl: 'views/mapa.html',
        controller: 'MapaCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });
  });
