package AllDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Details")

public class StudentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	@Column(name="Student_Name")
	private String Name;
	@Column(name="Roll_No")
	private String RollNo;
	@Column(name="Class")
	private String StudentClass;
	
	public StudentDetails() {}
	public StudentDetails(String name, String rollNo, String class1) {
		Name = name;
		RollNo = rollNo;
		StudentClass = class1;
	}
	public StudentDetails(int id, String name, String rollNo, String class1) {
		super();
		Id = id;
		Name = name;
		RollNo = rollNo;
		StudentClass = class1;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRollNo() {
		return RollNo;
	}
	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}
	public String getStudentClass() {
		return StudentClass;
	}
	public void setClass(String class1) {
		StudentClass = class1;
	}
	@Override
	public String toString() {
		return "StudentDetails [Id=" + Id + ", Name=" + Name + ", RollNo=" + RollNo + ", Class=" + StudentClass + "]";
	}



}
