package metier;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Article;
import entities.Commande;
import entities.CommandeArticle;
import entities.Panier;
import entities.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration config = new Configuration();
		config.configure();

		config.addAnnotatedClass(Article.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Commande.class);
		config.addAnnotatedClass(Panier.class);
		config.addAnnotatedClass(CommandeArticle.class);
		config.addAnnotatedClass(Integer.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
