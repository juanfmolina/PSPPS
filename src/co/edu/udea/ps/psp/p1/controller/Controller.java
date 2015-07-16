package co.edu.udea.ps.psp.p1.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import co.edu.udea.ps.psp.p1.exception.MathModelException;
import co.edu.udea.ps.psp.p1.filemanager.FileManager;

public class Controller {
	private FileManager fileManager;
	
	private LinkedList<Double> numberList;
	
	

	public Controller() {
		fileManager= new FileManager();
	}



	public LinkedList<Double> getnumbersFromFile(String path) throws MathModelException {
		File file=fileManager.readFile(path);
		LinkedList<Double> numbers=null;
		try {
			numbers=fileManager.getNumbers(file);
		} catch (NumberFormatException e) {
			throw new MathModelException("El formato de números en el archivo no es correcto.");
		} catch (FileNotFoundException e) {
			throw new MathModelException("El archivo no existe");
		}
		return numbers;
	}



	public LinkedList<Double> getNumberList() {
		return numberList;
	}



	public void setNumberList(LinkedList<Double> numberList) {
		this.numberList = numberList;
	}
	
	

}
