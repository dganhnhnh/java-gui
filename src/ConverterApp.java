import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class ConverterApp extends JFrame {
    private JList list1,list2;
    private JPanel jPanel1,jPanel2;
    private JTextArea jTextArea1, jTextArea2;
    private JButton button;

    private static String[] units={"m", "km", "mile", "foot"};
    private Converter myConverter = new Converter("m", 1, 1);

    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        list1 = createList();
        list2 = createList();
        jTextArea1 = new JTextArea();
        jTextArea2 = new JTextArea();
        jTextArea1.setColumns(15);
        jTextArea1.setRows(4);
        jTextArea2.setColumns(15);
        jTextArea2.setRows(4);
        button = new JButton("Convert");
        button.setSize(100,100);

        jPanel1.add(list1);
        jPanel1.add(jTextArea1);
        jPanel2.add(list2);
        jPanel2.add(jTextArea2);
        add(jPanel1);
        add(button);
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
        
        button.addActionListener(new ActionListener(){  
         
            @Override
            public void actionPerformed(ActionEvent e) {
                myConverter.setInput(Double.parseDouble(jTextArea1.getText()));
                jTextArea2.setText(""+myConverter.outputValue());
            }  
            });  
    }

    public ConverterApp(){
        super("title");
        setLayout(new FlowLayout());
        initComponents();
    }   

    public JList createList(){
        JList list = new JList(units);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));
        return list;
    }

    private static void createAndShowGUI() {
        // JFrame.setDefaultLookAndFeelDecorated(true);
        ConverterApp frame = new ConverterApp();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(666,420);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {   
                createAndShowGUI();
            }
        });
    }
}