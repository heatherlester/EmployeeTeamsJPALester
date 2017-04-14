package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		//Create instance of EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeTeamsJPALester");		
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
				
		Scanner in = new Scanner(System.in);
		System.out.print("Employee Name: ");
						
		Employee toUpdate = em.find(Employee.class, 4);
				
		toUpdate.setPosition("QA Analyst I");
		em.getTransaction().commit();
						
		//Close instance of EntityManagerFactory
		em.close();
		emfactory.close();
					
		in.close();
	}

}
