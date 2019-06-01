/**
 * Created by melin on 2017/11/20.
 */
app.directive("markdownEditor", function () {
    return {
        restrict: "A",
        require:  'ngModel',
        link:     function (scope, element, attrs, ngModel) {
            $(element).markdown({
                language:'zh',
                hiddenButtons:['cmdPreview'],
                footer:'<div id="markdown-preview" class="markdown-preview" style="display:none;"></div><small id="markdown-counter" class="text-success">0 character entered</small>',
                onChange:function(e){
                    var content = e.parseContent(),
                        content_length = (content.match(/\n/g)||[]).length + content.length;

                    if (content == '') {
                        $('#markdown-preview').hide();
                    } else {
                        $('#markdown-preview').show().html(content);
                        // mdContent = content
                        ngModel.$setViewValue(content);
                    }

                    $('#markdown-counter').removeClass('text-success').addClass('text-success').html(content_length+' character entered.');
                }
            });
        }
    }
});
