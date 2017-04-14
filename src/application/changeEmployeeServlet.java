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
 * Servlet implementation class changeEmployeeServlet
 */
@WebServlet("/changeEmployeeServlet")
public class changeEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeEmployeeServlet() {
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
		System.out.println("Inside changeEmployeeServlet");
		int nEID = Integer.parseInt(request.getParameter("newEmployeeID"));
		String nFN = request.getParameter("newFirstName");
		String nLN = request.getParameter("newLastName");
		String nP = request.getParameter("newPosition");
		String nM = request.getParameter("newManager");
		String nHD = request.getParameter("newHireDate");
		int nTI = Integer.parseInt(request.getParameter("newTeamID"));
		
		Employee newInformation = new Employee(nEID, nFN, nLN, nP, nM, nHD, nTI);		
		EmployeeHelper.updateEmployee(newInformation);
		List<Team> results = EmployeeHelper.getAllTeams();
		request.setAttribute("allTeams", results);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}
	
	
	

}
