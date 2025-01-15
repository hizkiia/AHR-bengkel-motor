package projectpbol;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

public class MenuAwal extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 930;
    private static final int FRAME_HEIGHT = 630;
//    private static final int FRAME_X_ORIGIN = 495;
//    private static final int FRAME_Y_ORIGIN = 225;
    private ImageIcon image1;
    private JButton btn1, btn2, btn3, btn4;
    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2, text3;

    public static void main(String[] args) {
        MenuAwal frame = new MenuAwal();
        frame.setVisible(true);
    }

    public MenuAwal() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        setTitle("Bengkel Motor");
        setResizable(false);
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        btn1 = new JButton("Service");
        btn1.setBounds(50, 300, 200, 100);
        btn2 = new JButton("Sparepart");
        btn2.setBounds(350, 300, 200, 100);
        btn3 = new JButton("Transaksi");
        btn3.setBounds(650, 300, 200, 100);
        btn4 = new JButton("Keluar");
        btn4.setBounds(750, 500, 100, 40);
        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        image1 = new ImageIcon("LOGO.png");
        label4 = new JLabel(image1);
        label4.setBounds(215, 56, 500, 188);
        contentPane.add(label4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        JRootPane rootPane = clickedButton.getRootPane();
        Frame frame = (JFrame) rootPane.getParent();
        String buttonText = clickedButton.getText();
        if (buttonText.equals("Service")) {
            Service servis = new Service();
            servis.setVisible(true);  
            this.dispose();
        }
        if(buttonText.equals("Sparepart")){
            Sparepart sp = new Sparepart();
            sp.setVisible(true);
            this.dispose();
        }
        if (buttonText.equals("Keluar")) {
            System.exit(0);
        }
    }

}
