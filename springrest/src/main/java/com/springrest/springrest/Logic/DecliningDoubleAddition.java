package com.springrest.springrest.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Database.Train;
import com.springrest.springrest.entities.SrcDestnDto;
import com.springrest.springrest.entities.TrainDto;
import com.springrest.springrest.services.TrainSrvImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecliningDoubleAddition {
	@Autowired
	 private final TrainSrvImpl trainServiceImplementation = new TrainSrvImpl();
	 @Autowired
	 private final StationSettling stationSettling = null;
	 @Autowired
	 private EntityManager entityManager;

	    @Transactional // Ensures the method is executed within a transaction
	    public int findTrainsWithInnerJoinAndCondition(String nm_incoming, long num_incoming) {
	        // Writing an HQL query with inner join and condition
	        String hql = "SELECT COUNT(*) FROM TrainDto WHERE name = :nm AND number = :num";

	        // Creating a query object
	        Query query = entityManager.createQuery(hql);

	        // Setting parameters
	        query.setParameter("nm", nm_incoming);
	        query.setParameter("num", num_incoming);

	        // Executing the query and returning result
	        return ((Number) query.getSingleResult()).intValue();
    }
	    
	    @Transactional // Ensures the method is executed within a transaction
	     public void deleteFromTables(long num_incoming) {
	        // Writing an HQL query with inner join and condition
	        String hql = "DELETE FROM TrainDto WHERE number = :num";
	        String hql1 = "DELETE FROM Train WHERE number = :num";

	        // Creating a query object
	        Query query = entityManager.createQuery(hql);
	        Query query1 = entityManager.createQuery(hql1);

	        // Setting parameters
	        query.setParameter("num", num_incoming);
	        
	        query1.setParameter("num", num_incoming);

	        // Executing the query and returning result
	        query.executeUpdate();
	        query1.executeUpdate();
    }
	    
	    @Transactional // Ensures the method is executed within a transaction
	     public void UpdateFromTables(TrainDto trainDto) {
	        try {
	            System.out.println("Entering updateAndAddTrain");
	            long number_incoming = trainDto.getNumber();

	            // Delete the train with the provided number from the Train table
	            String hql1 = "DELETE FROM Train WHERE number = :num";
	            Query query1 = entityManager.createQuery(hql1);
	            query1.setParameter("num", number_incoming);
	            query1.executeUpdate();

	            // Update the train by number
	            trainServiceImplementation.updateTrainByNum(trainDto);

	            // Add the train again
	            stationSettling.AddingTrainSegregatingStations(trainDto);
	        } catch (Exception e) {
	            // Handle exceptions
	        	e.printStackTrace();
	        }
	    }
}

