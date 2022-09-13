import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoLabel {
    public static void main(String[] args) throws Exception {
        
        ImageIcon image= new ImageIcon("sami.jpg");

        JLabel label = new JLabel();
        label.setText("Lay Sami");
        label.setIcon(image);

        JFrame frame = new JFrame();
        frame.setTitle("First GUI stuff");
        frame.setSize(666,420);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
    }
}
