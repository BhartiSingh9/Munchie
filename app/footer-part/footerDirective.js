angular.module('myApp').directive('myFooter',function() {
return{
    restrict:'E',
    templateUrl:'app/footer-part/footer-part.html',
    controller:'FooterController'

};
});