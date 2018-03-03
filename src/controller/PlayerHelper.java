package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueMeyer");
		
	public void insert(Player toAdd) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers() {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select ap from Player ap", Player.class);
		List<Player> allPlayers = allResults.getResultList();
		em.close();
		return allPlayers;
	}
	public void deletePlayer(Player toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from Player li where li.firstName = :selectedPlayer and li.lastName = :selectedPlayerLastName", Player.class);
		typedQuery.setParameter("selectedPlayer", toDelete.getFirstName());
		typedQuery.setParameter("selectedPlayerLastName", toDelete.getLastName());
		typedQuery.setMaxResults(1);
		Player result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	public Player searchForPlayerById(int playerId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player foundItem = em.find(Player.class, playerId);
		em.close();
		return foundItem;
	}
}
