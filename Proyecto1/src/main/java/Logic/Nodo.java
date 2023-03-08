/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Robin
 */
public class Nodo {
    public Nodo hizq;
    public Nodo hder;
    public String val;
    public int id;

    public Nodo(Nodo hizq, Nodo hder, String val, int id) {
        this.hizq = hizq;
        this.hder = hder;
        this.val = val;
        this.id = id;
    }

    public Nodo getHizq() {
        return hizq;
    }

    public void setHizq(Nodo hizq) {
        this.hizq = hizq;
    }

    public Nodo getHder() {
        return hder;
    }

    public void setHder(Nodo hder) {
        this.hder = hder;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodigoInterno(){
        String etiqueta;
        if(hizq == null && hder == null){
            etiqueta="nodo"+id+"[label=\""+val+"\"];\n";
        }else{
            etiqueta="nodo"+id+"[label=\""+val+"\"];\n";
        }
        if(hizq!=null){
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hizq.id + "\n";
        }
        if(hder!=null){
            etiqueta = etiqueta + hder.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hder.id + "\n";
        }
        return etiqueta;
    }
    
}
