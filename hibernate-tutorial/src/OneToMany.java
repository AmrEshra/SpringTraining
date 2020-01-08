import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import orm.Course;
import orm.Instructor;
import orm.Review;

public class OneToMany {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
		try {
			session.beginTransaction();
//			insert();
			Instructor d = get(1L);
//			insertCouser(d);
//			insertReviews(21L);
//			getCourses(d);
//			deleteCourse(2L);

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
			System.out.println("Done");
		}

	}
	
	private static void deleteCourse(long l) {

		Course d = session.get(Course.class, 2L);
		session.delete(d);
		session.getTransaction().commit();
	}

	private static void insertReviews(Long l) {
		Course d = session.get(Course.class, l);
		Review review = new Review("Help me", d);
		
		session.save(review);
		session.getTransaction().commit();
		
	}

	private static void insertCouser(Instructor instructor) {
		
		Course course2 = new Course("C#", instructor);
		
		session.save(course2);
		session.getTransaction().commit();
		
	}

	private static void getCourses(Instructor instructor) {

		List<Course> courses = session.createQuery("from Course where instructor.id = " + instructor.getId()).getResultList();
		
		courses.forEach(course ->System.out.println(course));
	}

	private static Instructor get(Long i) {
		Instructor d = session.get(Instructor.class, i);
		System.out.println(d);
		d.getCourses().forEach(course ->System.out.println(course));
		return d;
	}

	public static void insert() {
		
		Instructor instructor = new Instructor("Amr Ali", "amr.eshra@gmail.com");
		
		session.save(instructor);
		session.getTransaction().commit();
	}

}
