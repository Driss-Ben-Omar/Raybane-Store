package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.User;
import metier.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	public User getById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User client = session.get(User.class, id);

		transaction.commit();
		session.close();
		return client;
	}

	public User getByEmail(String email) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "FROM User where email= :email";
		User users = null;
		try {
			users = (User) session.createQuery(hql, User.class).setParameter("email", email).getSingleResult();
		} catch (Exception e) {

		}
		transaction.commit();
		session.close();
		return users;
	}

	public User save(User client) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(client);

		transaction.commit();
		session.close();
		return client;
	}

	public void update(User c) {

		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("done1");
		session.update(c);
		transaction.commit();
		session.close();
	}

	public User getUserByInfo(String email, String password) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "FROM User where email= :email AND password = :password";
		User users = null;
		try {
			users = (User) session.createQuery(hql, User.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
		} catch (Exception e) {

		}
		transaction.commit();
		session.close();
		return users;
	}

}
