package etec.sp.gov.br.atividadeavaliativa;

import java.util.Date;

public class Poupanca extends Conta {
    private Integer aniversario;

    public Poupanca(Integer numero, String titular, Integer aniversario) {
        super(numero, titular);
        this.aniversario = aniversario;
    }


    public Integer getAniversario() {
        return aniversario;
    }

    public void setAniversario(Integer aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return"numero=" + this.getNumero() +
                ", titular='" + this.getTitular() + '\'' +
                ", saldo=" + this.getSaldo() +", aniversario=" + aniversario + System.lineSeparator();
    }
}