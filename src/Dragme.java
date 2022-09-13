import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Dragme {
   
   /**
    * Press on label and move mouse,the window shall be able to move correctly.
    * But the frame move in differents directions and the phenomen is more important if
    * you have multi screen.When you perform a drag from first screen into second screen
    * the frame movement jerked.
    */
   private static void createAndShowGUI() {
      
      //Create and set up the window.
      JFrame frame = new JFrame();
      frame.setUndecorated(true);
      frame.setAlwaysOnTop(true);
      
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      
      JLabel label = new JLabel("Drag Me");
      label.setFont(label.getFont().deriveFont(24f));
      label.setBorder(BorderFactory.createEtchedBorder());
      mainPanel.add(label, BorderLayout.NORTH);
      
      MouseDragAdapter mouseAdapter = new MouseDragAdapter(frame);
      
      label.addMouseListener(mouseAdapter);
      label.addMouseMotionListener(mouseAdapter);
      
      //Display the window.
      frame.setContentPane(mainPanel);
      frame.setSize(200,200);
      
      frame.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e) {
            if (e.getClickCount()==2){
               System.exit(0);
            }
         }
      });
      
      frame.pack();
      frame.setVisible(true);
   }
   
   public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
   
   private static class MouseDragAdapter implements MouseListener, MouseMotionListener{
      
      private static Point origin = new Point();
      private JFrame frame;
      
      public MouseDragAdapter(JFrame frame){
         this.frame = frame;
      }
      
      public void mousePressed(MouseEvent e) {
         origin.x = e.getPoint().x;
         origin.y = e.getPoint().y;
      }
      
      public void mouseDragged(MouseEvent e) {
         final Point mp = e.getPoint();
         final Point fp = frame.getLocationOnScreen();
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               frame.setLocation(fp.x + mp.x - origin.x,
                                 fp.y + mp.y - origin.y);
            }
         });
      }
      
      public void mouseClicked(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {
         origin.x = 0;
         origin.y = 0;
      }
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mouseMoved(MouseEvent e) {}
      
   }
}
