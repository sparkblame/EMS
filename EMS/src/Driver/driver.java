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
			System.out.println("1.导出图片");
			System.out.println("2.导出pdf");
			System.out.println("0.退出");
			System.out.println("输入你的选择");
			choose = scan.nextInt();
			switch(choose) {
			case 1:
				imageControl.control(format, list);
				System.out.println("图片生成完成，在export中查看，只有前三张是结果，后面只是一维码");
				flag=true;
				break;
			case 2:
				if(flag==false) 
					System.out.println("你需要先执行命令1");
				else {
					for(int i=1;i<4;i++) {
						try {
							String imgSrc=Global.global.PICPLACE+Global.global.TAG+String.valueOf(i)+Global.global.FORMAT;
							String pdfSrc = Global.global.PICPLACE+"pdf"+String.valueOf(i)+".pdf";
							ImgToPdf.imgToPdf(imgSrc,pdfSrc);
							System.out.println(pdfSrc.substring(9)+"导出完成");
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
				System.out.println("输入有误，没有这个选择");
			}
			System.out.println("");
		}


	}
}
