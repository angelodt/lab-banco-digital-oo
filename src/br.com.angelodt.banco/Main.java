package br.com.angelodt.banco;

import br.com.angelodt.banco.negocio.Conta;
import br.com.angelodt.banco.dominio.Cliente;
import br.com.angelodt.banco.dominio.ContaCorrente;
import br.com.angelodt.banco.dominio.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		ContaCorrente cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.imprimirExtrato();
		cc.transferir(100, poupanca);
		cc.realizarNovoEmprestimo(1000D);
		poupanca.imprimirExtrato();
		cc.imprimirExtrato();
		cc.pagarParcelaEmprestimo(500D);
		cc.imprimirExtrato();
	}

}
