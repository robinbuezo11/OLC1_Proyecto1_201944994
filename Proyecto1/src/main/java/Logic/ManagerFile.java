/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Robin
 */
public class ManagerFile {
    private File file;
    private ArrayList<String> data;

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
    
    public static void graphTree(Node act, String nombre, String path){
        
        FileWriter fichero = null;
        PrintWriter pw;
        try{
            fichero = new FileWriter(path+nombre+".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=UD");
            pw.println("node[shape=circle]");
            pw.println("concentrate=true");
            pw.println(act.getCodTree());
            pw.println("}");
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
        }finally{
            try{
                if (fichero!=null){
                    fichero.close();
                }
            }catch(IOException ex){
                Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+ex.toString()+"\n");
            }
        }

        try{
            //direccion del compilador de Graphviz
            String grapPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            //direccion del .dot
            String filePath = path+nombre+".dot";
            //direccion de la imagen a crear
            String imgPath = path+nombre+".jpg";
            //conversion
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = grapPath;
            cmd[1] = tParam;
            cmd[2] = filePath;
            cmd[3] = tOParam;
            cmd[4] = imgPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
        }
    }
    
    public static void graphCode(String nombre, String path, String code){
        
        FileWriter fichero = null;
        PrintWriter pw;
        try{
            fichero = new FileWriter(path+nombre+".dot");
            pw = new PrintWriter(fichero);
            pw.print(code);
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
        }finally{
            try{
                if (fichero!=null){
                    fichero.close();
                }
            }catch(IOException ex){
                Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+ex.toString()+"\n");
            }
        }

        try{
            //direccion del compilador de Graphviz
            String grapPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            //direccion del .dot
            String filePath = path+nombre+".dot";
            //direccion de la imagen a crear
            String imgPath = path+nombre+".jpg";
            //conversion
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = grapPath;
            cmd[1] = tParam;
            cmd[2] = filePath;
            cmd[3] = tOParam;
            cmd[4] = imgPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
        }
    }
    
    public static void createFile(String nombre, String path,String ext, String code){
        
        FileWriter fichero = null;
        PrintWriter pw;
        try{
            fichero = new FileWriter(path+nombre+ext,StandardCharsets.UTF_8);
            pw = new PrintWriter(fichero);
            pw.print(code);
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
        }finally{
            try{
                if (fichero!=null){
                    fichero.close();
                }
            }catch(IOException ex){
                Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+ex.toString()+"\n");
            }
        }
    }
    
    //------------------------METODO PARA EJECUTAR UN ARCHIVO------------------------------------
    public void exeFile(String path){
        try{
            File openfile = new File(path);
            Desktop.getDesktop().open(openfile);
        }catch(IOException e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+e.toString()+"\n");
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
