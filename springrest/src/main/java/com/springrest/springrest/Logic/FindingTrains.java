package com.springrest.springrest.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.SrcDestnDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FindingTrains {

    @Autowired
    private EntityManager entityManager;
    
    public Set<String> findTrainsWithInnerJoinAndCondition(String source, String destination) {
    	

        // Writing an HQL query with inner join and condition
//        String hql = "SELECT T1.name FROM Train T1 " +
//                     "INNER JOIN Train T2 ON T1.number = T2.number " +
//                     "WHERE T1.stationName = :source AND T2.stationName = :destination";

    	  String hql = "SELECT t1.name FROM Train t1 " +
                "JOIN Train t2 ON t1.number = t2.number " +
                "WHERE t1.stationName = :source " +
                "AND t2.nxtStationId = :destination " +
                "AND (t1.id < t2.id OR t1.id = t2.id )";
    	
    	// Creating a query object
        Query query = entityManager.createQuery(hql);
 
        // Setting parameters
        query.setParameter("source", source);
        query.setParameter("destination", destination);

        // Executing the query and returning results
        System.out.println("OP" + query.getResultList());
        return new HashSet<>(query.getResultList());
    }
}

