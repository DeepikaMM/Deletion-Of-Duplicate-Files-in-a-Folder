import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class CompXls 
{
	public void compXls(ArrayList<File> a)
	{
		 for(int i =0;i<a.size();i++)
		   {
			 File b = (File)(a.get(i));
			 //System.out.println(b);
			 //int c1 = a.indexOf(a.get(i));
			 //if(c1 == -1)
			//	 continue;
			 String v = compXl(b);
		      for(int j = i+1;j<a.size();j++)
		      {
		        File c = (File)(a.get(j));
		        //.out.println(c);
		        String u = compXl(c);
		        //System.out.println(v+" "+u);
		        if(v.equals(u))
		        {
		        	StringBuilder sb = new StringBuilder();
		        	sb.append(c);
		        	a.remove(j);
		        	j--;
		        	//System.out.println(p);
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
		        else
		        {
		        	System.out.println("not deleted");
		        }
		      }
		   }
	}
   private String compXl(File b)
   {
	   Cell cell = null;
	   StringBuilder sb = new StringBuilder();
	try {
		
		Workbook wb = new HSSFWorkbook(new FileInputStream(b));
		Sheet sht = wb.getSheetAt(0);
		for(Iterator<Row> rit = sht.rowIterator();rit.hasNext();){
			Row row = rit.next();
			for(Iterator<Cell> cit = row.cellIterator();cit.hasNext();){
				 cell = cit.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				sb.append(cell.getStringCellValue());
				
			}
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return sb.toString();
	
   }
}
