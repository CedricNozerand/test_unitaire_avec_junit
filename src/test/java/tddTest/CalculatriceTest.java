package tddTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.condition.EnabledIf;

@DisplayName("Test de l'objet Calculatrice")
@TestMethodOrder(OrderAnnotation.class)
@Tag("service")
public class CalculatriceTest {

	private static Calculatrice calculatrice;
	
	boolean calculatriceIsNotNull() {
	    return calculatrice != null;
	}
	
	@BeforeAll
	@Timeout(5)
	public static void init() {
		System.out.println("Initisialisation de l'objet calculatrice");
		calculatrice = new Calculatrice();
	}
	
	@Test
	@Order(1)
	@EnabledIf("calculatriceIsNotNull")
	public void additionTest() {
		int resultat = calculatrice.somme(5, 5);
		assertEquals(10, resultat);
		System.out.println("test de la méthode addition");
	}
	
	@Test
	@Order(2)
	@RepeatedTest(2)
	public void soustractionTest() {
		int resultat = calculatrice.soustraction(10, 5);
		assertEquals(5, resultat);
		System.out.println("test de la méthode soustraction");
	}
	
	@Test
	@Order(3)
	public void multiplicationTest() {
		int resultat = calculatrice.multiplication(5, 5);
		assertEquals(25, resultat);
		System.out.println("test de la méthode multiplication");
	}
	
	@Test
	@Order(4)
	public void divisionTest() {
		int resultat = calculatrice.division(10, 2);
		assertEquals(5, resultat);
		System.out.println("test de la méthode division");
	}
	
	@Test
    @Disabled("Méthode de test désactivée")
    void skippedTest() {

	}
	
	@AfterAll
	public static void clean() {
		System.out.println("Nétoyage des variables de test");
		calculatrice = null;
	}
}
