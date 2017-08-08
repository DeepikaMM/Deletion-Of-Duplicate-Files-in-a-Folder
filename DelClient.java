
import java.io.File;
import javax.swing.*;

public class DelClient {

	public static void main(String[] args) throws Exception 
	{	
		JFileChooser fl = new JFileChooser();//file object
		 fl.showOpenDialog(null);//folder
		File f = fl.getCurrentDirectory();
		String fn = f.getAbsolutePath();//path
		long startTime = System.currentTimeMillis();
		SortFile f1 = new SortFile();//yella files in  direc
		System.out.println(fn);
		f1.sorting(fn);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		System.out.println("completed");
	}
}


