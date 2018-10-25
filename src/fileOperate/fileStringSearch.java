package fileOperate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fileStringSearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		
		/*String filepath = "E:\\TXT\\1.txt";//E:\\IMG\\a.jpg	E:\\TXT\\1.txt
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filepath));
		byte[] b = new byte[bi.available()];
		
		bi.read(b);
		String ss = new String(b);
		Pattern pt = Pattern.compile("cr_tm");
		Matcher mc = pt.matcher(ss);
		if(mc.find()) {
			System.out.println("find!!");
		}else {
			System.out.println("not find!!");
		}*/
//		System.out.println(Arrays.toString(b));//得到的是字节
//		System.out.println(new String(b));//可以得到中文
//		bi.close();
		/*FileReader fr = new FileReader(new File(sourcefilepath));
		BufferedReader br = new BufferedReader(fr);
		int i=0;
		String bs;
		while( (bs = br.readLine())!=null) {
			++i;
			System.out.println(i+": "+bs);
		}
		br.close();
		fr.close();*/
		
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
		// TODO Auto-generated method stub
		FileReader sourcefr = new FileReader(sourcefilepath);
		BufferedReader sourcebr = new BufferedReader(sourcefr);
		
		FileReader tempfr = new FileReader(tempfilepath);
		BufferedReader tempbr = new BufferedReader(tempfr);//读取第一行文件名
		//temp文件的输入流
		FileWriter ftempw = new FileWriter(tempfilepath);
		BufferedWriter btempw = new BufferedWriter(ftempw);
		
		String readname;
		StringBuilder filename = new StringBuilder(((readname = tempbr.readLine())==null? sourcefilepath:readname));
		tempbr.close();tempfr.close();
		filename.append("|"+searchfilepath);
		btempw.write(filename.toString());//写入文件名
		
		String sources;
		StringBuilder sb;
		while((sources = sourcebr.readLine()) != null) {
			if(matchString(searchfilepath, sources)) {
				sb=new StringBuilder(sources).append("|1");
			}else {
				sb=new StringBuilder(sources).append("|0");
			}
			btempw.write("\n"+sb.toString());
		}
		sourcebr.close();
		sourcefr.close();
		btempw.close();
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
