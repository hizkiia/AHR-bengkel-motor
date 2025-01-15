/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbol;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sparepart extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 930;
    private static final int FRAME_HEIGHT = 630;
//    private static final int FRAME_X_ORIGIN = 495;
//    private static final int FRAME_Y_ORIGIN = 225;
    private ImageIcon image1;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2, text3;
    private JTextArea txt, txt1, txt2;
    JTable jt;
    DefaultTableModel model;

    public static void main(String[] args) {
        Sparepart frame = new Sparepart();
        frame.setVisible(true);
    }

    public Sparepart() {
        Container contentPane = getContentPane();
        setLayout(null);
        String data[][] = {};
        String column[] = {"Nama", "No Part", "Harga"};
        model = new DefaultTableModel(data, column);
        jt = new JTable(model);
        jt.setBounds(107, 400, 500, 120);
        JScrollPane sp = new JScrollPane(jt);
        contentPane.add(sp, new BorderLayout().SOUTH);
        
        setTitle("Sparepart");
        setResizable(true);
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Nama:");
        JLabel label1 = new JLabel("Nomor Part:");
        JLabel label2 = new JLabel("Harga Jual:");
        label.setBounds(107, 260, 80, 50);
        label1.setBounds(107, 295, 80, 50);
        label2.setBounds(107, 325, 80, 50);
        contentPane.add(label);
        contentPane.add(label1);
        contentPane.add(label2);
        txt = new JTextArea();
        txt.setBounds(200, 280, 200, 20);
        contentPane.add(txt);
        txt1 = new JTextArea();
        txt1.setBounds(200, 310, 200, 20);
        contentPane.add(txt1);
        txt2 = new JTextArea();
        txt2.setBounds(200, 340, 200, 20);
        contentPane.add(txt2);
        btn2 = new JButton("Tambah");
        btn2.setBounds(700, 260, 90, 40);
        btn3 = new JButton("Hapus");
        btn3.setBounds(700, 310, 90, 40);
        btn4 = new JButton("Edit");
        btn4.setBounds(700, 360, 90, 40);
        btn5 = new JButton("Kembali");
        btn5.setBounds(700, 500, 90, 40);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        showData();
        image1 = new ImageIcon("LOGO.png");
        label4 = new JLabel(image1);
        label4.setBounds(215, 56, 500, 188);
        contentPane.add(label4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "XE";
        String usr = "hr";
        String pwd = "hizkiia";
        //Lead driver class
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + db, usr, pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return conn;
    }

    public void showData() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        conn = this.getConnection();
        try {

            st = conn.createStatement();
            rs = st.executeQuery("select * from sparepart");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
                jt.setModel(model);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    

    public void inputData() {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();

        String no = txt.getText();
        String nama = txt1.getText();
        String harga = txt2.getText();

        try {
            ps = conn.prepareStatement("insert into sparepart values(?, ?, ?)");
            ps.setString(1, no);
            ps.setString(2, nama);
            ps.setString(3, harga);
            ps.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    
    public void deleteData() {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = this.getConnection();        
        String nomor = JOptionPane.showInputDialog(null,"Masukkan No Part yang ingin dihapus");
        try {
            ps = conn.prepareStatement("delete from sparepart where no_part = ?");
            ps.setString(1, nomor);
            ps.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(this, "Data sudah dihapus");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        JRootPane rootPane = clickedButton.getRootPane();
        Frame frame = (JFrame) rootPane.getParent();
        String buttonText = clickedButton.getText();

        if (buttonText.equals("Kembali")) {
            MenuAwal menu = new MenuAwal();
            menu.setVisible(true);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.dispose();
        }

        if (buttonText.equals("Tambah")) {
            inputData();
        }
        
        if (buttonText.equals("Hapus")) {
            deleteData();
        }
        if (buttonText.equals("Keluar")) {
            Sparepart sp = new Sparepart();
            sp.setVisible(true);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.dispose();
        }
    }
}
