$(document).ready(function() {
	$("#ydna").show();
	$('.raw').show();
	if ($('input[name=test]:checked').val() == '23andMe') {
		$('.23').show();
		$('.exp23').show();
		$('.gen').hide();
		$('.expGen').hide();
		$('.expGenNext').hide();
	} else if ($('input[name=test]:checked').val() == 'geno') {
		$('.23').hide();
		$('.exp23').hide();
		$('.gen').show();
		$('.expGen').show();
		$('.expGenNext').hide();
	} else {
		$('.23').hide();
		$('.exp23').hide();
		$('.gen').show();
		$('.expGen').hide();
		$('.expGenNext').show();
	}
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
			$('.23').show();
			$('.exp23').show();
			$('.gen').hide();
			$('.expGen').hide();
			$('.expGenNext').hide();
		} else if (test == 'geno') {
			$('.23').hide();
			$('.exp23').hide();
			$('.gen').show();
			$('.expGen').show();
			$('.expGenNext').hide();
		} else {
			$('.23').hide();
			$('.exp23').hide();
			$('.gen').show();
			$('.expGen').hide();
			$('.expGenNext').show();
		}
	}
}