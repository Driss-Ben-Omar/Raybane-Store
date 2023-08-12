package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int codeArticle;

	@Column(name = "qteArt", nullable = false)
	public int quantite;

	@Column(name = "nomArt", nullable = false, length = 20)
	public String nomArticle;

	@Column(name = "descArt", nullable = false, length = 200)
	public String descriptionArticle;

	@Column(name = "prixArt", nullable = false)
	public int prixArticle;
	@Column(name = "image")
	private String image;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "article")
	private Set<CommandeArticle> commandeArticles = new HashSet<>();

	public Set<CommandeArticle> getCommandeArticles() {
		return commandeArticles;
	}

	public void setCommandeArticles(Set<CommandeArticle> commandeArticles) {
		this.commandeArticles = commandeArticles;
	}

	public Article() {
		super();
	}

	public int getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescriptionArticle() {
		return descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	public int getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(int prixArticle) {
		this.prixArticle = prixArticle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "{Code :" + this.codeArticle + " ,Nom : " + this.nomArticle + " ,Quantety :" + this.quantite + " ,Pris :"
				+ this.prixArticle + " ,Desc : " + this.descriptionArticle + " }\n";

	}
}