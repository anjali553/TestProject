angular.module('testProject')
.factory('AuthInterceptor', [function() {  
    return {
    // Send the Authorization header with each request
        'request': function(config) {
            config.headers = config.headers || {};
            var encodedString = btoa("bill:abc123");
            config.headers.Authorization = 'Basic '+encodedString;
           return config;
        }
    };
}]);

/*btoa() function to get the Base64 encoded string from user-credentials.*/