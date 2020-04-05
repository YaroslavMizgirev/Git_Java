import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param args
     */
	JButton b1, b2;
	JLabel l1, l2, l3, l4;
	JTextField t1, t2;
	int i, k;
	String a, b;
	EHandler handler = new EHandler();

	public HelloWorld(String s) {	
		super(s);
		setLayout(new FlowLayout());
		
		b1 = new JButton("��������");
		b2 = new JButton("���������");
		
		l1 = new JLabel(" - ������ �����");
		l2 = new JLabel(" - ������ �����");
		l3 = new JLabel("");
		l4 = new JLabel("");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		
		add(t1);		
		add(l1);
		add(t2);
		add(l2);
		add(b2);
		b2.addActionListener(handler);
		add(b1);
		b1.addActionListener(handler);
		add(l3);
		add(l4);
	}
	
    public static boolean CheckStringIsInteger(String in) {
        if (in == null || in.isEmpty()) return false;
        in = in.trim();
        for (int i = 0; i < in.length(); i++) {
            if (!Character.isDigit(in.charAt(i))) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		
		HelloWorld hw = new HelloWorld("G-�����");
		hw.setVisible(true);
		hw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hw.setSize(300, 200);
		hw.setResizable(false);
		hw.setLocationRelativeTo(null);
    }
	
	public class EHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b2) {
				if (!CheckStringIsInteger(t1.getText())) {
					JOptionPane.showMessageDialog(null, "������� ������ ����� �����!");
					t1.setText(null);
					l3.setText("");
				}
				else {
					i = Integer.parseInt(t1.getText());
					l3.setText("���� - " + i + ", ����� - " + (i + 1));
				}
				
				if (!CheckStringIsInteger(t2.getText())) {
					JOptionPane.showMessageDialog(null, "������� ������ ����� �����!");
					t2.setText(null);
					l4.setText("");
				}
				else {
					k = Integer.parseInt(t2.getText());
					l4.setText("���� - " + k + ", ����� - " + (k + 1));
				}
				
			}
			
			if (e.getSource() == b1) {
				t1.setText(null);
				t2.setText(null);
				l3.setText("");
				l4.setText("");
			}
		}
		
	}
}