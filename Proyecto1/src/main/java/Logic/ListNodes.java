/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 *
 * @author Robin
 */
public class ListNodes {
    private LinkedList<Node> nodes;
    private TreeMap<Integer, LinkedList<String>> nexts;

    public ListNodes() {
        this.nodes = new LinkedList<>();
        this.nexts = new TreeMap<>();
    }
    
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
            case "?" -> {
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
    
    public void clearAll(){
        nodes.clear();
        nexts.clear();
    }
    
    public String getCodeNexts(){
        String data = "n[label=<<table cellspacing=\"0\">\n<tr><td><b>Nodo</b></td><td><b>Valor</b></td><td><b>Siguiente</b></td></tr>\n";
        for(Entry<Integer,LinkedList<String>> nod: nexts.entrySet()){
            data += "<tr><td>"+nod.getKey()+"</td><td>"+getValueOfNode(nod.getKey())+"</td><td>"+String.valueOf(nod.getValue())+"</td></tr>\n";
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
    
    public String getValueOfNode(int id){
        for (Node n : nodes) {
            if(n.getId()==id){
                return n.getVal();
            }
        }
        return null;
    }
}
