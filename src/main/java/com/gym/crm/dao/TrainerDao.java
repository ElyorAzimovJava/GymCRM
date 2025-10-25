package com.gym.crm.dao;

import com.gym.crm.model.Trainer;

import java.util.UUID;

public interface TrainerDao extends GenericDao<UUID, Trainer> {
    Trainer findByUsername(String username);
}
