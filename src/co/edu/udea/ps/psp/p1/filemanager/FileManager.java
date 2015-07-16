package co.edu.udea.ps.psp.p1.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileManager {
	
	private File readedFile;

	public File getReadedFile() {
		return readedFile;
	}

	public void setReadedFile(File readedFile) {
		this.readedFile = readedFile;
	}

	public File readFile(String path) {
		readedFile= new File(path);
		return readedFile;
	}

	public LinkedList<Double> getNumbers(File file) throws FileNotFoundException, NumberFormatException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		LinkedList<Double>numbers= new LinkedList<>();
		String line= null;
			try {
				while ((line=reader.readLine())!=null) {
					if (line!=null && !line.equals("")) {
						numbers.add(Double.parseDouble(line));
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				 try {
				        if (reader != null) {
				            reader.close();
				        }
				    } catch (IOException e) {
				    }
			}
		
		return numbers;
	}

}
