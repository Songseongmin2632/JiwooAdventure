<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="UTF-8">
	<title>Field</title>
	<link rel="stylesheet" href="style/common.css">
	<link rel="stylesheet" href="style/field.css">
</head>
<body>
	<div class="root-mainScreen">
		<div class="fieldInfo">
			<div class="firstLine">
				<div class="level">Lv</div>
				<div class="levelInfo">1</div>
				<div class="levelBox">0%</div>
			</div>
			<div class="secondLine">
				<img src="images/소지금.png" class="moneyImage" />
				<div class="money">0</div>
			</div>
		</div>
		<div class="charBox">			
			<img src="images/메인캐릭터.png" class="mainCharacter"/>			
		</div>
		<div class="menuBox">
			<a href="index.jsp">
				<img src="images/처음으로.png" class="menu-main"/>
			</a>
			<a href="shop.jsp">
				<img src="images/상점.png" class="menu-shop"/>
			</a>	
			<a href="information.jsp">
				<img src="images/플레이어정보.png" class="menu-information"/>
			</a>
			<a href="stageSelect.jsp">
				<img src="images/전투1.png" class="menu-battle"/>
			</a>
		</div>
	</div>
</body>
</html>