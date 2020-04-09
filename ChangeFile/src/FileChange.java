import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class FileChange {

	public static void main(String[] args) {
		File dir = new File("C:/test");
		File[] pdfFiles = dir.listFiles(new PdfFileExtensionFilter());
		
		ArrayList<DataClassForSortFile> fileList = new ArrayList<>();
		String a = "", b = "";
		int c = 0;
		Date d;
		
		for (File pdfFile : pdfFiles) {
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
            	DataClassForSortFile dc = new DataClassForSortFile(a, b, c, pdfFile, d);
            	fileList.add(dc);
            }
		}

		Collections.sort(fileList);
		
		Calendar cal = Calendar.getInstance();
		for (DataClassForSortFile dc: fileList) {
			dc.getFile().setLastModified(cal.getTimeInMillis());
			cal.add(Calendar.SECOND, 1);
		}
		
		for (File pdfFile : pdfFiles) {
			for (DataClassForSortFile dc: fileList) {
				if (pdfFile.equals(dc.getFile())) {
					pdfFile.setLastModified(dc.getFileLastModifyDate().getTime());
					break;
				}
			}
		}
	}
}
