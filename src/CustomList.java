import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class CustomList extends JList<String> {

    // @Override        //disallowed for this location
    public CustomList(String[] items){
        // super("title");
        // setLayout(new FlowLayout());
        // items
        this.setVisibleRowCount(4);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // add(new JScrollPane(this));

        this.addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event){
                    
                }
            }   
        );
    }
}