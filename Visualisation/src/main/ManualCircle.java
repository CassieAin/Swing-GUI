package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ManualCircle  extends JFrame {
    int x = 10;
    int y = 300;
    private int radius = 30;
    private int xDelta = 100;
    
    ManualCircle() {
        super("Circle");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        JButton f = new JButton("Move circle");
        f.addActionListener(new Action());
        add(f, BorderLayout.NORTH);
    }

    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	x += xDelta;  
			 if (x + (radius * 2) > getWidth()) { 
				 x = getWidth() - (radius * 2) - 10;
				 xDelta *= -1;
            } else if (x < 0) { 
           	 	x = 10;
                xDelta *= -1;
            }	
			radius++;
			repaint(); 
        }
    }

    public void paint(Graphics g) {
    	 super.paint(g);
         g.setColor(Color.RED);
         g.fillOval(x, y - radius, radius * 2, radius * 2);   
    }

    public static void main(String[] args) {
    	ManualCircle mc = new ManualCircle();
        mc.setVisible(true);
    }
}
