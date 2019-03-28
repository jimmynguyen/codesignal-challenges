// js snippet to run in the browser to extract tests
var data = {};
data.inputs = [];
data.outputs = [];
for (var i = 0; i < $('.accordion--head').length; i++) {
	$('.accordion--head')[i].click();
	if (i == 0) {
		for (var j = 0; j < $('.task-tests--value > div').length; j++) {
			data.inputs[j] = [$('.task-tests--value > div')[j].innerText];
		}
	} else {
		for (var j = 0; j < $('.task-tests--value > div').length; j++) {
			data.inputs[j].push($('.task-tests--value > div')[j].innerText);
		}
	}
	if ($('.-answer').length > 0) {
		data.outputs.push($('.-answer')[0].innerText);
	}
}
JSON.stringify(data)