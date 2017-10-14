<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car</title>
</head>
<body>
 This is add car page
 
 <form action="addCar">
Car Name:<input name="cname" type="text"/>
<br/>
Car Model:<input name="cmodel" type="text"/>
<br/>
Seats:<input name="cseat" type="text"/>
<br/>
Price:<input name="cprice" type="text"/>
<br/>
RentType :
<input type="radio" name="cshareType" value="Shareable"> Shareable
<input type="radio" name="cshareType" value="NonShareable">  NonShareable
<br/>
<input type="Submit" value="Add Car"/>



 </form>
</body>
</html>