package fileOperate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsFileCreateFromTxtFile {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xlsFileCreateFromTxtFile xlsFileCreateFromTxtFile = new xlsFileCreateFromTxtFile();
		try {
			xlsFileCreateFromTxtFile.generateXlsByTxt("E:\\TXT\\file.temp", "E:\\TXT\\result.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateXlsByTxt(String txtfilename,String xlsname) throws IOException {
		String rootpath = txtfilename.substring(0,txtfilename.lastIndexOf("\\")+1);
		File txtfile = new File(txtfilename);
		if(!txtfile.exists()) {
			System.err.println("txt file not exist");
			return;
		}
		String filetype = xlsname.substring(xlsname.lastIndexOf(".")+1);
		if("xls".equals(filetype)) {
			generatexlsfile(txtfilename,xlsname);
		}else if("xlsx".equals(filetype)) {
			generatexlsxfile(txtfilename,xlsname);
		}else {
			System.err.println("Excel file name error,end with xls or xlsx");
			return;
		}
//		String xlsfilename = rootpath+"result.xls";
//		String xlsxfilename = rootpath+"result.xlsx";
//		
//		HSSFWorkbook wb = new HSSFWorkbook();
//		HSSFSheet xlssheet = wb.createSheet(xlsfilename);
		
	}
	
	private boolean generatexlsfile(String f1,String f2) throws IOException {
		// TODO Auto-generated method stub
		boolean result = true;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet xlssheet = wb.createSheet();
		
		FileReader f1r = new FileReader(f1);
		BufferedReader bf1r = new BufferedReader(f1r);
		String linedate;
		int i=0;
		while((linedate = bf1r.readLine()) != null) {
			String[] rowdate = linedate.split("\\|");
		 	HSSFRow hsr = xlssheet.createRow(i);
			int j=0;
			while(j<rowdate.length) {
				hsr.createCell(j).setCellValue(rowdate[j]);
				j++;
			}
			i++;
		}
		File  file = new File(f2);
	    //文件输出流
	    FileOutputStream outStream = new FileOutputStream(file);
	    wb.write(outStream);
	    outStream.flush();
	    outStream.close();
		return result;
	}
	
	private boolean generatexlsxfile(String f1,String f2) throws IOException {
		// TODO Auto-generated method stub
		boolean result = true;
		XSSFWorkbook xwb = new XSSFWorkbook();
		XSSFSheet xlsxsheet = xwb.createSheet();
		
		FileReader f1r2 = new FileReader(f1);
		BufferedReader bf1r2 = new BufferedReader(f1r2);
		String linedate2;
		int i=0;
		while((linedate2 = bf1r2.readLine()) != null) {
			String[] rowdate2 = linedate2.split("\\|");
		 	XSSFRow xsr = xlsxsheet.createRow(i);
			int j=0;
			while(j<rowdate2.length) {
				xsr.createCell(j).setCellValue(rowdate2[j]);
				j++;
			}
			i++;
		}
		File  file = new File(f2);
	    //文件输出流
	    FileOutputStream outStream = new FileOutputStream(file);
	    xwb.write(outStream);
	    outStream.flush();
	    outStream.close();
		return result;
	}
}
