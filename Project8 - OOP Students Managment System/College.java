

/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
public class College {
	
	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) {
		Course addedCourse = new Course(cid,title);
		this.courses.add(addedCourse);
	}
	
	/**
	 * Returns a list of all the courses.
	 */
	public LinkedList<Course> coursesList() {
		return this.courses;
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {
		if(getCourse(cid) != null){
			courses.remove(getCourse(cid));
			return true;
		}
		return false;
	}
	
	// Returns the course that has the given id, or null if there is no such course.
	public Course getCourse(int cid) {
		ListIterator <Course> index = this.courses.iterator();
		while(index.hasNext()) {
			Course current = index.next();
			if(current.getCid() == cid ){
				return current;
			}
		}
		return null;
	}
	
	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		Student addedStudent = new Student(sid,name);
		this.students.add(addedStudent);
	}
	
	/**
	 * Returns a list of all the students.
	 */
	public LinkedList<Student> studentsList() {
		return this.students;
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		if(getStudent(sid) != null){
			students.remove(getStudent(sid));
			return true;
		}
		return false;
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	public Student getStudent(int sid) {
		ListIterator <Student> index = this.students.iterator();
		while(index.hasNext()) {
			Student current = index.next();
			if(current.getSid() == sid ){
				return current;
			}
		}
		return null;
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		Student student = getStudent(sid);
		student.addCourse(getCourse(cid), grade);
	}
	
	/** 
	 * Returns the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public String studentReport(int sid) {
		return getStudent(sid).studentReport();
	}
	
	// Returns a list of all the students who took the given course
	public LinkedList<Student> studentsWhoTook(Course c) {
		LinkedList <Student> stu = new LinkedList <Student>();
		ListIterator <Student> index = this.students.iterator();
		while (index.hasNext()){
			Student current = index.next();
			if(current.tookCourse(c)){
				stu.add(current);
			}
		}
		return stu;
	}
	
	// Returns a list of the all the student got the given grade or above it 
	public LinkedList<Student> studentsWithGrade(Course c, int grade) {
		LinkedList <Student> stu = studentsWhoTook(c);
		ListIterator <Student> indexStu = stu.iterator();
		LinkedList <Student> goodStu = new LinkedList <Student>();
		while (indexStu.hasNext()){
			Student current = indexStu.next();
			if(current.gradeInCourse(c) >= grade){
				goodStu.add(current);
			}
		}
		return goodStu;
	}
	public int highestGrade (Course c){
		LinkedList <Student> stu = studentsWhoTook(c);
		ListIterator <Student> indexStu = stu.iterator();
		int maxGrade = 0;
		while (indexStu.hasNext()){
			Student current = indexStu.next();
			if(current.gradeInCourse(c) > maxGrade){
				maxGrade = current.gradeInCourse(c);
			}
	}
	return maxGrade;
}
	// Returns a list of courses with the grade averages of all the students who took it
	public LinkedList<CourseTaken> getCoursesAverages() {
		LinkedList <CourseTaken> averages = new LinkedList<CourseTaken>();
		ListIterator <Course> index = this.courses.iterator();
		while(index.hasNext()){
			Course current = index.next();
			LinkedList <Student> stu = studentsWhoTook(current);
			if(stu.size() == 0){
				averages.add(new CourseTaken(current, 0));
				continue;
			}
			ListIterator <Student> indexStu = stu.iterator();
			int sum = 0;
			int ave = 0;
			while(indexStu.hasNext()){
				Student currentStu = indexStu.next();
				sum += currentStu.gradeInCourse(current);
			}
			ave = sum/stu.size();
			averages.add(new CourseTaken(current, ave));
		}
		return averages;
	}
	

	/** 
	 * Returns the students with the highest grade in the given course.
	 * @param cid  course id
	 */
	public LinkedList<Student> topPerfomerReport(int cid) {
		LinkedList <Student> topPerformer = new LinkedList<Student>();
		LinkedList <Student> stu = studentsWhoTook(getCourse(cid));
		ListIterator <Student> index = stu.iterator();
		while (index.hasNext()){
			Student currentStu = index.next();
			if(currentStu.gradeInCourse(getCourse(cid)) == highestGrade(getCourse(cid))){
				topPerformer.add(currentStu);
			}
		}
		return topPerformer;
	}

	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + "\n";
		str += "courses:" + "\n";
		str += courses.toString() + "\n";
		str += "students:" + "\n";
		str += students.toString() + "\n";
		return str;
	}
}

