package dao;

import java.util.List;

import entities.Panier;

public interface IPanierDao 
{
	public List<Panier> getAll();
	public void update(Panier panier);
	public void save(Panier panier);
	public void delete(Panier panier);
	public List<Panier> getByIdClient(int id);
}
