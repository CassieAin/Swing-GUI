package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AutomaticCircle{
	 public static void main(String[] args) {
	        new AutomaticCircle();
	    }

	 public AutomaticCircle() {
		 EventQueue.invokeLater(new Runnable() {
			 @Override
			 public void run() {
				 try {
	    		 		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				 } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				 	}

				 JFrame frame = new JFrame("Testing");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.setLayout(new BorderLayout());
				 frame.add(new TestPane());
				 frame.pack();
				 frame.setLocationRelativeTo(null);
				 frame.setVisible(true);
			 }
		 });
	 }

	 public class TestPane extends JPanel {
		 private int x = 0;
	     private int y = 250;
	     private int radius = 30;
	     private int xDelta = 7;
	     
	     public TestPane() {
	    	 Timer timer = new Timer(40, new ActionListener() {              
	    		 @Override      
	    		 public void actionPerformed(ActionEvent e) {           
	    			 x += xDelta;  
	    			 if (x + (radius * 2) > getWidth()) { 
	    				 x = getWidth() - (radius * 2);
	                     xDelta *= -1;
	                     radius++;
	                 } else if (x < 0) { 
	                	 x = 0;
	                     xDelta *= -1;
	                     radius++;
	                 }	
	    			 repaint(); 
	    		 } 
	    	 });  
	    	 timer.start();  
	     }
  
	     @Override 
	     public Dimension getPreferredSize() {    
	    	 return new Dimension(650, 550);
	     }

	     @Override
	     protected void paintComponent(Graphics g) { 
	    	 super.paintComponent(g);
	         g.setColor(Color.RED);
	         g.fillOval(x, y - radius, radius * 2, radius * 2);  
	     }  
	 }
}
