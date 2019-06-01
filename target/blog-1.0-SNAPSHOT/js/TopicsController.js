/**
 * Created by melin on 2017/10/10.'
 * 话题页控制器
 */
app.controller('TopicsController',function ($scope,$http) {
    var user = JSON.parse(sessionStorage.getItem('user'));
    $http({
        url:'http://localhost:8080/topics',
        method:'GET'

    }).success(function (data) {
        $scope.topics = data;//关注话题总数

    });
    $scope.follow=function (followTopic) {
        $http({
            method:'POST',
            url:'http://localhost:8080/follow',
            data:{
                "userId":user.userId,
                "topicId":id,
            }
        }).success(function () {
            window.location.reload();//刷新当前页面
        });
    }
    $scope.cancelFollow=function(followTopic){
        $http({
            method:"POST",
            url:'http://localhost:8080/cancelFollow',
            data:{
                "userId":user.userId,
                "topicId":id,
            }
        }).success(function () {
            window.location.reload();
        })
    }

});
