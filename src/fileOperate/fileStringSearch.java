package fileOperate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fileOperate.xlsFileCreateFromTxtFile;
public class fileStringSearch {

	public static void main(String[] args) throws IOException {
		System.out.println("Source file: ");
		File sfile;
		String sourcefilepath;
		do {
			BufferedReader sf = new BufferedReader(new InputStreamReader(System.in));
			sourcefilepath = sf.readLine();
			sfile = new File(sourcefilepath);
			if(!sfile.exists()) {
				System.err.println("file not exit try again.\nSource file:");
			}
		}while(!sfile.exists());
		String rootpath = sourcefilepath.substring(0,sourcefilepath.lastIndexOf("\\")+1);
		String destfilepath = rootpath+"file.out"; 		//输出文件
		String tempfilepath = rootpath+"file.temp";		//中转文件
		String xlsfilepath = rootpath+"result.xls"; 	//输出XLS文件
		File destfile = new File(destfilepath);
		File tempfile = new File(tempfilepath);
		if(!tempfile.exists()) {tempfile.createNewFile();}
		if(!destfile.exists()) {destfile.createNewFile();}
		String searchfilepath;
		System.out.println("Search file: ");
		searchlab:
		do{
			BufferedReader scf =  new BufferedReader(new InputStreamReader(System.in));
			searchfilepath = scf.readLine();
			if(searchfilepath == null || "".equals(searchfilepath)) {
				System.err.println("end!");
				break searchlab;
			}
			File searchfile = new File(searchfilepath);
			if(!searchfile.exists()) {
				System.err.println("file not exit try again.\nSearch file:");
				continue;
			}else {
				System.err.println("file ok.\nThe next search file:");
			}
			SearchWord(searchfilepath,sourcefilepath,tempfilepath,destfilepath);
		}while(searchfilepath!=null&&searchfilepath!="");
		
		xlsFileCreateFromTxtFile xlsFileCreateFromTxtFile = new xlsFileCreateFromTxtFile();
		System.out.println("result file name,must end with xls or xlsx: ");
		String xlsname;
		BufferedReader xlsbr = new BufferedReader(new InputStreamReader(System.in));
		String xlsnamein = xlsbr.readLine();
		if(searchfilepath == null || "".equals(searchfilepath)) {
			xlsname = xlsfilepath;
		}else {
			xlsname = xlsnamein;
		}
		xlsFileCreateFromTxtFile.generateXlsByTxt(destfilepath, xlsname);
	}

	/**
	 * 
	 * @Description: 文件匹配
	 * @date 2018年10月25日下午6:51:41
	 * @return void
	 * @param searchfilepath 待搜索文件
	 * @param sourcefilepath 搜索源文件
	 * @param tempfilepath	   中间处理文件
	 * @param destfilepath	   处理后文件
	 * @throws IOException
	 */
	private static void SearchWord(String searchfilepath, String sourcefilepath, String tempfilepath, String destfilepath) throws IOException {
		//先从处理后文件中读，如果有内容则在此内容后追加内容写入中间文件，如果没有内容将搜索源文件的内容写入中间文件，待中间文件操作完成后再复制写入处理后文件。
		FileReader sourcefr = new FileReader(sourcefilepath);
		BufferedReader sourcebr = new BufferedReader(sourcefr);
		
		//temp文件的输入流
		FileWriter ftempw = new FileWriter(tempfilepath);
		BufferedWriter btempw = new BufferedWriter(ftempw);
		
		FileReader destfr = new FileReader(destfilepath);
		BufferedReader destbr = new BufferedReader(destfr);
		
		String readname;
		StringBuilder filename = new StringBuilder(((readname = destbr.readLine())==null? sourcefilepath:readname));
		
		filename.append("|"+searchfilepath);
		btempw.write(filename.toString());//写入文件名
		
		String sources;
		String deststr;
		StringBuilder sb;
		while((sources = sourcebr.readLine()) != null) {
			deststr = destbr.readLine();
			if(matchString(searchfilepath, sources)) {
				sb=new StringBuilder(((deststr==null)||"".equals(deststr.trim())?sources:deststr)).append("|1");
			}else {
				sb=new StringBuilder(((deststr==null)||"".equals(deststr.trim())?sources:deststr)).append("|0");
			}
			btempw.write("\n"+sb.toString());
		}
		btempw.close();
		sourcebr.close();
		destbr.close();
		System.out.println("deal over start writing to destfile");
		
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream(tempfilepath));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(destfilepath));
        int ch = 0;
        while ((ch = bufis.read()) != -1) {
            bufos.write(ch);
        }
        bufos.close();
        bufis.close();
	}

	/**
	 * 
	 * @Description: 文件中匹配字符串
	 * @date 2018年10月25日下午6:50:06
	 * @return boolean
	 * @param filename 文件名
	 * @param matchword	待匹配串
	 * @return
	 * @throws IOException
	 */
	private static boolean matchString(String filename,String matchword) throws IOException {
		
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
		byte[] b = new byte[bi.available()];
		
		bi.read(b);
		String ss = new String(b);
		Pattern pt = Pattern.compile(matchword);
		Matcher mc = pt.matcher(ss);
		if(mc.find()) {
			bi.close();
			return true;
		}else {
			bi.close();
			return false;
		}
	}
}
