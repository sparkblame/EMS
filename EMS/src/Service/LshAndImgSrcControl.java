package Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LshAndImgSrcControl {

	public static String orderProduct(String orderNumber,String format) {
		String src;
		String head = Global.global.PICPLACE;
		src = head+Global.global.TAG+orderNumber+format;
		return src;
	}
	public static String QRcodeProduct(String orderNumber) {
		String src;
		String head = Global.global.PICPLACE;
		src=head+"物流单号"+orderNumber+"一维码.png";
		return src;
	}
	public static String DcodeProduct(String orderNumber) {
		String src;
		String head = Global.global.PICPLACE;
		src=head+"物流单号"+orderNumber+"一维码.png";
		return src;
		
	}
	public static String lsh (String lsh) {
		Date data = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String time = format.format(data);
		lsh=time+lsh;
		return lsh;
	}
	public String getData(String a) {
		Date date = new Date();
		if (a == "cal") {
			DateFormat format2 = new SimpleDateFormat("yyyyMMdd");
			String time2 = format2.format(date);
			return time2;
		} else if (a == "time") {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			return time;
		} else
			return null;
	}
}
