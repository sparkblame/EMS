package Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class DAndQRCode {

    // 格式
    public static BufferedImage createCode(String qrUrl,int h,int w) {
        MultiFormatWriter multiFormatWriter = null;
        BitMatrix bm = null;
        Map<EncodeHintType, Object> hints = getDecodeHintType();
        BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        try {
            multiFormatWriter = new MultiFormatWriter();
            // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
            bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, w, h, hints);
            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? Global.global.TEXTCOLOR : Global.global.BACKCOLOR);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    private static Map<EncodeHintType, Object> getDecodeHintType() {
        // 用于设置QR二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 设置编码方式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 0);
        hints.put(EncodeHintType.MAX_SIZE, 350);
        hints.put(EncodeHintType.MIN_SIZE, 100);
        return hints;
    }
    /*
     * contents 内容
     * dest 地址
     * width 长度
     * height 高度
     * offset 偏移量
     */
    public static void Dencode(String contents,String dest,int width,int height,int offset){
    	try{
    		contents=new String(contents.getBytes("UTF-8"),"ISO-8859-1");
        	BitMatrix matrix=new MultiFormatWriter().encode(contents,BarcodeFormat.CODE_128,width-offset, height);
        	MatrixToImageWriter.writeToStream(matrix,Global.global.QRFORMAT,new FileOutputStream(new File(dest)));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public static void encode(String contents,String dest,int width,int height){
    	try{
	    	contents=new String(contents.getBytes("UTF-8"),"ISO-8859-1");
	    	QRCodeWriter writer=new QRCodeWriter();
	    	BitMatrix matrix=writer.encode(contents, BarcodeFormat.QR_CODE, width, height);
	    	MatrixToImageWriter.writeToStream(matrix,Global.global.QRFORMAT, new FileOutputStream(new File(dest)));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
