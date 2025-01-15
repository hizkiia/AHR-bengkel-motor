/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbol;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Tabel extends JFrame {

    JTable table;

    public static void main(String[] args) {
        Tabel tabel = new Tabel();
    }

    public Tabel() {
        String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[]={"ID","NAME","SALARY"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt); 
    add(sp);          
    setSize(300,400);    
    setVisible(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
