    package br.com.angelodt.banco.negocio;

    import br.com.angelodt.banco.dominio.Cliente;
    import br.com.angelodt.banco.interfaces.IEmprestimo;

    public class Emprestimo implements IEmprestimo {

        protected double saldoEmprestimo = 0.0;
        protected double limiteEmprestimo = 0.0;

        public Emprestimo() {
            this.saldoEmprestimo =  0.0;
            this.limiteEmprestimo = 0.0;
        }
        public Emprestimo(double limiteEmprestimo) {
            this.saldoEmprestimo = 0.0;
            this.limiteEmprestimo = limiteEmprestimo;
        }

        public double getSaldoEmprestimo() {
            return saldoEmprestimo;
        }

        public void setSaldoEmprestimo(double saldoEmprestimo) {
            this.saldoEmprestimo = saldoEmprestimo;
        }

        public double getLimiteEmprestimo() {
            return limiteEmprestimo;
        }

        public double getLimiteDisponivelEmprestimo() {
            return limiteEmprestimo-saldoEmprestimo;
        }

        public void setLimiteEmprestimo(double limiteEmprestimo) {
            this.limiteEmprestimo = limiteEmprestimo;
        }

        public Boolean possuiEmprestimo(Cliente cliente) {
            return saldoEmprestimo>0;
        }

        public Double realizarEmprestimo(Double valorEmprestimo) {
            if(getLimiteDisponivelEmprestimo() > valorEmprestimo){
                saldoEmprestimo += valorEmprestimo;
            } else if(valorEmprestimo >= getLimiteDisponivelEmprestimo() && getLimiteDisponivelEmprestimo() > 0) {
                valorEmprestimo = getLimiteDisponivelEmprestimo();
                saldoEmprestimo += valorEmprestimo;
            } else {
                valorEmprestimo = 0D;
            }
            return valorEmprestimo;
        };

        public void pagarEmprestimo(Double valorPagamento) {
            if(saldoEmprestimo>valorPagamento) {
                saldoEmprestimo -= valorPagamento;
            } else {
                saldoEmprestimo = 0D;
            }
        }
    }
