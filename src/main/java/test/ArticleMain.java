package test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dao.ArticleDaoImpl;
import dao.IArticleDao;
import entities.Article;

public class ArticleMain {
	public static void main(String[] args) {
		IArticleDao doa1=new ArticleDaoImpl();
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
	
		Article article=(Article)factory.getBean("article");
		article.setDescriptionArticle("rayban for men");
		article.setImage("rayban-soleil.jpeg");
		article.setNomArticle("rayban-y");
		article.setPrixArticle(105);
		article.setQuantite(20);
		doa1.save(article);
		System.out.println("done");
		List<Article> articles=doa1.getAll();
		for (Article article2 : articles) {
			System.out.println(article2.getCodeArticle());
		}
	}
}
