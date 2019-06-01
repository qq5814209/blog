/**
 * Created by melin on 2017/10/10.'
 * 发现内容控制器
 */
app.controller('GuanzhuController',function ($scope,$http) {
    var user = JSON.parse(sessionStorage.getItem('user'));
    // alert(123)
    $http({

        url:'http://localhost:8080/topic',
        mathod:'GET',
        params:{userId:user.userId}
    }).success(function (data) {
        // alert(555);
        $scope.topic=data;
        $scope.name=data.topics;
        $scope.count=data.topics.length;
    });

    var others=[];
    $scope.others=others;

});