package AllDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_Details")
public class TeacherDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	@Column(name="Teacher_Name")
	private String Name;
	@Column(name="Subject")
	private String Subject;
	@Column(name="Class")
	private String TeacherClass;
	
	public TeacherDetails() {}
	
	public TeacherDetails(String name, String subject, String class1) {
		Name = name;
		Subject = subject;
		TeacherClass = class1;
	}
	
	public TeacherDetails(int id, String name, String subject, String class1) {
		super();
		Id = id;
		Name = name;
		Subject = subject;
		TeacherClass = class1;
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

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getTeacherClass() {
		return TeacherClass;
	}

	public void setTeacherClass(String teacherClass) {
		TeacherClass = teacherClass;
	}

	@Override
	public String toString() {
		return "TeacherDetails [Id=" + Id + ", Name=" + Name + ", Subject=" + Subject + ", TeacherClass=" + TeacherClass
				+ "]";
	}
	
}