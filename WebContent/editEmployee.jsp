<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/Template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee Information</title>
</head>
<body>
<%
String tempEmployeeID = (String)request.getAttribute("employeeID");
String tempFirstName = (String)request.getAttribute("firstName");
String tempLastName = (String)request.getAttribute("lastName");
String tempPosition = (String)request.getAttribute("position");
String tempManager = (String)request.getAttribute("manager");
String tempHireDate = (String)request.getAttribute("hireDate");
String tempTeamID = request.getAttribute("teamID").toString();
%>

<form action="changeEmployeeServlet" method="post">
<table>
	<tr><h3 class="underline">EDIT EMPLOYEE INFORMATION BELOW</h3></tr>
	<tr>
		<td class="font">First Name:</td>
		<td><input type = "text" name = "newFirstName" value = "<%=tempFirstName %>"></td>
	</tr>
	<tr>
		<td class="font">Last Name:</td>
		<td><input type = "text" name = "newLastName" value = "<%=tempLastName%>"></td>
	</tr>
	<tr>
		<td class="font">Position:</td>
		<td><input type = "text" name = "newPosition" value = "<%=tempPosition%>"></td>
	</tr>
	<tr>
		<td class="font">Manager:</td>
		<td><input type = "text" name = "newManager" value = "<%=tempManager%>"></td>
	</tr>
	<tr>
		<td class="font">Hire Date:</td>
		<td><input type = "text" name = "newHireDate" value = "<%=tempHireDate%>"></td>
	</tr>
</table>
<br>
<input type = "hidden" name = "newEmployeeID" value = "<%=tempEmployeeID%>">
<input type = "hidden" name = "newTeamID" value = "<%=tempTeamID%>">
<input type = "submit" value = "Save Changes" class="button2">
<input type = "submit" value = "Back" class="button2">

</form>
</body>
</html>