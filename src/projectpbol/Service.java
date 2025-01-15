/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbol;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import projectpbol.MenuAwal;
import projectpbol.Sparepart;

/**
 *
 * @author ASUS
 */
public class Service extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 830;
    private static final int FRAME_HEIGHT = 1000;
//    private static final int FRAME_X_ORIGIN = 515;
//    private static final int FRAME_Y_ORIGIN = 10;
    private ImageIcon image1;
    private JButton btn1, btn2;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
    private JTextField text1, text2, text3, text4, text5, text6, text7;
    private JComboBox cb1, cb2;
    private JTextArea txtar;

    public static void main(String[] args) {
        Service frame = new Service();
        frame.setVisible(true);
    }

    public Service() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        setTitle("Service");
        setResizable(false);
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        //Image
        image1 = new ImageIcon("LOGO.png");
        label11 = new JLabel(image1);
        label11.setBounds(165, 8, 500, 188);
        contentPane.add(label11);

        //Label
        label10 = new JLabel("Tanggal : ");
        label10.setBounds(107, 200, 80, 50);
        contentPane.add(label10);
        label1 = new JLabel("Nama : ");
        label1.setBounds(107, 260, 80, 50);
        contentPane.add(label1);
        label2 = new JLabel("No. Telpon : ");
        label2.setBounds(107, 320, 80, 50);
        contentPane.add(label2);
        label3 = new JLabel("No. Plat : ");
        label3.setBounds(107, 380, 80, 50);
        contentPane.add(label3);
        label4 = new JLabel("Keluhan : ");
        label4.setBounds(107, 440, 80, 50);
        contentPane.add(label4);
        label5 = new JLabel("Produk : ");
        label5.setBounds(107, 550, 80, 50);
        contentPane.add(label5);
        label6 = new JLabel("Tambah Produk : ");
        label6.setBounds(107, 610, 100, 50);
        contentPane.add(label6);
        label7 = new JLabel("Estimasi Sparepart : ");
        label7.setBounds(107, 670, 120, 50);
        contentPane.add(label7);
        label8 = new JLabel("Estimasi Jasa : ");
        label8.setBounds(107, 730, 100, 50);
        contentPane.add(label8);
        label9 = new JLabel("Total : ");
        label9.setBounds(107, 790, 80, 50);
        contentPane.add(label9);

        //Button
        btn1 = new JButton("Batal");
        btn1.setBounds(177, 870, 80, 50);
        contentPane.add(btn1);
        btn2 = new JButton("Simpan");
        btn2.setBounds(531, 870, 80, 50);
        contentPane.add(btn2);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        //TextField
        text1 = new JTextField(10);
        text1.setBounds(361, 210, 375, 25);
        contentPane.add(text1);
        text2 = new JTextField(10);
        text2.setBounds(361, 270, 375, 25);
        contentPane.add(text2);
        text3 = new JTextField(10);
        text3.setBounds(361, 330, 375, 25);
        contentPane.add(text3);
        text4 = new JTextField(10);
        text4.setBounds(361, 390, 375, 25);
        contentPane.add(text4);
        text5 = new JTextField(10);
        text5.setBounds(361, 680, 375, 25);
        contentPane.add(text5);
        text6 = new JTextField(10);
        text6.setBounds(361, 740, 375, 25);
        contentPane.add(text6);
        text7 = new JTextField(10);
        text7.setBounds(361, 800, 375, 25);
        contentPane.add(text7);

        //TextArea
        txtar = new JTextArea();
        txtar.setBounds(361, 450, 375, 85);
        txtar.setLineWrap(true);
        contentPane.add(txtar);

        //ComboBox
        String prod1[] = {"Oli Helix", "Oli Shell", "", "", "", ""};
        cb1 = new JComboBox(prod1);
        cb1.setBounds(361, 560, 375, 25);
        contentPane.add(cb1);
        String prod2[] = {"Oli Helix", "Oli Shell", "", "", "", ""};
        cb2 = new JComboBox(prod2);
        cb2.setBounds(361, 620, 375, 25);
        contentPane.add(cb2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        JRootPane rootPane = clickedButton.getRootPane();
        Frame frame = (JFrame) rootPane.getParent();
        String buttonText = clickedButton.getText();
        if (buttonText.equals("Batal")) {
            MenuAwal menu = new MenuAwal();
            menu.setVisible(true);
            this.dispose();
        }
        if (buttonText.equals("Simpan")) {
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
