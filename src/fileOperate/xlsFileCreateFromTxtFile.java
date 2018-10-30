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
		xlsFileCreateFromTxtFile xlsFileCreateFromTxtFile = new xlsFileCreateFromTxtFile();
		try {
			xlsFileCreateFromTxtFile.generateXlsByTxt("E:\\TXT\\file.temp", "E:\\TXT\\result.xls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description: 生成XLS/XLSX文件
	 * @date 2018年10月30日下午2:33:27
	 * @return void
	 * @param txtfilename 文件中的内容以|作分割符
	 * @param xlsname
	 * @throws IOException
	 */
	public void generateXlsByTxt(String txtfilename,String xlsname) throws IOException {
		@SuppressWarnings("unused")
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
	}
	
	/**
	 * 
	 * @Description: 生成XLS文件
	 * @date 2018年10月30日下午2:14:17
	 * @return boolean
	 * @param f1 TXT文件名
	 * @param f2 XLS文件名
	 * @return
	 * @throws IOException
	 */
	private boolean generatexlsfile(String f1,String f2) throws IOException {
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
	    bf1r.close();
	    wb.close();
		return result;
	}
	
	/**
	 * 
	 * @Description: 生成XLSX文件
	 * @date 2018年10月30日下午2:13:06
	 * @return boolean
	 * @param f1 TXT文件名
	 * @param f2 XLSX文件名
	 * @return
	 * @throws IOException
	 */
	private boolean generatexlsxfile(String f1,String f2) throws IOException {
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
	    bf1r2.close();
	    xwb.close();
		return result;
	}
}
