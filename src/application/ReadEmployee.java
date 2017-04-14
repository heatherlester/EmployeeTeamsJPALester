package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Employee;
import entities.Team;

public class ReadEmployee {

	public static void main(String[] args) {
		//Create instance of EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
		
		Scanner in = new Scanner(System.in);
		
		//Return employees based on team name
		System.out.print("Enter a team name to find all employees associated to the team: ");
		String selectedTeam = in.nextLine();
	
		TypedQuery<Employee> selectedTeamQuery = em.createQuery("select e from Employee e, Team t where e.teamID = t.teamID and t.teamName = :selectedTeam", Employee.class);
		selectedTeamQuery.setParameter("selectedTeam", selectedTeam);
		List<Employee> results = selectedTeamQuery.getResultList();
				
		for(Employee a : results){
			System.out.println(a.getFirstName() + " " + a.getLastName());
		}
		
		
		//Return team name based on employee name
		System.out.print("Enter an employee name to find the associated team name: ");
		String selectedEmployee = in.nextLine();
	
		TypedQuery<Team> selectedEmployeeQuery = em.createQuery("select t from Team t, Employee e where t.teamID = e.teamID and e.firstName = :selectedEmployee", Team.class);
		selectedEmployeeQuery.setParameter("selectedEmployee", selectedEmployee);
		List<Team> teamResults = selectedEmployeeQuery.getResultList();
				
		for(Team t : teamResults){
			System.out.println(t.getTeamName());
		}
		

		//ListEmployee found = em.find(ListEmployee.class, 1);
		//System.out.println(found.getFirstName() + " " + found.getLastName());
		
		//Close instance of EntityManagerFactory
		em.close();
		emfactory.close();
		
		in.close();
	}

}
