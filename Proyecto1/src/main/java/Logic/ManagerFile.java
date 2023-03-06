/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Robin
 */
public class ManagerFile {
    File file;
    ArrayList<String> data;

    public ManagerFile(File file) {
        this.file = file;
        data = new ArrayList<>();
    }

    public ManagerFile() {
        file = new File("");
        data = new ArrayList<>();
    }
    
    private void readFile(){
        try{
            FileReader freader = new FileReader(this.file);
            BufferedReader breader = new BufferedReader(freader);
            String linea = "";
            data.clear();
            while(linea != null){
                linea = breader.readLine();
                
                if (linea != null) data.add(linea);
            }  
            freader.close();
            breader.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean openFile(File file){
        try{
            setFile(file);
            readFile();
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean saveFile(String text){
        try{
            FileWriter fwriter = new FileWriter(file);
            fwriter.write(text);
            fwriter.close();
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean saveAsFile(File file, String text){
        try{
            FileWriter fwriter = new FileWriter(file);
            fwriter.write(text);
            fwriter.close();
            setFile(file);
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
