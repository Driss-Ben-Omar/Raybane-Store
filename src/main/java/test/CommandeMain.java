package test;


import dao.CommandeArticle;
import dao.CommandeDaoImpl;
import dao.ICommandeDao;
import entities.Article;
import entities.Commande;
import generatePDF.GeneratePDF;
import metier.CommandeMetier;
import metier.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class CommandeMain {

	public static void main(String[] args) {

		GeneratePDF generatePDF=new GeneratePDF();
		generatePDF.generateInvoice(10);

		System.out.println("hello world");
	}

}
