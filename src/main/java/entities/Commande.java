package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int codeCommande;
	
	@Column(name="date_commanede")
	private Date dateCommande;
	
	
	@Column(name="date_livraison")
	private String dateLivraison;
	
	
	@Column(name = "prix_commande")
	private double prixTotal;
	

	@ManyToOne
    @JoinColumn(name = "client_id")
    private User user;
	
	@Column
	private boolean open=false;

	@Override
	public String toString() {
		return "Commande [codeCommande=" + codeCommande + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + ", prixTotal=" + prixTotal + ", user=" + user + ", open=" + open
				+ ", commandeArticles=" + commandeArticles + "]";
	}
	
	private String status;


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean getOpen() {
		return open;
	}


	public void setOpen(boolean open) {
		this.open = open;
	}
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "commande")
    private Set<CommandeArticle> commandeArticles = new HashSet<>();



	public Set<CommandeArticle> getCommandeArticles() {
		return commandeArticles;
	}


	public void setCommandeArticles(Set<CommandeArticle> commandeArticles) {
		this.commandeArticles = commandeArticles;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public String getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public double getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}


	public int getCodeCommande() {
		return codeCommande;
	}
	public void setCodeCommande(int codeCommande) {
		this.codeCommande=codeCommande;
	}
}
