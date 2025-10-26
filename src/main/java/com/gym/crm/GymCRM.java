package com.gym.crm;

import com.gym.crm.config.Config;
import com.gym.crm.model.Trainee;
import com.gym.crm.service.TraineeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GymCRM {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        TraineeService traineeService = context.getBean(TraineeService.class);
        traineeService.listAll();

        System.out.println("Spring context initialized successfully!");
    }


}
