package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {
	@Test
	public void teste1() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme1 = new Filme("As baratas tontas", 0, 25.00);
		Usuario user1 = new Usuario("Juan");
		//Acao
		try {
			Locacao Locacao = service.alugarFilme(user1, filme1);
			fail("Deveria haver ocorrido uma exception.");
		} catch (Exception e) {
		//Verificação
		assertEquals("Estoque vazio.", e.getMessage());
		}
	}
	
	@Test
	public void teste2() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme1 = new Filme("As baratas tontas", 0, 25.00);
		Usuario user1 = new Usuario("Juan");
		//Acao
		Exception minhaException = assertThrows(Exception.class,() -> {
			service.alugarFilme(user1, filme1);
		}, "Deveria ter ocorrido uma exception.");
		
		
		//Verificação
		assertEquals("Estoque vazio.", minhaException.getMessage());
	}
	
	@Test
	public void teste3() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme1 = new Filme("As baratas tontas", 10, 25.00);
		Usuario user1 = new Usuario("");
		//Acao
		Exception minhaException = assertThrows(Exception.class,() -> {
			service.alugarFilme(user1, filme1);
		}, "Deveria ter ocorrido uma exception.");
		
		
		//Verificação
		assertEquals("Nome vazio.", minhaException.getMessage());
	}
	@Test
	public void teste4() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme1 = new Filme("", 10, 25.00);
		Usuario user1 = new Usuario("DaviGleri");
		//Acao
		try {
			service.alugarFilme(user1, filme1);
			fail("Deveria ter ocorrido uma exception");
		} catch (Exception e) {
			assertEquals("Titulo vazio.", e.getMessage());
		}
		
		
		//Verificação
	}
	@Test
	public void teste5() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme1 = new Filme("As baratas tontas", 10, 0.0);
		Usuario user1 = new Usuario("Juan");
		//Acao
		Exception minhaException = assertThrows(Exception.class,() -> {
			service.alugarFilme(user1, filme1);
		}, "Deveria ter ocorrido uma exception.");
		
		
		//Verificação
		assertEquals("O filme não era para ser grátis, Pobre.", minhaException.getMessage());
	}
}
