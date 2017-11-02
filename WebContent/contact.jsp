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
<title>Contact Us</title>
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
							<li><a href="feedback.jsp"> FEEDBACK </a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div id="gbox">
						<div id="gbox-top"></div>
						<div id="gbox-bg">
							<div id="gbox-grd">
								<h2>WELCOME TO OUR CAR RENTING COMPANY</h2>

								<CENTER>
								<h2>CONTACT DETAILS</h2>
								</CENTER> <h4><br>  <b><u>Contact Number</u></b> : <%=number %> <br/>
									<b><u> Mailing address</u></b> : <%=email %> <br/> <b> <u>Address :</u> </b> <br/> <%=addressLine1 %><br/>
									<%=addressLine2 %><br/> <%=location %><br/> <%=postcode %><br/> </h4>
									
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
