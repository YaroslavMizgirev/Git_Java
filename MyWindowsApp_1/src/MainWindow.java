import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shlBulbulator;
	private Text text;
	private Text text_1;
	private double variableOne = 0.0;
	int NEW_STRING = 1;
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
	 * set calculation.
	 */
	private void setArithmeticOperations(boolean multiplication, boolean division, boolean addition, boolean subtraction) {
		if (multiplication) {
			this.multiplication = multiplication;
			this.division = false;
			this.addition = false;
			this.subtraction = false;
		}
		else if (division) {
			this.multiplication = false;
			this.division = division;
			this.addition = false;
			this.subtraction = false;
		}
		else if (addition) {
			this.multiplication = false;
			this.division = false;
			this.addition = addition;
			this.subtraction = false;
		}
		else if (subtraction) {
			this.multiplication = false;
			this.division = false;
			this.addition = false;
			this.subtraction = subtraction;
		}
	}

	/**
	 * get calculation.
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
			return "";
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
		shlBulbulator = new Shell(SWT.CLOSE | SWT.MIN);
		shlBulbulator.setSize(671, 304);
		shlBulbulator.setText("Bulbulator...");
		shlBulbulator.setLayout(new GridLayout(5, false));
		
		Menu menu = new Menu(shlBulbulator, SWT.BAR);
		shlBulbulator.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_2 = new Menu(mntmFile);
		mntmFile.setMenu(menu_2);
		
		MenuItem mntmExit = new MenuItem(menu_2, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String qMsg = "Вы действительно хотите выйти";
				MessageBox mb = new MessageBox(shlBulbulator, SWT.YES | SWT.NO | SWT.CANCEL);
				mb.setMessage(qMsg);
				mb.open();
				/*if (mb.getStyle() == SWT.YES) {
					text_1.setText("Exit");
				}*/
			}
		});
		mntmExit.setText("Exit");
		
		MenuItem mntmHelp_1 = new MenuItem(menu, SWT.CASCADE);
		mntmHelp_1.setText("Help");
		
		Menu menu_1 = new Menu(mntmHelp_1);
		mntmHelp_1.setMenu(menu_1);
		
		MenuItem mntmAbout = new MenuItem(menu_1, SWT.NONE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String infoMsg = "Разработал Мизгирев Ярослав";
				MessageBox mb = new MessageBox(shlBulbulator, SWT.OK | SWT.ICON_INFORMATION);
				mb.setMessage(infoMsg);
				mb.open();
			}
		});
		mntmAbout.setText("About");
		
		Label lblNewLabel = new Label(shlBulbulator, SWT.NONE);
		lblNewLabel.setText("                              ");
		lblNewLabel.setAlignment(SWT.RIGHT);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
		
		text = new Text(shlBulbulator, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.RIGHT | SWT.MULTI);
		GridData gd_text = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 7);
		gd_text.widthHint = 240;
		text.setLayoutData(gd_text);
		
		Menu menu_3 = new Menu(text);
		text.setMenu(menu_3);
		
		MenuItem mntmClearHistory = new MenuItem(menu_3, SWT.NONE);
		mntmClearHistory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NEW_STRING = 1;
				text.setText("");
			}
		});
		mntmClearHistory.setText("Clear history");
		
		text_1 = new Text(shlBulbulator, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		text_1.setText("0");
		
		Button btnXx = new Button(shlBulbulator, SWT.NONE);
		btnXx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (text_1.getText().length() > 1) {
					text_1.setText(text_1.getText().substring(0, text_1.getText().length() - 1));
				}
				else if (text_1.getText().length() == 1) {
					if (! text_1.getText().equals("0")) {
						text_1.setText("0");
					}
				}
			}
		});
		btnXx.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnXx.setText("Backspace");
		
		Button btnx = new Button(shlBulbulator, SWT.NONE);
		btnx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int RESULT_COMPUTATION = 0;
				double a = Double.parseDouble(text_1.getText());
				if (a != 0.0d) {
					if (Double.toString(1 / a).length() > 20) {
						RESULT_COMPUTATION = 20;
					}
					else {
						RESULT_COMPUTATION = Double.toString(1 / a).length();
					}
					text_1.setText(Double.toString(1 / a).substring(0, RESULT_COMPUTATION));
				}
			}
		});
		btnx.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnx.setText("1/x");
		
		Button btnC = new Button(shlBulbulator, SWT.NONE);
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				setArithmeticOperations(false, false, false, false);
				text_1.setText("0");
				lblNewLabel.setText("");
			}
		});
		btnC.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnC.setText("C");
		
		Button button_17 = new Button(shlBulbulator, SWT.NONE);
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text_1.setText("0");
			}
		});
		button_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_17.setText("CE");
		
		Button button_12 = new Button(shlBulbulator, SWT.NONE);
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (lblNewLabel.getText().trim().length() == 0) {
					variableOne = Double.parseDouble(text_1.getText());
					setArithmeticOperations(true, false, false, false);
					lblNewLabel.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
					//text_1.setText(Double.toString(variableOne));
				}
				else {
					setArithmeticOperations(true, false, false, false);
					if (! lblNewLabel.getText().substring(lblNewLabel.getText().length() - 1, lblNewLabel.getText().length()).equals(getArithmeticOperations())) {
						lblNewLabel.setText(lblNewLabel.getText().substring(0, lblNewLabel.getText().length() - 1).trim() + " " + getArithmeticOperations());
					}
					//text_1.setText(Double.toString(variableOne));
				}
			}
		});
		button_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_12.setText("*");
		
		Button button = new Button(shlBulbulator, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "1");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "1");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("1");
        					}
        					else if (min) {
        						text_1.setText("-" + "1");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "1");
				}
			}
		});
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button.setText("1");
		
		Button button_1 = new Button(shlBulbulator, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "2");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "2");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("2");
        					}
        					else if (min) {
        						text_1.setText("-" + "2");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "2");
				}
			}
		});
		button_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_1.setText("2");
		
		Button button_2 = new Button(shlBulbulator, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "3");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "3");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("3");
        					}
        					else if (min) {
        						text_1.setText("-" + "3");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "3");
				}
			}
		});
		button_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_2.setText("3");
		
		Button button_13 = new Button(shlBulbulator, SWT.NONE);
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (lblNewLabel.getText().trim().length() == 0) {
					variableOne = Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, true, false, false);
					lblNewLabel.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
					//text_1.setText(Double.toString(variableOne));
				}
				else {
					//variableOne = variableOne / Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, true, false, false);
					if (! lblNewLabel.getText().substring(lblNewLabel.getText().length() - 1, lblNewLabel.getText().length()).equals(getArithmeticOperations())) {
						lblNewLabel.setText(lblNewLabel.getText().substring(0, lblNewLabel.getText().length() - 1).trim() + " " + getArithmeticOperations());
					}
					//text_1.setText(Double.toString(variableOne));
				}
			}
		});
		button_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_13.setText("/");
		
		Button button_3 = new Button(shlBulbulator, SWT.NONE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "4");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "4");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("4");
        					}
        					else if (min) {
        						text_1.setText("-" + "4");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "4");
				}
			}
		});
		button_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_3.setText("4");
		
		Button button_4 = new Button(shlBulbulator, SWT.NONE);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "5");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "5");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("5");
        					}
        					else if (min) {
        						text_1.setText("-" + "5");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "5");
				}
			}
		});
		button_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_4.setText("5");
		
		Button button_5 = new Button(shlBulbulator, SWT.NONE);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "6");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "6");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("6");
        					}
        					else if (min) {
        						text_1.setText("-" + "6");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "6");
				}
			}
		});
		button_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_5.setText("6");
		
		Button button_16 = new Button(shlBulbulator, SWT.NONE);
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (lblNewLabel.getText().trim().length() == 0) {
					variableOne = Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, false, true, false);
					lblNewLabel.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
					//text_1.setText(Double.toString(variableOne));
				}
				else {
					//variableOne = variableOne + Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, false, true, false);
					if (! lblNewLabel.getText().substring(lblNewLabel.getText().length() - 1, lblNewLabel.getText().length()).equals(getArithmeticOperations())) {
						lblNewLabel.setText(lblNewLabel.getText().substring(0, lblNewLabel.getText().length() - 1).trim() + " " + getArithmeticOperations());
					}
					//text_1.setText(Double.toString(variableOne));
				}
			}
		});
		button_16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_16.setText("+");
		
		Button button_6 = new Button(shlBulbulator, SWT.NONE);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "7");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "7");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("7");
        					}
        					else if (min) {
        						text_1.setText("-" + "7");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "7");
				}
			}
		});
		button_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_6.setText("7");
		
		Button button_7 = new Button(shlBulbulator, SWT.NONE);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (!min) {
        						text_1.setText(Long.toString(Math.abs(a)) + "8");
        					}
        					else if (min) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "8");
        					}
        				}
        				else if (a == 0) {
        					if (!min) {
        						text_1.setText("8");
        					}
        					else if (min) {
        						text_1.setText("-" + "8");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "8");
				}
			}
		});
		button_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_7.setText("8");
		
		Button button_8 = new Button(shlBulbulator, SWT.NONE);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
					if (text_1.getText().length() < 19) {
						long a = Long.parseLong(text_1.getText());
	    				if (a != 0) {
	    					if (!min) {
	    						text_1.setText(Long.toString(Math.abs(a)) + "9");
	    					}
	    					else if (min) {
	    						text_1.setText("-" + Long.toString(Math.abs(a)) + "9");
	    					}
	    				}
	    				else if (a == 0) {
	    					if (!min) {
	    						text_1.setText("9");
	    					}
	    					else if (min) {
	    						text_1.setText("-" + "9");
	    					}
	    				}
					}
				}
				else {
					text_1.setText(text_1.getText() + "9");
				}
			}
		});
		button_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_8.setText("9");
		
		Button button_15 = new Button(shlBulbulator, SWT.NONE);
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (lblNewLabel.getText().trim().length() == 0) {
					variableOne = Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, false, false, true);
					lblNewLabel.setText(Double.toString(variableOne) + " " + getArithmeticOperations());
					//text_1.setText(Double.toString(variableOne));
				}
				else {
					//variableOne = variableOne - Double.parseDouble(text_1.getText());
					setArithmeticOperations(false, false, false, true);
					if (! lblNewLabel.getText().substring(lblNewLabel.getText().length() - 1, lblNewLabel.getText().length()).equals(getArithmeticOperations())) {
						lblNewLabel.setText(lblNewLabel.getText().substring(0, lblNewLabel.getText().length() - 1).trim() + " " + getArithmeticOperations());
					}
					//text_1.setText(Double.toString(variableOne));
				}
			}
		});
		button_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_15.setText("-");
		
		Button button_10 = new Button(shlBulbulator, SWT.NONE);
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (text_1.getText().length() > 0) {
					if (text_1.getText().indexOf("-") == 0) {
						text_1.setText(text_1.getText().substring(1, text_1.getText().length()));
					}
					else {
						text_1.setText("-" + text_1.getText());
					}
				}
			}
		});
		GridData gd_button_10 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button_10.widthHint = 90;
		button_10.setLayoutData(gd_button_10);
		button_10.setText("+/-");
		
		Button button_9 = new Button(shlBulbulator, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean min = false;
				if (text_1.getText().indexOf("-") == 0) {
					min = true;
				}
				
				if (text_1.getText().indexOf(".") < 0) {
    				if (text_1.getText().length() < 19) {
    					long a = Long.parseLong(text_1.getText());
        				if (a != 0) {
        					if (min == false) {
        						text_1.setText(Long.toString(Math.abs(a)) + "0");
        					}
        					else if (min == true) {
        						text_1.setText("-" + Long.toString(Math.abs(a)) + "0");
        					}
        				}
    				}
				}
				else {
					text_1.setText(text_1.getText() + "0");
				}
			}
		});
		GridData gd_button_9 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button_9.widthHint = 90;
		button_9.setLayoutData(gd_button_9);
		button_9.setText(" 0 ");
		
		Button button_11 = new Button(shlBulbulator, SWT.NONE);
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (text_1.getText().indexOf(".") < 0) {
					if (text_1.getText().length() > 0) {
						text_1.setText(text_1.getText() + ".");
					}
					else {
						text_1.setText("0.");
					}
				}
			}
		});
		GridData gd_button_11 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button_11.widthHint = 90;
		button_11.setLayoutData(gd_button_11);
		button_11.setText(".");
		
		Button button_14 = new Button(shlBulbulator, SWT.NONE);
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (lblNewLabel.getText().length() > 0) {
					if (getArithmeticOperations().equals("*")) {
						variableOne = variableOne * Double.parseDouble(text_1.getText());
					}
					else if (getArithmeticOperations().equals("/")) {
						variableOne = variableOne / Double.parseDouble(text_1.getText());
					}
					else if (getArithmeticOperations().equals("+")) {
						variableOne = variableOne + Double.parseDouble(text_1.getText());
					}
					else if (getArithmeticOperations().equals("-")) {
						variableOne = variableOne - Double.parseDouble(text_1.getText());
					}
					else {
						return;
					}
					
					if (text.getText().length() > 0) {
						text.setText(text.getText() + System.lineSeparator() + Integer.toString(NEW_STRING++) + ") " + lblNewLabel.getText() + " " + Double.toString(Double.parseDouble(text_1.getText())) + " = " + Double.toString(variableOne));
					}
					else {
						text.setText(Integer.toString(NEW_STRING++) + ") " + lblNewLabel.getText() + " " + Double.toString(Double.parseDouble(text_1.getText())) + " = " + Double.toString(variableOne));
					}
					setArithmeticOperations(false, false, false, false);
					lblNewLabel.setText("");
					text_1.setText(Double.toString(variableOne));
				}
			}
		});
		GridData gd_button_14 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button_14.widthHint = 90;
		button_14.setLayoutData(gd_button_14);
		button_14.setText("=");
	}
}
