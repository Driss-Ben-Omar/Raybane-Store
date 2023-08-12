package bean;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.opensymphony.xwork2.ActionSupport;

import dao.ArticleDaoImpl;
import dao.CommandeDaoImpl;
import dao.IArticleDao;
import dao.ICommandeDao;
import dao.IPanierDao;
import dao.PanierDaoImpl;
import dao.UserDaoImpl;
import entities.Article;
import entities.Commande;
import entities.CommandeArticle;
import entities.Panier;
import entities.User;
import generatePDF.GeneratePDF;
import metier.CommandeMetier;
import metier.HibernateUtil;
import metier.PanierMetier;

public class PanierAction extends ActionSupport {
	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);
	private int id;
	private int quantite;
	private List<Panier> panier;
	private List<Article> articles;
	private List<Commande> commandes;
	private int count;
	private Set<CommandeArticle> cmdArticles;

	public String shopingcard() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User client = (User) session.getAttribute("client");

		if (client != null) {

			PanierDaoImpl daoImpl = (PanierDaoImpl) factory.getBean("panierDao");
			daoImpl.saveByIds(client.getId(), this.id);
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			panier = daoImpl.getByIdClient(client.getId());
			this.setPanier(panier);
			this.setArticles(doa1.getAll());
			return "success";
		} else {
			return "error";
		}

	}

	public String remove() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User client = (User) session.getAttribute("client");

		if (client != null) {

			PanierDaoImpl daoImpl = (PanierDaoImpl) factory.getBean("panierDao");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			Panier panier = daoImpl.getById(this.id);
			daoImpl.delete(panier);
			this.panier = daoImpl.getByIdClient(client.getId());
			this.setPanier(this.panier);
			this.setArticles(doa1.getAll());
			return "success";
		} else {
			return "error";
		}

	}

	public String commander() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User client = (User) session.getAttribute("client");

		if (client != null) {
			PanierDaoImpl daoImpl = (PanierDaoImpl) factory.getBean("panierDao");
			PanierMetier metier = (PanierMetier) factory.getBean("panierMetier");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			panier = daoImpl.getByIdClient(client.getId());
			this.setPanier(panier);
			this.setArticles(doa1.getAll());
			Commande commande = metier.creerCommande(panier);
			this.setCmdArticles(commande.getCommandeArticles());
			daoImpl.deleteByIdClient(client.getId());
			return "success";
		} else {
			return "error";
		}
	}

	public String generate() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User client = (User) session.getAttribute("client");

		if (this.id != 0 && client != null) {

			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			panier = doa2.getByIdClient(client.getId());
			this.setPanier(panier);
			this.setArticles(doa1.getAll());
			GeneratePDF generatePDF = (GeneratePDF) factory.getBean("generatePdf");
			generatePDF.generateInvoice(this.id);
			generatePDF.openPdf(this.id);
			return "success";
		} else {
			if (client == null) {
				return "login";
			}
			return "error";
		}
	}

	public String UpdateQuantite() {

		if (this.id != 0) {

			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Panier cartItem = session.get(Panier.class, this.id);
			cartItem.setQuantiteArticle(this.quantite);
			session.update(cartItem);
			transaction.commit();
			session.close();
			System.out.println("success" + this.id);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1 = request.getSession();
		User client = (User) session1.getAttribute("client");
		IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
		IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
		panier = doa2.getByIdClient(client.getId());
		this.setPanier(panier);
		this.setArticles(doa1.getAll());

		if (client == null) {

			return "login";
		} else {
			return "error";
		}

	}

	public String card() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1 = request.getSession();
		User client = (User) session1.getAttribute("client");

		if (client != null) {

			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			panier = doa2.getByIdClient(client.getId());
			this.setPanier(panier);
			this.setArticles(doa1.getAll());
			return "success";
		}
		return "error";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<CommandeArticle> getCmdArticles() {
		return cmdArticles;
	}

	public void setCmdArticles(Set<CommandeArticle> cmdArticles) {
		this.cmdArticles = cmdArticles;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
