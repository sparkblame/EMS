package Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Service.ImgToPdf;
import Service.DAndQRCode;
import Service.imageControl;
import Service.jxlControl;
import vo.Information;

public class driver {
	public static void main(String[] args) {
		int choose=1;
		boolean flag=false;
		String format=Global.global.FORMAT;
		String fileName =Global.global.FILENAME;
		Scanner scan = new Scanner(System.in);
		ArrayList<Information>list = jxlControl.readFromExcel(fileName);
		while(choose!=0) {
			System.out.println("1.����ͼƬ");
			System.out.println("2.����pdf");
			System.out.println("0.�˳�");
			System.out.println("�������ѡ��");
			choose = scan.nextInt();
			switch(choose) {
			case 1:
				imageControl.control(format, list);
				System.out.println("ͼƬ������ɣ���export�в鿴��ֻ��ǰ�����ǽ��������ֻ��һά��");
				flag=true;
				break;
			case 2:
				if(flag==false) 
					System.out.println("����Ҫ��ִ������1");
				else {
					for(int i=1;i<4;i++) {
						try {
							String imgSrc=Global.global.PICPLACE+Global.global.TAG+String.valueOf(i)+Global.global.FORMAT;
							String pdfSrc = Global.global.PICPLACE+"pdf"+String.valueOf(i)+".pdf";
							ImgToPdf.imgToPdf(imgSrc,pdfSrc);
							System.out.println(pdfSrc.substring(9)+"�������");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
			case 0:
				System.exit(1);
				break;	
			default :
				System.out.println("��������û�����ѡ��");
			}
			System.out.println("");
		}


	}
}
