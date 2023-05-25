package fr.nawelbp.test_Java_OC;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorToTest {
	//Arrange
			int a=2;
			int b=3;
			private static Instant startedAt;
	//Act		
			private Calculator calculatorUnderTest;
	
	/*
	 * objectif 1 : initialiser une instance du calculateur avant chaque test
	 */
	@BeforeEach
	public void initCalculator() {
				System.out.println("Appel avant chaque test");
				calculatorUnderTest= new Calculator();
			}
	/*
	 * objectif 2 : après chaque test, mettre la valeur du calculateur à null
	 * utilisé ici pour tester l'annotation, inutile dans ce contexte
	 */
	@AfterEach
	public void undefineCalculator() {
		System.out.println("Appel après chaque test");
		calculatorUnderTest= null;
	}
	/*
	 * méthodes BeforeAll & AfterAll & variables startedAt sont statiques 
	 * C'est un héritage des anciennes versions de JUnit. 
	 * Les méthodes appelées avant ou après tous les tests sont donc statiques 
	 * car considérées comme liées à l'objet de la classe de test, et non à une instance particulière.
	 */
	
	/*
	 * objectif 3 : mesurer le temps de traitement de l'ensemble des tests
	 */
	@BeforeAll
	static public void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	static public void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}
	
	
	@ParameterizedTest(name="{0} + {1} should equal to {2}")
	@CsvSource({"1,1,2", "2,3,5", "42, 57, 99"})
	void add(int arg1, int arg2, int expectedResult) {		
		int actualResult = calculatorUnderTest.add(arg1, arg2);		
		//Assert
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	@Test
	void add() {
		int somme=calculatorUnderTest.add(a,b);
		//Assert
		assertThat(somme).isEqualTo(5);
	}

	@Test
	void multiply() {
		int produit=calculatorUnderTest.multiply(a,b);
		//Assert
		assertThat(produit).isEqualTo(6);
	}
	
	@ParameterizedTest(name="{0} x 0 should equal to 0")
	@ValueSource(ints = {1, 2, 42, 1011, 5089})
	public void multiplyByZero(int argument) {
		//Arrange -> annotations
		//Act
		int actualResult = calculatorUnderTest.multiply(argument, 0);
		//Assert
		assertThat(actualResult).isEqualTo(0);
	}
	
	/*
	 * Tester la vitesse des traitement
	 * faire échouer un test si la durée est trop longue( durée fixée ici a 1seconde)
	 */
	
	@Timeout(1)
	@Test
	public void longCalcul_should_computeInLessThan1Second() {
		calculatorUnderTest.longCalculation();
	}
}
