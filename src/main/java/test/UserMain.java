package test;

import dao.IUserDao;
import dao.UserDaoImpl;
import entities.User;
import metier.HibernateUtil;
import metier.UserMetier;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserMain {

	public static void main(String[] args) {
		
		IUserDao dao1=new UserDaoImpl();
		User client=new User();
		
		client.setFullName("driss ");
		client.setEmail("driss.@etu.uae.ac.ma");
		client.setAddress("diza");
		client.setBirthday("2001-03-02");
		client.setPhone("33444553");
		client.setPassword("driss");
		client.setSalt("");
		client.setImage("test.jpg");
		dao1.save(client);
		
		System.out.println("done");
	}

}
