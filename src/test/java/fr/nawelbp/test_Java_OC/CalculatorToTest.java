package fr.nawelbp.test_Java_OC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorToTest {

	//Arrange
			int a=2;
			int b=3;
	//Act
	Calculator calculator=new Calculator();	
	
	@Test
	void add() {		
		int somme = calculator.add(a, b);
		
		//Assert
		assertEquals(5, somme);
	}

	@Test
	void multiply() {
		int produit=calculator.multiply(a,b);
		
		//Assert
		assertEquals(6, produit);
	}
}
