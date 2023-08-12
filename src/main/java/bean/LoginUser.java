package bean;

import java.io.File;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.struts2.ServletActionContext;
import javax.servlet.ServletException;

import com.opensymphony.xwork2.ActionSupport;

import dao.ArticleDaoImpl;
import dao.CommandeDaoImpl;
import dao.IArticleDao;
import dao.IPanierDao;
import dao.IUserDao;
import dao.PanierDaoImpl;
import dao.UserDaoImpl;
import entities.Article;
import entities.Commande;
import entities.CommandeArticle;
import entities.Panier;
import entities.User;
import metier.CommandeMetier;
import metier.UserMetier;

public class LoginUser extends ActionSupport {
	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);
	private String password;
	private int id;
	private File upload;
	private String salt;
	private String email;
	private String name, phone, birthday, address, old, confirm;
	private List<Panier> panier;
	private List<Article> articles;
	private List<Commande> commandes;
	private boolean open = false;
	private int count;
	private Set<CommandeArticle> cmdArticles;

	public String execute() throws ServletException, IOException {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("client");

		if (user == null) {
			if (this.email != null && this.password != null && !this.password.isEmpty() && !this.email.isEmpty())  {
				UserDaoImpl dao = (UserDaoImpl) factory.getBean("userDao");
				User c = dao.getUserByInfo(this.email, this.password);
				System.out.println("clinet logined");
				System.out.println(c);

				if (c != null) {
					c.setLastLogin(new Date());
					dao.update(c);
					session.setAttribute("client", c);
					IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
					IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
					CommandeMetier commandeMetier = (CommandeMetier) factory.getBean("commandeMetier");
					CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

					this.setCommandes(commandeDaoImpl.getByIdClient(c.getId()));
					panier = doa2.getByIdClient(c.getId());
					this.setPanier(panier);
					this.setArticles(doa1.getAll());
					return "success";
				} else {
					addActionError("The Email or the password are incorrect");
					return "error";
				}
			} else {
				if (this.email == null && this.password == null || this.email.isEmpty() && this.password.isEmpty()) {
					addActionError("The input Email and Password are empty");
					return "error";
				} else {
					if (this.password == null || this.password.isEmpty()) {
						addActionError("The input Password is empty");
						return "error";
					} else {
						addActionError("The input Email is empty");
						return "error";
					}
				}
			}
		} else {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			ArticleDaoImpl doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

			this.setCommandes(commandeDaoImpl.getByIdClient(user.getId()));
			this.setArticles(doa1.getAll());
			panier = doa2.getByIdClient(user.getId());
			this.setPanier(panier);
			return "success";
		}

	}

	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("client");
		if (user == null) {
			return "success";
		} else {
			return "error";
		}

	}

	public String index() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("client");
		if (user != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			ArticleDaoImpl doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

			this.setCommandes(commandeDaoImpl.getByIdClient(user.getId()));
			this.setArticles(doa1.getAll());
			panier = doa2.getByIdClient(user.getId());
			this.setPanier(panier);
			
			return "success";
		} else {
			return "error";
		}
	}

	public String profil() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("client");
		if (user != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");
			panier = doa2.getByIdClient(user.getId());
	
			return "success";
		} else {
			return "error";
		}
	}

	public String setting() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("client");
		if (user != null) {
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

			
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			panier = doa2.getByIdClient(user.getId());
			
			return "success";
		} else {
			return "error";
		}
	}

	public String shop() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("client");
		if (user != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			ArticleDaoImpl doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

			
			this.setArticles(doa1.getAll());
			panier = doa2.getByIdClient(user.getId());
			
			return "success";
		} else {
			return "error";
		}
	}

	public String deconnect() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("client");
		if (user != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");
			panier = doa2.getByIdClient(user.getId());
			session.removeAttribute("client");
			session.invalidate();
			return "true";
		} else {
			return "false";
		}
	}

	public String mescommande() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User client = (User) session.getAttribute("client");

		if (client != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			panier = doa2.getByIdClient(client.getId());

			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeMetier commandeMetier = (CommandeMetier) factory.getBean("commandeMetier");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");
			List<Commande> commande = commandeDaoImpl.getByIdClient(client.getId());

			for (Commande cmd : commande) {
				cmd.setStatus(commandeMetier.status(commandeMetier.stringToDate(cmd.getDateLivraison())));
			}

			this.setCommandes(commande);
			this.setCmdArticles(this.getCommandes().get(this.count).getCommandeArticles());

			Commande cmdOpen = this.getCommandes().get(count);
			cmdOpen.setOpen(true);
			this.getCommandes().set(this.count, cmdOpen);
			
			this.setOpen(!this.open);
			this.setArticles(doa1.getAll());
			this.setPanier(panier);
			return "success";
		} else {
			return "error";
		}

	}

	public String commande() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User client = (User) session.getAttribute("client");

		if (client != null) {
			IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
			panier = doa2.getByIdClient(client.getId());

			IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");
			CommandeMetier commandeMetier = (CommandeMetier) factory.getBean("commandeMetier");
			CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");
			List<Commande> commande = commandeDaoImpl.getByIdClient(client.getId());

			for (Commande cmd : commande) {
				cmd.setStatus(commandeMetier.status(commandeMetier.stringToDate(cmd.getDateLivraison())));
			}

			this.setCommandes(commande);
			if(this.commandes.size()>0) {
				this.setCmdArticles(this.getCommandes().get(this.count).getCommandeArticles());
				}
			
			this.setArticles(doa1.getAll());
			this.setPanier(panier);
			return "success";
		} else {
			return "error";
		}
		

	}

	public String updateInformation() throws ServletException, IOException {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		if (session.getAttribute("client") != null) {
			User oldClient = (User) session.getAttribute("client");

			if (this.old != null && this.old.equals(oldClient.getPassword())) {
				if (this.password != null && this.confirm != null && this.password.equals(this.confirm)
						&& !this.password.isEmpty() && !this.confirm.isEmpty()) {

					UserMetier metier = (UserMetier) factory.getBean("userMetier");

					oldClient.setAddress(this.address);
					oldClient.setBirthday(this.birthday);
					oldClient.setEmail(this.email);
					oldClient.setFullName(this.name);
					oldClient.setPhone(this.phone);
					oldClient.setPassword(this.confirm);

					IUserDao clientDao = (UserDaoImpl) factory.getBean("userDao");
					clientDao.update(oldClient);
					if (this.upload != null) {
						metier.copyImageByFile(this.upload,
								"C:\\Users\\zaimj\\Downloads\\Project J2EE\\Gestion-Vente\\src\\main\\webapp\\assets\\img\\"
										+ oldClient.getId() + ".png");
					}

					System.out.println("updated");
					IPanierDao doa2 = (PanierDaoImpl) factory.getBean("panierDao");
					panier = doa2.getByIdClient(oldClient.getId());
					IArticleDao doa1 = (ArticleDaoImpl) factory.getBean("articleDao");

					CommandeDaoImpl commandeDaoImpl = (CommandeDaoImpl) factory.getBean("commandeDao");

					
					return "update";
				} else {
					if (this.old == null || this.old.isEmpty()) {
						addActionError("The old Password is empty");
					} else if (this.password == null || this.password.isEmpty()) {
						addActionError("The new Password is empty");
					} else {
						addActionError("The Confirm Password is incorrect");
					}
					return "confirm";
				}
			} else {
				if (this.old == null || this.old.isEmpty()) {
					addActionError("The input old Password is empty");
				} else {
					addActionError("The old Password is incorrect");
				}
				return "old";
			}
		} else {
			System.out.println("no login");
			return "no";
		}
	}

	public String register() throws ServletException, IOException {

		if (this.password != null && this.confirm != null && this.password.equals(this.confirm)
				&& !this.password.isEmpty() && !this.confirm.isEmpty())  {
			User newClient = (User) factory.getBean("user");
			IUserDao clientDao = (UserDaoImpl) factory.getBean("userDao");
			UserMetier metier = (UserMetier) factory.getBean("userMetier");
			User userExist = clientDao.getByEmail(this.email);

			if (userExist == null) {
				newClient.setAddress(this.address);
				newClient.setBirthday(this.birthday);
				newClient.setEmail(this.email);
				newClient.setFullName(this.name);
				newClient.setPhone(this.phone);
				newClient.setPassword(this.confirm);
				newClient.setRole("client");
				clientDao.save(newClient);
				if (this.upload != null) {
					metier.copyImageByFile(this.upload,
							"C:\\Users\\zaimj\\Downloads\\Project J2EE\\Gestion-Vente\\src\\main\\webapp\\assets\\img\\"
									+ newClient.getId() + ".png");
				} else {
					metier.copyImageByPath(
							"C:\\Users\\zaimj\\Downloads\\Project J2EE\\Gestion-Vente\\src\\main\\webapp\\assets\\img\\noprofil.png",
							"C:\\Users\\zaimj\\Downloads\\Project J2EE\\Gestion-Vente\\src\\main\\webapp\\assets\\img\\"
									+ newClient.getId() + ".png");
				}

				System.out.println(newClient.toString());

				System.out.println("updated");
				return "create";
			} else {
				addActionError("The email already has an account");
				return "error";
			}
		} else {
			if (this.password == null && this.confirm == null || this.password.isEmpty() && this.confirm.isEmpty()) {
				addActionError("The Password and The Confirm Password are empty");
			} else if (this.confirm == null || this.confirm.isEmpty()) {
				addActionError("The input Confirm Password is empty");
			} else if (this.password == null || this.password.isEmpty()) {
				addActionError("The input Password is empty");
			} else {
				addActionError("The confirm password incorrect");
			}

			return "error";
		}
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Set<CommandeArticle> getCmdArticles() {
		return cmdArticles;
	}

	public void setCmdArticles(Set<CommandeArticle> cmdArticles) {
		this.cmdArticles = cmdArticles;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
