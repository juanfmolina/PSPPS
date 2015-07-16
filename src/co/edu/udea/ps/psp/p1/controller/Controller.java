package co.edu.udea.ps.psp.p1.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import co.edu.udea.ps.psp.p1.exception.MathModelException;
import co.edu.udea.ps.psp.p1.filemanager.FileManager;
import co.edu.udea.ps.psp.p1.mathmodel.MathCalculator;

public class Controller {
	private FileManager fileManager;
	private MathCalculator calculator;
	
	
	
	public Controller() {
		fileManager= new FileManager();
		calculator = new MathCalculator();
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

	public double calculateMean(LinkedList<Double> numbers) throws MathModelException{

			double mean = calculator.calculateMean(numbers);

		return mean;
	}



	public double calculateStandardDesviation(LinkedList<Double> numbers) throws MathModelException {
		double sd= calculator.calculateStandarDesviation(numbers);
		return sd;
	}
	
	

}
