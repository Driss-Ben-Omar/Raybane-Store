package entities;

import javax.persistence.*;

@Entity
@Table(name = "commandes_articles")
public class CommandeArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;

	@Column(name = "quantity", nullable = false)
	public Integer quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}