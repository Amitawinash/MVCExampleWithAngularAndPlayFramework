searchApp.controller("searchController", ['$scope', '$http', function($scope, $http) {

//$http.get('http://localhost:9000/fetchAllCar').success(function(data) {
//	$scope.companies = data;
//});
$scope.addRow = function(){		
	$scope.companies.push({ 'transporterName':$scope.transporterName, 'originPincode': $scope.originPincode, 'originCity':$scope.originCity });
};
$scope.removeRow = function(name){				
		var index = -1;		
		var comArr = eval( $scope.companies );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].name === name ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.companies.splice( index, 1 );		
	};
}]);