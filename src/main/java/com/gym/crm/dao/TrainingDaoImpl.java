package com.gym.crm.dao;

import com.gym.crm.model.Training;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;
@Repository
public class TrainingDaoImpl implements TrainingDao {
    private static final Logger logger = Logger.getLogger(String.valueOf(TrainingDaoImpl.class));
    private final Map<UUID, Object> db;
    public TrainingDaoImpl(@Qualifier("trainingDb") Map<UUID, Object> db) {
        this.db = db;
    }
    @Override
    public Training save(Training entity) {
        if(entity.getId() == null){
            entity.setId(UUID.randomUUID());
        }
        db.put(entity.getId(), entity);
        logger.info("Training " + entity.getId() + " has been saved");
        return entity;

    }

    @Override
    public Training update(Training entity) {
        db.put(entity.getId(), entity);
        logger.info("Training " + entity.getId() + " has been updated");
        return entity;
    }

    @Override
    public void delete(UUID id) {
       db.remove(id);
       logger.info("Training " + id + " has been deleted");
    }

    @Override
    public Training findById(UUID id) {
        return (Training) db.get(id);
    }

    @Override
    public List<Training> findAll() {
        return db.values().stream()
                .filter(o -> o instanceof Training)
                .map( o -> (Training) o)
                .collect(Collectors.toList());
    }
}
