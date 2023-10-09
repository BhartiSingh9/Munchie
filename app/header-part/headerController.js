angular.module('myApp').controller('HeaderController', function ($scope) {
    $scope.locations = [
        { label: 'Location', value: 'Location' },
        { label: 'Delhi, India', value: 'delhi' },
        { label: 'Kolkata, India', value: 'kolkata' }
        // Add more locations as needed
    ];

    $scope.selectedLocation = $scope.locations[0]; // Default selected location
    $scope.isDropdownVisible = false; // Initialize dropdown visibility

    // Function to handle location change
    $scope.changeLocation = function (location) {
        $scope.selectedLocation = location;
        $scope.toggleDropdown(); // Close dropdown when a location is selected
        // You can implement location change logic here
    };

    // Function to toggle dropdown visibility
    $scope.toggleDropdown = function () {
        $scope.isDropdownVisible = !$scope.isDropdownVisible;
    };

    $scope.headerItems = [
        {
            link: '#', // Replace with your actual links
            iconClass: '_1GTCc', // Replace with your actual icon class
            iconHeight: '17', // Replace with your actual icon height
            iconWidth: '17', // Replace with your actual icon width
            iconFill: '#686b78', // Replace with your actual icon fill color
            iconPath: 'M18.125,15.804l-4.038-4.037c0.675-1.079,1.012-2.308,1.01-3.534C15.089,4.62,12.199,1.75,8.584,1.75C4.815,1.75,1.982,4.726,2,8.286c0.021,3.577,2.908,6.549,6.578,6.549c1.241,0,2.417-0.347,3.44-0.985l4.032,4.026c0.167,0.166,0.43,0.166,0.596,0l1.479-1.478C18.292,16.234,18.292,15.968,18.125,15.804 M8.578,13.99c-3.198,0-5.716-2.593-5.733-5.71c-0.017-3.084,2.438-5.686,5.74-5.686c3.197,0,5.625,2.493,5.64,5.624C14.242,11.548,11.621,13.99,8.578,13.99 M16.349,16.981l-3.637-3.635c0.131-0.11,0.721-0.695,0.876-0.884l3.642,3.639L16.349,16.981z',
            text: 'Search'
        },
        {
            link: '#',
            iconClass: '_1GTCc',
            iconHeight: '19',
            iconWidth: '19',
            iconFill: '#686b78',
            iconPath: 'M12.075,10.812c1.358-0.853,2.242-2.507,2.242-4.037c0-2.181-1.795-4.618-4.198-4.618S5.921,4.594,5.921,6.775c0,1.53,0.884,3.185,2.242,4.037c-3.222,0.865-5.6,3.807-5.6,7.298c0,0.23,0.189,0.42,0.42,0.42h14.273c0.23,0,0.42-0.189,0.42-0.42C17.676,14.619,15.297,11.677,12.075,10.812 M6.761,6.775c0-2.162,1.773-3.778,3.358-3.778s3.359,1.616,3.359,3.778c0,2.162-1.774,3.778-3.359,3.778S6.761,8.937,6.761,6.775 M3.415,17.69c0.218-3.51,3.142-6.297,6.704-6.297c3.562,0,6.486,2.787,6.705,6.297H3.415z',
            text: 'Sign In'
        }
    ];
});

