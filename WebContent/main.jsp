<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="entities.Team, java.util.List"%>
<link href="css/Template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1UTF-8">
<title>Employee Database</title>
</head>
<body>
<%List<Team> t = (List<Team>)request.getAttribute("allTeams");%>
	<form method="post" action="EmployeeServlet">
		<table>
			<h3 class="underline">NEW EMPLOYEES</h3>
			<tr>
				<td>PLEASE ENTER EMPLOYEE INFORMATION BELOW:</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Position:</td>
				<td><input type="text" name="position"></td>
			</tr>
			<tr>
				<td>Manager:</td>
				<td><input type="text" name="manager"></td>
			</tr>
			<tr>
				<td>Hire Date:</td>
				<td><input type="text" name="hireDate"></td>
			</tr>
			<tr>
				<td>Team Name:</td>
				<td><input type="text" name="teamName"></td>
			</tr>
			<tr>
				<td></td>
				<td><center><div><input type="submit" name="doThisToItem" value="Add Employee"></div></center></td>
			</tr>
		</table>
		<table>
			<h3 class="underline">EXISTING EMPLOYEES</h3>
		</table>
		<table>			
			<tr>
				<td>TEAM NAME:</td>
			</tr>
			<tr>
				<td><select id="tName" name="tName">
					<%for (int i = 0; i < t.size(); i++) {%>
					<option value="<%=t.get(i).getTeamName()%>"><%=t.get(i).getTeamName()%></option>
					<%}%>
					</select>
				</td>								
				<td><center><div><input type="submit" name="doThisToItem" value="View Employees"></div></center></td>
			</tr>
		</table>		
</body>
</html>