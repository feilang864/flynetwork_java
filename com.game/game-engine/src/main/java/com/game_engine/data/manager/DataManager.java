/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.data.manager;

import com.game_engine.data.log.controllor.CreatLogJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fly_troy
 */
public class DataManager {

    private final EntityManagerFactory logEntityManagerFactory = Persistence.createEntityManagerFactory("gamelog");
    private static DataManager instance = new DataManager();
    private CreatLogJpaController logdao = new CreatLogJpaController(logEntityManagerFactory);

    public static DataManager getInstance() {

        return instance;
    }

    public CreatLogJpaController getLogdao() {
        return logdao;
    }

    public void setLogdao(CreatLogJpaController logdao) {
        this.logdao = logdao;
    }

}
