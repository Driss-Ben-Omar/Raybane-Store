package dao;

import java.util.List;

import entities.Commande;
import entities.User;

public interface ICommandeDao {
	public void save(Commande commande);
	public void update(Commande commande);
	public void delete(Commande commande) ;
	 public Commande getById(int id);
	public List<Commande> getAll();
	public List<Commande> getByName(String name);
}
