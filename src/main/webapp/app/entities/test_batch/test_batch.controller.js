'use strict';

angular.module('testProject').controller('Test_batchController',
		function($scope, $state, $stateParams, Test_batch){
				
						
			$scope.testBatchId = '';
		};
		
		$scope.init = function(){
        	$scope.test_batch = {};
        	
       };               
       $scope.init(); 
       
       
       $scope.save = function () {
      	 $scope.testBatchId = $scope.test_batch.id;
          if ($scope.test_batch.id != null) {
              Test_batch.update($scope.test_batch,
                  function () {
              		$rootScope.alerts.push({type: 'success',msg: 'Updated successfully!'});
              		//$state.go('test_parameterForTestBatch',{testBatchId: $scope.testBatchId });
                      $scope.refresh();
                  });
          }
       };
       $scope.refresh = function () {
           $scope.reset();
           //$('#saveTest_batchModal').modal('hide');
           $scope.clear();
           $scope.init();
           
       };
       
       $scope.clear = function () {
           $scope.test_batch = {test_btach_name: null, id: null};
           $scope.editForm.$setPristine();
           $scope.editForm.$setUntouched();

       };
)