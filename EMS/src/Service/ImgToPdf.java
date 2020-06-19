package Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

public class ImgToPdf {
	public static boolean imgToPdf(String imgFilePath, String pdfFilePath)throws IOException {
		File file=new File(imgFilePath);
		if(file.exists()){
		Document document = new Document();
		FileOutputStream fos = null;
		try {
		fos = new FileOutputStream(pdfFilePath);
		PdfWriter.getInstance(document, fos);

		// 添加PDF文档的某些信息，比如作者，主题等等
		document.addAuthor("学生");
		document.addSubject("pdf制作");
		// 设置文档的大小
		document.setPageSize(PageSize.A4);
		// 打开文档
		document.open();
		// 写入一段文字
		//document.add(new Paragraph("JUST TEST ..."));
		// 读取一个图片
		Image image = Image.getInstance(imgFilePath);
		float imageHeight=image.getScaledHeight();
		float imageWidth=image.getScaledWidth();
		int i=0;
		while(imageHeight>500||imageWidth>500){
		image.scalePercent(100-i);
		i++;
		imageHeight=image.getScaledHeight();
		imageWidth=image.getScaledWidth();
		}

		image.setAlignment(Image.ALIGN_CENTER); 
//		     //设置图片的绝对位置
		// image.setAbsolutePosition(0, 0);
		// image.scaleAbsolute(500, 400);
		// 插入一个图片
		document.add(image);
		} catch (DocumentException de) {
		System.out.println(de.getMessage());
		} catch (IOException ioe) {
		System.out.println(ioe.getMessage());
		}
		document.close();
		fos.flush();
		fos.close();
		return true;
		}else{
		return false;
		}
		}
}
