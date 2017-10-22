<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Add Car</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" type="text/css" charset="utf-8" />
</head>
<body>
	<div id="outer">
		<div id="wrapper">
			<div id="body-bot">
				<div id="body-top">
					<div id="logo">
						<h1>CAR RENTAL COMPANY</h1>
						<p>For memorable driving experience</p>
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
Price:<input name="cprice" type="text"/>
<br/> <br/>
RentType :
<input type="radio" name="cshareType" value="Shareable"> Shareable
<input type="radio" name="cshareType" value="NonShareable">  NonShareable
<br/> <br/>
<input type="submit" value="Add Car"/>
</form>
								
									<div style=" padding: 6px;background: #EDF0C4;">
									<center><h2>FEATURED SERVICES</h2></centra>
									<br/>
									<ul>
										<li>Book car of your choice</li>
										<li>Easy cancellation and modification</li>
										<li>Add your car</li>
										<li>Rent your car</li>
									</ul>
								</div>
								
								
							</div>
						</div>
						<div id="gbox-bot"></div>
					</div>
					<div id="greybox">
						<div id="greybox-bot">
							<div id="greybox-top">
								<h2>MOST CONVINEIANT & RELIABLE TRANSPORT SERVICES</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


