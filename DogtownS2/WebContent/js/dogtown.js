
function totalScores(label)
{
	var total = 0;
	var totalNine = 0;

	for(i = 1; i < 19; i++)
	{
		var hole = document.getElementById(label + i + "LabelText");
		
		total = total + parseInt(hole.value);
		if(i<10){
			totalNine = total;
		}
	}
	
	var scorecardTotal = document.getElementById(label + "TotalLabelText");
	var scorecardTotalAfterNine = document.getElementById(label + "TotalAfterNineLabelText");
	
	scorecardTotalAfterNine.innerHTML = totalNine;
	scorecardTotal.innerHTML = total;
}

function calcNines(label)
{

	var totalNine = 0;

	for(i = 1; i < 10; i++)
	{
		var hole = document.getElementById(label + i + "LabelText");
		
		totalNine = totalNine + parseInt(hole.value);
	}

	var scorecardTotalAfterNine = document.getElementById(label + "TotalAfterNineLabelText");
	scorecardTotalAfterNine.innerHTML = totalNine;

}