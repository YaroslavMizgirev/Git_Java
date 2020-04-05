import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shlBulbulator;
	private Text textJournal;
	private Text textComputation;
	private Label labelActionDisplay;
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
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBulbulator.open();
		shlBulbulator.layout();
		while (!shlBulbulator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBulbulator = new Shell(SWT.CLOSE | SWT.MIN); //окно не изменяет свои размеры
		shlBulbulator.setSize(671, 279);
		shlBulbulator.setText("Bulbulator");
		shlBulbulator.setLayout(new GridLayout(5, false));
		
		labelActionDisplay = new Label(shlBulbulator, SWT.NONE);
		labelActionDisplay.setText("                              ");
		labelActionDisplay.setAlignment(SWT.RIGHT);
		labelActionDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
		labelActionDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});
		
		textJournal = new Text(shlBulbulator, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.RIGHT | SWT.MULTI);
		GridData gd_textJournal = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 7);
		gd_textJournal.widthHint = 240;
		textJournal.setLayoutData(gd_textJournal);
		textJournal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});
		
		/*
		 * Всплывающее меню для журнала вычислений
		 */
		Menu menu_3 = new Menu(textJournal);
		textJournal.setMenu(menu_3);
		
		MenuItem mntmClearHistory = new MenuItem(menu_3, SWT.NONE);
		mntmClearHistory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NEW_STRING = 1;
				textJournal.setText("");
			}
		});
		mntmClearHistory.setText("Clear history");
		
		textComputation = new Text(shlBulbulator, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
		textComputation.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textComputation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		textComputation.setText("0");
		textComputation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonBackspace = new Button(shlBulbulator, SWT.NONE);
		buttonBackspace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonBackspace.setText("Backspace");
		buttonBackspace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_BACKSPASE_Press();
			}
		});
		buttonBackspace.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonReciprocal = new Button(shlBulbulator, SWT.NONE);
		buttonReciprocal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonReciprocal.setText("1/x");
		buttonReciprocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int RESULT_COMPUTATION = 0;
				double a = Double.parseDouble(textComputation.getText());
				if (a != 0.0d) {
					if (Double.toString(1 / a).length() > 20) {
						RESULT_COMPUTATION = 20;
					}
					else {
						RESULT_COMPUTATION = Double.toString(1 / a).length();
					}
					textComputation.setText(Double.toString(1 / a).substring(0, RESULT_COMPUTATION));
				}
			}
		});
		
		Button buttonDropping = new Button(shlBulbulator, SWT.NONE);
		buttonDropping.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		buttonDropping.setText("C");
		buttonDropping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_ESC_Press();
			}
		});
		buttonDropping.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonCE = new Button(shlBulbulator, SWT.NONE);
		buttonCE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				textComputation.setText("0");
			}
		});
		buttonCE.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonCE.setText("CE");
		
		Button buttonMultiplication = new Button(shlBulbulator, SWT.NONE);
		buttonMultiplication.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonMultiplication.setText("*");
		buttonMultiplication.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_MULTIPLICATION_Press();
			}
		});
		buttonMultiplication.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button1 = new Button(shlBulbulator, SWT.NONE);
		button1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button1.setText("1");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_1_Press();
			}
		});
		button1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button2 = new Button(shlBulbulator, SWT.NONE);
		button2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button2.setText("2");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_2_Press();
			}
		});
		button2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});
		
		Button button3 = new Button(shlBulbulator, SWT.NONE);
		button3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button3.setText("3");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_3_Press();
			}
		});
		button3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonDivision = new Button(shlBulbulator, SWT.NONE);
		buttonDivision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonDivision.setText("/");
		buttonDivision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_DIVISION_Press();
			}
		});
		buttonDivision.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button4 = new Button(shlBulbulator, SWT.NONE);
		button4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button4.setText("4");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_4_Press();
			}
		});
		button4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button5 = new Button(shlBulbulator, SWT.NONE);
		button5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button5.setText("5");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_5_Press();
			}
		});
		button5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button6 = new Button(shlBulbulator, SWT.NONE);
		button6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button6.setText("6");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_6_Press();
			}
		});
		button6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonAddition = new Button(shlBulbulator, SWT.NONE);
		buttonAddition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonAddition.setText("+");
		buttonAddition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_ADDITION_Press();
			}
		});
		buttonAddition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button7 = new Button(shlBulbulator, SWT.NONE);
		button7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button7.setText("7");
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_7_Press();
			}
		});
		button7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button8 = new Button(shlBulbulator, SWT.NONE);
		button8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button8.setText("8");
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_8_Press();
			}
		});
		button8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button button9 = new Button(shlBulbulator, SWT.NONE);
		button9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button9.setText("9");
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_9_Press();
			}
		});
		button9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonSubtraction = new Button(shlBulbulator, SWT.NONE);
		buttonSubtraction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		buttonSubtraction.setText("-");
		buttonSubtraction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_SUBTRACTION_Press();
			}
		});
		buttonSubtraction.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonPlusMinus = new Button(shlBulbulator, SWT.NONE);
		GridData gd_buttonPlusMinus = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_buttonPlusMinus.widthHint = 90;
		buttonPlusMinus.setLayoutData(gd_buttonPlusMinus);
		buttonPlusMinus.setText("+/-");
		buttonPlusMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (textComputation.getText().length() > 0) {
					if (textComputation.getText().indexOf("-") == 0) {
						textComputation.setText(textComputation.getText().substring(1, textComputation.getText().length()));
					}
					else {
						textComputation.setText("-" + textComputation.getText());
					}
				}
			}
		});
		
		Button button0 = new Button(shlBulbulator, SWT.NONE);
		GridData gd_button0 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button0.widthHint = 90;
		button0.setLayoutData(gd_button0);
		button0.setText(" 0 ");
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_0_Press();
			}
		});
		button0.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

		Button buttonDot = new Button(shlBulbulator, SWT.NONE);
		GridData gd_buttonDot = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_buttonDot.widthHint = 90;
		buttonDot.setLayoutData(gd_buttonDot);
		buttonDot.setText(".");
		buttonDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_DOT_Press();
			}
		});
		buttonDot.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});
		
		Button buttonEqual = new Button(shlBulbulator, SWT.NONE);
		GridData gd_buttonEqual = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_buttonEqual.widthHint = 90;
		buttonEqual.setLayoutData(gd_buttonEqual);
		buttonEqual.setText("=");
		buttonEqual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				key_EQUAL_Press();
			}
		});
		buttonEqual.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				keystrokeHandling(arg0.keyCode);
			}
		});

	}

	/**
	 * Keystroke Handling of the widgets.
	 * @param key_ASCII_Code
	 */
	protected void keystrokeHandling(int key_ASCII_Code) {
		if (key_ASCII_Code == 49 || key_ASCII_Code == 16777265) {
			key_1_Press();
		}
		else if (key_ASCII_Code == 50 || key_ASCII_Code == 16777266) {
			key_2_Press();
		}
		else if (key_ASCII_Code == 51 || key_ASCII_Code == 16777267) {
			key_3_Press();
		}
		else if (key_ASCII_Code == 52 || key_ASCII_Code == 16777268) {
			key_4_Press();
		}
		else if (key_ASCII_Code == 53 || key_ASCII_Code == 16777269) {
			key_5_Press();
		}
		else if (key_ASCII_Code == 54 || key_ASCII_Code == 16777270) {
			key_6_Press();
		}
		else if (key_ASCII_Code == 55 || key_ASCII_Code == 16777271) {
			key_7_Press();
		}
		else if (key_ASCII_Code == 56 || key_ASCII_Code == 16777272) {
			key_8_Press();
		}
		else if (key_ASCII_Code == 57 || key_ASCII_Code == 16777273) {
			key_9_Press();
		}
		else if (key_ASCII_Code == 48 || key_ASCII_Code == 16777264) {
			key_0_Press();
		}
		else if (key_ASCII_Code == 8) {
			key_BACKSPASE_Press();
		}
		else if (key_ASCII_Code == 27) {
			key_ESC_Press();
		}
		else if (key_ASCII_Code == 16777263) {
			key_DIVISION_Press();
		}
		else if (key_ASCII_Code == 16777258) {
			key_MULTIPLICATION_Press();
		}
		else if (key_ASCII_Code == 16777261) {
			key_SUBTRACTION_Press();
		}
		else if (key_ASCII_Code == 16777259) {
			key_ADDITION_Press();
		}
		else if (key_ASCII_Code == 16777262) {
			key_DOT_Press();
		}
		else if (key_ASCII_Code == 16777296) {
			key_EQUAL_Press();
		}
		else {
			return;
			//System.out.println(Integer.toString(key_ASCII_Code));
		}
	}

	private void key_1_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "1");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "1");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("1");
    					}
    					else if (min) {
    						textComputation.setText("-" + "1");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "1");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("1");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_2_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "2");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "2");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("2");
    					}
    					else if (min) {
    						textComputation.setText("-" + "2");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "2");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("2");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_3_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "3");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "3");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("3");
    					}
    					else if (min) {
    						textComputation.setText("-" + "3");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "3");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("3");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_4_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "4");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "4");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("4");
    					}
    					else if (min) {
    						textComputation.setText("-" + "4");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "4");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("4");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_5_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "5");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "5");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("5");
    					}
    					else if (min) {
    						textComputation.setText("-" + "5");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "5");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("5");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_6_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "6");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "6");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("6");
    					}
    					else if (min) {
    						textComputation.setText("-" + "6");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "6");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("6");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_7_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "7");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "7");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("7");
    					}
    					else if (min) {
    						textComputation.setText("-" + "7");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "7");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("7");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_8_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "8");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "8");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("8");
    					}
    					else if (min) {
    						textComputation.setText("-" + "8");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "8");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("8");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_9_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (!min) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "9");
    					}
    					else if (min) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "9");
    					}
    				}
    				else if (a == 0) {
    					if (!min) {
    						textComputation.setText("9");
    					}
    					else if (min) {
    						textComputation.setText("-" + "9");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "9");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("9");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_0_Press() {
		if (!AFTER_COMPUTATION && !AFTER_ARITHMETIC) {
    		boolean min = false;
    		if (textComputation.getText().indexOf("-") == 0) {
    			min = true;
    		}
    		
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() < 19) {
    				long a = Long.parseLong(textComputation.getText());
    				if (a != 0) {
    					if (min == false) {
    						textComputation.setText(Long.toString(Math.abs(a)) + "0");
    					}
    					else if (min == true) {
    						textComputation.setText("-" + Long.toString(Math.abs(a)) + "0");
    					}
    				}
    			}
    		}
    		else {
    			textComputation.setText(textComputation.getText() + "0");
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("0");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	
	private void key_BACKSPASE_Press() {
		if (textComputation.getText().length() > 1) {
			textComputation.setText(textComputation.getText().substring(0, textComputation.getText().length() - 1));
		}
		else if (textComputation.getText().length() == 1) {
			if (! textComputation.getText().equals("0")) {
				textComputation.setText("0");
			}
		}
		AFTER_COMPUTATION = false;
		AFTER_ARITHMETIC = false;
	}
	
	private void key_ESC_Press() {
		setArithmeticOperations(false, false, false, false);
		textComputation.setText("0");
		labelActionDisplay.setText("");
		AFTER_COMPUTATION = false;
		AFTER_ARITHMETIC = false;
	}
	
	private void key_DIVISION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (labelActionDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(textComputation.getText());
    			setArithmeticOperations(false, true, false, false);
    			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, true, false, false);
    			if (! labelActionDisplay.getText().substring(labelActionDisplay.getText().length() - 1, labelActionDisplay.getText().length()).equals(getArithmeticOperations())) {
    				labelActionDisplay.setText(labelActionDisplay.getText().substring(0, labelActionDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(textComputation.getText());
			setArithmeticOperations(false, true, false, false);
			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	
	private void key_MULTIPLICATION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (labelActionDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(textComputation.getText());
    			setArithmeticOperations(true, false, false, false);
    			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(true, false, false, false);
    			if (! labelActionDisplay.getText().substring(labelActionDisplay.getText().length() - 1, labelActionDisplay.getText().length()).equals(getArithmeticOperations())) {
    				labelActionDisplay.setText(labelActionDisplay.getText().substring(0, labelActionDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(textComputation.getText());
			setArithmeticOperations(true, false, false, false);
			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	
	private void key_SUBTRACTION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (labelActionDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(textComputation.getText());
    			setArithmeticOperations(false, false, false, true);
    			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, false, false, true);
    			if (! labelActionDisplay.getText().substring(labelActionDisplay.getText().length() - 1, labelActionDisplay.getText().length()).equals(getArithmeticOperations())) {
    				labelActionDisplay.setText(labelActionDisplay.getText().substring(0, labelActionDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(textComputation.getText());
			setArithmeticOperations(false, false, false, true);
			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	
	private void key_ADDITION_Press() {
		if (!AFTER_COMPUTATION) {
    		if (labelActionDisplay.getText().trim().length() == 0) {
    			variableOne = Double.parseDouble(textComputation.getText());
    			setArithmeticOperations(false, false, true, false);
    			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
    			AFTER_ARITHMETIC = true;
    		}
    		else {
    			setArithmeticOperations(false, false, true, false);
    			if (! labelActionDisplay.getText().substring(labelActionDisplay.getText().length() - 1, labelActionDisplay.getText().length()).equals(getArithmeticOperations())) {
    				labelActionDisplay.setText(labelActionDisplay.getText().substring(0, labelActionDisplay.getText().length() - 1).trim() + " " + getArithmeticOperations());
    			}
    			AFTER_ARITHMETIC = true;
    		}
		}
		else if (AFTER_COMPUTATION) {
			variableOne = Double.parseDouble(textComputation.getText());
			setArithmeticOperations(false, false, true, false);
			labelActionDisplay.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = true;
		}
		else return;
	}
	
	
	private void key_DOT_Press() {
		if (!AFTER_COMPUTATION || !AFTER_ARITHMETIC) {
    		if (textComputation.getText().indexOf(".") < 0) {
    			if (textComputation.getText().length() > 0) {
    				textComputation.setText(textComputation.getText() + ".");
    			}
    			else {
    				textComputation.setText("0.");
    			}
    		}
		}
		else if (AFTER_COMPUTATION || AFTER_ARITHMETIC) {
			textComputation.setText("0.");
			AFTER_COMPUTATION = false;
			AFTER_ARITHMETIC = false;
		}
		else return;
	}
	

	private void key_EQUAL_Press() {
		if (labelActionDisplay.getText().length() > 0) {
			if (getArithmeticOperations().equals("*")) {
				variableOne = variableOne * Double.parseDouble(textComputation.getText());
			}
			else if (getArithmeticOperations().equals("/")) {
				variableOne = variableOne / Double.parseDouble(textComputation.getText());
			}
			else if (getArithmeticOperations().equals("+")) {
				variableOne = variableOne + Double.parseDouble(textComputation.getText());
			}
			else if (getArithmeticOperations().equals("-")) {
				variableOne = variableOne - Double.parseDouble(textComputation.getText());
			}
			else return;
			
			if (textJournal.getText().length() > 0) {
				textJournal.setText(textJournal.getText() + System.lineSeparator() + Integer.toString(NEW_STRING++) + ") " + labelActionDisplay.getText() + " " + Double.toString(Double.parseDouble(textComputation.getText())) + " = " + Double.toString(variableOne));
			}
			else {
				textJournal.setText(Integer.toString(NEW_STRING++) + ") " + labelActionDisplay.getText() + " " + Double.toString(Double.parseDouble(textComputation.getText())) + " = " + Double.toString(variableOne));
			}
			setArithmeticOperations(false, false, false, false);
			labelActionDisplay.setText("");
			textComputation.setText(Double.toString(variableOne));
			AFTER_COMPUTATION = true;
			AFTER_ARITHMETIC = false;
		}
	}
}
