$(document).ready(function() {
	display();
});

function display() {
	var sesso = $('input[name=sesso]:checked').val();
	var test = $('input[name=test]:checked').val();
	
	if (sesso == 'femmina' || test == 'ancestry') {
		$("#ydna").hide();
		$('.raw').hide();
		$('.exp23').hide();
		$('.expGen').hide();
		$('.expGenNext').hide();
		$('.expLiving').hide();
		if (test == 'ancestry') {
			$("#ancestry").show();
			$("#mtdna").hide();
		} else {
			$("#ancestry").hide();
			$("#mtdna").show();
		}
	} else {
		$("#mtdna").show();
		$("#ancestry").hide();
		$("#ydna").show();
		$('.raw').show();
		if (test == '23andMe') {
			$('.exp23').show();
			$('.expGen').hide();
			$('.expGenNext').hide();
			$('.expLiving').hide();
		} else if (test == 'living') {
			$('.exp23').hide();
			$('.expGen').hide();
			$('.expGenNext').hide();
			$('.expLiving').show();
		} else if (test == 'geno') {
			$('.exp23').hide();
			$('.expGen').show();
			$('.expGenNext').hide();
			$('.expLiving').hide();
		} else {
			$('.exp23').hide();
			$('.expGen').hide();
			$('.expGenNext').show();
			$('.expLiving').hide();
		}
	}
}