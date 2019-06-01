/**
 * Created by melin on 2017/10/10.'
 * 主页内容控制器
 */
app.controller('QuestionController',function ($scope,$routeParams,$http) {
    var id=$routeParams.id;
    var user=JSON.parse(sessionStorage.getItem("user"));
    $http({
        url:'http://localhost:8080/question/'+id,
        method:'GET',
        params:{
            "userId":user.userId
        }
    }).success(function (data) {
        $scope.question=data;
    });
    $scope.collectionQuestion = function (qCollection) {
        $http({
            method:'POST',
            url:'http://localhost:8080/collection',
            data:{
                "userId":user.userId,
                "questionId":id,
            }
        }).success(function () {
            window.location.reload();//刷新当前页面
        });
    }
    $scope.cancelCollection=function (qCollection) {
        $http({
            method:'POST',
            url:'http://localhost:8080/cancelCollection',
            data:{
                "userId":user.userId,
                "questionId":id,
            }
        }).success(function () {
            window.location.reload();//刷新当前页面
        })
    }
    $scope.answerQuestion=function (answer) {
        $http({
            method:'POST',
            url:'http://localhost:8080/answer',
            data:{
                "account":user.account,
                "questionId":id,
                "answerContent":answer.answerContent
            }
        }).success(function () {
            swal({
                title:"评论成功",
                type:"success",
                timer:1000,
                showConfirmButton:false
            });
            setTimeout(function () {
                window.location.reload();
            },1200);
        })
    }

    function compile(){
        var text = document.getElementById("content").value;
        var converter = new showdown.Converter();
        var html = converter.makeHtml(text);
        document.getElementById("result").innerHTML = html;
    }
});
