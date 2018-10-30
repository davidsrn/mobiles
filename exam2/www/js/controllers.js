angular.module('app.controllers', [])

.controller('pageCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {
  $scope.mdl={};

}])

.controller('page2Ctrl', ['$scope', '$stateParams', '$http', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
  appid = "5QKKND56CF60IZ9S";
  company = $stateParams.company;
  console.log(company);
  url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="+company+"&apikey="+ appid;

  $http.get(url).then(function(response){
    $scope.symbol = response.data["Global Quote"]["01. symbol"];
    $scope.current = parseInt(response.data["Global Quote"]["05. price"]);
    $scope.today = response.data["Global Quote"]["07. latest trading day"];
    $scope.res = parseFloat(response.data["Global Quote"]["05. price"]) - parseFloat(response.data["Global Quote"]["08. previous close"]);
    $scope.action = (parseFloat(response.data["Global Quote"]["05. price"]) - parseFloat(response.data["Global Quote"]["08. previous close"])) < 0 ? "Sell" : "Don't Sell";
    $scope.color=(parseFloat(response.data["Global Quote"]["05. price"]) - parseFloat(response.data["Global Quote"]["08. previous close"])) < 0 ? "red" : "black";
  }, function(error){
    alert("An error ocurred");
  })


}])




 