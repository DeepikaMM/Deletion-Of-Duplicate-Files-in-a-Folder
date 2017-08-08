import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.io.comparator.SizeFileComparator;


public class ToGetFiles 
{
	 public  ArrayList<File> listf(String directoryName)//list andsort
	   {
	        File directory = new File(directoryName);
	        ArrayList<File> resultList = new ArrayList<File>();
	        File[] fList = directory.listFiles();
           Arrays.sort(fList, SizeFileComparator.SIZE_SUMDIR_COMPARATOR);
	        resultList.addAll(Arrays.asList(fList));
	       for (File file : fList)
	       {
	            if (file.isFile()) 
	            {
	                System.out.println(file.getAbsolutePath());
	            } else if (file.isDirectory()) {
	                resultList.addAll(listf(file.getAbsolutePath()));
	            }
	        }
	    
	        return resultList;
	    } 
	 
	 public void compareFile(ArrayList<File> a)
	 {
		 try
		 {
		   for(int i =0;i<a.size();i++)
		   {
			   
		      for(int j = i+1;j<a.size();j++)
		      {
			    
		        File c = (File)a.get(j);
		        String t1 = filec(c);
		        File b = (File)a.get(i);
				String t = filec(b);
		        if(t.equals(t1))
		        {
		        	
		        	StringBuilder sb = new StringBuilder();
		        	sb.append(c);
		        	a.remove(j);
		        	j--;
		        	//System.out.println(t);
		        	System.out.println(a.size());
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
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 private String filec(File a)
	 {
		 BufferedReader br = null;
		 String line = "";
		 StringBuilder sb = new StringBuilder();
		 System.out.println(a);
		 try
		 {
			 br = new BufferedReader(new FileReader(a));
			
			 while((line = br.readLine())!=null)
             {
				  line = line.replaceAll("\\s+", "");
				 /// System.out.println(line);
				    if (!line.trim().equals("")) 
				         sb.append(line.trim());
             }
				  // System.out.println(sb.toString());
				  // System.out.println(sb1.toString());
			 br.close();
             
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 return sb.toString();
     }
	 private String filecheck(File a,File b)
	 {
		 BufferedReader br = null;
		 String line = "";
		 BufferedReader br1 = null;
		 String line1 = "";
		 try
		 {
			 br = new BufferedReader(new FileReader(a));
			 br1 = new BufferedReader(new FileReader(a));
			 line = br.readLine();
			 line = line.replaceAll("\\s+", "");
			 line1 = br1.readLine();
			 line1 = line1.replaceAll("\\s+", "");
            
				  StringBuilder sb = new StringBuilder();
				  if (!line.trim().equals("")) 
				       sb.append(line.trim());
            
				  // System.out.println(sb.toString());
				  // System.out.println(sb1.toString());
			 br.close();
             
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 return "";
     }
}

