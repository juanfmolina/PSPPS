package co.edu.udea.ps.psp.p1.filemanager;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {

	private FileManager fileManager;	
	
	private String path = "D:\\prueba.txt";
	private String pathNoExist= "D:\\prueba2.txt";
	private String pathBadNumbers= "D:\\prueba3.txt";
	private String pathNoNumbers= "D:\\prueba4.txt";

	@Before
	public void setUp() throws Exception {
		fileManager = new FileManager();
	}

	@Test
	public void testReadFile() {

		File file = fileManager.readFile(path);
		assertEquals(path, file.getAbsolutePath());

	}

	@Test
	public void testGetNumbersFromFilebutFileDoesntExist() {
		boolean thrown = false;
		File file = fileManager.readFile(pathNoExist);

		try {
			fileManager.getNumbers(file);
		} catch (FileNotFoundException e) {
			thrown = true;
		} catch (NumberFormatException e) {
			fail("Formato de número incorrecto");
		}
		assertEquals(true, thrown);
	}


	@Test
	public void testGetNumbersFromFileExistsAndDontHaveNumbers() {
		File file = fileManager.readFile(pathNoNumbers);
		LinkedList<Double> numbers=null;
		try {
			numbers = fileManager.getNumbers(file);
		} catch (FileNotFoundException e) {
			fail("El archivo debe existir");
		} catch (NumberFormatException e) {
			fail("Formato de número incorrecto");
		}
		assertEquals(0, numbers.size());
	}
	
	@Test
	public void testGetNumbersFromFileExistsAndHaveThreeNumbers() {
		File file = fileManager.readFile(path);
		LinkedList<Double> numbers=null;
		try {
			numbers = fileManager.getNumbers(file);
		} catch (FileNotFoundException e) {
			fail("El archivo debe existir");
		} catch (NumberFormatException e) {
			fail("Formato de número incorrecto");
		}
		assertEquals(3, numbers.size());
	}
	@Test
	public void testGetNumbersFromFileExistsAndHaveASpecificNumber() {
		File file = fileManager.readFile(path);
		LinkedList<Double> numbers=null;
		try {
			numbers = fileManager.getNumbers(file);
		} catch (FileNotFoundException e) {
			fail("El archivo debe existir");
		} catch (NumberFormatException e) {
			fail("Formato de número incorrecto");
		}
		assertEquals(2d, numbers.get(1).doubleValue(),000.1);
	}

}
