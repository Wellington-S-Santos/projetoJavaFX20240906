package etec.sp.gov.br.atividadeavaliativa;

public class Especial extends Conta{
    private Integer limite;

    public Especial(java.lang.Integer numero, java.lang.String titular, java.lang.Double saldo, java.lang.Integer limite) {
        super(numero, titular, saldo);
        this.limite = limite;
    }

    public java.lang.Integer getLimite() {
        return limite;
    }

    public void setLimite(java.lang.Integer limite) {
        this.limite = limite;
    }
}
