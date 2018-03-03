package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueMeyer");
		
	public void insertTeam(Team toAdd) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Team> getAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select li from Team li", Team.class);
		List<Team> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	public Team searchForTeamById(int searchId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team foundItem = em.find(Team.class, searchId);
		em.close();
		return foundItem;
	}
	public void itemToDelete(Team toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select li from Team li", Team.class);
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
}
