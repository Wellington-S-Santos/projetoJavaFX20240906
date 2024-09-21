package etec.sp.gov.br.atividadeavaliativa;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;


    public Conta(java.lang.Integer numero, java.lang.String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo =  0.0;

    }


    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public java.lang.Integer getNumero() {
        return numero;
    }

    public void setNumero(java.lang.Integer numero) {
        this.numero = numero;
    }

    public java.lang.String getTitular() {
        return titular;
    }

    public void setTitular(java.lang.String titular) {
        this.titular = titular;
    }



    protected void sacar(){

    }


    public void depositar(Double valor) {
        if (valor >= 50 && valor <= 2000)
            this.saldo += valor;
    }

    public Boolean sacar (Double valor){
        if (valor<= this.saldo){
        this.saldo -= valor;
        return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return"numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo + System.lineSeparator();
    }
}
