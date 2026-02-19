package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {
	@Test
	public void teste01() {
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Carlos");
		Filme filme = new Filme("Titulo 1", 1, 10.00);
		
		//ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificação
		assertTrue(locacao.getValorLocacao() == 10.00);
		assertTrue(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));
		assertTrue(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));
		
		//Exercício:
		//Crie os seguintes testes:
		//Nome do usuário
		assertTrue(locacao.getUsuario().getNome() == "Carlos");
		//Título do filme
		assertTrue(locacao.getFilme().getTitulo() == "Titulo 1");
		//Estoque do filme
		assertTrue(locacao.getFilme().getEstoque() == 1);
	}
}