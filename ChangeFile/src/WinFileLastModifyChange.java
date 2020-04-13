import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class WinFileLastModifyChange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextArea textArea;
	private JPopupMenu popupMenu;
	private JMenuItem mntmClearJournal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinFileLastModifyChange frame = new WinFileLastModifyChange();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinFileLastModifyChange() {
		createContents();
	}
	
	private void createContents() {
		setTitle("Настроить 'Дату изменения' файлов");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Местоположение файлов:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("...");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            int option = fileChooser.showOpenDialog(null);
	            if(option == JFileChooser.APPROVE_OPTION) {
	               File file = fileChooser.getSelectedFile();
	               textField.setText(file.getAbsolutePath());
	            }
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		/*
		 * Поле календаря для выбора даты и времени изменения файлов
		 */
		//UtilDateModel model = new UtilDateModel();
		//JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		//JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		//datePicker.setFont(new Font("Arial", Font.PLAIN, 20));
		//GridBagConstraints gbc_datePicker = new GridBagConstraints();
		//gbc_datePicker.gridwidth = 2;
		//gbc_datePicker.insets = new Insets(0, 0, 0, 5);
		//gbc_datePicker.fill = GridBagConstraints.BOTH;
		//gbc_datePicker.gridx = 0;
		//gbc_datePicker.gridy = 2;
		//contentPane.add(datePicker, gbc_datePicker);
		//frame.add(datePicker);
		
		btnNewButton_1 = new JButton("Упорядочить по нумерации файлов");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortFiles();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 18));
		
		popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		
		mntmClearJournal = new JMenuItem("Clear journal");
		mntmClearJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		popupMenu.add(mntmClearJournal);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 4;
		//contentPane.add(scroll);
		contentPane.add(scroll, gbc_textArea);
	}

	public static File[] getSpecificFiles(String folder) {
		File dir = new File(folder);
		File[] pdfFiles = dir.listFiles(new PdfFileExtensionFilter());
		return pdfFiles;
	}
	
	public static DataClassForSortFile getVariableDataClassForSortFile(File pdfFile) {
		String a = "", b = "";
		int c = 0;
		Date d;
		DataClassForSortFile dc = new DataClassForSortFile();
		
		if (pdfFile.getName().indexOf("_") >= 0) {
			a = pdfFile.getName().substring(0, pdfFile.getName().length() - 4);
			b = pdfFile.getName().substring(pdfFile.getName().length() - 3, pdfFile.getName().length());
			d = new Date(pdfFile.lastModified());
			for (String zzzTemp: a.split("-")) {
				if (zzzTemp.indexOf("_") >= 0) {
					c = Integer.parseInt(zzzTemp.substring(zzzTemp.length() - 3, zzzTemp.length()));
					break;
				}
			}
			dc.setFileName(a);
			dc.setFileExtension(b);
			dc.setFileOrder(c);
			dc.setFile(pdfFile);
			dc.setFileLastModifyDateOld(d);
		}
		return dc;
	}
	
	public static void changeInListFileLastModifyDate(ArrayList<DataClassForSortFile> fileList1) {
		for (DataClassForSortFile tmp: fileList1) {
			tmp.getFile().setLastModified(tmp.getFileLastModifyDateNew().getTime());
		}
	}
	
	public static String repOneFileListLastModifiedChange(ArrayList<DataClassForSortFile> fileList1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		int i = 1;
		String r = "";
		for (DataClassForSortFile tmp1: fileList1) {
			if (r.length() > 0) {
				r = r + System.lineSeparator() + Integer.toString(i++) + ") " + tmp1.getFile().getName() + " " + sdf.format(new Date(tmp1.getFile().lastModified()))+ ";";
			}
			else {
				r = Integer.toString(i++) + ") " + tmp1.getFile().getName() + " " + sdf.format(new Date(tmp1.getFile().lastModified()))+ ";";
			}
		}
		return r;
	}
	
	public static String repContentFileList(ArrayList<DataClassForSortFile> fileList1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		int i = 1;
		String r = "";
		for (DataClassForSortFile tmp1: fileList1) {
			if (r.length() > 0) {
				r = r + System.lineSeparator() + Integer.toString(i++) + ") " + tmp1.getFile().getName() + " " + sdf.format(tmp1.getFileLastModifyDateOld()) + ";";
			}
			else {
				r = Integer.toString(i++) + ") " + tmp1.getFile().getName() + " " + sdf.format(tmp1.getFileLastModifyDateOld()) + ";";
			}
		}
		return r;
	}

	public void SortFiles() {
		if (textField.getText().length() > 0) {
			File dir = new File(textField.getText());
			if (dir.exists()) {
				File[] pdfFiles = getSpecificFiles(textField.getText());
				ArrayList<DataClassForSortFile> fileList1 = new ArrayList<DataClassForSortFile>();
	    		for (File pdfFile : pdfFiles) {
	    			DataClassForSortFile dc = getVariableDataClassForSortFile(pdfFile);
	    			if (dc.getFileName().length() > 0) {
	    				fileList1.add(dc);
	    			}
	    		}
	    		
				if (!fileList1.isEmpty()) {
					addJournalEntry("File list done: contains " + fileList1.size() + " elements." + System.lineSeparator());
					addJournalEntry(repContentFileList(fileList1));
					Collections.sort(fileList1);
					addJournalEntry(System.lineSeparator());
					addJournalEntry("File list sorted." + System.lineSeparator());
					Calendar cal = Calendar.getInstance();
					for (DataClassForSortFile dc1: fileList1) {
						dc1.setFileLastModifyDateNew(cal.getTime());
						cal.add(Calendar.SECOND, 1);
					}
					changeInListFileLastModifyDate(fileList1);
					addJournalEntry("Table 1. Report for file last modified dates." + System.lineSeparator());
					addJournalEntry("-------------------------------------------------------------------------" + System.lineSeparator());
					addJournalEntry(repOneFileListLastModifiedChange(fileList1));
					addJournalEntry(System.lineSeparator());
					addJournalEntry("-------------------------------------------------------------------------" + System.lineSeparator());
				}
				else {
					JOptionPane.showMessageDialog(null, "File list is empty.\nCopy specific files into work directory for continue.", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Directory does not exist.\nChoose another one.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Choose directory for continue.", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void addJournalEntry(String entryJ) {
		String a = "";
		if (textArea.getText().length() > 0) {
			a = entryJ; 
			textArea.setText(textArea.getText() + a);
		}
		else {
			a = entryJ; 
			textArea.setText(a);
		}
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

/**
 * Examples for JOptionPane.showMessageDialog
 * 
 * JOptionPane.showMessageDialog(null, "Simple Information Message");

 * JOptionPane.showMessageDialog(null, 8.9, "This is not an integer.", JOptionPane.PLAIN_MESSAGE);

 * JOptionPane.showMessageDialog(null, "Uh-oh!", "Error", JOptionPane.ERROR_MESSAGE);

 * JOptionPane.showMessageDialog(null, "I like turtles.", "Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);

 * ImageIcon icon = new ImageIcon("src/images/turtle64.png");
 * JPanel panel = new JPanel();
 * panel.setBackground(new Color(102, 205, 170));
 * panel.setSize(new Dimension(200, 64));
 * panel.setLayout(null);
 * JLabel label = new JLabel("Turtles are awesome!!! :D");
 * label.setBounds(0, 0, 200, 64);
 * label.setFont(new Font("Arial", Font.BOLD, 11));
 * label.setHorizontalAlignment(SwingConstants.CENTER);
 * panel.add(label);
 * UIManager.put("OptionPane.minimumSize",new Dimension(300, 120));        
 * JOptionPane.showMessageDialog(null, panel, "Customized Message Dialog", JOptionPane.PLAIN_MESSAGE, icon);
 */

/**
 * Describe parameters for JOptionPane.showMessageDialog
 * 
 * Component – The first parameter is a component which determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used.
 * Object – The second parameter can be any objects. (In some older versions of Java you might get a compiler error when using primitive types directly).
 * String – The third parameter is a String placed as the title of the message dialog window.
 * int – The int that follows the String is the MessageType. The different MessageTypes for JOptionPane, are:
 *		ERROR_MESSAGE
 *		INFORMATION_MESSAGE
 * 		WARNING_MESSAGE
 * 		QUESTION_MESSAGE
 * 		PLAIN_MESSAGE
 * Icon – The last parameter is an Icon that is displayed inside the dialog and overrides the default MessageType icon.
 */
