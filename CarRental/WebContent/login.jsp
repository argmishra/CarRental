<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Login</title>
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
								<h2>LOGIN</h2>
								<CENTER>
								<br>
								<br>
								<h3 style="color: black">${errorMsg}</h3>
								<form action="login">

									UserName
									<input type="text" name="username" required>
									<br>
									<br> Password
									<input type="password" name="password" required>
									<br>
									<br>


									<center> <input type="submit" value="Submit"></center>
									<a href="forgot.jsp">Forgot Password</a>
									<a href="registration.jsp">New User</a>

								</form>

								<div id="features">
									<h2>FEATURED SERVICES</h2>
									<br/><br/>
									<ul>
										<li>Book car of your choice</li>
										<li>Easy cancellation and modification</li>
									</ul>
									<ul>
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
