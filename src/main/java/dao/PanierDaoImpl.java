package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import entities.Article;
import entities.Panier;

import metier.HibernateUtil;

public class PanierDaoImpl implements IPanierDao {
	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);

	@Override
	public List<Panier> getAll() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		List<Panier> panier = session.createQuery("FROM Panier", Panier.class).getResultList();
		transaction.commit();

		session.close();
		return panier;
	}

	public Panier getById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Panier article = session.get(Panier.class, id);

		transaction.commit();
		session.close();
		return article;
	}

	@Override
	public void update(Panier panier) {

		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(panier);
		transaction.commit();
		System.out.println("done1");
		session.close();
	}

	@Override
	public void save(Panier panier) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(panier);
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(Panier panier) {

		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(panier);
		transaction.commit();
		session.close();
	}

	public List<Panier> getByIdClient(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "FROM Panier WHERE idClient = :clientId";
		List<Panier> paniers = session.createQuery(hql, Panier.class).setParameter("clientId", id).getResultList();

		transaction.commit();
		session.close();
		return paniers;

	}

	public void deleteByIdClient(int idClient) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "DELETE FROM Panier WHERE idClient = :clientId";
		session.createQuery(hql).setParameter("clientId", idClient).executeUpdate();

		transaction.commit();
		session.close();
	}

	public void saveByIds(int idClient, int idArticle) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		IArticleDao articleDao = (ArticleDaoImpl) factory.getBean("articleDao");
		Article article = articleDao.getById(idArticle);
		Panier panier = (Panier) factory.getBean("panier");
		panier.setIdArticle(idArticle);
		panier.setIdClient(idClient);
		panier.setName(article.getNomArticle());
		panier.setImg(article.getImage());
		panier.setPrixTotal(article.getPrixArticle());
		panier.setQuantiteArticle(1);
		session.save(panier);
		transaction.commit();
		session.close();
	}

}
