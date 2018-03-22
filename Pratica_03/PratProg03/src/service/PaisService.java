package service;

import model.Pais;
import dao.PaisDAO;

public class PaisService{
	
	PaisDAO dao = new PaisDAO();
	
	public void incluir(Pais pais) {
		dao.incluir(pais);
	}
	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}
	public void excluir(int id) {
		dao.excluir(id);
	}
	public void vetorPaises () {
		dao.vetorPaises();
	}
	public void menorArea () {
		dao.menorArea();
	}
	public void maiorPopulacao() {
		dao.maiorPopulacao();
	}
	
}
