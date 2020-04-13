import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel label_CalculationDisplay;
	private JTextArea textJournal;
	private JLabel label_ActionDisplay;
	private double variableOne = 0.0;
	private int NEW_STRING = 1;
	private boolean AFTER_COMPUTATION = false;
	private boolean AFTER_ARITHMETIC = false;
	private boolean ARITHMETIC_ACTION = false;
	private boolean multiplication = false;
	private boolean division = false;
	private boolean addition = false;
	private boolean subtraction = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 40, 14, 37, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		label_CalculationDisplay = new JLabel("");
		label_CalculationDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		label_CalculationDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
		label_CalculationDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_CalculationDisplay = new GridBagConstraints();
		gbc_label_CalculationDisplay.fill = GridBagConstraints.BOTH;
		gbc_label_CalculationDisplay.gridwidth = 4;
		gbc_label_CalculationDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_label_CalculationDisplay.gridx = 0;
		gbc_label_CalculationDisplay.gridy = 0;
		contentPane.add(label_CalculationDisplay, gbc_label_CalculationDisplay);
		
		textJournal = new JTextArea();
		JScrollPane scroll = new JScrollPane(textJournal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textJournal.setEnabled(false);
		textJournal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e.getKeyCode());
				keystrokeHandling(e.getKeyCode());
			}
		});
		textJournal.setFont(new Font("Arial", Font.BOLD, 16));
		textJournal.setWrapStyleWord(true);
		textJournal.setLineWrap(true);
		GridBagConstraints gbc_textJournal = new GridBagConstraints();
		gbc_textJournal.gridheight = 8;
		gbc_textJournal.fill = GridBagConstraints.BOTH;
		gbc_textJournal.gridx = 4;
		gbc_textJournal.gridy = 0;
		contentPane.add(scroll, gbc_textJournal);
		
		label_ActionDisplay = new JLabel("0");
		label_ActionDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		label_ActionDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
		label_ActionDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_ActionDisplay = new GridBagConstraints();
		gbc_label_ActionDisplay.fill = GridBagConstraints.BOTH;
		gbc_label_ActionDisplay.gridwidth = 4;
		gbc_label_ActionDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_label_ActionDisplay.gridx = 0;
		gbc_label_ActionDisplay.gridy = 1;
		contentPane.add(label_ActionDisplay, gbc_label_ActionDisplay);
		
		JLabel lblNewLabel_1 = new JLabel("                    ");
		lblNewLabel_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                    ");
		lblNewLabel_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("                    ");
		lblNewLabel_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("                    ");
		lblNewLabel_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 2;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		Button button_Reciprocal = new Button("1/x");
		button_Reciprocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_RECIPROCAL_Press();
			}
		});
		button_Reciprocal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Reciprocal.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Reciprocal = new GridBagConstraints();
		gbc_button_Reciprocal.fill = GridBagConstraints.BOTH;
		gbc_button_Reciprocal.insets = new Insets(0, 0, 5, 5);
		gbc_button_Reciprocal.gridx = 0;
		gbc_button_Reciprocal.gridy = 3;
		contentPane.add(button_Reciprocal, gbc_button_Reciprocal);
		
		Button button_Clear = new Button("CE/C");
		button_Clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_ESC_Press();
			}
		});
		button_Clear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Clear.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Clear = new GridBagConstraints();
		gbc_button_Clear.fill = GridBagConstraints.BOTH;
		gbc_button_Clear.insets = new Insets(0, 0, 5, 5);
		gbc_button_Clear.gridx = 1;
		gbc_button_Clear.gridy = 3;
		contentPane.add(button_Clear, gbc_button_Clear);
		
		Button button_Backspase = new Button("00 > 0");
		button_Backspase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_BACKSPASE_Press();
			}
		});
		button_Backspase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Backspase.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Backspase = new GridBagConstraints();
		gbc_button_Backspase.fill = GridBagConstraints.BOTH;
		gbc_button_Backspase.insets = new Insets(0, 0, 5, 5);
		gbc_button_Backspase.gridx = 2;
		gbc_button_Backspase.gridy = 3;
		contentPane.add(button_Backspase, gbc_button_Backspase);
		
		Button button_Division = new Button("/");
		button_Division.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_DIVISION_Press();
			}
		});
		button_Division.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Division.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Division = new GridBagConstraints();
		gbc_button_Division.fill = GridBagConstraints.BOTH;
		gbc_button_Division.insets = new Insets(0, 0, 5, 5);
		gbc_button_Division.gridx = 3;
		gbc_button_Division.gridy = 3;
		contentPane.add(button_Division, gbc_button_Division);
		
		Button button_1 = new Button("1");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_1_Press();
			}
		});
		button_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 4;
		contentPane.add(button_1, gbc_button_1);
		
		Button button_2 = new Button("2");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_2_Press();
			}
		});
		button_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 4;
		contentPane.add(button_2, gbc_button_2);
		
		Button button_3 = new Button("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_3_Press();
			}
		});
		button_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_3.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.BOTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 4;
		contentPane.add(button_3, gbc_button_3);
		
		Button button_Multiplication = new Button("x");
		button_Multiplication.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_MULTIPLICATION_Press();
			}
		});
		button_Multiplication.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Multiplication.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Multiplication = new GridBagConstraints();
		gbc_button_Multiplication.fill = GridBagConstraints.BOTH;
		gbc_button_Multiplication.insets = new Insets(0, 0, 5, 5);
		gbc_button_Multiplication.gridx = 3;
		gbc_button_Multiplication.gridy = 4;
		contentPane.add(button_Multiplication, gbc_button_Multiplication);
		
		Button button_4 = new Button("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_4_Press();
			}
		});
		button_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_4.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.BOTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 5;
		contentPane.add(button_4, gbc_button_4);
		
		Button button_5 = new Button("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_5_Press();
			}
		});
		button_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_5.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.BOTH;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 1;
		gbc_button_5.gridy = 5;
		contentPane.add(button_5, gbc_button_5);
		
		Button button_6 = new Button("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_6_Press();
			}
		});
		button_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_6.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.BOTH;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 2;
		gbc_button_6.gridy = 5;
		contentPane.add(button_6, gbc_button_6);
		
		Button button_Subtraction = new Button("-");
		button_Subtraction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_SUBTRACTION_Press();
			}
		});
		button_Subtraction.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Subtraction.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Subtraction = new GridBagConstraints();
		gbc_button_Subtraction.fill = GridBagConstraints.BOTH;
		gbc_button_Subtraction.insets = new Insets(0, 0, 5, 5);
		gbc_button_Subtraction.gridx = 3;
		gbc_button_Subtraction.gridy = 5;
		contentPane.add(button_Subtraction, gbc_button_Subtraction);
		
		Button button_7 = new Button("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_7_Press();
			}
		});
		button_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_7.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.BOTH;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 0;
		gbc_button_7.gridy = 6;
		contentPane.add(button_7, gbc_button_7);
		
		Button button_8 = new Button("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_8_Press();
			}
		});
		button_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_8.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.BOTH;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 1;
		gbc_button_8.gridy = 6;
		contentPane.add(button_8, gbc_button_8);
		
		Button button_9 = new Button("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_9_Press();
			}
		});
		button_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_9.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.BOTH;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 2;
		gbc_button_9.gridy = 6;
		contentPane.add(button_9, gbc_button_9);
		
		Button button_Addition = new Button("+");
		button_Addition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_ADDITION_Press();
			}
		});
		button_Addition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Addition.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Addition = new GridBagConstraints();
		gbc_button_Addition.insets = new Insets(0, 0, 5, 5);
		gbc_button_Addition.fill = GridBagConstraints.BOTH;
		gbc_button_Addition.gridx = 3;
		gbc_button_Addition.gridy = 6;
		contentPane.add(button_Addition, gbc_button_Addition);
		
		Button button_PlusMinus = new Button("+/-");
		button_PlusMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_PLUS_MINUS_Press();
			}
		});
		button_PlusMinus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_PlusMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_PlusMinus = new GridBagConstraints();
		gbc_button_PlusMinus.fill = GridBagConstraints.BOTH;
		gbc_button_PlusMinus.insets = new Insets(0, 0, 0, 5);
		gbc_button_PlusMinus.gridx = 0;
		gbc_button_PlusMinus.gridy = 7;
		contentPane.add(button_PlusMinus, gbc_button_PlusMinus);
		
		Button button_0 = new Button("0");
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_0_Press();
			}
		});
		button_0.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_0.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_0 = new GridBagConstraints();
		gbc_button_0.fill = GridBagConstraints.BOTH;
		gbc_button_0.insets = new Insets(0, 0, 0, 5);
		gbc_button_0.gridx = 1;
		gbc_button_0.gridy = 7;
		contentPane.add(button_0, gbc_button_0);
		
		Button button_Dot = new Button(".");
		button_Dot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_DOT_Press();
			}
		});
		button_Dot.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Dot.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Dot = new GridBagConstraints();
		gbc_button_Dot.fill = GridBagConstraints.BOTH;
		gbc_button_Dot.insets = new Insets(0, 0, 0, 5);
		gbc_button_Dot.gridx = 2;
		gbc_button_Dot.gridy = 7;
		contentPane.add(button_Dot, gbc_button_Dot);
		
		Button button_Equal = new Button("=");
		button_Equal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				key_EQUAL_Press();
			}
		});
		button_Equal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keystrokeHandling(e.getKeyCode());
			}
		});
		button_Equal.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_Equal = new GridBagConstraints();
		gbc_button_Equal.fill = GridBagConstraints.BOTH;
		gbc_button_Equal.insets = new Insets(0, 0, 0, 5);
		gbc_button_Equal.gridx = 3;
		gbc_button_Equal.gridy = 7;
		contentPane.add(button_Equal, gbc_button_Equal);
	}

	/**
	 * set only one calculation in same time.
	 */
	private void setArithmeticOperations(boolean multiplication, boolean division, boolean addition, boolean subtraction) {
		if (multiplication) {
			this.multiplication = true;
			this.division = false;
			this.addition = false;
			this.subtraction = false;
		}
		else if (division) {
			this.multiplication = false;
			this.division = true;
			this.addition = false;
			this.subtraction = false;
		}
		else if (addition) {
			this.multiplication = false;
			this.division = false;
			this.addition = true;
			this.subtraction = false;
		}
		else if (subtraction) {
			this.multiplication = false;
			this.division = false;
			this.addition = false;
			this.subtraction = true;
		}
	}

	/**
	 * get current calculation as string.
	 */
	private String getArithmeticOperations() {
		if (this.multiplication) {
			return "*";
		}
		else if (this.division) {
			return "/";
		}
		else if (this.addition) {
			return "+";
		}
		else if (this.subtraction) {
			return "-";
		}
		else {
			return "?";
		}
	}
	
	protected void keystrokeHandling(int key_ASCII_Code) {
		if (key_ASCII_Code == 49 || key_ASCII_Code == 97) {
			key_1_Press();
		}
		else if (key_ASCII_Code == 50 || key_ASCII_Code == 98) {
			key_2_Press();
		}
		else if (key_ASCII_Code == 51 || key_ASCII_Code == 99) {
			key_3_Press();
		}
		else if (key_ASCII_Code == 52 || key_ASCII_Code == 100) {
			key_4_Press();
		}
		else if (key_ASCII_Code == 53 || key_ASCII_Code == 101) {
			key_5_Press();
		}
		else if (key_ASCII_Code == 54 || key_ASCII_Code == 102) {
			key_6_Press();
		}
		else if (key_ASCII_Code == 55 || key_ASCII_Code == 103) {
			key_7_Press();
		}
		else if (key_ASCII_Code == 56 || key_ASCII_Code == 104) {
			key_8_Press();
		}
		else if (key_ASCII_Code == 57 || key_ASCII_Code == 105) {
			key_9_Press();
		}
		else if (key_ASCII_Code == 48 || key_ASCII_Code == 96) {
			key_0_Press();
		}
		else if (key_ASCII_Code == 8) {
			key_BACKSPASE_Press();
		}
		else if (key_ASCII_Code == 27) {
			key_ESC_Press();
		}
		else if (key_ASCII_Code == 111) {
			key_DIVISION_Press();
		}
		else if (key_ASCII_Code == 106) {
			key_MULTIPLICATION_Press();
		}
		else if (key_ASCII_Code == 109) {
			key_SUBTRACTION_Press();
		}
		else if (key_ASCII_Code == 107) {
			key_ADDITION_Press();
		}
		else if (key_ASCII_Code == 110) {
			key_DOT_Press();
		}
		else if (key_ASCII_Code == 10) {
			key_EQUAL_Press();
		}
		else {
			return;
			//System.out.println(Integer.toString(key_ASCII_Code));
		}
	}
	
	private boolean isNormalLengthVariable(String inString) {
		if (isNegativeNumber(inString)) {
			if (inString.substring(1, inString.length()).length() >= 19) return false;
			return true;
		}
		else {
			if (inString.length() >= 19) return false;
			return true;
		}
	}

	private String setNormalLengthVariable(String inString) {
		if (isNegativeNumber(inString)) {
			return inString.substring(0, 19);
		}
		else {
			return inString.substring(0, 18);
		}
	}
	
	private boolean isNegativeNumber(String inString) {
		if (inString.indexOf("-") == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isDoubleNumber(String inString) {
		if (inString.indexOf(".") < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean isZeroNumber(String inString) {
		if (inString.length() > 0) {
			double temp1 = 0D;
			long temp2 = 0L;
			
			if (isNegativeNumber(inString)) {
				inString = inString.substring(1, inString.length());
			}
			if (isDoubleNumber(inString)) {
				temp1 = Double.parseDouble(inString);
				if (temp1 == 0D) return true;
				return false;
			}
			else {
				try {
    				temp2 = Long.parseLong(inString);
    				if (temp2 == 0L) return true;
    				return false;					
				} catch (Exception e) {
					return false;
				}
			}
		}
		return false;
	}
	
	private void key_1_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {    		
    		if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "1");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "1");
        				}
        				else {
        					label_ActionDisplay.setText("1");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "1");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("1");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_2_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {    		
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "2");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "2");
        				}
        				else {
        					label_ActionDisplay.setText("2");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "2");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("2");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_3_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {    		
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "3");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "3");
        				}
        				else {
        					label_ActionDisplay.setText("3");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "3");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("3");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_4_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {    		
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "4");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "4");
        				}
        				else {
        					label_ActionDisplay.setText("4");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "4");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("4");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_5_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "5");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "5");
        				}
        				else {
        					label_ActionDisplay.setText("5");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "5");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("5");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_6_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "6");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "6");
        				}
        				else {
        					label_ActionDisplay.setText("6");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "6");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("6");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_7_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "7");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "7");
        				}
        				else {
        					label_ActionDisplay.setText("7");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "7");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("7");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_8_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "8");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "8");
        				}
        				else {
        					label_ActionDisplay.setText("8");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "8");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("8");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_9_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "9");
    			}
        		else {
        			if (isZeroNumber(label_ActionDisplay.getText())) {
        				if (isNegativeNumber(label_ActionDisplay.getText())) {
        					label_ActionDisplay.setText("-" + "9");
        				}
        				else {
        					label_ActionDisplay.setText("9");
        				}
        			}
        			else {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "9");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("9");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_0_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
			if (isNormalLengthVariable(label_ActionDisplay.getText())) {
    			if (isDoubleNumber(label_ActionDisplay.getText())) {
        			label_ActionDisplay.setText(label_ActionDisplay.getText() + "0");
    			}
        		else {
        			if (!isZeroNumber(label_ActionDisplay.getText())) {
        				label_ActionDisplay.setText(label_ActionDisplay.getText() + "0");
        			}
        		}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("0");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_BACKSPASE_Press() {
		if (label_ActionDisplay.getText().length() > 1) {
			label_ActionDisplay.setText(label_ActionDisplay.getText().substring(0, label_ActionDisplay.getText().length() - 1));
		}
		else if (label_ActionDisplay.getText().length() == 1) {
			if (!isZeroNumber(label_ActionDisplay.getText())) {
				label_ActionDisplay.setText("0");
			}
		}
		AFTER_COMPUTATION = false;
		AFTER_ARITHMETIC = false;
	}
	
	private void key_ESC_Press() {
		setArithmeticOperations(false, false, false, false);
		label_ActionDisplay.setText("0");
		label_CalculationDisplay.setText("");
		AFTER_COMPUTATION = false;
		AFTER_ARITHMETIC = false;
	}
	
	private void key_DIVISION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (label_CalculationDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(label_ActionDisplay.getText());
    			setArithmeticOperations(false, true, false, false);
    			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, true, false, false);
    			if (! label_CalculationDisplay.getText().substring(label_CalculationDisplay.getText().length() - 1, label_CalculationDisplay.getText().length()).equals(getArithmeticOperations())) {
    				label_CalculationDisplay.setText(label_CalculationDisplay.getText().substring(0, label_CalculationDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(label_ActionDisplay.getText());
			setArithmeticOperations(false, true, false, false);
			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	private void key_MULTIPLICATION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (label_CalculationDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(label_ActionDisplay.getText());
    			setArithmeticOperations(true, false, false, false);
    			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(true, false, false, false);
    			if (! label_CalculationDisplay.getText().substring(label_CalculationDisplay.getText().length() - 1, label_CalculationDisplay.getText().length()).equals(getArithmeticOperations())) {
    				label_CalculationDisplay.setText(label_CalculationDisplay.getText().substring(0, label_CalculationDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(label_ActionDisplay.getText());
			setArithmeticOperations(true, false, false, false);
			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	private void key_SUBTRACTION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (label_CalculationDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(label_ActionDisplay.getText());
    			setArithmeticOperations(false, false, false, true);
    			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, false, false, true);
    			if (! label_CalculationDisplay.getText().substring(label_CalculationDisplay.getText().length() - 1, label_CalculationDisplay.getText().length()).equals(getArithmeticOperations())) {
    				label_CalculationDisplay.setText(label_CalculationDisplay.getText().substring(0, label_CalculationDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(label_ActionDisplay.getText());
			setArithmeticOperations(false, false, false, true);
			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	private void key_ADDITION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (label_CalculationDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(label_ActionDisplay.getText());
    			setArithmeticOperations(false, false, true, false);
    			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, false, true, false);
    			if (! label_CalculationDisplay.getText().substring(label_CalculationDisplay.getText().length() - 1, label_CalculationDisplay.getText().length()).equals(getArithmeticOperations())) {
    				label_CalculationDisplay.setText(label_CalculationDisplay.getText().substring(0, label_CalculationDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(label_ActionDisplay.getText());
			setArithmeticOperations(false, false, true, false);
			label_CalculationDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	private void key_DOT_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		if (label_ActionDisplay.getText().indexOf(".") < 0) {
    			if (label_ActionDisplay.getText().length() > 0) {
    				label_ActionDisplay.setText(label_ActionDisplay.getText() + ".");
    			}
    			else {
    				label_ActionDisplay.setText("0.");
    			}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			label_ActionDisplay.setText("0.");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_EQUAL_Press() {
		if (label_CalculationDisplay.getText().length() > 0) {
			if (getArithmeticOperations().equals("*")) {
				variableOne = variableOne * Double.parseDouble(label_ActionDisplay.getText());
			}
			else if (getArithmeticOperations().equals("/")) {
				variableOne = variableOne / Double.parseDouble(label_ActionDisplay.getText());
			}
			else if (getArithmeticOperations().equals("+")) {
				variableOne = variableOne + Double.parseDouble(label_ActionDisplay.getText());
			}
			else if (getArithmeticOperations().equals("-")) {
				variableOne = variableOne - Double.parseDouble(label_ActionDisplay.getText());
			}
			else return;
			
			if (textJournal.getText().length() > 0) {
				textJournal.setText(textJournal.getText() + System.lineSeparator() + Integer.toString(NEW_STRING++) + ") " + label_CalculationDisplay.getText() + " " + Double.toString(Double.parseDouble(label_ActionDisplay.getText())) + " = " + Double.toString(variableOne));
			}
			else {
				textJournal.setText(Integer.toString(NEW_STRING++) + ") " + label_CalculationDisplay.getText() + " " + Double.toString(Double.parseDouble(label_ActionDisplay.getText())) + " = " + Double.toString(variableOne));
			}
			setArithmeticOperations(false, false, false, false);
			label_CalculationDisplay.setText("");
			label_ActionDisplay.setText(Double.toString(variableOne));
			AFTER_COMPUTATION = true;
			AFTER_ARITHMETIC = false;
		}
	}
	
	private void key_RECIPROCAL_Press() {
		if (!isZeroNumber(label_ActionDisplay.getText())) {
			double a = 1D / Double.parseDouble(label_ActionDisplay.getText());
			if (isNormalLengthVariable(Double.toString(a))) {
				label_ActionDisplay.setText(Double.toString(a));
			}
			else {
				label_ActionDisplay.setText(setNormalLengthVariable(Double.toString(a)));
			}
		}
	}
	
	private void key_PLUS_MINUS_Press() {
		if (label_ActionDisplay.getText().length() > 0) {
			if (isNegativeNumber(label_ActionDisplay.getText())) {
				label_ActionDisplay.setText(label_ActionDisplay.getText().substring(1, label_ActionDisplay.getText().length()));
			}
			else {
				label_ActionDisplay.setText("-" + label_ActionDisplay.getText());
			}
		}
	}
}
