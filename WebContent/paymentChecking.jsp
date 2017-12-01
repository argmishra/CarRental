<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Refresh" content="5;url=paymentConfimration.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checking Payment</title>
</head>
<body><h2>
Total amount paid is : <c:out value="${amount}"></c:out>  </br></br>
Please wait while we are confirming details. You will be redirected automatically.
</h2>
</body>
</html>