package com.example.administrator.testandroid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-27.
 */

public class MyMap implements Serializable{
    private Map<String,String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
