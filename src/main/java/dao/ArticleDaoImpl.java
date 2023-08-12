package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Article;
import metier.HibernateUtil;

import java.util.List;

public class ArticleDaoImpl implements IArticleDao {

	@Override
	public void save(Article article) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(article);
		transaction.commit();
		session.close();
	}

	@Override
	public void update(Article article) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(article);
		transaction.commit();
		System.out.println("done1");
		session.close();
	}

	@Override
	public void delete(Article article) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(article);
		transaction.commit();
		session.close();
	}

	@Override
	public Article getById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Article article = session.get(Article.class, id);

		transaction.commit();
		session.close();
		return article;
	}

	@Override
	public List<Article> getAll() {

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		List<Article> clients = session.createQuery("FROM Article", Article.class).getResultList();
		transaction.commit();

		session.close();
		return clients;
	}
}