/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.manager;

import com.game_engine.struct.GameObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author fly_troy
 */
public class GameObjectManager {

    private static final GameObjectManager instance = new GameObjectManager();

    public static GameObjectManager GetInstance() {
        return instance;
    }

    public void addClass(GameObject object) {

    }

    HashMap<String, List<GameObject>> nameInstanceMap;

    HashMap<String, List<GameObject>> scriptInstanceMap;

    public GameObjectManager() {
        nameInstanceMap = new HashMap<>();
        scriptInstanceMap = new HashMap<>();
    }

    /**
     *
     * @param name
     * @return
     */
    public synchronized List<GameObject> getEvent(String name) {
        List<GameObject> bases = null;
        if (nameInstanceMap.containsKey(name)) {
            bases = nameInstanceMap.get(name);
        }
        return bases;
    }

    public synchronized void addClassType(GameObject tClass) {
        Class<?> interClass[] = tClass.getClass().getInterfaces();
        for (Class<?> c : interClass) {
            if (!nameInstanceMap.containsKey(c.getName())) {
                nameInstanceMap.put(c.getName(), new ArrayList<GameObject>());
            }
            nameInstanceMap.get(c.getName()).add(tClass);
        }
    }

    public synchronized void addScript(GameObject tSctipt) {
        Class<?> interClass[] = tSctipt.getClass().getInterfaces();
        for (Class<?> c : interClass) {
            if (!scriptInstanceMap.containsKey(c.getName())) {
                scriptInstanceMap.put(c.getName(), new ArrayList<GameObject>());
            }
            scriptInstanceMap.get(c.getName()).add(tSctipt);
        }
    }

    public synchronized List<GameObject> getScript(String name) {
        List<GameObject> bases = null;
        if (scriptInstanceMap.containsKey(name)) {
            bases = scriptInstanceMap.get(name);
        }
        return bases;
    }

}
