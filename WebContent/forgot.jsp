<head>
<title>Forgot Password</title>
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
							<li><a href="contact.jsp">CONTACT US</a></li>
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
								<h2>RESET PASSWORD</h2>
								<CENTER>
								<br/>
								
								<h3 style="color: black">${msg}</h3>
								<form action="forgot">

									UserName
									<input type="text" name="uname" required>
									<br>
									<br> New Password
									<input type="password" name="npassword" required>
									<br>
									<br>


									<center> <input type="submit" value="Reset Password"></center>
									<a href="login.jsp">Login</a>

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
