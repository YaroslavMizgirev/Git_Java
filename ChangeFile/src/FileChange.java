import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FileChange {

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
			dc.setFileLastModifyDate(d);
		}
		return dc;
	}
	
	public static Calendar getNowCalendar() {
		Calendar cal = Calendar.getInstance();
		return cal;
	}
	
	public static void repOneFileListLastModifiedChange(ArrayList<DataClassForSortFile> fileList1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		if (!fileList1.isEmpty()) {
			int i = 1;
			for (DataClassForSortFile tmp1: fileList1) {
				System.out.println(tmp1.getFile().getName() + " " + sdf.format(new Date(tmp1.getFile().lastModified()))+ " " + (i++) + " |");
			}
		}
	}

	public static void repOneFileListLastModifiedChange(List<DataClassForSortFile> fileList1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		if (!fileList1.isEmpty()) {
			int i = 1;
			for (DataClassForSortFile tmp1: fileList1) {
				System.out.println(tmp1.getFileName() + " " + sdf.format(new Date(tmp1.getFile().lastModified()))+ " " + (i++) + " |");
			}
		}
	}

	public static void changeInListFileLastModifyDate(ArrayList<DataClassForSortFile> fileList1) {
		for (DataClassForSortFile tmp: fileList1) {
			tmp.getFile().setLastModified(tmp.getFileLastModifyDate().getTime());
		}
	}
	
	public static void repTwoFileListLastModifiedChange(ArrayList<DataClassForSortFile> fl1, ArrayList<DataClassForSortFile> fl2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy hh:mm:ss");
		int i = 0;
		if (!fl1.isEmpty()) {
			for (DataClassForSortFile tmp1: fl1) {
				System.out.print(tmp1.getFileName() + " " + sdf.format(new Date(tmp1.getFile().lastModified())) + " " + (++i));
				System.out.print(" | ");
				if (!fl2.isEmpty()) {
					for (DataClassForSortFile tmp2: fl2) {
						if (tmp1.getFileName().equals(tmp2.getFileName())) {
							System.out.print(tmp2.getFileName() + " " + sdf.format(new Date(tmp2.getFile().lastModified())) + " " + i);
							break;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String folder1 = "C:/test";
		File dir = new File(folder1);
		if (dir.exists()) {
			File[] pdfFiles = getSpecificFiles(folder1);
			ArrayList<DataClassForSortFile> fileList1 = new ArrayList<>();
    		for (File pdfFile : pdfFiles) {
    			DataClassForSortFile dc = getVariableDataClassForSortFile(pdfFile);
    			if (dc.getFileName().length() > 0) {
    				fileList1.add(dc);
    			}
    		}
    		
			if (!fileList1.isEmpty()) {
				System.out.println("File list done.");
				Collections.sort(fileList1);
				System.out.println("File list sorted.");
				System.out.println();
								
				Calendar cal = getNowCalendar();
				for (DataClassForSortFile dc1: fileList1) {
					dc1.setFileLastModifyDate(cal.getTime());
					cal.add(Calendar.SECOND, 1);
				}
				System.out.println("File last modified date change is done.");
				System.out.println();
				
				System.out.println("Table 1. Report for file last modified dates.");
				System.out.println("----------------------------------------------------------------");
				changeInListFileLastModifyDate(fileList1);
				repOneFileListLastModifiedChange(fileList1);
				System.out.println("----------------------------------------------------------------");
			}
			else {
				System.out.println("File list is empty.");
				System.out.println("Copy specific files into work directory for continue.");
				System.out.println();
				return;
			}
		}
		else {
			if (dir.mkdir()) {
				System.out.println("Program success make directory: " + folder1 + ".");
				System.out.println("Now copy specific files into new directory for continue.");
				System.out.println();
				return;
			}
			else {
				System.out.println("Error 1");
				System.out.println();
				return;
			}
		}
	}
}
