package com.ph.shopping.common.util.picture;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 * @description
 * @author whl
 * @date 2018-03-23 17:57
 * @version 1.0.0
 */
public class PictureUtils {
	private File file = null; // 文件对象
	private String inputDir; // 输入图路径
	private String outputDir; // 输出图路径
	private String inputFileName; // 输入图文件名
	private String outputFileName; // 输出图文件名
	private int outputWidth ; // 默认输出图片宽
	private int outputHeight ; // 默认输出图片高
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

	public PictureUtils() { // 初始化变量
		inputDir = "";
		outputDir = "";
		inputFileName = "";
		outputFileName = "";
		outputWidth = 290;
		outputHeight = 620;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}

	public void setWidthAndHeight(int width, int height) {
		this.outputWidth = width;
		this.outputHeight = height;
	}

	/**
	 * 获得图片大小 传入参数 String path ：图片路径
	 * @param path
	 * @return
	 */
	public long getPicSize(String path) {
		file = new File(path);
		return file.length();
	}

	/**
	 * @description 图片处理
	 * @author whl
	 * @date 2018-03-23 18:04
	 * @version 1.0.0
	 * @return
	 */
	public String compressPic() {
		FileOutputStream out = null;
		try {
			// 获得源文件
			file = new File(inputDir + inputFileName);
			if (!file.exists()) {
				return null;
			}
			Image img = ImageIO.read(file);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return null;
			}
			
			int newWidth;
			int newHeight;
			
			//原始图片如果没有压缩目标图片大，则不进行压缩
			int oldWidth = img.getWidth(null);
			int oldHeight = img.getHeight(null);
			if(oldWidth <= outputWidth || oldHeight <= outputHeight){
				return "0";
			}
			
			// 判断是否是等比缩放
			if (this.proportion == true) {
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;
				double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 > rate2 ? rate1 : rate2;
				newWidth = (int) (((double) img.getWidth(null)) / rate);
				newHeight = (int) (((double) img.getHeight(null)) / rate);
				
			} else {
				// 输出的图片宽度
				newWidth = outputWidth;
				// 输出的图片高度
				newHeight = outputHeight;
			}
			
			BufferedImage tag = new BufferedImage((int) newWidth,(int) newHeight, BufferedImage.TYPE_INT_RGB);

			/*
			 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
			 */
			tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH), 0, 0, null); //4516毫秒 效果好
			out = new FileOutputStream(outputDir + outputFileName);
			ImageIO.write(tag, "jpg", out);
			out.flush();
			out.close();
			return "0";
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
			
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public File compressPic(File file) {
		try {
			// 获得源文件
			if (!file.exists()) {
				return null;
			}
			BufferedImage img = ImageIO.read(file);
			String formatName = getFormatName(file);

			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return null;
			}

			int newWidth;
			int newHeight;

			//原始图片如果没有压缩目标图片大，则不进行压缩
			int oldWidth = img.getWidth(null);
			int oldHeight = img.getHeight(null);
			if (oldWidth <= outputWidth) {
				return file;
			}

			// 判断是否是等比缩放
			if (this.proportion == true) {
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) oldWidth) / (double) outputWidth;
				newWidth = (int) (((double) oldWidth) / rate1);
				newHeight = (int) (((double) oldHeight) / rate1);

			} else {
				// 输出的图片宽度
				newWidth = outputWidth;
				// 输出的图片高度
				newHeight = outputHeight;
			}

			BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
			String png = "png";
			if (png.equals(formatName)) {
				//将原图放大或缩小后画下来:并且保持png图片放大或缩小后背景色是透明的而不是黑色
				Graphics2D resizedG = tag.createGraphics();
				tag = resizedG.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight, Transparency.TRANSLUCENT);
				resizedG.dispose();
			}
			tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null); //4516毫秒 效果好
			ImageIO.write(tag, formatName, file);
			return file;

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 图片压缩
	 * @param inputDir 文件路径
	 * @param inputFileName 文件名
	 * @param width 宽度
	 * @param height 高度
	 * @return 0：成功  null失败
	 */
	public String compressPic(String inputDir,String inputFileName,int width,int height) {
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = inputDir;
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = inputFileName;
		// 读取配置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = true;
		return compressPic();
	}

	private String getFormatName(Object o) {
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(o);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if(iter!=null && iter.hasNext()){
				ImageReader reader = iter.next();
				//获得图片的类型
				return reader.getFormatName();
			}
		} catch (IOException e) {
			//
		}
		// The image could not be read
		return "jpg";
	}
	/**
	 * @description 图片处理
	 * @author whl
	 * @date 2018-03-23 18:08
	 * @version 1.0.0
	 * @param file		文件
	 * @param width	宽度
	 * @param height	高度
	 * @return
	 */
	public File compressPic(File file,int width,int height) {
		// 读取配置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = true;
		return compressPic(file);
	}

}
