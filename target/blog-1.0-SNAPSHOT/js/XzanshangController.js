/**
 * Created by melin on 2017/10/10.'
 * 发现内容控制器
 */
app.controller('XzanshangController',function ($scope) {

    var data = [
        {
            'questionId' : 1,
            'thumbnail':'explore_1.jpg',
            'topicName':'知乎',
            'questionTitle':'如何看待捷克人2017年10月7日登顶贡嘎山主峰？',
            'authorIcon':'1.png',
            'authorName':'户外探险杂志',
            'authorIntroduce':'知乎live：户外运动入门到精通',
            'content':"谢邀。就在张梁顺利完成14座8000+的第五天，六名捷克登山者登顶贡嘎主峰——木雅贡嘎（Minya Konka）。2017年10月7日下午15时，这座海拔7556米，被冠以“蜀山之王”的四川最高峰之巅，再次被人类触及。此番距上一次登顶，已过去了整整15年。据了解，六名捷谢邀。就在张梁顺利完成14座8000+的第五天，六名捷克登山者登顶贡嘎主峰——木雅贡嘎（Minya Konka）。2017年10月7日下午15时，这座海拔7556米，被冠以“蜀山之王”的四川最高峰之巅，再次被人类触及。此番距上一次登顶，已过去了整整15年。据了解，六名捷",
            'commentCount':111,
            'collectionCount':666,
            'likeCount':520,
            'subtitle1':'为什么国外的移动支付没有像国内的支付宝和微信那样普及',
            'FAQ':'问答',
        },
        // {
        //     'questionId': 1,
        //     'thumbnail': '1.jpg',
        //     'topicName': '知乎',
        //     'questionTitle': '你最反感的东西是什么？',
        //     'authorIcon': '1.png',
        //     'authorName': 'Folra Liu',
        //     'authorIntroduce': '北京土著',
        //     'content': "你最反感的东西是什么你最反感的东西是什么你最反感的东西是什么你最反感的东西是什么你最反感的东西是什么你最反感的东西是什么",
        //     'commentCount': 111,
        //     'collectionCount': 666,
        //     'likeCount': 520,
        // }

    ];

    $scope.questions = data;
});