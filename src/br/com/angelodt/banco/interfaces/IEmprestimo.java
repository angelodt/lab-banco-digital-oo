package br.com.angelodt.banco.interfaces;

public interface IEmprestimo {

    public Double realizarEmprestimo(Double valorEmprestimo);

    public void pagarEmprestimo(Double valorPagamento);
}
