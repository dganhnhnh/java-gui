import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JListTest {

    private JList jList1;
    private JPanel jPanel1;
    private JTextArea jTextArea1;
    private JFrame f;

    private static String[] colornames = {"black", "blue", "red", "pink"};
    private static Color[] colors={Color.BLACK, Color.BLUE, Color.RED, Color.PINK };

    public JListTest() {
        initComponents();
    }

    private void initComponents() {
        f = new JFrame();
        f.setLayout(new FlowLayout());
        jPanel1 = new JPanel();
        jList1 = createList();
        
        jTextArea1 = new JTextArea();

        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        jPanel1.add(jList1);
        jPanel1.add(jTextArea1);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(jPanel1);
        f.pack();
        f.setVisible(true);
    }

    public JList createList(){
        JList list = new JList(colornames);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        f.add(new JScrollPane(list));

        list.addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    f.getContentPane().setBackground(colors[list.getSelectedIndex()]);
                }
            }
        );
        return list;
    }


    

}
