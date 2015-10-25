'use strict';

angular.module('c3aApp')
  .controller('MapaCtrl', function($scope,$uibModal,$log,$http) {

	  $scope.menu =  {name: 'menu', url: 'views/menu.html'};

    var getLocalLocation = function(latitude, longitude) {
      var latlon = latitude + "," + longitude;

      $http.get("https://maps.googleapis.com/maps/api/geocode/json?latlng="+latlon+"&sensor=false")
           .success(function(data) {
              var currentLocation = data.results[0];
              
              var locationWrap = {
                  "endereco":currentLocation.formatted_address
              }
              $.each(currentLocation.address_components, function(k, v) {
                if($.inArray("neighborhood",v.types)){
                  locationWrap["neighborhood"]=v.long_name;
                }else if($.inArray("postal_code",v.types)){
                  locationWrap["postal_code"]=v.long_name;
                }
              });

              $scope.nova_posicao.endereco=locationWrap["endereco"];
              $scope.nova_posicao.location=locationWrap;
            });
    };

    $scope.open = function () {
      // var modalInstance = 
      $uibModal.open({
        animation: true,
        templateUrl: 'adicionar.html',
        controller: 'AdicionarCtrl'
      });
    };
    
    $scope.addMarker = function(event) {
      var ll = event.latLng;
      if($scope.nova_posicao){
        $scope.nova_posicao.lat=ll.lat();
        $scope.nova_posicao.lng=ll.lng();
        getLocalLocation($scope.nova_posicao.lat,$scope.nova_posicao.lng);
      }
    }
    
    $scope.cancelar_adicionar = function(event) {
      $scope.nova_posicao=null;
      hideInfoWindow();
    }
  })
  .controller('AdicionarCtrl', function ($scope, $uibModalInstance) {

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };

    $scope.preparar_adicionar = function(tipo){
      $scope.$parent.nova_posicao = {tipo:tipo}
      $uibModalInstance.dismiss('cancel');
    }
  });
