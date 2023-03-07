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
public class Calc {
    private LinkedList<Integer> pila;

    public Calc() {
        pila = new LinkedList<>();
    }
    
    public void print(){
        try{
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\n" + pila.pop());
        } catch(Exception e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\nError al imprimir");
        }
    }
    
    public void push(Integer num){
        pila.push(num);
    }
    
    public void div(){
        try{
            pila.push(pila.pop()/pila.pop());
        } catch(Exception e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\nError en división");
        }
    }
    
    public void mult(){
        try{
            pila.push(pila.pop()*pila.pop());
        } catch(Exception e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\nError en multiplicación");
        }
    }
    
    public void add(){
        try{
            pila.push(pila.pop()+pila.pop());
        } catch(Exception e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\nError en suma");
        }
    }
    
    public void sub(){
        try{
            pila.push(pila.pop()-pila.pop());
        } catch(Exception e){
            Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText() + "\nError en resta");
        }
    }
}
