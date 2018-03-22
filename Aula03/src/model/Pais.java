package model;

public class Pais {
	int id;
	String nome;
	long populacao;
	double area;

	public Pais () {}
	
	public Pais( int id, String nome, long populacao, double area) {
		setId(id);
		setNome(nome);
		setPopulacao(populacao);
		setArea(area);
	}
	// Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Nome: " + nome + "População: " + populacao + "Area: " + area;
	}
	
	
	
}//Pais