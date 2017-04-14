package entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@Entity
@Table(name="teams")

public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TeamID")
	private int teamID;
	@Column(name="TeamName")
	private String teamName;
	
	@OneToMany(mappedBy="teams")
    private List<Employee> employee;
	
	public Team(){
		
	}
	
	public Team(String teamName, int teamID){
		this.teamName = teamName;
		this.teamID = teamID;
	}
	
	public Team(String teamName){
		this.teamName = teamName;
	}
	
	public int getEmployeeID() {
		return teamID;
	}
	public void setEmployeeID(int employeeID) {
		this.teamID = employeeID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
