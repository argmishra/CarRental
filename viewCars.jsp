<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ul.project.dto.CarDetail" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View page</title>
</head>
<body>
<% CarDetail carlist = (CarDetail)request.getAttribute("carlist"); %>
This is view Car page
<a href="addCar.jsp"> Add Car </a>
Text Fields <a href="deleteCar.jsp"> Delete Booking </a>
Text Fields <a href="addCar.jsp"> Edit Car </a>
<br/>


<c:forEach items="${carlist}" var="clist">
<table>
       <tr><c:out value="${clist.model}"/></tr>
       <tr><c:out value="${clist.name}"/></tr>
       <tr><c:out value="${clist.seat}"/></tr>
       <tr><c:out value="${clist.price}"/></tr>
       <tr><c:out value="${clist.share}"/></tr>
        <tr><c:out value="${clist.status}"/></tr>
       <tr><a href="ShowCarServlet?carId=${clist.id}"> Book Now</a></tr>
       </table>
</c:forEach>


</body>
</html>

