function openNav() {
    document.getElementById("mySidenav").style.width = "200px";
    document.getElementById("main").style.marginLeft = "200px";
}


function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}

$(document).ready(function() {
	$('.titel').hide().fadeIn(2500, 'linear');
});

$(document).ready(function() {
	var speed = 5000;
	$('#fixedheader').slideDown(speed);
	$('#fixedfooter').slideDown(speed);
});

