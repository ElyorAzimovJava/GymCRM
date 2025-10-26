package com.gym.crm.dao;

import com.gym.crm.model.Trainee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class TraineeDaoImpl implements TraineeDao{
    private static final Logger logger = Logger.getLogger(String.valueOf(TraineeDaoImpl.class));
    private final Map<UUID, Object> db;
    public TraineeDaoImpl(@Qualifier("traineeDb")Map<UUID, Object> db) {
        this.db = db;
    }

    @Override
    public Trainee findByUsername(String username) {
        return db.values()
                .stream()
                .filter(o -> (o instanceof Trainee))
                .map(o -> (Trainee) o)
                .findFirst().orElse(null);
    }

    @Override
    public Trainee save(Trainee entity) {
        if(entity.getId()==null){
            entity.setId(UUID.randomUUID());
        }
        db.put(entity.getId(), entity);
        logger.info("TraineeDaoImpl save Trainee");
        return entity;
    }

    @Override
    public Trainee update(Trainee entity) {
        db.put(entity.getId(), entity);
        logger.info("TraineeDaoImpl update Trainee");
        return entity;
    }

    @Override
    public void delete(UUID id) {
       db.remove(id);
       logger.info("TraineeDaoImpl delete Trainee");
    }

    @Override
    public Trainee findById(UUID id) {
        return (Trainee) db.get(id);
    }

    @Override
    public List<Trainee> findAll() {
        return db.values().stream()
                .filter(o -> o instanceof Trainee)
                .map(o -> (Trainee) o)
                .toList();
    }
}
