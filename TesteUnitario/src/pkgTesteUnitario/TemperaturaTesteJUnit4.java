package pkgTesteUnitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperaturaTesteJUnit4 {
	Temperatura t;

	@Before
	public void setUp() throws Exception {
		t = new Temperatura();
	}

	@Test
	public void testCelsiusParaFarenheit() {
		assertEquals("CASO 1", 23, t.celsiusParaFarenheit(-5),0);
		assertEquals("CASO 2", 32, t.celsiusParaFarenheit(0),9);
		assertEquals("CASO 3", 64, t.celsiusParaFarenheit(18),41);
	}

	@Test
	public void testCelsiusParaKelvin() {
		assertEquals("CASO 4", 268.150, t.celsiusParaKelvin(-5),0);
		assertEquals("CASO 5", 273.150, t.celsiusParaKelvin(0),0);
		assertEquals("CASO 6", 291.150, t.celsiusParaKelvin(18),0);
	}

	@Test
	public void testClassificaTemperatura() {
		assertTrue("CASO 7", "NEGATIVA"==t.classificaTemperatura(-5));
		assertTrue("CASO 8", "ZERO"==t.classificaTemperatura(0));
		assertTrue("CASO 9", "POSITIVA"==t.classificaTemperatura(18));
	}

	@Test
	public void testValidaConversaoCelsiusFarenheit() {
		//assertTrue("CASO 10", true==t.classificaTemperatura(-5,23));
		assertTrue("", true == t.validaConversaoCelsiusFarenheit(-5,23));
		
	}

}
