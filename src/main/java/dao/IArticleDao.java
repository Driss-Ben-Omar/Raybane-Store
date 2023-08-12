package dao;

import java.util.List;

import entities.Article;

public interface IArticleDao {
	public void save(Article article);
	public void update(Article article);
	public void delete(Article article) ;
	 public Article getById(int id);
	public List<Article> getAll();

}
