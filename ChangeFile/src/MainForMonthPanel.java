import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainForMonthPanel {
	
	public static void main(String[] args) {
	    MonthPanel panel = new MonthPanel(5, 2015);
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new FlowLayout());
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	}
	
}
