package PicDeal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.net.NetworkInterface;
import java.util.Base64;

import interFace.picDeal;
//import sun.misc.BASE64Encoder;
//import sun.misc.BASE64Decoder;


public class Base64ToPic implements picDeal {

	public static void main(String[] args) {
		String imgFile = "E:\\IMG\\a.jpg";
		String path = "E:\\IMG\\test.jpg";
		Base64ToPic p = new Base64ToPic();
		String ImgString = p.Img2String(imgFile);
		System.out.print(ImgString);
		if(p.String2Img(ImgString, path)) {
			System.out.print("\nIMG: "+path+" creat success!");
		}else {
			System.out.print("creat false!");
		}
	}
	
	/**
	 * @Description: ��base64�����ַ���ת��ΪͼƬ
	 * @Author: dx
	 * @CreateTime: 20180705
	 * @param imgStr base64�����ַ���
	 * @param path ͼƬ·��-���嵽�ļ�
	 * @return
	*/
	public   boolean String2Img(String imgStr, String path) {
		if (imgStr == null)
			return false;
//		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// ����
//			byte[] b = decoder.decodeBuffer(imgStr);
			byte[] b = Base64.getDecoder().decode(imgStr);
			// ��������
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @Description: ����ͼƬ��ַת��Ϊbase64�����ַ���
	 * @Author: dx
	 * @CreateTime: 20180705
	 * @return
	 */
	public  String Img2String(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // ����
	    return Base64.getEncoder().encodeToString(data);
//	    BASE64Encoder encoder = new BASE64Encoder();
//	    return encoder.encode(data);
	}
}
