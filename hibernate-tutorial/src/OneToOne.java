import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import orm.Student;
import orm.StudentDetails;

public class OneToOne {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.addAnnotatedClass(StudentDetails.class)
										.buildSessionFactory();
	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
		try {
			session.beginTransaction();
//			insert();
//			Student d = get(21L);

//			update();
//			delete(d);
			getAll();

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
			System.out.println("Done");
		}

	}
	
	private static void delete(Student student) {
		session.delete(student);
	}

	private static void update() {
		session.createQuery("update Student w set w.email = '####'").executeUpdate();	
	}

	private static void getAll() {

		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student").getResultList();
		
		students.forEach(student ->System.out.println(student));
	}

	private static Student get(Long i) {
		Student d = session.get(Student.class, i);
		System.out.println(d);
		return d;
	}

	public static void insert() {
		
		StudentDetails studentDetails = new StudentDetails("amr@youTube", "Amr.Eshra@Facebook");
		Student student = new Student("Amr", "amr@gmail.com");
		student.setStudentDetails(studentDetails);
		
		session.save(student);
		session.getTransaction().commit();
	}

}
