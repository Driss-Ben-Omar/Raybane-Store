package metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import dao.ArticleDaoImpl;
import entities.CommandeArticle;
import dao.IArticleDao;
import dao.IPanierDao;
import dao.IUserDao;
import dao.PanierDaoImpl;
import dao.UserDaoImpl;
import entities.Article;
import entities.Commande;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import entities.Panier;
import entities.User;

public class PanierMetier {

	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);
	IPanierDao panierDoa = (PanierDaoImpl) factory.getBean("panierDao");
	IArticleDao articleDoa = (ArticleDaoImpl) factory.getBean("articleDao");

	public double calculPriceTotal(int idClient) {

		double priceTotal = 0;
		System.out.println("hi");
		List<Panier> lines = panierDoa.getByIdClient(idClient);

		for (Panier panier : lines) {
			priceTotal += panier.getQuantiteArticle() * articleDoa.getById(panier.getIdArticle()).getPrixArticle();
		}
		return priceTotal;
	}

	public Commande creerCommande(List<Panier> paniers) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		Date dateApres3Jours = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormatee = dateFormat.format(dateApres3Jours);
		Commande commande = (Commande) factory.getBean("commande");
		IUserDao dao = (UserDaoImpl) factory.getBean("userDao");

		CommandeMetier commandeMetier = (CommandeMetier) factory.getBean("commandeMetier");
		IArticleDao articleDao = (ArticleDaoImpl) factory.getBean("articleDao");

		commande.setDateCommande(commandeMetier.formatDate(new Date()));
		commande.setDateLivraison(dateFormatee);
		commande.setPrixTotal(calculerPrixTotal(paniers));

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) dao.getById(paniers.get(0).getIdClient());
			List<CommandeArticle> commandeArticles = new ArrayList<CommandeArticle>();
			for (Panier panier : paniers) {
				CommandeArticle commandeArticle = new CommandeArticle();

				Article article = articleDao.getById(panier.getIdArticle());
				commandeArticle.setArticle(article);
				commandeArticle.setCommande(commande);

				commandeArticle.setQuantity(panier.getQuantiteArticle());
				commandeArticles.add(commandeArticle);

				commande.getCommandeArticles().add(commandeArticle);
				System.out.println("Panieing..");
				article.setQuantite(article.getQuantite() - panier.getQuantiteArticle());
				session.update(article);

			}

			for (CommandeArticle commandeArticle1 : commandeArticles) {
				session.save(commandeArticle1);
				System.out.println("saving ..");

			}

			commande.setUser(user);

			session.save(commande);

			transaction.commit();

			return commande;

		} catch (Exception ex) {
			if (!(transaction == null))
				transaction.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public double calculerPrixTotal(List<Panier> paniers) {
		double prixTotal = 0.0;
		for (Panier panier : paniers) {
			prixTotal += panier.getPrixTotal() * panier.getQuantiteArticle();
		}
		return prixTotal;
	}
}
