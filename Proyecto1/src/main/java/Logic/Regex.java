/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Gui.MainWindow;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    
    public String analyzeERS(){
        setConjs();
        JSONArray jsonarray = new JSONArray();
        for(Map.Entry<String, LinkedList<String>> compare : compares.entrySet()){
            for(String str : compare.getValue()){
                JSONObject json = new JSONObject();
                json.put("Valor", str);
                json.put("ExpresionRegular", compare.getKey());
                if(str.replace("\\", "").matches(ers.get(compare.getKey()))){
                    json.put("Resultado","Cadena Válida");
                    MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+"La expresión: "+str+" es válida con la Expresión Regular "+compare.getKey()+"\n");
                }else{
                    json.put("Resultado","Cadena Inválida");
                    MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+"La expresión: "+str+" no es válida con la Expresión Regular "+compare.getKey()+"\n");
                }
                jsonarray.add(json);
            }
        }
        
        //MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+"\n"+jsonarray.toString()+"\n");
        
        return jsonarray.toJSONString();
    }
    
    public void setConjs(){
        for(Map.Entry<String, String> er: ers.entrySet()){
            for(Map.Entry<String, String> conj: conjs.entrySet()){
                er.setValue(er.getValue().replace(conj.getKey(), conj.getValue()));
            }
            ers.put(er.getKey(), er.getValue());
        }
    }
    
    public void clearAll(){
        conjs.clear();
        ers.clear();
        compares.clear();
    }
}
