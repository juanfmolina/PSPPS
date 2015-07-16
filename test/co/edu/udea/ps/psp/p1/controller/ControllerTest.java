package co.edu.udea.ps.psp.p1.controller;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.ps.psp.p1.exception.MathModelException;

public class ControllerTest {

	private Controller controller;

	private String path = "D:\\prueba.txt";
	private String pathNoExist= "D:\\prueba2.txt";
	private String pathBadNumbers= "D:\\prueba3.txt";
	
	@Before
	public void setUp() throws Exception {
		controller= new Controller();
	}

	@Test
	public void testGetNumbersFromFileControllerFileDoesntExist() {
		
		LinkedList<Double> numbers;
		try {
			numbers = controller.getnumbersFromFile(pathNoExist);
		} catch (MathModelException e) {
			assertEquals("El archivo no existe", e.getMessage());
		}
	}
	
	@Test
	public void testGetNumbersFromFileControllerThreeNumbers() {
		
		LinkedList<Double> numbers;
		try {
			numbers = controller.getnumbersFromFile(path);
			assertEquals(3, numbers.size());
		} catch (MathModelException e) {
			assertEquals("El archivo no existe", e.getMessage());
		}
	}
	
	@Test
	public void testCalculateMean() {
		
		double mean= 0;
		try {
			mean = controller.calculateMean();
			assertEquals(3, numbers.size());
		} catch (MathModelException e) {
			assertEquals("El archivo no existe", e.getMessage());
		}
	}

}
