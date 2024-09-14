package etec.sp.gov.br.atividadeavaliativa;

public class Poupanca extends Conta{
    private Integer aniversario;

    public Poupanca(java.lang.Integer numero, java.lang.String titular, double saldo, java.lang.Integer aniversario) {
        super(numero, titular, saldo);
        this.aniversario = aniversario;
    }

    public java.lang.Integer getAniversario() {
        return aniversario;
    }

    public void setAniversario(java.lang.Integer aniversario) {
        this.aniversario = aniversario;
    }
}
