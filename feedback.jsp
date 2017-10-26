<%@ page language="java" import="java.util.*"%>
<%@ page import="java.util.ResourceBundle"%>
<% ResourceBundle resource = ResourceBundle.getBundle("config");
  String number=resource.getString("number");
  String email=resource.getString("email");
  String addressLine1=resource.getString("addressLine1");
  String addressLine2=resource.getString("addressLine2");
  String location=resource.getString("location");
  String postcode=resource.getString("postcode");%>
<head>
<title>Feedback</title>
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
							<li><a href="registration.jsp">REGISTRATION</a></li>
							<li><a href="login.jsp">LOGIN</a></li>
							<li><a href="contact.jsp">CONTACT US</a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div id="gbox">
						<div id="gbox-top"></div>
						<div id="gbox-bg">
							<div id="gbox-grd">
								<h2>WELCOME TO CAR RENTING COMPANY</h2>

								<CENTER>
								<h2>FEEDBACK</h2>
								</CENTER> 
								<h4 style="color: green">${infoMsg}</h4>
								<form action="feedback">

									Title
									<input type="text" name="fdTitle" style="width: 300px;" required>
									<br>
									<br> Description
									<input type="textarea" name="fdDescription" style="width:300px; height: 100px;"">
									<br>
									<br>


									<center> <input type="submit" value="Submit Feedback"></center>
									

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
