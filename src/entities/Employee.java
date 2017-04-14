package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@Entity
@Table(name="employees")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EmployeeID")
	private int employeeID;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="Position")
	private String position;
	@Column(name="Manager")
	private String manager;
	@Column(name="HireDate")
	private String hireDate;	
	private int teamID;
	
	@ManyToOne
	@JoinColumn(name="TeamID", insertable=false, updatable=false)
	@XmlInverseReference(mappedBy="employee")
	private Team teams;
 
		
	public Employee(){
		
	}
	
	public Employee(int employeeID, String firstName, String lastName, String position, String manager, String hireDate, int teamID){
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.manager = manager;
		this.hireDate = hireDate;
		this.teamID = teamID;
	}
	
	public Employee(String firstName, String lastName, String position, String manager, String hireDate, int teamID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.manager = manager;
		this.hireDate = hireDate;
		this.teamID = teamID;
	}
	
	public Employee(String firstName, String lastName, String position, String manager, String hireDate, Team teams){
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.manager = manager;
		this.hireDate = hireDate;
		this.teams = teams;
	}
	
	public Employee(String firstName, String lastName, String position, String manager, String hireDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.manager = manager;
		this.hireDate = hireDate;
	}
		
	public Employee(int teamID){
		this.teamID = teamID;
	}
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

}
