package com.gym.crm.dao;

import com.gym.crm.model.Trainee;
import com.gym.crm.model.Trainer;

import java.util.UUID;

public interface TraineeDao extends GenericDao<UUID, Trainee>{
    Trainee findByUsername(String username);
}
