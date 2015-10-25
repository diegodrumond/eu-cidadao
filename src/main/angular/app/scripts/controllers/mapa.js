'use strict';

angular.module('c3aApp')
  .controller('MapaCtrl', function($scope,$uibModal) {
    
    $scope.open = function () {
      // var modalInstance = 
      $uibModal.open({
        animation: true,
        templateUrl: 'adicionar.html',
        controller: 'AdicionarCtrl'
      });
    };
  });

angular.module('c3aApp')
  .controller('AdicionarCtrl', function ($scope, $uibModalInstance) {

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };
  });
