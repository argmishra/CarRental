<head>
<title>Add Car</title>
<link rel="stylesheet" href="style.css" type="text/css" charset="utf-8" />
</head>
<body>
	<div id="outer">
		<div id="wrapper">
			<div id="body-bot">
				<div id="body-top">
					<div id="logo">
						<h1>CAR RENTAL COMPANY</h1>
						<p>For memorable driving experience</p> <p> <a href="login.jsp">Logout</a> </p>
					</div>
					<div id="nav">
						<ul>
							<li><a href="contact.jsp">CONTACT US</a></li>
							<li><a href="feedback.jsp"> FEEDBACK </a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div id="gbox">
						<div id="gbox-top"></div>
						<div id="gbox-bg">
							<div id="gbox-grd">
								<CENTER>
								<h2>ADD YOUR CAR</h2>
								<CENTER>
								<form action="addCar">
Car Name:<input name="cname" type="text"/>
<br/> <br/>
Car Model:<input name="cmodel" type="text"/>
<br/> <br/>
Seats:<input name="cseat" type="text"/>
<br/> <br/>
Car Category:<input name="ctype" type="text"/>
<br/> <br/>
RentType :
<input type="radio" name="cshareType" value="Shareable"> Shareable
<input type="radio" name="cshareType" value="NonShareable">  NonShareable
<br/> <br/>
<input type="submit" value="Add Car"/>
</form>
								
					
			</div>
		</div>
	</div>
</body>
</html>


