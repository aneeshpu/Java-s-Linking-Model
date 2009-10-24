package com.aneeshpu.classloader;

@SuppressWarnings("serial")
public class CantLocateTheFileToCopy extends RuntimeException {

	public CantLocateTheFileToCopy(String message) {
		super(message);
	}
}