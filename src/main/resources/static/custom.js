var map;

function initMap(){
	map = new google.maps.Map(document.getElementById('map'), {
		center: coords,
		zoom: 14,
		scrollwheel: false
	});
}

var marker = new google.maps.Marker({
	position: coords,
	map: map,
//	animation: google.maps.Animation.BOUNCE
//});
//
//let contentString = '<h2>' + city + ', ' + state + '</h2>'>
//
//let infoWindow = new google.maps.InfoWindow ({
//	content: contentString
//});
//
//google.maps.event.addListener(marker, 'click', function(){
//	infoWindow.open(map, marker);
//});