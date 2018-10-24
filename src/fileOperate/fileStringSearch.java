package fileOperate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fileStringSearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*System.out.println("Source file: ");
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
		do{
			System.out.println("Search file: ");
			BufferedReader scf =  new BufferedReader(new InputStreamReader(System.in));
			searchfilepath = scf.readLine();
			if(searchfilepath == null || searchfilepath== "") {
				System.err.println("end!");
				break;
			}
			File searchfile = new File(searchfilepath);
			if(!searchfile.exists()) {
				System.err.println("file not exit try again.\nSearch file:");
			}
			SearchWord(searchfilepath,sourcefilepath,tempfilepath,destfilepath);
		}while(searchfilepath!=null&&searchfilepath!="");*/
		
		String filepath = "E:\\TXT\\1.txt";//E:\\IMG\\a.jpg	E:\\TXT\\1.txt
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
		}
//		System.out.println(Arrays.toString(b));//得到的是字节
//		System.out.println(new String(b));//可以得到中文
		bi.close();
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

	private static void SearchWord(String searchfilepath, String sourcefilepath, String tempfilepath, String destfilepath) {
		// TODO Auto-generated method stub
		
	}

	private boolean matchString(String filename,String matchword) throws FileNotFoundException {
		
		/*BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
		byte[] b = new byte[bi.available()];
		int b2;
		b2 = bi.read();
		bi.read(b);
		System.out.println(Arrays.toString(b));//得到的是字节
		System.out.println(new String(b));//可以得到中文
		bi.close();
		*/
		/*FileInputStream fi = new FileInputStream(new File(filename));
		byte[] b = fi.read(fi.available());
		Pattern pt = Pattern.compile(matchword);
		Matcher mc = pt.matcher("");*/
		return true;
	}
}
