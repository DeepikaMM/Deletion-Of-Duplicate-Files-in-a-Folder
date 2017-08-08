import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;



public class CompPdf 
{
  public void compdf(ArrayList<File> a) throws IOException
  {
	  for(int i =0;i<a.size();i++)
	  {
		  File b = (File)(a.get(i));
		  for(int j = i+1;j<a.size();j++)
		  {
			  File c = (File)(a.get(j));
			  if(checkEq( c, b)== false)
				  continue;
			  String v = comP(b);
		        //.out.println(c);
		        String u = comP(c);
		        //System.out.println(v+" "+u);
		        if(v.equals(u))
		        {
		        	StringBuilder sb = new StringBuilder();
		        	sb.append(c);
		        	a.remove(j);
		        	j--;
		        	//System.out.println(p);
		        	//System.out.println(a.size());
					File file = new File(sb.toString());
					//file.delete();
					if(file.delete())
				    {
		    			System.out.println(file.getName() + " is deleted!");
		    		}
				 else
				    {
		    			System.out.println("Delete operation is failed.");
		    		}
		        }
		  }
	  }
  }
  private boolean checkEq(File a,File b)
  {
	  String x = convertPDFToText1(b.toString(),"textfrompdf.txt");
	  String x1 = convertPDFToText1(a.toString(),"textfrompdf.txt");
	  if(x.equals(x1))
		  return true;
	  return false;
  }
  private String comP(File b) throws IOException
  {
	   
         String x = convertPDFToText(b.toString(),"textfrompdf.txt");
          return x;
  }
  private String convertPDFToText(String src,String desc)
  {
	  StringBuilder sb = new StringBuilder();
	  try
	  { 
	   
	    PdfReader pr=new PdfReader(src);
	    int pNum=pr.getNumberOfPages();
	    for(int page=1;page<=pNum;page++)
	      {
	       String text=PdfTextExtractor.getTextFromPage(pr, page);
	       sb.append(text);
	     }
	    pr.close();
	    
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return sb.toString();
	 }
	 
  private String convertPDFToText1(String src,String desc)
  {
	  StringBuilder sb = new StringBuilder();
	  try
	  { 
	   
	    PdfReader pr=new PdfReader(src);
	    int pNum=pr.getNumberOfPages();
	       String text=PdfTextExtractor.getTextFromPage(pr, 1);
	       sb.append(text);
	    pr.close();
	    
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return sb.toString();
	 }
}

