package test;

import java.util.ArrayList;
import java.util.List;

import dao.CommandeDaoImpl;
import dao.ICommandeDao;
import dao.IPanierDao;
import dao.PanierDaoImpl;
import entities.Commande;
import entities.Panier;
import metier.PanierMetier;

public class PanierMain {

	public static void main(String[] args) {
		PanierDaoImpl dao1=new PanierDaoImpl();
		List<Panier> paniers=dao1.getByIdClient(7);
		dao1.saveByIds(2, 1);
		

	}

}
