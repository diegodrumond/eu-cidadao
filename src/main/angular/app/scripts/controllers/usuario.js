'use strict';

angular.module('c3aApp')
	.controller('UsuarioCtrl', function ($scope, Session) {
		console.log(Session);
		$scope.user = {name: Session.name, login: Session.login};
		$scope.menu =  {name: 'menu', url: 'views/menu.html'};
	});
