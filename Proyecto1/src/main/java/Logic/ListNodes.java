/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Robin
 */
public class ListNodes {
    private LinkedList<Node> nodes;
    private TreeMap<Integer, LinkedList<String>> nexts;
    private TreeMap<String, LinkedList<String>> status;
    //private TreeMap<Node, LinkedList<String>> afnd;
    private int countStatus;
    
    public ListNodes() {
        this.nodes = new LinkedList<>();
        this.nexts = new TreeMap<>();
        this.status = new TreeMap<>();
        this.countStatus = 0;
        //this.afnd = new TreeMap<>();
    }
    
    //------------------------METODO PARA AGREGAR NODOS------------------------------------
    public void add(Node newnode){
        nodes.add(newnode);
        switch(newnode.getVal()){
            case "." -> {
                String[] itemsstr = newnode.getHizq().getLast().split(",");
                Integer[] items = new Integer[itemsstr.length];
                for(int i=0;i<itemsstr.length;i++){
                    items[i]=Integer.valueOf(itemsstr[i]);
                }
                String[] next = newnode.getHder().getFirst().split(",");
                for(Integer s: items){
                    if(nexts.containsKey(s)){
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }else{
                        nexts.put(s, new LinkedList());
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }
                }
            }
            case "*" -> {
                String[] itemsstr = newnode.getLast().split(",");
                Integer[] items = new Integer[itemsstr.length];
                for(int i=0;i<itemsstr.length;i++){
                    items[i]=Integer.valueOf(itemsstr[i]);
                }
                String[] next = newnode.getFirst().split(",");
                for(Integer s: items){
                    if(nexts.containsKey(s)){
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }else{
                        nexts.put(s, new LinkedList());
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }
                }
            }
            case "+" -> {
                String[] itemsstr = newnode.getLast().split(",");
                Integer[] items = new Integer[itemsstr.length];
                for(int i=0;i<itemsstr.length;i++){
                    items[i]=Integer.valueOf(itemsstr[i]);
                }
                String[] next = newnode.getFirst().split(",");
                for(Integer s: items){
                    if(nexts.containsKey(s)){
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }else{
                        nexts.put(s, new LinkedList());
                        for(String n: next){
                            if(!nexts.get(s).contains(n)){
                                nexts.get(s).add(n);
                            }
                        }
                    }
                }
            }
        }
    }
    
    //------------------------INICIALIZA LAS ESTRUCTURAS Y CAMPOS------------------------------------
    public void clearAll(){
        nodes.clear();
        nexts.clear();
        status.clear();
        countStatus = 0;
    }
    
    //------------------------METODO PARA GRAFICAR SIGUIENTES-------------------------------------------
    public String getCodeNexts(){
        String data = "n[label=<<table cellspacing=\"0\">\n<tr><td><b>Nodo</b></td><td><b>Valor</b></td><td><b>Siguiente</b></td></tr>\n";
        for(Entry<Integer,LinkedList<String>> nod: nexts.entrySet()){
            data += "<tr><td>"+nod.getKey()+"</td><td>"+getValueOfNodeByKey(nod.getKey())+"</td><td>"+String.valueOf(nod.getValue())+"</td></tr>\n";
        }
        data+="</table>>]\n";
        
        return """
               digraph G {
               node[shape=rectangle style=filled pencolor="#00000" color="cyan" fontname="Helvetica,Arial"];
               edge [dir=both]
               rankdir=TB;
               """ +
		data +
		"}";
    }
    
    //------------------------METODO PARA POBLAR ESTRUCTURA DE ESTADOS------------------------------------
    private void generateStatus(){
        String[] arrfirst = nodes.getLast().getFirst().split(",");
        List<String> lsfirsts = Arrays.asList(arrfirst);
        LinkedList<String> firsts = new LinkedList<>(lsfirsts);
        status.put("S"+countStatus, firsts);
        addStatus(firsts);
    }
    
    //------------------------METODO PARA AGREGAR ESTADOS--------------------------------------------------
    private void addStatus(LinkedList<String> nodes){
        for(String n: nodes){
            int i = Integer.parseInt(n);
            if(!status.containsValue(nexts.get(i)) && nexts.get(i)!=null){
                countStatus+=1;
                status.put("S"+countStatus, nexts.get(i));
                addStatus(nexts.get(i));
            }
        }
    }
    
    //------------------------METODO PARA GRAFICAR TRANSICIONES---------------------------------------------
    public String getCodeTransitions(){
        generateStatus();
        
        String data = "n[label=<<table cellspacing=\"0\">\n<tr><td><b>Estado</b></td><td><b>Nodo</b></td><td><b>Terminal</b></td><td><b>Siguiente</b></td></tr>\n";
        for(Entry<String,LinkedList<String>> stat: status.entrySet()){
            for(String s : stat.getValue()){
                if(nexts.get(Integer.valueOf(s))!=null){
                    boolean acptstatus = false;
                    boolean acptstn = false;
                    for(String acpt: stat.getValue()){
                        if ("#".equals(getValueOfNodeByKey(Integer.parseInt(acpt)))){
                            acptstatus = true;
                        }
                    }
                    for(String acptn: nexts.get(Integer.valueOf(s))){
                        if ("#".equals(getValueOfNodeByKey(Integer.parseInt(acptn)))){
                            acptstn = true;
                        }
                    }
                    if (acptstatus && acptstn){
                        data += "<tr><td><b>"+stat.getKey()+String.valueOf(stat.getValue())+"</b></td><td>"+s+"</td><td>"+getValueOfNodeByKey(Integer.parseInt(s))+"</td><td><b>"+String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(s))))+"</b></td></tr>\n";
                    }else if(!acptstatus && acptstn){
                        data += "<tr><td>"+stat.getKey()+String.valueOf(stat.getValue())+"</td><td>"+s+"</td><td>"+getValueOfNodeByKey(Integer.parseInt(s))+"</td><td><b>"+String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(s))))+"</b></td></tr>\n";
                    }else if(acptstatus && !acptstn){
                        data += "<tr><td><b>"+stat.getKey()+String.valueOf(stat.getValue())+"</b></td><td>"+s+"</td><td>"+getValueOfNodeByKey(Integer.parseInt(s))+"</td><td>"+String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(s))))+"</td></tr>\n";
                    }else{
                        data += "<tr><td>"+stat.getKey()+String.valueOf(stat.getValue())+"</td><td>"+s+"</td><td>"+getValueOfNodeByKey(Integer.parseInt(s))+"</td><td>"+String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(s))))+"</td></tr>\n";
                    }
                }
            }
        }
        data+="</table>>]\n";
        
        //MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+String.valueOf(status)+"\n");
        
        return """
               digraph G {
               node[shape=rectangle style=filled pencolor="#00000" color="cyan" fontname="Helvetica,Arial"];
               edge [dir=both]
               rankdir=TB;
               """ +
		data +
		"}";
        
    }
    
    //-------------------------------METODO PARA GRAFICAR AFD--------------------------------------------------
    public String getCodeAFD(){
        String accept = "node [shape=doublecircle]";
        String connect = "\n";
        for(Entry<String,LinkedList<String>> stat: status.entrySet()){
            boolean same = false;
            for(String next : stat.getValue()){
                if ("#".equals(getValueOfNodeByKey(Integer.parseInt(next)))){
                    accept += " "+stat.getKey();
                }
                if(!stat.getKey().equals(String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(next))))) && same==true){
                    same=!same;
                    connect+="\"];\n";
                }
                if(nexts.get(Integer.valueOf(next))!= null){
                    if(!same){
                        connect += stat.getKey()+"->"+String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(next))))+" [label = \""+getValueOfNodeByKey(Integer.parseInt(next)).replace("\\", "\\\\").replace("\"", "\\\"");
                    }else{
                        connect +="\\n"+getValueOfNodeByKey(Integer.parseInt(next)).replace("\\", "\\\\").replace("\"", "\\\"");
                    }
                }
                if(stat.getKey().equals(String.valueOf(getKeyOfStatusByValue(nexts.get(Integer.valueOf(next))))) && same==false){
                    same=!same;
                }
                if(!same && nexts.get(Integer.valueOf(next))!= null){
                    connect+="\"];\n";
                }
            }
        }
        accept += ";\nnode [shape=circle];";
        
        //MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+String.valueOf(status)+"\n");
        
        return """
               digraph G {
               fontname="Helvetica,Arial,sans-serif"
               node [fontname="Helvetica,Arial,sans-serif"]
               edge [fontname="Helvetica,Arial,sans-serif"]
               rankdir=LR;
               """ +
		accept +
                connect +
		"}";
        
    }
    
    //------------------------METODO PARA OBTENER EL VALOR DEL NODO SEGÚN LA LLAVE---------------------------------------------
    public String getValueOfNodeByKey(int id){
        for (Node n : nodes) {
            if(n.getId()==id){
                return n.getVal();
            }
        }
        return null;
    }
    
    //------------------------METODO PARA OBTENER LA LLAVE DEL ESTADO SEGÚN SU VALOR-----------------------------------------
    public String getKeyOfStatusByValue(LinkedList<String> val){
        for(Entry<String,LinkedList<String>> ent: status.entrySet()){
            if (ent.getValue().equals(val)){
                return ent.getKey();
            }
        }
        return null;
    }
}
