package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


public class EmployeeHelper {
	
	public static List<Employee> getAllEmployees(){
		System.out.println("Inside getAllEmployees method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Employee> selectedTeamQuery = em.createQuery("select e from Employee e, Team t where e.teamID = t.teamID",Employee.class);
		List<Employee> getAllEmployees = selectedTeamQuery.getResultList();
		
		em.close();
		emfactory.close();
		
		return getAllEmployees;		
	}
	
	public static List<Employee> getEmployeesByTeam(String teamName){
		System.out.println("Inside getEmployeesByTeam method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Employee> selectedTeamQuery = em.createQuery("select e from Employee e, Team t where e.teamID = t.teamID and t.teamName = :tName",Employee.class);
		selectedTeamQuery.setParameter("tName", teamName);

		List<Employee> getEmployeesByTeam = selectedTeamQuery.getResultList();
		
		em.close();
		emfactory.close();
		
		return getEmployeesByTeam;		
	}
	
	public static List<Team> getAllTeams(){
		System.out.println("Inside getAllTeams method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Team> selectedEmployeeQuery = em.createQuery("select t from Team t",Team.class);
		List<Team> getAllTeams = selectedEmployeeQuery.getResultList();
		
		for(Team t : getAllTeams){
			System.out.println(t.getTeamName());
		}
		
		em.close();
		emfactory.close();
		
		return getAllTeams;		
	}
	
	public static void insertEmployee(Employee employee){
		System.out.println("Inside insertEmployee Method");
		//Create instance of EntityManagerFactory1
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
				
		//Create entity based off object
		//Employee toAdd = new Employee(employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getManager(), employee.getHireDate());
				
		//Add item in database
		em.persist(employee);
		em.getTransaction().commit();
		System.out.println("Exiting insertEmployeeMethod");
	}
	
	public static int getTeamIDByName(String teamName){
		System.out.println("Inside getTeamIDByName method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Query selectedTeamQuery = em.createQuery("select teamID from Team team where teamName = :teamName");
		//selectedTeamQuery.setParameter("teamName", teamName);		
		
		TypedQuery<Team> selectedTeamQuery = em.createQuery("select t from Team t where t.teamName = :tName",Team.class);
		selectedTeamQuery.setParameter("tName", teamName);
		
		System.out.println("Team Name is: " + teamName);

		int getTeamIDByName = 0;
		try {
			getTeamIDByName = selectedTeamQuery.getResultList().get(0).getTeamID();
			System.out.println("Team ID is: " + getTeamIDByName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
		emfactory.close();
		
		return getTeamIDByName;		
	}
	
	public static int createNewTeamAndReturnID(String teamName){
		System.out.println("Inside createNewTeamAndReturnID method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Team insertNewTeam = new Team(teamName);
		
		em.persist(insertNewTeam);
		em.getTransaction().commit();
		
		System.out.println("New Team ID is: " + insertNewTeam);
		
		em.close();
		emfactory.close();
		return getTeamIDByName(teamName);
	}

	public void editEmployee(Employee employee){
		System.out.println("Inside editEmployee method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
						
		//Employee toUpdate = em.find(employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getManager(), employee.getHireDate(), Employee.class);	
		//toUpdate.setPosition("QA Analyst I");
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}
	
	public static void updateEmployee(Employee newInformation){
		System.out.println("Inside updateEmployee method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
		System.out.println("*****" + newInformation.getTeamID());
		
		em.merge(newInformation);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}
	
	public static List<Employee> getEmployeeByID(int employeeID){
		System.out.println("Inside getEmployeeByID method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("run query to find employee by id");
		TypedQuery<Employee> selectedTeamQuery = em.createQuery("select employee from Employee employee where employee.employeeID = :employeeID", Employee.class);
		selectedTeamQuery.setParameter("employeeID", employeeID);
		
		System.out.println("Employee ID is:" + employeeID);

		List<Employee> getEmployeeByID = selectedTeamQuery.getResultList();
		
		System.out.println("Employee: " + getEmployeeByID.get(0).getFirstName() + " " + getEmployeeByID.get(0).getLastName());
		
		em.close();
		emfactory.close();
		
		System.out.println("Leaving getEmployeeByID method");
		
		return getEmployeeByID;
		
	}
	
	
	public static void deleteEmployeeByID(int employeeID){
		System.out.println("Inside deleteEmployeeByID method");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
		
		System.out.println("run query to find employee by id");
		TypedQuery<Employee> selectedTeamQuery = em.createQuery("select employee from Employee employee where employee.employeeID = :employeeID", Employee.class);
		selectedTeamQuery.setParameter("employeeID", employeeID);		
		System.out.println("Employee ID is: " + employeeID);

		List<Employee> getEmployeeByID = selectedTeamQuery.getResultList();		
		System.out.println("Employee: " + getEmployeeByID.get(0).getFirstName());
		
		Employee toRemove = em.find(Employee.class, employeeID);
						
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}
		
}
