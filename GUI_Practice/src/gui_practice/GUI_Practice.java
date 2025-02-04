package gui_practice;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GUI_Practice implements ActionListener{
    private int count = 0;
    private JFrame a;
    private JPanel b;
    private JLabel d;
    public GUI_Practice(){
        a = new JFrame();
        JButton c = new JButton("click me");
        c.addActionListener(this);
        d = new JLabel("Number of clicks: 0");
        
        b = new JPanel();
        b.setBorder(BorderFactory.createEmptyBorder(300,300,300,300)); //top,bottom,left,right
        b.setLayout(new GridLayout(0,1));
        b.add(c);
        b.add(d);
        a.add(b, BorderLayout.CENTER);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setTitle("The GUI");
        
        a.pack();
        a.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI_Practice();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        count++;
        d.setText("Number of clicks: "+count);
    }
}
