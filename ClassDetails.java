package AllDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Class_Details")
public class ClassDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	@Column(name="Class")
	private String ClassName;
	@Column(name="Section")
	private String ClassSection;
	@Column(name="Room_No")
	private String ClassRoomNo;
	
	public ClassDetails() {}
	
	public ClassDetails(String className, String classSection, String classRoomNo) {
		ClassName = className;
		ClassSection = classSection;
		ClassRoomNo = classRoomNo;
	}
	
	public ClassDetails(int id, String className, String classSection, String classRoomNo) {
		super();
		Id = id;
		ClassName = className;
		ClassSection = classSection;
		ClassRoomNo = classRoomNo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getClassSection() {
		return ClassSection;
	}

	public void setClassSection(String classSection) {
		ClassSection = classSection;
	}

	public String getClassRoomNo() {
		return ClassRoomNo;
	}

	public void setClassRoomNo(String classRoomNo) {
		ClassRoomNo = classRoomNo;
	}

	@Override
	public String toString() {
		return "ClassDetails [Id=" + Id + ", ClassName=" + ClassName + ", ClassSection=" + ClassSection
				+ ", ClassRoomNo=" + ClassRoomNo + "]";
	}
	
	
}
