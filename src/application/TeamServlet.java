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
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
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
		System.out.println("Inside TeamServlet");
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Enter Employee Database")){
		System.out.println("Launch us to employee screen");
		List<Team> results = EmployeeHelper.getAllTeams();
		//for (int i = 0; i < results.size(); i++) {
		//System.out.println(" ******* " + results.get(i).getTeamName());
		//}
		
		request.setAttribute("allTeams", results);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}
}
