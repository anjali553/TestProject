'use strict';

angular.module('testProject')
    .factory('Test_batch', function ($resource, DateUtils) {
        return $resource('demo/test_batch/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'getTestBatchCount': { method: 'GET', params: {testBatchId:"testBatchId" }, url:'/demo/test_batch/getTestBatchCount', isArray: false},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                   
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });