/**
 * Created by melin on 2017/11/15.
 */
app.controller('RegisterController',function ($scope,$http) {
    // alert(11)
    $scope.registerIn=function (user) {
        $http({
            url:'http://localhost:8080/registerIn',
            method:'POST',
            data:{
                "nickname":user.nickname,
                "account":user.account,
                "password":user.password
            }
        }).success(function (data) {
            if(data!=" "){
                swal({
                    title:"注册成功",
                    type:"success",
                    timer:1000,
                    showConfirmButton:false
                });
                sessionStorage.setItem('user',JSON.stringify(data));
                window.setTimeout("location.href='http://localhost:8080/page/login.html'",1200);
            }else {
                swal({
                    title:"登录失败",
                    type:"error",
                    timer:1000,
                    showConfirmButton:false
                });
                window.setTimeout("location.href='http://localhost:8080/page/login.html'",1200);
            }
            });
    }
})