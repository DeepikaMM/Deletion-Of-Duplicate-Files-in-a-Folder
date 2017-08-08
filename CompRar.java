import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



public class CompRar 
{
	
	 public void compareFile(ArrayList<File> a)
	 {
		 try
		 {
			 System.out.println(a.size());
		   for(int i =0;i<a.size();i++)
		   {   
			   File b = (File)a.get(i);
		      for(int j = i+1;j<a.size();j++)
		      {
		    	  File c = (File)a.get(j);
			    if(checkZip(b,c)==false)
			    	continue;
			    String t = comp_Rar(b);
		        String t1 = comp_Rar(c);
		        if(t.equals(t1))
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
		    			System.out.println(file.getName()+"Delete operation is failed.");
		    		}
		        }
		       /* else
		        {
		        	System.out.println("not deleted");
		        }*/
		        
		      }
		   }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	
		public String compz(File a) throws IOException
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(
			        new GZIPInputStream(new FileInputStream(a))));
			String content = null;
            StringBuilder sb = new StringBuilder();
			while ((content = in.readLine()) != null)
			{
				sb.append(content);
			}
			return sb.toString();
		}
	   public String comp(File a) throws IOException
	   {  
		   StringBuilder sb = new StringBuilder();
		   JarFile jf=new JarFile(a);
		   Enumeration<JarEntry> e=jf.entries();
		   while(e.hasMoreElements())
		   {
		     JarEntry je=(JarEntry)e.nextElement();
		     String name=je.getName();
		     sb.append(name);
		     //System.out.println(name);
		   }
		   return sb.toString();
	   }
	   
	   public String compzip(File a) throws IOException
	   {
		   ZipFile zf = new ZipFile(a);
		      Enumeration entries = zf.entries();
              StringBuilder sb = new StringBuilder();
		      BufferedReader br = null;
		      while (entries.hasMoreElements())
		      {
		    	  
		        ZipEntry ze = (ZipEntry) entries.nextElement();
		        long size = ze.getSize();
	            if (size > 0)
	            {
	              //System.out.println("Length is " + size);
	            br = new BufferedReader(
	                new InputStreamReader(zf.getInputStream(ze)));
	             String line;
	             while ((line = br.readLine()) != null)
	              {
	               sb.append(line); 
	              }
		        }
		     }
		      zf.close();
		      br.close();
		   
		      return sb.toString();
	 }
	public String comp_Rar(File d) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		JarFile jf=new JarFile(d);
		Enumeration e=jf.entries();
		while(e.hasMoreElements())
		{
		  JarEntry je=(JarEntry)e.nextElement();
		  String name=je.getName();
		  sb.append(name);
		///System.out.println(name);
		}
		jf.close();
		return sb.toString();
	}
	public boolean checkZip(File a,File b) throws IOException
	   {
		   ZipFile zf = new ZipFile(a);
		      Enumeration entries = zf.entries();
		      ZipFile zf1 = new ZipFile(a);
		      Enumeration entries1 = zf1.entries();
		      BufferedReader br = null;
		      BufferedReader br1 = null;  
		        ZipEntry ze = (ZipEntry) entries.nextElement();
		        long size = ze.getSize();
		        ZipEntry ze1 = (ZipEntry) entries1.nextElement();
		        long size1 = ze1.getSize();
	            if (size > 0 && size1>0)
	            {
	              //System.out.println("Length is " + size);
	            br = new BufferedReader(
	                new InputStreamReader(zf.getInputStream(ze)));
	             String line;
	             br1 = new BufferedReader(
	 	                new InputStreamReader(zf.getInputStream(ze)));
	 	             String line1;
	 	            line = br.readLine();
	 	           line1 = br1.readLine();
	 	           if(line.equals(line1))
	 	        	   return true;
	            }
		      zf.close();
		      br.close();
		      zf1.close();
		      br1.close();
		   
		      return false;
	 }
}
