'use strict';

angular.module('c3aApp')
	.controller('LoginCtrl', function ($scope, $rootScope) {

		$scope.login = function (provider) {
			OAuth.popup(provider)
				.done(function(result) {
					result.me().done(function (response) {
							var user = {
								name: response.name,
								email: response.email
							};
							$rootScope.$broadcast('login-successful', user);
						})
						.fail(function (err) {
							console.log(err);
						});
					console.log(result);
				})
				.fail(function (err) {
					//handle error with err
					console.log(err);
				});
		};
	});
