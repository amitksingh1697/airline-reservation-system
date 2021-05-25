package com.capgemini.airlinereservationsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.airlinereservationsystem.beans.UserBean;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	//New user can registered themselves
	@Override
	public boolean registerUser(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
			String role = "user";
			userBean.setUserRole(role);
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}

	//Authentication of all type of users(customer,admin,executive)
	@Override
	public String userLogin(String userId, String userPassword) {
		String role = null;
		UserBean userBean = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		userBean = entityManager.find(UserBean.class, userId);
		if(userBean!=null) {
			String password = userBean.getUserPassword();
			if (password.equals(userPassword)) {
				return role = userBean.getUserRole();
			}
			return role;		
		}
		return "This user not exist";
	}// end of userLogin()

	//register the new admin or new executive only by the admin
	@Override
	public boolean registerByAdmin(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}

}// end of class
