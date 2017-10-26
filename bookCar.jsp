<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Book Car</title>
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
								<h2><CENTER> WELCOME TO OUR CAR RENTING COMPANY</CENTER></h2><br/>

								<CENTER>
								<h2>BOOK CAR</h2>
								</CENTER>
								<br/>
								<form action="bookCar">
<div>  <b>Car Name :</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${cardetail.name} </div> 
<div>  <b>  Car Model :</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${cardetail.model}  </div>
<div> <b> Car Seat :</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${cardetail.seat}  </div> 
<div>  <b>  Car Price :</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${cardetail.price} </div>
<div> <b>Car RentType :</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${cardetail.share} </div>

RentType :
<input type="radio" name="paymentType" value="Cash" checked> Cash
<input type="radio" name="paymentType" value="Credit">  Credit Card
<input type="radio" name="paymentType" value="Debit">  Debit Card
<br/> <br/>
Card Number:<input name="cardNumber" type="text"/> <br/> <br/>
CVV Number:<input name="cardCVV" type="text"/><br/> <br/>
Expire Date  :<input name="cardYear" type="text"/>
<br/> <br/>

<br/>
<input type="hidden" value="${cardetail.id}" name="bookingCarId">
<CENTER> <input type="submit" value="Book Car"/> </CENTER><br/>
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
