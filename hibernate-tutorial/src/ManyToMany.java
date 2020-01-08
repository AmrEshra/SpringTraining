import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import orm.Course;
import orm.Instructor;
import orm.Review;
import orm.Student;
import orm.StudentDetails;

public class ManyToMany {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(StudentDetails.class)
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
		try {
			session.beginTransaction();
			
//			insert();
			
			print();

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
			System.out.println("Done");
		}

	}
	
	private static void print() {

		Student amr = session.get(Student.class, 22L);
		amr.getCourses().forEach(c -> System.out.println(c));
		
	}

	@SuppressWarnings("unchecked")
	private static void insert() {
		
		Student amr = session.get(Student.class, 22L);
		
		List<Course> courses = session.createQuery("from Course").getResultList();
		for(Course course : courses)
			amr.getCourses().add(course);
		
		session.save(amr);
		session.getTransaction().commit();
	}

}
