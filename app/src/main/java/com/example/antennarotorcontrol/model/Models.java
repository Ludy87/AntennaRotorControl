package com.example.antennarotorcontrol.model;

import java.util.ArrayList;

public class Models {
    private ArrayList<Model> models = new ArrayList<>();

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(Model model) {
        models.add(model);
    }
}
