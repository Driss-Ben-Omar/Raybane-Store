package dao;

import entities.User;


public interface IUserDao 
{

	public User getById(int id);
	public User save(User client);
	public void update(User c) ;
	public User getUserByInfo(String email,String password);
	public User getByEmail(String email) ;

}
