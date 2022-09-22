import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener {
    JButton b;

    About() {
        this.setBounds(600, 200, 700, 600);
        this.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 80, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(180, 40, 400, 80);
        this.add(l1);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(100, 100, 1);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(50, 180, 100, 100);
        this.add(l2);
        JLabel l3 = new JLabel("<html>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        l3.setBounds(200, 130, 500, 300);
        l3.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 24));
        this.add(l3);
        this.b = new JButton("OK");
        this.b.setBounds(580, 500, 80, 25);
        this.b.addActionListener(this);
        this.add(this.b);
    }

    public static void main(String[] args) {
        (new About()).setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
