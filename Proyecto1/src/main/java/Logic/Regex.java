/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Robin
 */
public class Regex {
    public HashMap<String, String> conjs;
    public HashMap<String, String> ers;
    public HashMap<String, LinkedList<String>> compares;

    public Regex() {
        this.conjs = new HashMap<>();
        this.ers = new HashMap<>();
        this.compares = new HashMap<>();
    }
    
    public boolean existsKeyInCompares(String key){
        for(Map.Entry<String, LinkedList<String>> e: compares.entrySet()){
            if(e.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }
}
