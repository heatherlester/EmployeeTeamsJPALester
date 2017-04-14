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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		System.out.println("Inside EditServlet");
		
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Edit Employee")){
			int tempEmployeeID = Integer.parseInt(request.getParameter("id"));
			System.out.println("*****Employee ID is: " + tempEmployeeID);
			
			Employee employeeToEdit = EmployeeHelper.getEmployeeByID(tempEmployeeID).get(0);
			request.setAttribute("employeeID", tempEmployeeID + "");
			request.setAttribute("firstName", employeeToEdit.getFirstName());
			request.setAttribute("lastName", employeeToEdit.getLastName());
			request.setAttribute("position", employeeToEdit.getPosition());
			request.setAttribute("manager", employeeToEdit.getManager());
			request.setAttribute("hireDate", employeeToEdit.getHireDate());
			request.setAttribute("teamID", employeeToEdit.getTeamID());			
			System.out.println("employee attributes set inside EditServlet");
						
			getServletContext().getRequestDispatcher("/editEmployee.jsp").forward(request, response);
		} else if(actionToPerform.equals("Delete Employee")){
			System.out.println("Remove employee");
			int tempEmployeeID = Integer.parseInt(request.getParameter("id"));
			System.out.println("*****Employee ID is: " + tempEmployeeID);
			
			EmployeeHelper.deleteEmployeeByID(tempEmployeeID);
			List<Team> results = EmployeeHelper.getAllTeams();
			request.setAttribute("allTeams", results);
			getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}

}
