<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script> --%>

<html lang="en">
	<head>
		<meta charset="utf-8" />

		<c:url value="/resources/css/searchStyle.css" var="url" />
		<c:url value="/resources/css/autoCompleteSearchStyle.css" var="autoCompleteUrl" />
		<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
		<link rel="stylesheet" href="${autoCompleteUrl}" type="text/css">
		<title>Search</title>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<!-- 		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
		
		<script>
		$(document).ready(function(){
		  	$("#submit").click(function(){
			    $(search).hide();
			    $(header).hide(); 
			    $(loading).show();
			});
		});  
		$(function() {
			var candidateList= ["Aderholt, Robert", "Alexander, Rodney", "Amash, Justin", "Amodei, Mark", "Andrews, Robert", "Ann Emerson, Jo", "Bachmann, Michele", "Bachus, Spencer", "Barber, Ron", "Barletta, Lou", "Barr, Andy", "Barrow, John", "Barton, Joe", "Bass, Karen", "Beatty, Joyce", "Becerra, Xavier", "Benishek, Dan", "Bentivolio, Kerry", "Bera, Ami", "Bernice Johnson, Eddie", "Bilirakis, Gus", "Bishop, Rob", "Bishop, Sanford", "Bishop, Timothy", "Black, Diane", "Blackburn, Marsha", "Blumenauer, Earl", "Boehner, John", "Bonamici, Suzanne", "Bonner, Jo", "Boustany, Charles", "Brady, Kevin", "Brady, Robert", "Braley, Bruce", "Bridenstine, Jim", "Brooks, Mo", "Brooks, Susan", "Broun, Paul", "Brown, Corrine", "Brownley, Julia", "Buchanan, Vern", "Bucshon, Larry", "Burgess, Michael", "Bustos, Cheri", "Butterfield, G.K.", "C. Peterson, Collin", "Calvert, Ken", "Camp, Dave", "Campbell, John", "Cantor, Eric", "Capps, Lois", "Capuano, Mike", "Cardenas, Tony", "Carney, John", "Carson, Andre", "Carter, John", "Cartwright, Matthew", "Cassidy, Bill", "Castor, Kathy", "Castro, Joaquin", "Chabot, Steve", "Chaffetz, Jason", "Chu, Judy", "Cicilline, David", "Clarke, Yvette", "Clay, Lacy", "Cleaver, Emanuel", "Clyburn, Jim", "Coble, Howard", "Coffman, Mike", "Cohen, Steve", "Cole, Tom", "Collins, Chris", "Collins, Doug", "Conaway, Mike", "Connolly, Gerry", "Conyers, John", "Cook, Paul", "Cooper, Jim", "Costa, Jim", "Cotton, Tom", "Courtney, Joe", "Cramer, Kevin", "Crawford, Rick", "Crenshaw, Ander", "Crowley, Joe", "Cuellar, Henry", "Culberson, John", "Cummings, Elijah", "D. Hunter, Duncan", "Daines, Steve", "Davis, Danny", "Davis, Rodney", "Davis, Susan", "DeFazio, Peter", "DeGette, Diana", "Delaney, John", "DeLauro, Rosa", "DelBene, Suzan", "Denham, Jeff", "Dent, Charles", "DeSantis, Ron", "DesJarlais, Scott", "Deutch, Ted", "Diaz-Balart, Mario", "Dingell, John", "Doggett, Lloyd", "Doyle, Mike", "Duckworth, Tammy", "Duffy, Sean", "Duncan, Jeff", "Duncan, John", "E. Serrano, Jose", "Edwards, Donna", "Ellison, Keith", "Ellmers, Renee", "Engel, Eliot", "Enyart, William", "Eshoo, Anna", "Esty, Elizabeth", "Farenthold, Blake", "Farr, Sam", "Fattah, Chaka", "Fincher, Stephen", "Fitzpatrick, Mike", "Fleischmann, Chuck", "Fleming, John", "Flores, Bill", "Forbes, Randy", "Fortenberry, Jeff", "Foster, Bill", "Foxx, Virginia", "Frankel, Lois", "Franks, Trent", "Frelinghuysen, Rodney", "Fudge, Marcia", "Gabbard, Tulsi", "Gallego, Pete", "Garamendi, John", "Garcia, Joe", "Gardner, Cory", "Garrett, Scott", "Gerlach, Jim", "Gibbs, Bob", "Gibson, Christopher", "Gingrey, Phil", "Gohmert, Louie", "Goodlatte, Bob", "Gosar, Paul", "Gowdy, Trey", "Granger, Kay", "Graves, Sam", "Graves, Tom", "Grayson, Alan", "Green, Al", "Green, Gene", "Griffin, Tim", "Griffith, Morgan", "Grijalva, Raul", "Grimm, Mike", "Guthrie, Brett", "Gutierrez, Luis", "Hahn, Janice", "Hall, Ralph", "Hanabusa, Colleen", "Hanna, Richard", "Harper, Gregg", "Harris, Andy", "Hartzler, Vicky", "Hastings, Alcee", "Hastings, Doc", "Heck, Denny", "Heck, Joe", "Hensarling, Jeb", "Herrera Beutler, Jaime", "Higgins, Brian", "Himes, Jim", "Hinojosa, Ruben", "Holding, George", "Holt, Rush", "Honda, Mike", "Horsford, Steven", "Hoyer, Steny", "Hudson, Richard", "Huelskamp, Tim", "Huffman, Jared", "Huizenga, Bill", "Hultgren, Randy", "Hurt, Robert", "Israel, Steve", "Issa, Darrell", "Jackson Lee, Sheila", "Jackson, Jesse", "Jeffries, Hakeem", "Jenkins, Lynn", "Johnson, Bill", "Johnson, Hank", "Johnson, Sam", "Jones, Walter", "Jordan, Jim", "Joyce, David", "Kaptur, Marcy", "Keating, Bill", "Kelly, Mike", "Kennedy, Joe", "Kildee, Daniel", "Kilmer, Derek", "Kind, Ron", "King, Peter", "King, Steve", "Kingston, Jack", "Kinzinger, Adam", "Kirkpatrick, Ann", "Kline, John", "Kuster, Ann", "La Malfa, Doug", "Labrador, Raul", "Lamborn, Doug", "Lance, Leonard", "Langevin, Jim", "Lankford, James", "Larsen, Rick", "Larson, John", "Latham, Tom", "Latta, Bob", "Lee, Barbara", "Levin, Sander", "Lewis, John", "Lipinski, Dan", "LoBiondo, Frank", "Loebsack, Dave", "Lofgren, Zoe", "Long, Billy", "Lowenthal, Alan", "Lowey, Nita", "Lucas, Frank", "Luetkemeyer, Blaine", "Lujan Grisham, Michelle", "Lummis, Cynthia", "Lynch, Stephen", "Maffei, Daniel", "Maloney, Carolyn", "Marchant, Kenny", "Marino, Thomas", "Markey, Ed", "Massie, Thomas", "Matheson, Jim", "Matsui, Doris", "McCarthy, Carolyn", "McCarthy, Kevin", "McCaul, Michael", "McClintock, Tom", "Mccollum, Betty", "McDermott, Jim", "McGovern, Jim", "McHenry, Patrick", "McIntyre, Mike", "McKeon, Buck", "McKinley, David", "McLeod, Gloria", "McMorris Rodgers, Cathy", "McNerney, Jerry", "Meadows, Mark", "Meehan, Patrick", "Meeks, Gregory", "Meng, Grace", "Messer, Luke", "Mica, John", "Michaud, Mike", "Miller, Candice", "Miller, Gary", "Miller, George", "Miller, Jeff", "Moore Capito, Shelley", "Moore, Gwen", "Moran, Jim", "Mullin, Markwayne", "Mulvaney, Mick", "Murphy, Patrick", "Murphy, Tim", "Nadler, Jerrold", "Napolitano, Grace", "Neal, Richard", "Neugebauer, Randy", "Noem, Kristi", "Nolan, Richard", "Nugent, Richard", "Nunes, Devin", "Nunnelee, Alan", "O'Rourke, Beto", "Olson, Pete", "Owens, Bill", "Palazzo, Steven", "Pallone, Frank", "Pascrell, Bill", "Pastor, Ed", "Patrick Maloney, Sean", "Paulsen, Erik", "Payne Jr., Donald", "Pearce, Steve", "Pelosi, Nancy", "Perlmutter, Ed", "Perry, Scott", "Peters, Gary", "Peters, Scott", "Petri, Tom", "Pingree, Chellie", "Pittenger, Robert", "Pitts, Joseph", "Pocan, Mark", "Poe, Ted", "Polis, Jared", "Pompeo, Mike", "Posey, Bill", "Price, David", "Price, Tom", "Quigley, Mike", "R. Lujan, Ben", "Radel, Trey", "Rahall, Nick", "Rangel, Charles", "Reed, Thomas", "Reichert, Dave", "Renacci, Jim", "Ribble, Reid", "Rice, Tom", "Richmond, Cedric", "Rigell, Scott", "Roby, Martha", "Roe, Phil", "Rogers, Hal", "Rogers, Mike", "Rogers, Mike", "Rohrabacher, Dana", "Rokita, Todd", "Rooney, Tom", "Ros-Lehtinen, Ileana", "Roskam, Peter", "Ross, Dennis", "Rothfus, Keith", "Roybal-Allard, Lucille", "Royce, Ed", "Ruiz, Raul", "Runyan, Jon", "Ruppersberger, Dutch", "Rush, Bobby", "Ryan, Paul", "Ryan, Tim", "Salmon, Matt", "Sanchez, Linda", "Sanchez, Loretta", "Sarbanes, John", "Scalise, Steve", "Schakowsky, Jan", "Schiff, Adam", "Schneider, Brad", "Schock, Aaron", "Schrader, Kurt", "Schwartz, Allyson", "Schweikert, David", "Scott, Austin", "Scott, Bobby", "Scott, David", "Scott, Tim", "Sensenbrenner, Jim", "Sessions, Pete", "Sewell, Terri", "Shea-Porter, Carol", "Sherman, Brad", "Shimkus, John", "Shuster, Bill", "Simpson, Mike", "Sinema, Kyrsten", "Sires, Albio", "Slaughter, Louise", "Smith, Adam", "Smith, Adrian", "Smith, Chris", "Smith, Lamar", "Southerland, Steve", "Speier, Jackie", "Stewart, Chris", "Stivers, Steve", "Stockman, Steve", "Stutzman, Marlin", "Swalwell, Eric", "Takano, Mark", "Terry, Lee", "Thompson, Bennie", "Thompson, Glenn", "Thompson, Mike", "Thornberry, Mac", "Tiberi, Pat", "Tierney, John", "Tipton, Scott", "Titus, Dina", "Tonko, Paul", "Tsongas, Niki", "Turner, Mike", "Upton, Fred", "Valadao, David", "Van Hollen, Chris", "Vargas, Juan", "Veasey, Marc", "Vela, Filemon", "Velazquez, Nydia", "Visclosky, Peter", "Wagner, Ann", "Walberg, Tim", "Walden, Greg", "Walorski, Jackie", "Walz, Tim", "Wasserman Schultz, Debbie", "Waters, Maxine", "Watt, Mel", "Waxman, Henry", "Weber, Randy", "Webster, Daniel", "Welch, Peter", "Wenstrup, Brad", "Westmoreland, Lynn", "Whitfield, Ed", "Williams, Roger", "Wilson, Frederica", "Wilson, Joe", "Wittman, Rob", "Wolf, Frank", "Womack, Steve", "Woodall, Rob", "Yarmuth, John", "Yoder, Kevin", "Yoho, Ted", "Young, Bill", "Young, Don", "Young, Todd"] ;
			$( "#searchField").autocomplete({
				source: candidateList
			});
		});
		
		
		
		</script>
	</head>
	<h2 id="header" class="center">Search by Candidate Name</h2>
		<body onload='document.search.cand_name.focus();' class="center">	
			<div id="loading" style="display:none">
				<div id="pleaseWait">
					Searching the Universe
				</div>
				<div id="spinner_container">
					<img id="spinner" src="${pageContext.request.contextPath}/resources/img/progress-wheel.gif" alt="" />
				</div>
			</div>
			<div id="search">	
				<P>
					<font color="red">${error_msg}</font>
				</P>
				
				<form id="inputField" name="search" method="POST" onsubmit="loadingBar();">
					<input id="searchField" type="text" name="cand_name" autocomplete="off" placeholder="ex. Connolly, Gerry" size=25 maxlength=25>
			    	<input type="submit" id="submit" value="Search"/>
				</form>
			</div>
		</body>
</html>
