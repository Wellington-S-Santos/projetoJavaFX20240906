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
    private Label lbSaldo;
    @FXML
    private TextArea txtAreaDados;

    private Conta conta;




    private List<Conta> Contas = new ArrayList<>();

    @FXML
    protected void onSelecionarTipo(){
        if (rbtCorrente.isSelected()){
            txtLimite.setDisable(true);
            txtDVencimento.setDisable(true);
        } else if (rbtEspecial.isSelected()) {
            txtLimite.setDisable(false);
            txtDVencimento.setDisable(true);
        }else {
            txtLimite.setDisable(true);
            txtDVencimento.setDisable(false);
        }
    }
    @FXML
    protected void onClickRegistrar(){

        if (rbtCorrente.isSelected()){
            Conta conta = new Conta(Integer.parseInt(txtNConta.getText()),txtNTitular.getText());

            Contas.add(conta);
            txtAreaDados.setText(Contas.toString());
            limparCampos();
        } else if (rbtEspecial.isSelected()) {
             Especial especial= new Especial(Integer.parseInt(txtNConta.getText()),txtNTitular.getText(),Double.parseDouble(txtLimite.getText()));

            Contas.add(especial);
            txtAreaDados.setText(Contas.toString());
            limparCampos();
        } else  {
            Poupanca poupanca = new Poupanca(Integer.parseInt(txtNConta.getText()),txtNTitular.getText(),Integer.parseInt(txtDVencimento.getText()) );
            Contas.add(poupanca);
            txtAreaDados.setText(Contas.toString() );
            limparCampos();

        }

    }
    private void limparCampos (){
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








}