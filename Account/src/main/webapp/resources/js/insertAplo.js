$(document).ready(function() {
	if ($('input[name=sesso]:checked').val() == "maschio") {
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
	} else {
		$("#ydna").hide();
		$('.raw').hide();
		$('.exp23').hide();
		$('.expGen').hide();
		$('.expGenNext').hide();
	}
});

function displayForm(c) {
	if (c.value == 'maschio') {
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
	} else {
		$("#ydna").hide();
		$('.raw').hide();
		$('.exp23').hide();
		$('.expGen').hide();
		$('.expGenNext').hide();
	}
}

function displayAplo(d) {
	if ($('input[name=sesso]:checked').val() == 'maschio') {
		if (d.value == '23andMe') {
			$('.23').show();
			$('.exp23').show();
			$('.gen').hide();
			$('.expGen').hide();
			$('.expGenNext').hide();
		} else if (d.value == 'geno') {
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