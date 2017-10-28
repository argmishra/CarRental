<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ul.project.dto.CarDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>View Cars</title>
<link rel="stylesheet" href="style.css" type="text/css" charset="utf-8" />
</head>
<body>
<% CarDetail carlist = (CarDetail)request.getAttribute("carlist"); %>
	<div id="outer">
		<div id="wrapper">
			<div id="body-bot">
				<div id="body-top">
					<div id="logo">
						<h1>CAR RENTAL COMPANY</h1>
						<p>For memorable driving experience</p>  <p> <a href="login.jsp">Logout</a> </p>
					</div>
					<div id="gbox">
						<div id="gbox-top"></div>
						<div id="gbox-bg">
							<div id="gbox-grd">
	
<c:choose>
  <c:when test='${userType == "1"}'>
  <h2>Report Generation : </h2> <br>
Current users Report &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ReportServlet?reportId=1">Generate PDF</a> <br>
Available cars Report &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ReportServlet?reportId=2">Generate PDF</a> <br>
Booking History Report &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ReportServlet?reportId=3">Generate PDF</a> <br> 
Feedbacks Report  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ReportServlet?reportId=4">Generate PDF</a> <br> <br>
Reset Utilities : <br>
To reset booking status (Currently this will be manual process) <a href="ResetServlet?resetId=1">Reset</a> <br>
  </c:when>
  
  <c:otherwise>
   <CENTER>
									<h2>All available cars</h2>
									<CENTER>
<table style="border: 1px solid black;background-color: #f1f1c1;">
 <tr> <td><b>Model</b></td><td><b>Name</b></td><td><b>Seat</b></td><td><b>Price</b></td><td><b>Type</b></td></tr>
 <c:forEach items="${carlist}" var="clist"> <tr>
       <td><c:out value="${clist.model}"/></td>
       <td><c:out value="${clist.name}"/></td>
       <td><c:out value="${clist.seat}"/></td>
       <td><c:out value="${clist.price}"/></td>
       <td><c:out value="${clist.share}"/></td>
      <c:if test = "${clist.status == 'UnBooked'}"><td><a href="ShowCarServlet?carId=${clist.id}"> Book Now</a></td></c:if>
      <c:if test = "${clist.status == 'Booked'}"><td>Book Now</td></c:if>   
       </tr>
</c:forEach>
</table>
<form action="showeditCar"> Insert Car Id <input type="text" name="carId" required> <a href="addCar.jsp"> <input type="submit" value="Edit Car"> </a></form>
 <form action="deleteBooking"> Insert Booking Id <input type="text" name="deleteBookingId" required><input type="submit" value="Delete Booking"> </form>
 
  </c:otherwise>
</c:choose>
<br>Please click here to <a href="addCar.jsp">Add Car</a> <br><br>
</div></div></div></div>


			</div>
		</div>
	</div>
</body>
</html>


