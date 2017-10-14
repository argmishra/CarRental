<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Car</title>
</head>
<body>
This is book car page

<form action="book">
<input type="hidden" value="<c:out value="${carId}" />" name="bookingCarId">
<input type="Submit" value="Book Car"/>
</form>

</body>
</html>