package PicDeal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
 
public class ZipPic {
 
	/**
	 * ��ͼƬѹ����ָ����С����
	 * 
	 * @param srcImgData ԴͼƬ����
	 * @param maxSize Ŀ��ͼƬ��С
	 * @return ѹ�����ͼƬ����
	 */
	public static byte[] compressUnderSize(byte[] srcImgData, long maxSize) {
		double scale = 0.9;
		byte[] imgData = Arrays.copyOf(srcImgData, srcImgData.length);
 
		if (imgData.length > maxSize) {
			do {
				try {
					imgData = compress(imgData, scale);
 
				} catch (IOException e) {
					throw new IllegalStateException("ѹ��ͼƬ�����г����뼰ʱ��ϵ����Ա��", e);
				}
 
			} while (imgData.length > maxSize);
		}
 
		return imgData;
	}
 
	/**
	 * ���� ��� ����ѹ��
	 * 
	 * @param imgIs ��ѹ��ͼƬ������
	 * @param scale ѹ���̶�
	 * @param out ���
	 * @return ѹ����ͼƬ����
	 * @throws IOException ѹ��ͼƬ�����г���
	 */
	public static byte[] compress(byte[] srcImgData, double scale) throws IOException {
		BufferedImage bi = ImageIO.read(new ByteArrayInputStream(srcImgData));
		int width = (int) (bi.getWidth() * scale); // Դͼ���
		int height = (int) (bi.getHeight() * scale); // Դͼ�߶�
 
		Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
 
		Graphics g = tag.getGraphics();
		g.setColor(Color.RED);
		g.drawImage(image, 0, 0, null); // ���ƴ�����ͼ
		g.dispose();
 
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		ImageIO.write(tag, "JPEG", bOut);
 
		return bOut.toByteArray();
	}
 
	public static void main(String[] args) throws IOException {
		byte[] data = compressUnderSize(readInByteArray(new File("C:\\Users\\23008\\Desktop\\image\\5.jpg")), 100 * 300);	
		if(data.length < 100 * 300) {
			System.out.println("data:"+data);
		}
		FileUtils.writeByteArrayToFile(new File("C:\\\\Users\\\\23008\\\\Desktop\\\\image\\\\5zip.jpg"), data);
	}

	private static byte[] readInByteArray(File file) {
		try {
			return IOUtils.toByteArray(new FileInputStream(file));
		} catch (IOException e) {
			throw new IllegalStateException("��ȡ��ѹ��ͼƬ�����г����뼰ʱ��ϵ����Ա��", e);
		}
	}
}