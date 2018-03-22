
package test;


import static org.junit.Assert.assertEquals;
import model.Pais;
import service.PaisService;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.PaisDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais,copia;
	PaisService serv, servCopia;
	PaisDAO dao, daoCopia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Batista", 912344321,  23542352);
		copia = new Pais(id, "Batista", 912344321,  23542352);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void testeAtualizar() {
		System.out.println("Atualizar");
		copia.setArea(234554533);
		copia.setNome("Bulgaria");
		copia.setPopulacao(1437634);
		serv.atualizar(pais);
		assertEquals("teste atualizar", pais, copia);
	}
	
	@Test
	public void testeExcluir() {
		System.out.println("Excluir");
		copia.setArea(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		serv.atualizar(pais);
		assertEquals("teste atualizar", pais, copia);
	}
}
