package com.aneeshpu.classloader;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public class Linking {

	private String basePath = "/home/aneeshpu/workspace/JavaClassLinkingExample/bin/";
	private String packagePath = "com/aneeshpu/classloader/";

	public static void main(String[] args) throws IOException {

		Linking linkingExample = new Linking();
		linkingExample.removeBooksFromClassPath();
	}
	
	private File originalFile(){
		return new File(basePath + packagePath + "Book.class");
	}
	
	private File newFile(){
		return new File(basePath + packagePath + "Books_1.class");
	}

	public void removeBooksFromClassPath() throws IOException {
		File originalFile = originalFile();
		File newFile = newFile();
		
		System.out.println(MessageFormat.format("renaming {0} to {1}", originalFile.getAbsolutePath(), newFile.getAbsolutePath()));
		originalFile.renameTo(newFile);
	}
	
	public void addBooksBackToClassPath() {
		File originalFile = originalFile();
		File newFile = newFile();
		
		System.out.println(MessageFormat.format("renaming {0} to {1}", newFile.getAbsolutePath(), originalFile.getAbsolutePath()));
		newFile.renameTo(originalFile);
	}

}