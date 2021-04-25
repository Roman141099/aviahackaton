var ZoomTable={
	0:8000,
	1:3000,
	2:2000,
	3:1000,
	4:500,
	5:300,
	6:200,
	7:150,
	8:100,
}
var TimetoRase={
	1:"59 минут",
	2:"2 часа 35 минут",
	3:"8 часов 25 минут",
	4:"4 часа 15 минут",
	5:"2 часа 5 минут",
}
var MovesVarios={
	1:[1],
	2:[1,2,5],
	3:[3],
	4:[2,4],
	5:[5]
}
var Rases ={
	1: "14.10.48",
	2: "15.10.48",
	3: "16.10.48",
	4: "17.10.48",
}
var zoomInIndex = 0;
var MiddleX
var MiddleY
var Karta = document.getElementById("Map").viewBox.baseVal;
var Proporse =  Karta.height/Karta.width;
var DrawCircle = (x,y) => {
  document.getElementById("Map").innerHTML +=
    '<circle id="Circle' +
    '" cx="' +
    x +
    '" cy="' +
    y +
    '" r="300" class="fill-red"></circle>';
};	
var CalcMiddle = () =>{
	MiddleX=(Karta.width + 2*Karta.x)/2;
	MiddleY=(Karta.height + Karta.y)/2;
	// DrawCircle(MiddleX,MiddleY);

}
CalcMiddle();
var ZoomInMap = () =>{
	zoomInIndex++;	
	console.log(MiddleX,MiddleY);	
	Karta.x = MiddleX - ZoomTable[zoomInIndex]/2;
	Karta.y = MiddleY - ZoomTable[zoomInIndex]*Proporse/2;
	Karta.width = ZoomTable[zoomInIndex];	
	Karta.height = ZoomTable[zoomInIndex]*Proporse;
}
var ZoomOutMap = () =>{
	if(zoomInIndex>0){
	zoomInIndex--;
	}
	Karta.x = MiddleX - ZoomTable[zoomInIndex]/2;
	Karta.y = MiddleY - ZoomTable[zoomInIndex]*Proporse/2;
	Karta.width = ZoomTable[zoomInIndex];	
	Karta.height = ZoomTable[zoomInIndex]*Proporse;

}
var SelectFlight = (input) =>{
	var FlightNumber=input.value;
	if(FlightNumber==1 || FlightNumber==2 || FlightNumber==3 || FlightNumber==4 ||FlightNumber==5){
	document.getElementById("TimeValue").innerHTML=TimetoRase[input.value];
	document.getElementById("GetDirectoin").style.display="block";
	input.parentNode.style.display="none";
	CreateMovesList(input.value);
	return;
	}
	alert("Выбранный рейс не обнаружен");
}
var CreateMovesList = (NuberFlight) =>{	
		var Races=MovesVarios[NuberFlight];
		var out=""

		for(var i=0;i<Races.length;i++){
			var g=Races[i]-1;
			out+="<div class='move'><div class='nameMove'>"+moves[Races[i]-1].name+"</div>"+
			"<div class='selectMove' onclick='SelectMove(moves["+g+"].coords)'>Построить</div>"+
			"</div>"
		}
		document.getElementById("MovesList").innerHTML=out;
}
var SelectMove = (coords)=>{
	if(document.getElementById("PathLine")){
		document.getElementById("PathLine").remove();
	}
	var out = "<polyline id='PathLine' points='";
  	for(var j = 0; j < coords.length; j++) {
    	out += coords[j].x + "," + coords[j].y + " ";
 	}
 	out += "' style='fill:none;stroke:red;stroke-width:10'/>";
  	document.getElementById("Map").innerHTML+= out;
}
var BackToSelectRase = () =>{
	document.getElementById("GetDirectoin").style.display="none";
	document.getElementById("GetNumberFlight").style.display="block";
}
document.querySelectorAll('g[id^="__D3-"]').forEach((elem) => {
  elem.onmouseover = function (event) {
    elem.querySelector("#hover").style.display = "inline";
  };
  elem.onmouseout = function (event) {
    elem.querySelector("#hover").style.display = "none";
  };
});
