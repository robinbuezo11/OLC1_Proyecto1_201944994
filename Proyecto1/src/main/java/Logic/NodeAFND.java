/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author AdminTI
 */
public class NodeAFND {
    public int id;
    public String val;
    public LinkedList<Integer> nexts;

    public NodeAFND(int id, String val, LinkedList<Integer> nexts) {
        this.id = id;
        this.val = val;
        this.nexts = nexts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public LinkedList<Integer> getNexts() {
        return nexts;
    }

    public void setNexts(LinkedList<Integer> nexts) {
        this.nexts = nexts;
    }
    
    
}
