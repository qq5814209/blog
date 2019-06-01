/**
 * Created by melin on 2017/11/10.
 * 项目的路由配置 SPA规定动作
 */
var app = angular.module('JianShu', ['ngRoute']);

// var app = angular.module("myapp",["ngSanitize"]);
/**
 * angular的全局设置
 */
app.run(function ($rootScope) {
    $rootScope.numlimit = 100;
    if(sessionStorage.getItem('user')!=null){
        $rootScope.user=JSON.parse(sessionStorage.getItem('user'));
    }
});
app.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        .when('/home',{
            templateUrl:'/page/home.html',
            controller:'HomeController'
        })
        .when('/guanzhu',{
            templateUrl:'/page/guanzhu.html',
            controller:'GuanzhuController'
        })
        .when('/xiaoxi',{
            templateUrl:'/page/xiaoxi.html',
            controller:'XiaoxiController'
        })
        .when('/write',{
            templateUrl:'/page/write_1.html',
            controller:'WriteController'
        })
        // .when('/people',{
        //     templateUrl:'/page/people.html',
        //     controller:'PeopleController'
        // })
        .when('/people/:id',{
            templateUrl:'/page/people.html',
            controller:'PeopleController'
        })

        .when('/xiaoxi/pinglun',{
            templateUrl:'/page/x-pinglun.html',
            controller:'XpinglunController'
        })
        .when('/xiaoxi/jianxin',{
            templateUrl:'/page/x-jianxin.html',
            controller:'XjianxinController'
        })
        .when('/xiaoxi/tougao',{
            templateUrl:'/page/x-tougao.html',
            controller:'XtougaoController'
        })
        .when('/xiaoxi/xihuan',{
            templateUrl:'/page/x-xihuan.html',
            controller:'XxihuanController'
        })
        .when('/xiaoxi/guanzhu',{
            templateUrl:'/page/x-guanzhu.html',
            controller:'XguanzhuController'
        })
        .when('/xiaoxi/zanshang',{
            templateUrl:'/page/x-zanshang.html',
            controller:'XzanshangController'
        })
        .when('/xiaoxi/qita',{
            templateUrl:'/page/x-qita.html',
            controller:'XqitaController'
        })
        // .when('/people/:id', {
        //     templateUrl: '/page/personal-2.html',
        //     controller: 'PersonalController'
        // })
        .when('/topic/detail/:id', {
            templateUrl: '/page/topicdetail.html',
            controller: 'TopicDetailController'
        })
        .when('/question/:id', {
            templateUrl: '/page/question.html',
            controller: 'QuestionController'
        })
        .when('/daily_hot',{
            templateUrl:'/page/daily_hot.html',
            controller:'Daily_hotController'
        })
        .when('/monthly_hot',{
            templateUrl:'/page/monthly_hot.html',
            controller:'Monthly_hotController'
        })
        .when('/topics',{
            templateUrl:'/page/topics.html',
            controller:'TopicsController'
        })

        .otherwise({
            templateUrl:'/page/home.html',
            controller:'HomeController'
        })

}]);

