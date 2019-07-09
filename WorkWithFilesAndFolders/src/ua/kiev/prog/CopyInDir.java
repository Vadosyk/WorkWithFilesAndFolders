package ua.kiev.prog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

								

public class CopyInDir {
									//1
	/*public static void copyAll(String nameStrFrom, String nameStrTo) {
			
				File file = new File(nameStrFrom);
				File newFile = new File(nameStrTo);
				String nextSrcFilename, nextDstFilename;
					try {
						for (String filename : file.list()){
							nextSrcFilename = file.getAbsolutePath() + File.separator + filename;
							nextDstFilename = newFile.getAbsolutePath() + File.separator + filename;
							copyAll(nextSrcFilename, nextDstFilename);
							System.out.println(nextSrcFilename);
							System.out.println(nextDstFilename);
							}
						}catch (Exception e) {
					System.out.println(e.getMessage());
						}
					System.out.println("OK!!!");
    }*/
	
										//2
	public static void copyBuf(File from, File to) {// с использованием   BufferedInputStream & BufferedOutputStream
		try {
			
			
			try(FileInputStream fis = new FileInputStream(from);
					FileOutputStream fos = new FileOutputStream(to)) {
				
				try(BufferedInputStream bis = new  BufferedInputStream(fis);
						BufferedOutputStream bos = new  BufferedOutputStream(fos)) {
					
					byte [] buff= new byte [128*1024];
					int str;
                while ((str=bis.read(buff))!=-1) {
                	
                    bos.write(buff,0,str);
                }
            } finally {
               
            }
        } finally {
          
        }
	}catch (Exception e) {
		System.out.println(e.getMessage());
		}
   }
	
	public static void copyDir(String dirFrom, String dirTo) throws IOException {
		 File sdir=new File(dirFrom);
		 File ddir= new File(dirTo); 
		if (sdir.isDirectory()){
			 if (!ddir.isDirectory()){
				 ddir.mkdir();
			 }
			 File[]sfile=sdir.listFiles();
			 File[]dfile= new File[sfile.length];
			 for (int i=0; i< sfile.length; i++){
				 String file1=sfile[i].getPath();
				 String file2 = file1.replace(dirFrom, dirTo);
				 dfile[i]=new File(file2);
				 copyBuf(sfile[i],dfile[i]);
			 }
		 }else{
			 System.out.println("No such directory " +  dirFrom);
		 }
		System.out.println("OK!!!");
	 }
	
	
    public static void main(String[] args) {
    	try{
	 		copyDir("D:\\Test1","D:\\Test2");
	 	}catch (IOException e){
	 		System.out.println(e.getMessage());
	 	}
	
 }
}


