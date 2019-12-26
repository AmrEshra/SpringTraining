import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import orm.WorkingDay;

public class TestJDBC {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(WorkingDay.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			WorkingDay day = new WorkingDay("Amr", "26-12-2019", "14:00");
			session.beginTransaction();
			session.save(day);
			
			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
