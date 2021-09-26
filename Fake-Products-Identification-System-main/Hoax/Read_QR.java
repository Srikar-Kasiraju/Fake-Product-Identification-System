package hoax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



public class Read_QR{
	static String path;
	static String result;
	
	public static <BufferedImage> void main(String[] args)
	{}
}
class bar{
	//path of the image
	String path;
	bar(String path){
		this.path=path;
	}
	@SuppressWarnings("unchecked")
	public <BufferedImage> String barcode(){
		String barcode="";
		
try {

			
			BufferedImage bf = (BufferedImage) ImageIO.read(new FileInputStream(path));
			
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource((java.awt.image.BufferedImage) bf)));
			
			Result result = new MultiFormatOneDReader(null).decode(bitmap);
			
			System.out.println(result.getText());
			barcode=result.getText();
			
			
		} catch(Exception e) {
			System.out.println("Error while reading barcode " + e.getMessage());
		}
		
		
		
		return barcode;
	}
}

