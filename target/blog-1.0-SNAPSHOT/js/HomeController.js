/**
 * Created by melin on 2017/10/10.'
 * 主页内容控制器
 */
app.controller('HomeController',function ($scope,$http) {

    var user=JSON.parse(sessionStorage.getItem('user'));
    $scope.check = function () {
        swal({
            title:"请先登录",
            type:"error",
            timer:1000,
            showConfirmButton:false
        });
        window.setTimeout("location.href='http://localhost:8080/page/login.html'",1200);

    }
    $http({
        url:'http://localhost:8080/questions',
        method:'GET'
    }).success(function (data) {
        $scope.questions=data;
    })

    /**
     * 提问
     */
    $scope.newAsk=function (askQuestion) {
        $http({
            method:'POST',
            url:'http://localhost:8080/newQuestion',
            data:{
                "account":user.account,
                "title":askQuestion.title,
                "topicId":1,
                "content":askQuestion.content
            },
            params:{
                topicName:askQuestion.topicName
            }
        }).success(function (data) {
            swal({
                title:"提问成功",
                type:"success",
                timer:1000,
                showConfirmButton:false
            });
            setTimeout(function () {
                window.location.reload();
            },1200);
        });

    }
    $scope.logout=function () {
        sessionStorage.removeItem("user");
        window.setTimeout("location.href='http://localhost:8080'",1000)
    };

    $(document).ready(function(){
        $('.sort-nav li').click(function(){
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
        })

        var n=0;
        $('.btn_more').click(function(){
            $('.category_more').eq(n).show();
            n++;
        })


    });



});
