package ua.kiev.prog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class InfoInFile {
	
	public static void main(String[] args) {
		try {
			new File ("D:\\Java\\test.txt").createNewFile();
			
			File dir = new File ("D:\\Java\\");
			File [] list = dir.listFiles ();
			String [] listString = new String [list.length];
			byte [] c = new byte [2048];
			
			OutputStream ops = new FileOutputStream ("D:\\Java\\test.txt");
				try {
				for (int i=0; i<list.length; i++) {
					StringBuilder strb = new StringBuilder ();
					
					if (list[i].isFile()) {
						strb.append(list[i].getCanonicalPath()).append("     ")
						  .append(list[i].getName()).append("     ")
						  .append(new Date (list[i].lastModified()).toString()).append("\r\n");
						listString [i] = strb.toString();
							c = listString [i].getBytes();
							ops.write(c);
					}
				}
					} finally { 
						ops.close();
			  		}

			} catch (IOException e) {
			;
			} 
		
	}
}


