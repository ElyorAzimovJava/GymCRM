package com.gym.crm.dao;

import com.gym.crm.model.Trainer;
import com.gym.crm.model.Training;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class TrainerDaoImpl implements TrainerDao {
    private static final Logger LOG = Logger.getLogger(TrainerDaoImpl.class.getName());
    private final Map<UUID, Object> db;

    public TrainerDaoImpl(@Qualifier("trainerDb")  Map<UUID, Object> db) {
       this.db = db;
    }
    @Override
    public Trainer findByUsername(String username) {
        return db.values().stream()
                .filter(o -> o instanceof Trainer)
                .map(o -> (Trainer) o)
                .filter(trainer -> trainer.getUsername().equals(username))
                .findFirst().orElse(null);
    }

    @Override
    public Trainer save(Trainer entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
        db.put(entity.getId(), entity);
        LOG.info("Trainer " + entity.getId() + " saved as " + entity.toString());
        return entity;
    }

    @Override
    public Trainer update(Trainer entity) {
        db.put(entity.getId(), entity);
        LOG.info("Trainer " + entity.getId() + " updated as " + entity.toString());
        return entity;
    }

    @Override
    public void delete(UUID id) {
        db.remove(id);
        LOG.info("Trainer " + id + " deleted as " + id.toString());
    }

    @Override
    public Trainer findById(UUID id) {
        db.get(id);
        LOG.info("Trainer " + id + " found as " + id.toString());
        return (Trainer) db.get(id);
    }

    @Override
    public List<Trainer> findAll() {
        return db.values()
                .stream()
                .filter(o -> o instanceof Trainer)
                .map(o -> (Trainer) o)
                .toList();
    }
}
