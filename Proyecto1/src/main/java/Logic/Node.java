/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Robin
 */
public class Node {
    private Node hizq;
    private Node hder;
    private String val;
    private int idcount;
    private int id;
    private String voidable;
    private String first;
    private String last;
    private boolean isleaf;
    private int countafn;

    public Node(Node hizq, Node hder, String val, int idcount, int id, String voidable, String first, String last, boolean isleaf) {
        this.hizq = hizq;
        this.hder = hder;
        this.val = val;
        this.idcount = idcount;
        this.id = id;
        this.voidable = voidable;
        this.first = first;
        this.last = last;
        this.isleaf = isleaf;
        this.countafn = 0;
    }

    public int getCountafn() {
        return countafn;
    }

    public void setCountafn(int countafn) {
        this.countafn = countafn;
    }

    public boolean isIsleaf() {
        return isleaf;
    }

    public void setIsleaf(boolean isleaf) {
        this.isleaf = isleaf;
    }

    public Node getHizq() {
        return hizq;
    }

    public void setHizq(Node hizq) {
        this.hizq = hizq;
    }

    public Node getHder() {
        return hder;
    }

    public void setHder(Node hder) {
        this.hder = hder;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public int getIdcount() {
        return idcount;
    }

    public void setIdcount(int idcount) {
        this.idcount = idcount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoidable() {
        return voidable;
    }

    public void setVoidable(String voidable) {
        this.voidable = voidable;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    public String getCodTree(){
        String etiqueta;
        if(isleaf){
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td></td><td>"+voidable+"</td><td></td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"<tr><td></td><td>"+id+"</td><td></td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }else{
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td></td><td>"+voidable+"</td><td></td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }
        if(hizq!=null){
            etiqueta = etiqueta + hizq.getCodTree()
                    + "nodo" + idcount + "->nodo" + hizq.idcount + "\n";
        }
        if(hder!=null){
            etiqueta = etiqueta + hder.getCodTree()
                    + "nodo" + idcount + "->nodo" + hder.idcount + "\n";
        }
        return etiqueta;
    }
    
    public String getCodAFND(String connect){
        if (hder != null){
            switch (val) {
                case "." -> {
                    countafn+=1;
                    connect += (countafn-1)+"->"+hizq.getCodAFND(connect);//+" [label = \""+"".replace("\\", "\\\\").replace("\"", "\\\"");
                    connect += "->"+hder.getCodAFND(connect);
                }
                case "|" -> {
                    countafn+=3;
                    connect += (countafn-3)+"->"+(countafn-2)+" [label = \"ε\"];\n";
                    connect += (countafn-3)+"->"+(countafn-1)+" [label = \"ε\"];\n";
                    int a=countafn-2;
                    int b=countafn-1;
                    
                    connect += a+"->"+hizq.getCodAFND(connect);
                    countafn+=1;
                    connect += (countafn-2)+"->"+(countafn-1)+" [label = \"ε\"];\n";
                    int e=countafn-1;
                    connect += b+"->"+hder.getCodAFND(connect);
                    connect += (countafn-1)+"->"+e+" [label = \"ε\"];\n";
                }
                case "+" -> {
                    
                }
                case "*" -> {
                    
                }
                case "?" -> {
                    
                }
            }
        }else{
            //deben siempre apuntar a un siguiente
        }
        
        /*if(isleaf){
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td></td><td>"+voidable+"</td><td></td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"<tr><td></td><td>"+id+"</td><td></td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }else{
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td></td><td>"+voidable+"</td><td></td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }
        if(hizq!=null){
            etiqueta = etiqueta + hizq.getCodTree()
                    + "nodo" + idcount + "->nodo" + hizq.idcount + "\n";
        }
        if(hder!=null){
            etiqueta = etiqueta + hder.getCodTree()
                    + "nodo" + idcount + "->nodo" + hder.idcount + "\n";
        }
        */
        return connect;
    }

    @Override
    public String toString() {
        if (this.hizq == null && this.hder == null){
            return this.val;
        }else if (this.hizq == null && this.hder != null){
            return this.val+this.hder.val;
        }else {
            return this.hizq.val + this.val + this.hder.val;
        }
    }
}
