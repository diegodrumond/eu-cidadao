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
    OAuth.initialize('WAzfw_B0x-O2V6-ywpwNr8s9nKs');

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
  })
  .service('Session', function () {
    this.login = null;
    this.name = null;

    this.isActive = function() {
      return this.login !== null;
    };
    this.create = function (login, name) {
      this.login = login;
      this.name = name;
    };
    this.destroy = function () {
      this.login = null;
      this.name = null;
    };
  })
  .controller('ApplicationCtrl', function ($scope, $location, Session) {
    $scope.loggedUser = null;
    $scope.$on('login-successful', function(event, user) {
      Session.create(user.email, user.name);
      $scope.loggedUser = user;
      $scope.$apply(function() {
        $location.path('/mapa');
      });
    });
  });
