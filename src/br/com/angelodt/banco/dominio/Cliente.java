package br.com.angelodt.banco.dominio;

import br.com.angelodt.banco.negocio.Emprestimo;

import java.util.Optional;

public class Cliente {

	private String nome;

	private Emprestimo emprestimo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<Emprestimo> getEmprestimo() {
		return Optional.of(emprestimo);
	}
}
