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
	 * @Description: 将base64编码字符串转换为图片
	 * @Author: dx
	 * @CreateTime: 20180705
	 * @param imgStr base64编码字符串
	 * @param path 图片路径-具体到文件
	 * @return
	*/
	public   boolean String2Img(String imgStr, String path) {
		if (imgStr == null)
			return false;
//		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// 解密
//			byte[] b = decoder.decodeBuffer(imgStr);
			byte[] b = Base64.getDecoder().decode(imgStr);
			// 处理数据
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
	 * @Description: 根据图片地址转换为base64编码字符串
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
	    // 加密
	    return Base64.getEncoder().encodeToString(data);
//	    BASE64Encoder encoder = new BASE64Encoder();
//	    return encoder.encode(data);
	}
}
