'use strict';

angular
		.module('testProject')
		.config(
				function($stateProvider) {
					$stateProvider
							.state(
									'test_batch',
									{
										parent : 'entity',
										url : '/test_batch',
										data : {
											//roles : [ 'ROLE_USER' ],
											pageTitle : 'Test_batch'
										},
										views : {
											'measurement@' : {
												templateUrl : 'test_batch/test_batch.html',
												controller : 'Test_batchController'
											}
										},
										resolve : {}
									})
									
				});