import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class MyListApp extends JFrame {
    private JList list1,list2;
    private JPanel jPanel1,jPanel2;
    private JTextArea jTextArea1, jTextArea2;
    private static String[] colornames = {"black", "blue", "red", "pink"};
    private static Color[] colors={Color.BLACK, Color.BLUE, Color.RED, Color.PINK };

    private static String[] units={"m", "km", "mile", "foot"};
    private Converter myConverter = new Converter("m", 1, 1);

    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        list1 = createList();
        list2 = createList();
        jTextArea1 = new JTextArea();
        jTextArea2 = new JTextArea();
        jTextArea1.setColumns(20);
        jTextArea1.setRows(2);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(2);
        jPanel1.add(list1);
        jPanel1.add(jTextArea1);
        jPanel2.add(list2);
        jPanel2.add(jTextArea2);
        add(jPanel1);
        add(jPanel2);

        list1.addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    myConverter.setUnitFrom(list1.getSelectedValue().toString());
                    // jTextArea1.setText(list1.getSelectedValue().toString());
                    jTextArea2.setText(""+myConverter.outputValue());

                }
            }
        );
        list2.addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    myConverter.setUnitTo(list2.getSelectedIndex());
                    // jTextArea2.setText(""+list2.getSelectedIndex());
                    jTextArea2.setText(""+myConverter.outputValue());

                }
            }
        );

        jTextArea1.getDocument().addDocumentListener(
            new DocumentListener() {
                @Override
                public void removeUpdate(DocumentEvent e) {
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    myConverter.setInput(Double.parseDouble(jTextArea1.getText()));
                    jTextArea2.setText(""+myConverter.outputValue());
                }
        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        // havent work yet
            }
        );
    }

    public MyListApp(){
        super("title");
        setLayout(new FlowLayout());
        initComponents();
    }   

    public JList createList(){
        JList list = new JList(units);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));

        // list.addListSelectionListener(
        //     new ListSelectionListener() {
        //         public void valueChanged(ListSelectionEvent event){
        //             getContentPane().setBackground(colors[list.getSelectedIndex()]);
        //         }
        //     }
        // );
        //change this
        return list;
    }

    //TODO: list1 and list2 implements different listeners --> link with converter object
}




//cannot work because:
        // - CustomList needs constructor, but overriding that of JList doesnt work 



// public class MyListApp extends JFrame {
//     private JList list;
//     private static String[] colornames = {"black", "blue", "red", "pink"};
//     private static Color[] colors={Color.BLACK, Color.BLUE, Color.RED, Color.PINK };

//     public MyListApp(){
//         super("title");
//         setLayout(new FlowLayout());
//         CustomList unitList = new CustomList(colornames);
//         add(new JScrollPane(unitList));
//     }
// }