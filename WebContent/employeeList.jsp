<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="entities.Employee, java.util.List"%>
<link href="css/Template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
<%List<Employee> e = (List<Employee>) request.getAttribute("allEmployees");
String teamName = (String)request.getParameter("tName").toUpperCase();%>

	<form method="post" action="EditServlet">
		<table>
			<tr>
				<h3 class="underlineCenter">DISPLAYING EMPLOYEES FOR TEAM: <%=teamName%></h3>
			</tr>
		</table>
		<table class="border">
			<tr class="border">
				<td class="fontBackground"></td>
				<td class="fontBackground">First Name</td>
				<td class="borderBackground">Last Name</td>
				<td class="borderBackground">Position</td>
				<td class="borderBackground">Manager</td>
				<td class="borderBackground">Hire Date</td>
			</tr>
			<%for (int i = 0; i < e.size(); i++) {%>
			<tr class="border">
				<td><input type="radio" name="id" value="<%=e.get(i).getEmployeeID()%>"></td>
				<td class="font"><%=e.get(i).getFirstName()%></td>
				<td class="border"><%=e.get(i).getLastName()%></td>
				<td class="border"><%=e.get(i).getPosition()%></td>
				<td class="border"><%=e.get(i).getManager()%></td>
				<td class="border"><%=e.get(i).getHireDate()%></td>
			</tr>
			<%}%>
		</table>
		<br>
		<center>
			<div>
				<input type="submit" name="doThisToItem" value="Edit Employee" class="button2">
				<input type="submit" name="doThisToItem" value="Delete Employee" class="button2">
				<input type=button value="Back" onCLick="history.back()" class="button2">
			</div>
		</center>
	</form>
</body>
</html>