/** 
 * Represents a student.
 */
public class Student {
	
	private int sid;                             
	private String name;                         
	private LinkedList<CourseTaken> courseList;
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's id
	 * @param name the student's name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
		this.courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the id of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {
		return this.sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {
		CourseTaken newCourse = new CourseTaken(c, grade);
		courseList.add(newCourse);
	}
	
	/** 
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {
		ListIterator <CourseTaken> index = this.courseList.iterator();
		while(index.hasNext()) {
			CourseTaken current = index.next();
			if(current.getCourse() == c){
				return current.getGrade();
			}
		}
		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		ListIterator <CourseTaken> index = this.courseList.iterator();
		while(index.hasNext()) {
			CourseTaken current = index.next();
			if(current.getCourse() == c){
				return true;
			}
		}
		return false;
	}

	public double gpa() {
		ListIterator <CourseTaken> index = this.courseList.iterator();
		int numOfCourses = courseList.size();
		int sum = 0;
		while(index.hasNext()) {
			CourseTaken current = index.next();
			sum += current.getGrade();
		}
		return (double)(sum / numOfCourses);
	}


	
	/**
	 * Returns a string which contains
	 * 1) this student
	 * 2) all the courses that s/he took
	 * 3) the grade point average
	 */
	public String studentReport() {
		String str = this.name + "\n";
		str += "courses:" + "\n";
		str += courseList.toString() + "\n";
		str += "grade point average:" + "\n";
		str += gpa() + "\n";
		return str;
	}
	
	/** 
	 * Two students will be consdired equals iff they have the same sid
	 * @param other the other Student
	 * @return true/false
	 */
	public boolean equals(Student other){
		if(this.sid == other.sid){
			return true;
		}
		return false;
	}
	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + this.sid + ": " + this.name;
	}
}