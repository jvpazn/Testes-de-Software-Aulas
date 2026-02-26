package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertTest {

	@Test
	public void teste01() {
		assertTrue(true);
		assertFalse(false);
	}
	@Test
	public void teste02() {
		//Numeros
		assertEquals(1, 1,"Erro de comparação.");
		assertNotEquals(1, 2);
		assertEquals(0.23122, 0.2312, 0.0001);
		assertEquals(Math.PI, 3.14, 0.01);
		//Texto
		assertEquals("casa", "casa");
		assertTrue("casa" == "casa");
		assertTrue("casa".equalsIgnoreCase("Casa"));
		assertEquals("casa".toLowerCase(), "Casa".toLowerCase());
		//Objetos
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		assertEquals(u1, u2);
	}
	@Test
	public void teste03() {
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		Usuario u3 = u2;
		assertSame(u3, u2);
		assertNotSame(u1, u3);
	}
	@Test
	public void teste04() {
		Usuario u4 = new Usuario("Usuario 04");
		Usuario u5 = null;
		assertNull(u5);
		assertNotNull(u4);
	}
	
}
