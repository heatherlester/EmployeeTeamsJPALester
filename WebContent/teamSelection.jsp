<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="entities.Team, java.util.List"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Team> t = (List<Team>) request.getAttribute("allTeams");%>
	<form method="post" action="EditServlet">
		<table>
			<tr>
				<td class="font">Please select the type of election:</td>
				<td><select id="tName" name="tName">
						<%for(int i = 0; i < t.size(); i++){ %>
						<option value="<%=i%>"><%=t.get(i) %></option>

						<%} %>
				</select></td>
			</tr>
		</table>
		<center>
			<div>
				<input type="submit" name="doThisToItem" value="View Employees">
				<input type=button value="Back" onCLick="history.back()">
			</div>
		</center>
	</form>
</body>
</html>