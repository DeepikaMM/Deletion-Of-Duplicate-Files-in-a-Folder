import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;


public class CompImg 
{
	public void compIm(ArrayList<File> a) throws Exception
	{
		//int k=0;
    	for(int i =0;i<a.size()-1;i++)
    	{
		  
			  
			  StringBuilder v = new StringBuilder();
				 v.append(a.get(i));
				 StringBuilder v1 = new StringBuilder();
				 v1.append(a.get(i+1));
				// System.out.println(v.toString());
				//System.out.println(v1.toString());
				/* InputStream is =new FileInputStream(v.toString());
				 byte[] img = IOUtils.toByteArray(is);
				 InputStream is1 =new FileInputStream(v1.toString());
				 byte[] img1 = IOUtils.toByteArray(is1);
				 boolean tatti = Arrays.equals(img, img1);*/
			/*	 if(check(v.toString(),v1.toString())==false){
					// System.out.println(k++);
					 continue;}*/
				// System.out.println(System.getProperty(v.toString()));
				 //System.out.println(v1.toString());
				/* Mat rgba = Highgui.imread(f.getAbsolutePath());
				 Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_RGB2GRAY, 0);
				BufferedImage gray = new BufferedImage(rgba.width(), rgba.height(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] data = ((DataBufferByte) gray.getRaster().getDataBuffer()).getData();
				rgba.get(0, 0, data);
				 Mat rgba1 = Highgui.imread(f1.getAbsolutePath());
				 Imgproc.cvtColor(rgba1, rgba1, Imgproc.COLOR_RGB2GRAY, 0);
				BufferedImage gray1 = new BufferedImage(rgba1.width(), rgba1.height(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] data1 = ((DataBufferByte) gray.getRaster().getDataBuffer()).getData();
				rgba.get(0, 0, data1);
				boolean tatti = Arrays.equals(data,data1);*/
				// BufferedImage imgBuffer = new BufferedImage();
				// Image image = ImageIO.read(new File(v.toString()));
				 //BufferedImage imgBuffer = (BufferedImage) m;
				 //File f = new File(v.toString());
				// File f1 =  new File(v1.toString());
			    BufferedImage imgBuffer = ImageIO.read(new File(v.toString()));
				byte[] pixels = (byte[])imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);
				 /*Image image1 = ImageIO.read(new File(v1.toString()));
				 BufferedImage imgBuffer1 = (BufferedImage) image1;*/
				BufferedImage imgBuffer1 = ImageIO.read(new File(v1.toString()));
				byte[] pixels1 = (byte[])imgBuffer1.getRaster().getDataElements(0, 0, imgBuffer1.getWidth(), imgBuffer1.getHeight(), null);
				/* byte[] img = extractBytes(v.toString());
				 byte[] img1 = extractBytes(v1.toString());*/
				boolean tatti = Arrays.equals(pixels, pixels1);
				//System.out.println(tatti);
				if(tatti == true)
				{
					a.remove(i);
					i--;
					File file = new File(v1.toString());
					//file.delete();
					if(file.delete())
				    {
		    			System.out.println(file.getName() + " is deleted!");
		    		}
				/* else
				    {
		    			System.out.println("Delete operation is failed.");
		    		}*/
				}
				//System.out.println(tatti);
		  
    	}
	}
   private boolean check(String a ,String b) throws Exception
   {
	   System.out.println(a);
	   BufferedImage imgBuffer = ImageIO.read(new File(a));
	   BufferedImage imgBuffer1 = ImageIO.read(new File(b));
	   byte[] pixels1 = (byte[])imgBuffer1.getRaster().getDataElements(0, 0, 3 ,3, null);
	   byte[] pixels = (byte[])imgBuffer.getRaster().getDataElements(0, 0, 3, 3, null);
	   boolean tatti = Arrays.equals(pixels, pixels1);
	   if(tatti==true)
	   return true;
	   return false;
   }
   private byte[] extractBytes (String ImageName) throws IOException, Exception {
	   // open image
	   System.out.println(ImageName);
	    File imgPath = new File(ImageName);
	   BufferedImage bufferedImage = ImageIO.read(new File(getClass().getResource(ImageName).toURI()));

	   // get DataBufferBytes from Raster
	   WritableRaster raster = bufferedImage .getRaster();
	   DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

	   return ( data.getData() );
	  }
}
