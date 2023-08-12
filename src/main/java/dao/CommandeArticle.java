package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entities.Article;
import metier.HibernateUtil;

public class CommandeArticle {
	public List<Article> getCommandsById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT a FROM Article a JOIN a.commandes c WHERE c.id = :commandeId";
		Query<Article> query = session.createQuery(hql, Article.class);
		query.setParameter("commandeId", id);

		List<Article> articles = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return articles;
	}
}
