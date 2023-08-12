package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Commande;

import metier.HibernateUtil;

public class CommandeDaoImpl implements ICommandeDao {

	@Override
	public void save(Commande commande) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(commande);
		transaction.commit();
		session.close();

	}

	@Override
	public void update(Commande commande) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(commande);
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(Commande commande) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(commande);
		transaction.commit();
		session.close();
	}

	@Override
	public Commande getById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Commande commande = session.get(Commande.class, id);

		transaction.commit();
		session.close();
		return commande;
	}

	@Override
	public List<Commande> getAll() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		List<Commande> clients = session.createQuery("FROM Commande", Commande.class).getResultList();
		transaction.commit();

		session.close();
		return clients;
	}

	@Override
	public List<Commande> getByName(String name) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "SELECT commande FROM Commande commande JOIN commande.user user WHERE user.fullName LIKE :fullName";

		List<Commande> clients = session.createQuery(hqlQuery, Commande.class).setParameter("fullName", name)
				.getResultList();
		transaction.commit();

		session.close();
		return clients;
	}

	public List<Commande> getByIdClient(int idClient) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "SELECT commande FROM Commande commande JOIN commande.user user WHERE user.id LIKE :idClient";

		List<Commande> clients = session.createQuery(hqlQuery, Commande.class).setParameter("idClient", idClient)
				.getResultList();
		transaction.commit();

		session.close();
		return clients;
	}
}
