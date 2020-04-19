import java.io.File;
import java.util.Date;

public class DataClassForSortFile implements Comparable<DataClassForSortFile> {
	private String fileName;
	private String fileExtension;
	private int fileOrder;
	private File file;
	private Date fileLastModifyDateOld;
	private Date fileLastModifyDateNew;
		
	public DataClassForSortFile(String a, String b, int c, File pdfFile, Date d) {
		this.fileName = a;
		this.fileExtension = b;
		this.fileOrder = c;
		this.file = pdfFile;
		this.fileLastModifyDateOld = d;
	}
	
	public DataClassForSortFile() {
		this.fileName = "";
		this.fileExtension = "";
		this.fileOrder = 0;
		this.file = new File("");
		this.fileLastModifyDateOld = new Date();
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public int getFileOrder() {
		return fileOrder;
	}
	public void setFileOrder(int fileOrder) {
		this.fileOrder = fileOrder;
	}
	public Date getFileLastModifyDateOld() {
		return fileLastModifyDateOld;
	}
	public void setFileLastModifyDateOld(Long fileLastModifyDateOld) {
		this.fileLastModifyDateOld = new Date(fileLastModifyDateOld);
	}
	public Date getFileLastModifyDateNew() {
		return fileLastModifyDateNew;
	}
	public void setFileLastModifyDateNew(Long fileLastModifyDateNew) {
		this.fileLastModifyDateNew = new Date(fileLastModifyDateNew);
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public int compareTo(DataClassForSortFile o) {
		return Integer.compare(this.getFileOrder(), o.getFileOrder());
	}
	
}
