import java.util.List;

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
			WorkingDay d = get(122L);

			update();
			delete(d);
			getAll();

		} catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			factory.close();
			System.out.println("Done");
		}

	}
	
	private static void delete(WorkingDay day) {
		session.delete(day);
	}

	private static void update() {
		session.createQuery("update WorkingDay w set w.time = '16:00'").executeUpdate();	
	}

	private static void getAll() {

		@SuppressWarnings("unchecked")
		List<WorkingDay> days = session.createQuery("from WorkingDay").getResultList();
		
		days.forEach(day ->System.out.println(day));
	}

	private static WorkingDay get(Long i) {
		WorkingDay d = session.get(WorkingDay.class, i);
		System.out.println(d);
		return d;
	}

	public static void insert() {
		
		WorkingDay day = new WorkingDay("Amr", "26-12-2019", "14:00");
		session.save(day);
		session.getTransaction().commit();
	}

}
