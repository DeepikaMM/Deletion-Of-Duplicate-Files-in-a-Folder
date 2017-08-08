import java.io.File;
import java.util.ArrayList;

public class SortFile 
{
   public void sorting(String s) throws Exception 
   {
	   ToGetFiles t = new ToGetFiles();
	   ArrayList<File> a1 = t.listf(s);
	   System.out.println(a1.size());//sort on the basi of the size
	   ArrayList<File> toFile = new ArrayList<File>();
	   ArrayList<File> tocss = new ArrayList<File>();
	   ArrayList<File> tomp4 = new ArrayList<File>();
	   ArrayList<File> towav = new ArrayList<File>();
	   ArrayList<File> tocsv = new ArrayList<File>();
	   ArrayList<File> tomp3 = new ArrayList<File>();
	   ArrayList<File> topy = new ArrayList<File>();
	   ArrayList<File> tojava = new ArrayList<File>();
	   ArrayList<File> tohtml = new ArrayList<File>();
	   ArrayList<File> tohtm = new ArrayList<File>();
	   ArrayList<File> toxhtml = new ArrayList<File>();
	   ArrayList<File> torar = new ArrayList<File>();
	   ArrayList<File> todoc = new ArrayList<File>();
	   ArrayList<File> tojs = new ArrayList<File>();
	   ArrayList<File> toImg = new ArrayList<File>();
	   ArrayList<File> toPdf = new ArrayList<File>();
	   ArrayList<File> toRar = new ArrayList<File>();
	   ArrayList<File> toXls = new ArrayList<File>();
	   ArrayList<File> tostr = new ArrayList<File>();
	   //System.out.println(a1.size());
	   for(int i =0;i<=a1.size()-1;i++)
	   {
		   StringBuilder sb = new StringBuilder();
		   sb.append(a1.get(i));
		   String temp = sb.toString();
		  // temp = temp.replaceAll("\\s+", "");
		  // System.out.println(temp);
		   String[] te = temp.split("\\.");
		 //  System.out.println(te.length);
		 //  System.out.println(te[0]);
		  /* for(int j =0;j<=te.length;j++)
		   {
			   
		   }*/
		   
		   temp = te[te.length-1];
		  // System.out.println(temp);
		   switch(temp)
		   {
		     case "pdf":
		    	        toPdf.add(a1.get(i));
		    	        break;
		     case "xls":
		    	        toXls.add(a1.get(i));
	    	            break;
		     case "jpg":
		    	        toImg.add(a1.get(i));
	    	            break;
		     case "png":
		    	        toImg.add(a1.get(i));
	    	            break;
		     case "gif":
	    	           toImg.add(a1.get(i));
 	                   break;
		     case "jpeg":
		    	        toImg.add(a1.get(i));
	    	            break;
		     case "css":
		    	        tocss.add(a1.get(i));
	    	            break;
		     case "txt":
		    	        toFile.add(a1.get(i));
		    	        break;
		     case "mp4":
		    	        tomp4.add(a1.get(i));
		    	        break;
		     case "wav":
		    	        towav.add(a1.get(i));
	    	            break;
		     case "csv":
		    	        tocsv.add(a1.get(i));
	    	            break;
		     case "mp3":
		    	        tomp3.add(a1.get(i));
	    	            break;
		     case "py":
		    	        topy.add(a1.get(i));
	    	            break;
		     case "java":
		    	         tojava.add(a1.get(i));
	    	             break;
		     case "html":
		    	         tohtml.add(a1.get(i));
	    	             break;
		     case "htm":
    	                tohtm.add(a1.get(i));
	                    break;
		     case "xhtml":
    	                 toxhtml.add(a1.get(i));
	                     break;
		     case "js":
		                tojs.add(a1.get(i));
	    	            break;
		     case "str":
		    	        toFile.add(a1.get(i));
	    	            break;
		     case "zip":
		    	        toRar.add(a1.get(i));
		    	        break;
		     case "doc":
		    	        todoc.add(a1.get(i));
		    	        break;
		     case "rar":
	    	            torar.add(a1.get(i));
	    	            break;
		     default:
		    	    break;
	    	 
		   }
	   }
	   if(toFile.size() != 0)
	   {
		  System.out.println(toFile.size());
			 t.compareFile(toFile);
	   }
	   if(tocss.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tocss);
	   }
	   if(tomp4.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tomp4);
	   }
	   if(towav.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(towav);
	   }
	   if(tomp3.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tomp3);
	   }
	   if(tocsv.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tocsv);
	   }
	   if(topy.size() != 0)
	   {
		  System.out.println(toFile.size());
			 t.compareFile(topy);
	   }
	   if(tojava.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tojava);
	   }
	   if(tohtml.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tohtml);
	   }
	   if(tohtm.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tohtm);
	   }
	   if(tojs.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tojs);
	   }
	   if(toxhtml.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(toxhtml);
	   }
	   if(tostr.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(tostr);
	   }
	   if(todoc.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(todoc);
	   }
	   if(torar.size() != 0)
	   {
		   System.out.println(toFile.size());
			 t.compareFile(torar);
	   }
	   if(toImg.size() != 0)
	   {
		 CompImg c = new CompImg();
			c.compIm(toImg);
	   }
	   if(toPdf.size() != 0)
	   {
		 CompPdf  c1 = new CompPdf ();
			c1.compdf(toPdf);
	   }
	   if(toXls.size() != 0)
	   {
			CompXls c2 = new CompXls();
			c2.compXls(toXls);
	   }
	   if(toRar.size() != 0)
	   {
			CompRar c2 = new CompRar();
			c2.compareFile(toRar);
	   }
   }
   
  public boolean Exist(String s)
  {
	  File f = new File(s);
	  if (f.exists()) 
	  {
	       return true;
	  }
	  return false;
  }
}
