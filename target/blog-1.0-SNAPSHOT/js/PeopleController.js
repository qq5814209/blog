/**
 * Created by melin on 2017/11/12.
 */
/**
 * Created by melin on 2017/10/10.'
 * 发现内容控制器
 */
app.controller('PeopleController', function ($scope, $http, $routeParams) {
    var id=$routeParams.id;

    var user = JSON.parse(sessionStorage.getItem('user'));
    $http({
        url: 'http://localhost:8080/people/'+ user.userId,
        method: 'GET'
    }).success(function (data) {
        $scope.userInfo = data;     //该用户关注的话题动态集合
        $scope.collections = data.collections;
        $scope.follows = data.follows;
        $scope.user = data.user;
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

    $scope.updateUser = function (pppuser) {
        $http({
            url: 'http://localhost:8080/peopleEdit',
            method: 'POST',
            data: {
                "userId": user.userId,
                "account":user.account,
                "password":user.password,
                "profile":user.profile,
                "bgImage":user.bgImage,
                "nickname": pppuser.nickname,
                "introduce": pppuser.introduce,
                "address": pppuser.address,
                "industry": pppuser.industry,
                "profession": pppuser.profession,
                "education": pppuser.education
            }
        }).success(function (data) {
            swal({
                title: "修改成功",
                type: "success",
                timer: 1000,
                showConfirmButton: false
            });
            /*sessionStorage.removeItem('user');
             sessionStorage.setItem('user',JSON.stringify(data));*/
            window.setTimeout(function () {
                window.location.reload();
            }, 1200);
        });
    }


    $scope.modifyBgImg = function () {
        var file = document.querySelector('input[type=file]').files[0];
        var account = document.getElementById('account').value;

        $http({
            method: 'POST',
            url: 'http://localhost:8080/bgImg',
            data: {
                file: file,
                account: account
            },
            headers:{
                'Content-Type': undefined
            },   //请求头的设置
            transformRequest: function (data) {
                var formData = new FormData();
                formData.append('file', data.file);
                formData.append('account', data.account);
                return formData;
            }
        }).success(function () {

            window.location.reload();
        });
    }

    $scope.modifyProfile = function () {

        var file = document.querySelector('#photo1').files[0];
        var account = document.getElementById('account1').value;
        //   alert(file+account);
        $http({
            method: 'POST',
            url:'http://localhost:8080/profile',
            data: {
                file: file,
                account:account
            },
            headers:{
                'Content-Type': undefined
            },   //请求头的设置
            transformRequest:function (data) {
                var formData = new FormData();
                formData.append('file', data.file);
                formData.append('account', data.account);
                return formData;
            }
        }).success(function () {
            window.location.reload();
        });
    }
});

//头像选择预览函数
function getPicture() {
    $("#photo").click();      //点击头像，模拟点击input  type = file
}
function getPicture1() {
    //alert("2323");
    $("#photo1").click();     //点击头像，模拟点击input  type = file
}
function previewFile() {
    var preview  = document.getElementById("userBgImg");
    // var preview = document.querySelector('img');
    var file  = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();
    reader.onloadend = function () {
        preview.src = reader.result;
    }
    if (file) {
        reader.readAsDataURL(file);
        alert(file);
    } else {
        preview.src = "  ";
    }
}


function previewFile1() {
    var preview  = document.getElementById("userProfile");
    var file  = document.querySelector('#photo1').files[0];
    var reader = new FileReader();
    reader.onloadend = function () {
        preview.src = reader.result;
    }
    if (file) {
        reader.readAsDataURL(file);
        alert(file);
    } else {
        preview.src = "  ";
    }

}