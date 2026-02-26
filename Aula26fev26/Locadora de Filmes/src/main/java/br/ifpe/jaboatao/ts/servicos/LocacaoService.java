package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		if (filme.getEstoque() == 0 || filme.getEstoque() == null){
			throw new Exception("Estoque vazio.");
		}
		
		if (usuario.getNome() == "" || usuario.getNome() == null) {
			throw new Exception("Nome vazio.");
		}
		
		if (filme.getValor() == 0 || filme.getValor() == null){
			throw new Exception("O filme não era para ser grátis, Pobre.");
		}
		
		if (filme.getTitulo() == "" || filme.getTitulo() == null){
			throw new Exception("Titulo vazio.");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}
	
}