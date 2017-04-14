package application;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Employee;
import entities.EmployeeHelper;
import entities.Team;
/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside EmployeeServlet");
		
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Add Employee")){

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String position = request.getParameter("position");
			String manager = request.getParameter("manager");
			String hireDate = request.getParameter("hireDate");
			String teamName = request.getParameter("teamName");
			System.out.println("gathered employee info");
			
			int tempTeamID = EmployeeHelper.getTeamIDByName(teamName);
			if (tempTeamID == 0){
				tempTeamID = EmployeeHelper.createNewTeamAndReturnID(teamName);			
			}
			
			Employee employee = new Employee(firstName, lastName, position, manager, hireDate, tempTeamID);
			EmployeeHelper.insertEmployee(employee);
			System.out.println("Ran insert method");
			List<Team> results = EmployeeHelper.getAllTeams();
			request.setAttribute("allTeams", results);
			getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		} else if(actionToPerform.equals("View Employees")){
			System.out.println("Launch us to employee by team screen");
			String tName = request.getParameter("tName");
			System.out.println(tName);
			List<Employee> results = EmployeeHelper.getEmployeesByTeam(tName);				
			request.setAttribute("allEmployees", results);
			getServletContext().getRequestDispatcher("/employeeList.jsp").forward(request, response);
		}

	}

}
