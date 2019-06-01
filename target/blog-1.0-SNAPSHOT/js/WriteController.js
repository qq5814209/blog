/**
 * Created by melin on 2017-10-10.
 * 写作
 */

app.controller('WriteController', function ($scope, $http) {
    // alert(555);
    // var mdContent;
    // $("#comment-md").markdown({
    //     language:'zh',
    //     onShow: function () {
    //     },
    //     hiddenButtons:['cmdPreview'],
    //     footer:'<div id="markdown-preview" class="markdown-preview" style="display:none;"></div><small id="markdown-counter" class="text-success">0 character entered</small>',
    //     onChange:function(e){
    //         var content = e.parseContent(),
    //             content_length = (content.match(/\n/g)||[]).length + content.length;
    //
    //         if (content == '') {
    //             $('#markdown-preview').hide();
    //         } else {
    //             $('#markdown-preview').show().html(content);
    //             // mdContent = content
    //             ngModel.$setViewValue(content);
    //         }
    //
    //         $('#markdown-counter').removeClass('text-success').addClass('text-success').html(content_length+' character entered.');
    //     }
    // });


    var user=JSON.parse(sessionStorage.getItem('user'));

    /**
     * 提问*/
    $scope.newAsk=function (askQuestion, e) {
        //  alert("wwww");
        $http({
            method:'POST',
            url:'http://localhost:8080/newQuestion',
            data: {
                "account": user.account,
                "title":askQuestion.title,
                "topicId": 1,
                "content": askQuestion.content
            },
            params:{
                topicName:askQuestion.topicName
            }
        }).success(function (data) {
            //  alert("success");
            swal({
                title:"发表成功",
                type:"success",
                timer:1000,
                showConfirmButton:false

            });
            setTimeout(function () {
                window.location.reload();
            },1200);
        });
    }


})
