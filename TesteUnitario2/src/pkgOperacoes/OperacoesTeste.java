package pkgOperacoes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OperacoesTeste {

	Operacoes op1, op2;
	
	@Before
	public void setUp() throws Exception {
		op1 = new Operacoes();
		op2 = new Operacoes();
	}

	@Test
	public void deveriaVerificarMaiorValor() {
		assertEquals("CASO 1", 16, op1.maiorValor(16, 9),0);
		assertEquals("CASO 2", 17, op1.maiorValor(16, 9),1);
		assertEquals("CASO 3", 15, op1.maiorValor(16, 9),1);
	}

	@Test
	public void deveriaVerificarMenorValor() {
		assertFalse("CASO 4", 16 == op1.menorValor(16, 9));
		assertTrue("CASO 5", 9 == op1.menorValor(16, 9));
	}
	
	@Test
	public void deveriaCompararDoisObjetos() {
		assertNotSame(op1, op2);
		assertSame(op1, op1);
	}
	
	@Test
	public void deveriaTestarRaizQuadrada() {
		assertEquals("CASO 8", 9.380, op1.raizQuadrada(88),0.001);
	}

	@Test(expected = AssertionError.class)
	public void deveriaTestarDivisao () throws Exception{
		assertEquals("CASO 9", 25, op1.divide(50, 2),25);
		assertEquals("CASO 10", 0, op1.divide(50, 0),0);
		assertEquals("CASO 11", 0, op1.divide(0, 0),0);
	}

	@Test(expected = AssertionError.class)
	public void deveriaTestarProduto() throws Exception {
		assertEquals("CASO 12", 1000000000, op1.produto(1000000, 1000000),0);
	}

	@Test
	public void testSoma() {
		assertEquals("CASO 13", 20, op1.soma(10, 10),0);
		assertFalse("CASO 14", 21 == op1.soma(10, 10));
		assertTrue("CASO 15", 20 == op1.soma(10, 10));
	}

}
