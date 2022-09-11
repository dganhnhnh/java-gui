import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        MyListApp listApp = new MyListApp();
        listApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listApp.setSize(666,420);
        listApp.setVisible(true);

        // SwingUtilities.invokeLater(new Runnable() {

        //     @Override
        //     public void run() {
        //         new JListTest();
        //     }
        // });
    }
}
