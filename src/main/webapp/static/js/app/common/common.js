var wtApp = angular.module('wtApp', []);

$( document ).ready(function() {
    console.log( "ready!" );
  //floating labels
    $('.form-control').on('focus blur', function (e) {
        $(this).parents('.form-group').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
    }).trigger('blur');
});



//username directive
/*wtApp.directive('wtusername', function() {
    var directive = {};
    directive.restrict = 'E';
    directive.templateUrl = "static/js/app/common/username.html";
    return directive;
});*/