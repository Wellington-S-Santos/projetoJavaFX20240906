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
    private List<Conta> listaContas = new ArrayList<>();
    @FXML
    protected void onClickRegistrar(){
        int id = listaContas.size()+ 1;
        if (rbtCorrente.isSelected()){
            conta = new Conta(id,txtNConta.getText(),txtNTitular.getText(),txtValor.getText());
        }
    }





}