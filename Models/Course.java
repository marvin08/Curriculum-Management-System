package models;

public class Course {
	private String CourseID;
	private String Name;
	private String Type;
	private int Credits;
	private String Prerequisites;
	private String Status;
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
	public String getPrerequisites() {
		return Prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		Prerequisites = prerequisites;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
