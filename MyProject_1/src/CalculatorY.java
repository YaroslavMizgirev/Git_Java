import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.*;


public class CalculatorY extends JFrame {
	private static final long serialVersionUID = 4445181872615373336L;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19,
		b20, b21, b22, b23, b24;
	JLabel l1, l2;
	long i = 0, k = 0;
	double m = 0.0, n = 0.0;
	String a = "", b = "";
	EHandler handler = new EHandler();
	
	public CalculatorY(String s) {
		super(s);
		
		//Вспомогательная панель
		Container grid = getContentPane();
		grid.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		grid.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		//По умолчанию
		// установить изменение размера поля, если его заполнение больше размера поля
		// по умолчанию = по горизонтали (максимальная ширина)
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		// установить изменение размера поля, если его размер меньше размера поля
		// по умолчанию = в конец окна
		//constraints.anchor = GridBagConstraints.PAGE_END;
		// установить дополнительное пространство между полями по оси X
		constraints.weightx = 0.5;
		// установить дополнительное пространство между полями по оси Y
		constraints.weighty = 0.0;
		
		//Поле ввода
		l1 = new JLabel(a);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);
		constraints.ipady      = 40;	// установить размер поля = выше, чем по умолчанию
        constraints.gridwidth  = 4;		// размер поля в четыре ячейки таблицы
        constraints.gridheight = 1;		// размер поля в одну ячейку таблицы
		constraints.gridy      = 0;		// нулевая ячейка таблицы по вертикали
		constraints.gridx      = 0;		// нулевая ячейка таблицы по горизонтали
        grid.add(l1, constraints);
        
        //Отображаемый результат
        l2 = new JLabel(b);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.CENTER);
        constraints.ipady      = 40;	// установить размер поля = выше, чем по умолчанию
		constraints.gridy      = 1;		// первая ячейка таблицы по вертикали
        grid.add(l2, constraints);
        
		//Первый ряд кнопок
		b1 = new JButton("%");
        constraints.ipady      = 0;		// установить размер поля = по умолчанию
		constraints.gridwidth  = 1;		// размер поля по умолчанию
        constraints.gridy      = 2;		// вторая ячейка таблицы по вертикали
		grid.add(b1, constraints);
		b1.addActionListener(handler);
		
		b2 = new JButton("x!");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b2, constraints);
		b2.addActionListener(handler);
		
		b3 = new JButton("C");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b3, constraints);
		b3.addActionListener(handler);
		
		b4 = new JButton("◄");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b4, constraints);
		b4.addActionListener(handler);
		
		//Второй ряд кнопок
		b5 = new JButton("1/x");
		constraints.gridy      = 3;    // третья ячейка таблицы по вертикали
        constraints.gridx      = 0;    // нулевая ячейка таблицы по горизонтали
		grid.add(b5, constraints);
		b5.addActionListener(handler);
		
		b6 = new JButton("x*x");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b6, constraints);
		b6.addActionListener(handler);
		
		b7 = new JButton("√x");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b7, constraints);
		b7.addActionListener(handler);
		
		b8 = new JButton("/");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b8, constraints);
		b8.addActionListener(handler);
		
		//Третий ряд кнопок
		b9 = new JButton("7");
		constraints.gridy      = 4;    // четвертая ячейка таблицы по вертикали
        constraints.gridx      = 0;    // нулевая ячейка таблицы по горизонтали
		grid.add(b9, constraints);
		b9.addActionListener(handler);
		
		b10 = new JButton("8");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b10, constraints);
		b10.addActionListener(handler);
		
		b11 = new JButton("9");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b11, constraints);
		b11.addActionListener(handler);
		
		b12 = new JButton("*");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b12, constraints);
		b12.addActionListener(handler);
		
		//Четвертый ряд кнопок
		b13 = new JButton("4");
		constraints.gridy      = 5;    // пятая ячейка таблицы по вертикали
        constraints.gridx      = 0;    // нулевая ячейка таблицы по горизонтали
		grid.add(b13, constraints);
		b13.addActionListener(handler);
		
		b14 = new JButton("5");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b14, constraints);
		b14.addActionListener(handler);
		
		b15 = new JButton("6");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b15, constraints);
		b15.addActionListener(handler);

		b16 = new JButton("-");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b16, constraints);
		b16.addActionListener(handler);
		
		//Пятый ряд кнопок
		b17 = new JButton("1");
		constraints.gridy      = 6;    // шестая ячейка таблицы по вертикали
        constraints.gridx      = 0;    // нулевая ячейка таблицы по горизонтали
		grid.add(b17, constraints);
		b17.addActionListener(handler);
		
		b18 = new JButton("2");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b18, constraints);
		b18.addActionListener(handler);
		
		b19 = new JButton("3");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b19, constraints);
		b19.addActionListener(handler);
		
		b20 = new JButton("+");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b20, constraints);
		b20.addActionListener(handler);
		
		//Шестой ряд кнопок
		b21 = new JButton("±");
		constraints.gridy      = 7;    // седьмая ячейка таблицы по вертикали
        constraints.gridx      = 0;    // нулевая ячейка таблицы по горизонтали
		grid.add(b21, constraints);
		b21.addActionListener(handler);
		
		b22 = new JButton("0");
		constraints.gridx      = 1;		// первая ячейка таблицы по горизонтали
		grid.add(b22, constraints);
		b22.addActionListener(handler);
		
		b23 = new JButton(".");
		constraints.gridx      = 2;    // вторая ячейка таблицы по горизонтали
		grid.add(b23, constraints);
		b23.addActionListener(handler);
		
		b24 = new JButton("=");
		constraints.gridx      = 3;    // третья ячейка таблицы по горизонтали
		grid.add(b24, constraints);
		b24.addActionListener(handler);
	}
	
	public class EHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				
			}
			if (e.getSource() == b2) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						if (i < 0) {
							JOptionPane.showMessageDialog(null, "Факториал считается только для положительных целых чисел");
							return;
						}
						BigInteger result = BigInteger.ONE;
						for (BigInteger j = BigInteger.ONE; j.compareTo(BigInteger.valueOf(i)) <= 0; j = j.add(BigInteger.ONE)) {
							result = result.multiply(j);
						}
						//l1.setText("" + String.format("%, d", result));
						l1.setText("" + result);
					}
					else {
						JOptionPane.showMessageDialog(null, "Факториал считается только для целых чисел");
					}
				}
			}
			if (e.getSource() == b3) {
				l1.setText(a);
				l2.setText(b);
			}
			if (e.getSource() == b4) {
				if (l1.getText().length() > 0) {
					l1.setText(l1.getText().substring(0, l1.getText().length() - 1));
				}
			}
			if (e.getSource() == b5) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						m = 1 / i;
						l1.setText("" + m);
					}
					else {
						m = Double.parseDouble(l1.getText());
						m = 1 / m;
						l1.setText("" + m);
					}
				}
			}
			if (e.getSource() == b6) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						i = i * i;
						l1.setText("" + i);
					}
					else {
						m = Double.parseDouble(l1.getText());
						m = m * m;
						l1.setText("" + m);
					}
				}
			}
			if (e.getSource() == b7) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						m = Long.parseLong(l1.getText());
						l1.setText("" + Math.sqrt(m));
					}
					else {
						m = Double.parseDouble(l1.getText());
						l1.setText("" + Math.sqrt(m));
					}
				}
			}
			if (e.getSource() == b8) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						l2.setText(l2.getText() + i + "/");
						l1.setText("");
					}
					else {
						m = Double.parseDouble(l1.getText());
						l2.setText(l2.getText() + m + "/");
						l1.setText("");
					}
				}
			}
			if (e.getSource() == b9) {
				l1.setText(l1.getText() + 7);
			}
			if (e.getSource() == b10) {
				l1.setText(l1.getText() + 8);
			}
			if (e.getSource() == b11) {
				l1.setText(l1.getText() + 9);
			}
			if (e.getSource() == b12) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						l2.setText(l2.getText() + i + "*");
						l1.setText("");
					}
					else {
						m = Double.parseDouble(l1.getText());
						l2.setText(l2.getText() + m + "*");
						l1.setText("");
					}
				}
			}
			if (e.getSource() == b13) {
				l1.setText(l1.getText() + 4);
			}
			if (e.getSource() == b14) {
				l1.setText(l1.getText() + 5);
			}
			if (e.getSource() == b15) {
				l1.setText(l1.getText() + 6);
			}
			if (e.getSource() == b16) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						l2.setText(l2.getText() + i + "-");
						l1.setText("");
					}
					else {
						m = Double.parseDouble(l1.getText());
						l2.setText(l2.getText() + m + "-");
						l1.setText("");
					}
				}
			}
			if (e.getSource() == b17) {
				l1.setText(l1.getText() + 1);
			}
			if (e.getSource() == b18) {
				l1.setText(l1.getText() + 2);
			}
			if (e.getSource() == b19) {
				l1.setText(l1.getText() + 3);
			}
			if (e.getSource() == b20) {
				if (l1.getText().length() > 0) {
					if (l1.getText().indexOf(".") < 0) {
						i = Long.parseLong(l1.getText());
						l2.setText(l2.getText() + i + "+");
						l1.setText("");
					}
					else {
						m = Double.parseDouble(l1.getText());
						l2.setText(l2.getText() + m + "+");
						l1.setText("");
					}
				}
			}
			if (e.getSource() == b21) {
				if (l1.getText().indexOf("-") == 0) {
					l1.setText(l1.getText().substring(1, l1.getText().length()));
				}
				else {
					l1.setText("-" + l1.getText());
				}
			}
			if (e.getSource() == b22) {
				l1.setText(l1.getText() + 0);
			}
			if (e.getSource() == b23) {
				if (l1.getText().indexOf(".") < 0) {
					if (l1.getText().length() > 0) {
						l1.setText(l1.getText() + ".");
					}
					else {
						l1.setText(l1.getText() + "0.");
					}
				}
			}
			if (e.getSource() == b24) {
				
			}
		}
	}
		
	public static void main(String[] args) {
		CalculatorY calcY = new CalculatorY("Бульбулятор");
		calcY.pack();
		calcY.setVisible(true);
		calcY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcY.setSize(400, 320);
		calcY.setResizable(false);
		calcY.setLocationRelativeTo(null);
	}

}
