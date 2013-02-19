package com.futaba.tools;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FileOpener {


	private String filename;

	public FileOpener()

	{	

		 try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //make it look pretty
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose the directory with your contents");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(getParent());
		File directory = fileChooser.getSelectedFile();	

		try {
			filename = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Component getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName()
	{
		return this.filename;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		FileOpener read = new FileOpener();
//		String fileread = read.getName();
//		System.out.println(fileread);
//
//		InputStream fileRead = new FileInputStream(fileread);
//		Workbook wbRead = WorkbookFactory.create(fileRead);   <<<<<better implementation!
//		Workbook wbRead = new HSSFWorkbook(fileRead);


	}

}
