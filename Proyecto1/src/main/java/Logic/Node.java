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
    private int afni;
    private int afnf;

    //---------------------------------------------------------------------------------------------------------------------
    //--------------------------             CONSTRUCTOR INICIAL DEL NODO                            ----------------------
    //---------------------------------------------------------------------------------------------------------------------
    
//    public Node(Node hizq, Node hder, String val, int idcount, int id, String voidable, String first, String last, boolean isleaf) {
//        this.hizq = hizq;
//        this.hder = hder;
//        this.val = val;
//        this.idcount = idcount;
//        this.id = id;
//        this.voidable = voidable;
//        this.first = first;
//        this.last = last;
//        this.isleaf = isleaf;
//    }

    public Node(Node hizq, Node hder, String val, int idcount, int id, String voidable, String first, String last, boolean isleaf, int afni, int afnf) {
        this.hizq = hizq;
        this.hder = hder;
        this.val = val;
        this.idcount = idcount;
        this.id = id;
        this.voidable = voidable;
        this.first = first;
        this.last = last;
        this.isleaf = isleaf;
        this.afni = afni;
        this.afnf = afnf;
    }

    public int getAfni() {
        return afni;
    }

    public void setAfni(int afni) {
        this.afni = afni;
    }

    public int getAfnf() {
        return afnf;
    }

    public void setAfnf(int afnf) {
        this.afnf = afnf;
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
    
    public String getCodER(){
        String etiqueta="";
    
        if(hizq==null && hder==null){
            etiqueta += val;
        }
        else if(hizq==null && hder!=null) {
            etiqueta += "("+hder.getCodER()+")"+val;
        }else{
            if(hizq!=null){
                etiqueta += "("+hizq.getCodER()+")";
            }
            etiqueta += val;
            if(hder!=null){
                etiqueta += "("+hder.getCodER()+")";
            }
        }
        return etiqueta;
    }

/*  ---------------------------------------------------------------------------------------------------------------------
    ----------------             INTENTO INICIAL PARA GENERAR EL AFND (NO FUNCIONÓ)                           -----------
    ---------------------------------------------------------------------------------------------------------------------

    private String generateCodAFND(boolean self){
        String etiqueta="";
        switch (val) {
            case "." -> {
                if(hizq.hder == null && hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+" [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+" -> ";
                    etiqueta = etiqueta + idcount+"4 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"4 -> ";
                    if(self){
                        etiqueta = etiqueta + idcount+"4 -> "+idcount+"1 [label=\"ε\"];\n";
                    }
                }else if(hizq.hder != null && hder.hder == null){
                    etiqueta = etiqueta + hizq.generateCodAFND(false);
                    etiqueta = etiqueta + idcount+"4 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"4 -> ";
                }else if(hizq.hder == null && hder.hder != null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+" [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+" -> ";
                    etiqueta = etiqueta + hder.generateCodAFND(false);
                }else{
                    etiqueta = etiqueta + hizq.generateCodAFND(false);
                    etiqueta = etiqueta + hder.generateCodAFND(false);
                }
            }
            case "|" -> {
                if(hizq.hder == null && hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+"2 [label=\"ε\"];\n"+idcount+"2 -> "+idcount+"3 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"3 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"5 [label=\"ε\"];\n"+idcount+"5 -> "+idcount+"6 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"6 -> "+idcount+"4 [label=\"ε\"];\n"+idcount+"4 ->";
                    if(self){
                        etiqueta = etiqueta + idcount+"4 -> "+idcount+"1 [label=\"ε\"];\n";
                    }
                }else if(hizq.hder != null && hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+hizq.generateCodAFND(false)+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"5 [label=\"ε\"];\n"+idcount+"5 -> "+idcount+"6 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"6 -> "+idcount+"4 [label=\"ε\"];\n"+idcount+"4 ->";
                    if(self){
                        etiqueta = etiqueta + idcount+"4 -> "+idcount+"1 [label=\"ε\"];\n";
                    }
                }else if(hizq.hder == null && hder.hder != null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+"2 [label=\"ε\"];\n"+idcount+"2 -> "+idcount+"3 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"3 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+hder.generateCodAFND(false)+"4 [label=\"ε\"];\n"+idcount+"4 ->";
                    if(self){
                        etiqueta = etiqueta + idcount+"4 -> "+idcount+"1 [label=\"ε\"];\n";
                    }
                }else{
                    etiqueta = etiqueta + hizq.generateCodAFND(false);
                    etiqueta = etiqueta + hder.generateCodAFND(false);
                }
                
            }
            case "*" -> {
                if(hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+"2 [label=\"ε\"];\n"+idcount+"2 -> "+idcount+"3 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"3 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"3 -> "+idcount+"2 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }else{
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+hder.generateCodAFND(true)+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }
            }
            case "+" -> {
                if(hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+"2 [label=\"ε\"];\n"+idcount+"2 -> "+idcount+"3 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"3 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"3 -> "+idcount+"2 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }else{
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+hder.generateCodAFND(true)+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }
            }
            case "?" -> {
                if(hder.hder == null){
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+idcount+"2 [label=\"ε\"];\n"+idcount+"2 -> "+idcount+"3 [label=\""+hder.val.replace("\\", "\\\\").replace("\"", "\\\"")+"\"];\n"+idcount+"3 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }else{
                    etiqueta = etiqueta + idcount+"1 [label=\"ε\"];\n"+idcount+"1 -> "+hder.generateCodAFND(false)+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"1 -> "+idcount+"4 [label=\"ε\"];\n";
                    etiqueta = etiqueta + idcount+"4 -> ";
                }
            }
        }

        
        
        return etiqueta;
    }
    
    public String getCodeAFND(){
        String str = "";
        if(val.equals("*") || val.equals("+")){
            str = generateCodAFND(true);
        }else{
            str = generateCodAFND(false);
        }
        
        return """
               digraph G {
               fontname="Helvetica,Arial,sans-serif"
               node [fontname="Helvetica,Arial,sans-serif"]
               edge [fontname="Helvetica,Arial,sans-serif"]
               rankdir=LR;
               node [shape=doublecircle label=\"\"] 0;
               node [shape=circle label=\"\"];
               -1->
               """ +
		str +
		"0 [label=\"ε\"];\n}";
    }
    
    
    ---------------------------------------------------------------------------------------------------------------------
    ---------------------------------------------------------------------------------------------------------------------
    ---------------------------------------------------------------------------------------------------------------------
*/
    
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
