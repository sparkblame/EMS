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

		// ���PDF�ĵ���ĳЩ��Ϣ���������ߣ�����ȵ�
		document.addAuthor("ѧ��");
		document.addSubject("pdf����");
		// �����ĵ��Ĵ�С
		document.setPageSize(PageSize.A4);
		// ���ĵ�
		document.open();
		// д��һ������
		//document.add(new Paragraph("JUST TEST ..."));
		// ��ȡһ��ͼƬ
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
//		     //����ͼƬ�ľ���λ��
		// image.setAbsolutePosition(0, 0);
		// image.scaleAbsolute(500, 400);
		// ����һ��ͼƬ
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
