/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import java.util.TreeMap;

/**
 *
 * @author AdminTI
 */
public class NodeAFND {
    public int id;
    public TreeMap<Integer,String> nexts;

    public NodeAFND(int id, String val, TreeMap<Integer,String> nexts) {
        this.id = id;
        this.nexts = nexts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeMap<Integer,String> getNexts() {
        return nexts;
    }

    public void setNexts(TreeMap<Integer,String> nexts) {
        this.nexts = nexts;
    }
    
    
}
