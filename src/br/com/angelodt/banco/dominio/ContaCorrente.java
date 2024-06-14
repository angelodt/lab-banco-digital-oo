package br.com.angelodt.banco.dominio;

import br.com.angelodt.banco.negocio.Conta;
import br.com.angelodt.banco.negocio.Emprestimo;

import java.util.Optional;

public class ContaCorrente extends Conta {

	Emprestimo emprestimo;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	protected boolean possuiEmprestimo() {
		return null != emprestimo;
	}

	public void realizarNovoEmprestimo(Double valorEmprestimo) {
		if(!possuiEmprestimo()) {
			emprestimo = new Emprestimo(valorEmprestimo);
		}
		Double emprestimoRealizado = emprestimo.realizarEmprestimo(valorEmprestimo);
		this.depositar(emprestimoRealizado);
	}

	public void pagarParcelaEmprestimo(Double valorPagamento) {
		if(possuiEmprestimo() && this.getSaldo()>=valorPagamento) {
			this.sacar(valorPagamento);
			emprestimo.pagarEmprestimo(valorPagamento);
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		if(possuiEmprestimo()) {
			System.out.println(String.format("Saldo Emprestimo: %.2f", emprestimo.getSaldoEmprestimo()));
			System.out.println(String.format("Limite Emprestimo: %.2f", emprestimo.getLimiteEmprestimo()));
			System.out.println(String.format("Limite Disponivel Emprestimo: %.2f", emprestimo.getLimiteDisponivelEmprestimo()));
		}
	}
}
