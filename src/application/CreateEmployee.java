package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		//Create instance of EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
		
		//Scanner in = new Scanner(System.in);
		
		//System.out.println("Please enter first name: ");
		//String fName = in.nextLine();
		
		//Create entity based off object
		Employee toAdd = new Employee("Jhansi", "Goompa", "QA Test Analyst", "Jodie Dalsing", "10/15/2016", 1);
		//Employee toAdd = new Employee("Jami", "Codner", "QA Test Analyst", "Rafeeq Shaik", "08/15/2016", 1);
		
		//Add item in database
		em.persist(toAdd);
		em.getTransaction().commit();
	
		
		//Close instance of EntityManagerFactory
		//in.close();
		em.close();
		emfactory.close();
	}

}
