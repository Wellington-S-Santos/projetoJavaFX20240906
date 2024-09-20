package etec.sp.gov.br.atividadeavaliativa;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Conta conta;

    public Conta(java.lang.Integer numero, java.lang.String titular, java.lang.Double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo != null ? saldo : 0.0;;

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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }


    protected void sacar(){

    }


    public void depositar(Double valor){
        if (valor>=50 && valor <= 2000)
        this.saldo += valor;
    }
    public void sacar (Double valor){
        this.saldo -= valor;
    }



}
