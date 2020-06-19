package Service;

import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import vo.Information;

public class jxlControl {
	public static ArrayList<Information> readFromExcel(String fileName){
		ArrayList<Information> list =new ArrayList<Information>();
		try {
		File file = new File(fileName);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		String array[]=new String [15];
		for(int row = 1; row < sheet.getRows(); row++) {
			for(int col = 0; col < sheet.getColumns();col++) {
				Cell cell = sheet.getCell(col,row);
				array[col]=cell.getContents();
			}
			double pureWeight=Double.parseDouble(array[2]);
			double number = Double.parseDouble(array[4]);
			Information info;
			if(array[0].equals("")) {
				String mainGoods=array[5];
				info = new Information(pureWeight,number,array[5]);
			}
			else {
				double roughWeight=Double.parseDouble(array[3]);
				info =new Information(array[0],array[1],pureWeight,
					roughWeight,number,array[5],array[6],array[7],
					array[8],array[9],array[10],array[11],array[12],
					array[13],array[14]);
			}
			list.add(info);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
