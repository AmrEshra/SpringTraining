import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Insert;

import orm.WorkingDay;

public class TestJDBC {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(WorkingDay.class).buildSessionFactory();
	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
		try {
			session.beginTransaction();
//			insert();
			get(122L);
			

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			factory.close();
			System.out.println("Done");
		}

	}
	
	private static void get(Long i) {
		WorkingDay d = session.get(WorkingDay.class, i);
		System.out.println(d);
	}

	public static void insert() {
		
		WorkingDay day = new WorkingDay("Amr", "26-12-2019", "14:00");
		session.save(day);
		session.getTransaction().commit();
	}

}
