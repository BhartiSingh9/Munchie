angular.module('myApp').controller('FooterController', function ($scope) {
    $scope.categories = [
        {
            name: 'COMPANY',
            items: ['About us', 'Team', 'Careers', 'Swiggy Blog', 'Bug Bounty', 'Swiggy Super', 'Swiggy Corporate', 'Swiggy Instamart']
        },
        {
            name: 'CONTACT',
            items: ['Help & Support', 'Partner with us', 'Ride with us']
        },
        {
            name: 'LEGAL',
            items: ['Terms & Conditions', 'Refund & Cancellation', 'Privacy Policy', 'Cookie Policy', 'Offer Terms', 'Phishing & Fraud']
        }
    ];

    $scope.imageUrls = [
        "https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_108/play_ip0jfp",
        "https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_108/iOS_ajgrty"
    ];
});