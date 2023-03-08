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
    public Node hizq;
    public Node hder;
    public String val;
    public int idcount;
    public int id;
    public String voidable;
    public String first;
    public String last;

    public Node(Node hizq, Node hder, String val, int idcount, int id, String voidable, String first, String last) {
        this.hizq = hizq;
        this.hder = hder;
        this.val = val;
        this.idcount = idcount;
        this.id = id;
        this.voidable = voidable;
        this.first = first;
        this.last = last;
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
    
    public String getCodigoInterno(){
        String etiqueta;
        if(hizq == null && hder == null){
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td>"+voidable+"</td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"<tr><td>"+id+"</td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }else{
            etiqueta="nodo"+idcount+"[label=<\n"
                    +"<table border='0' cellborder='1' color='blue' cellspacing='0'>\n"
                    +"<tr><td>"+voidable+"</td></tr>\n"
                    +"<tr><td>"+first+"</td><td>"+val+"</td><td>"+last+"</td></tr>\n"
                    +"<tr><td>"+id+"</td></tr>\n"
                    +"</table>\n"
                    +">];\n";
        }
        if(hizq!=null){
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + idcount + "->nodo" + hizq.idcount + "\n";
        }
        if(hder!=null){
            etiqueta = etiqueta + hder.getCodigoInterno()
                    + "nodo" + idcount + "->nodo" + hder.idcount + "\n";
        }
        return etiqueta;
    }
    
}
