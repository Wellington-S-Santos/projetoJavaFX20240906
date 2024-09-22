package etec.sp.gov.br.atividadeavaliativa;

import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnDeposito;
    @FXML
    private Button btnSacar;
    @FXML
    private Button btnPesquisar;
    @FXML
    private ToggleGroup grpTipocontas;
    @FXML
    private RadioButton rbtCorrente;
    @FXML
    private RadioButton rbtPoupanca;
    @FXML
    private RadioButton rbtEspecial;
    @FXML
    private TextField txtNConta;
    @FXML
    private TextField txtNTitular;
    @FXML
    private TextField txtLimite;
    @FXML
    private TextField txtDVencimento;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtPesquisar;
    @FXML
    private  Label lbSaldo;
    @FXML
    private TextArea txtAreaDados;

    private Conta conta;



    private List<Conta> Contas = new ArrayList<>();

    @FXML
    protected void onSelecionarTipo() {
        if (rbtCorrente.isSelected()) {
            txtLimite.setDisable(true);
            txtDVencimento.setDisable(true);
        } else if (rbtEspecial.isSelected()) {
            txtLimite.setDisable(false);
            txtDVencimento.setDisable(true);
        } else {
            txtLimite.setDisable(true);
            txtDVencimento.setDisable(false);
        }
    }

    @FXML
    protected void onClickRegistrar() {
        boolean contaExistente = false;

        for (int j = 0; j < Contas.size(); j++) {
            if (Contas.get(j).getNumero() == Integer.parseInt(txtNConta.getText())) {
                contaExistente = true;
                break;
            }
        }
        if (!contaExistente){
            if (rbtCorrente.isSelected()) {
                Conta conta = new Conta(Integer.parseInt(txtNConta.getText()), txtNTitular.getText());
                Contas.add(conta);

            } else if (rbtEspecial.isSelected()) {
                Especial especial = new Especial(Integer.parseInt(txtNConta.getText()), txtNTitular.getText(), Double.parseDouble(txtLimite.getText()));
                Contas.add(especial);

                } else if (rbtPoupanca.isSelected()) {

                    Poupanca poupanca = new Poupanca(Integer.parseInt(txtNConta.getText()), txtNTitular.getText(), Integer.parseInt(txtDVencimento.getText()));
                    Contas.add(poupanca);

                }

            txtAreaDados.setText(Contas.toString());
            limparCampos();

                Alert alertconta = new Alert(Alert.AlertType.INFORMATION);
                alertconta.setTitle("Conta Registrada!!");
                alertconta.setHeaderText("Conta realizada com sucesso!!");
                alertconta.setContentText("Fique avontade para utilizar todos os recursos da plataforma");
                alertconta.show();

            }else{
           Alert alertContaExistente = new Alert(Alert.AlertType.ERROR);
           alertContaExistente.setTitle("Erro");
           alertContaExistente.setHeaderText("A conta já existe!!");
           alertContaExistente.setContentText("Não é necessario registrar a conta !!");
           alertContaExistente.show();
        }
    }

    private void limparCampos() {
        txtNConta.setText("");
        txtNTitular.setText("");
        txtLimite.setText(" ");
        txtDVencimento.setText("");
        txtValor.setText("");
        rbtCorrente.setSelected(false);
        rbtEspecial.setSelected(false);
        rbtPoupanca.setSelected(false);
        txtNConta.requestFocus();
    }

    @FXML
    protected void onDepositarDinheiro (){
        boolean contaEncontrada = false;


        for (int x = 0; x < Contas.size(); x++) {
            Conta conta = Contas.get(x);
            if (Integer.parseInt(txtNConta.getText()) == Contas.get(x).getNumero()) {
                contaEncontrada = true;

                if (rbtCorrente.isSelected() || rbtEspecial.isSelected() || rbtPoupanca.isSelected() ) {
                    conta.depositar(Double.parseDouble(txtValor.getText()));
                    lbSaldo.setText(String.valueOf(conta.getSaldo()));
                    limparCampos();


                }
                Alert alertDSucesso = new Alert(Alert.AlertType.INFORMATION);
                alertDSucesso.setTitle("Deposito realizado!!!");
                alertDSucesso.setHeaderText("Deposito efetuado com Sucesso!!");
                alertDSucesso.setContentText("Depositado na conta: " + txtNConta.getText());
                alertDSucesso.show();

                break;
            }
        }


        if (!contaEncontrada) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de busca.");
            alertError.setContentText("O conta não encontrada.");
            alertError.show();
            return;
        }

    }

    @FXML
    protected void onSacarDinheiro (){
        boolean contaEncontrada = false;


        for (int x = 0; x < Contas.size(); x++) {
            Conta conta = Contas.get(x);
            if (Integer.parseInt(txtNConta.getText()) == Contas.get(x).getNumero()) {
                contaEncontrada = true;

                if (rbtCorrente.isSelected() || rbtPoupanca.isSelected() ) {
                    conta.sacar(Double.parseDouble(txtValor.getText()));
                    lbSaldo.setText(String.valueOf(conta.getSaldo()));
                    limparCampos();


                } else if (rbtEspecial.isSelected()) {
                    Especial especial = (Especial) conta;
                    especial.sacar(Double.parseDouble(txtValor.getText()));
                    lbSaldo.setText(String.valueOf(conta.getSaldo()));
                    limparCampos();
                }
                Alert alertSSucesso = new Alert(Alert.AlertType.INFORMATION);
                alertSSucesso.setTitle("Saque realizado!!!");
                alertSSucesso.setHeaderText("Saque efetuado com Sucesso!!");
                alertSSucesso.setContentText("Saque da conta: " + txtNConta.getText());
                alertSSucesso.show();

                break;
            }
        }


        if (!contaEncontrada) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de busca.");
            alertError.setContentText("O conta não encontrada.");
            alertError.show();
            return;
        }

    }




    @FXML
    protected void OnPesquisarConta(){
        Integer pqNConta;
        boolean contaEncontrada = false;
        try {
            pqNConta = Integer.parseInt(txtPesquisar.getText());

        } catch (Exception err){
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de conversão");
            alertError.setContentText("O campo não é um número valido");
            alertError.show();
            return;
        }
        for (int i = 0; i < Contas.size(); i++) {
            if (Contas.get(i).getNumero() == pqNConta){
                contaEncontrada = true;
                Conta conta1 = Contas.get(i);
                populaCampos(conta1);
                break;
            }
        }
        if (!contaEncontrada) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de busca.");
            alertError.setContentText("O conta não encontrada.");
            alertError.show();
            return;
        }
    }


    private void populaCampos(Conta con) {
        txtNConta.setText(String.valueOf(con.getNumero()));
        txtNTitular.setText(con.getTitular());

        if (rbtCorrente.isSelected()) {
            rbtCorrente.setSelected(true);

        } else if (rbtEspecial.isSelected()) {
            // Para Conta Especial, criamos um objeto Especial e preenchemos os campos correspondentes
            Especial esp = (Especial) con;
            txtLimite.setText(String.valueOf(esp.getLimite()));
            rbtEspecial.setSelected(true);

        } else if (rbtPoupanca.isSelected()) {
            Poupanca poup = (Poupanca) con;
            txtDVencimento.setText(String.valueOf(poup.getAniversario()));
            rbtPoupanca.setSelected(true);
        }
    }


}

