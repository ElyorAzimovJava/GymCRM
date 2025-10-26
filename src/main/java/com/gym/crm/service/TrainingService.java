package com.gym.crm.service;

import com.gym.crm.dao.TrainingDao;
import com.gym.crm.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
@Service
public class TrainingService {
    private static final Logger logger = Logger.getLogger(TrainingService.class.getName());


    private TrainingDao trainingDao;


    @Autowired
    public void setTrainingDao(TrainingDao trainingDao) { this.trainingDao = trainingDao; }


    public Training createTraining(Training t) {
        Training saved = trainingDao.save(t);
        logger.info("Training created: " + saved);
        return saved;
    }


    public Training findById(UUID id) { return trainingDao.findById(id); }
    public List<Training> listAll() { return trainingDao.findAll(); }
}
