package fileOperate;

import java.io.File;
import org.apache.poi.*;

public class xlsFileCreateFromTxtFile {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void generateXlsByTxt(String txtfilename) {
		String rootpath = txtfilename.substring(0,txtfilename.lastIndexOf("\\")+1);
		File txtfile = new File(txtfilename);
		if(!txtfile.exists()) {
			System.err.println("txt file not exist");
			return;
		}
		String xlsfilename = rootpath+"result.xls";
		
	}
}
