package br.com.etec.aula20240906;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {


    @FXML
    private Button btnCadastar;

    @FXML
    private CheckBox chkCasado;

    @FXML
    private ToggleGroup grpSexo;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private TextArea txtAreaDados;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    private Cliente cliente;

    private List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    protected void onClickCadastrar () {

        String sexo = rbMasculino.isSelected()? "Masculino" : "Feminino";
        int id = listaClientes.size() + 1;

        cliente = new Cliente(id, txtNome.getText(), txtEmail.getText(), txtTelefone.getText(),sexo,chkCasado.isSelected());

        listaClientes.add(cliente);
        txtAreaDados.setText(listaClientes.toString());
        limparCampos();

    }

    private void limparCampos(){
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(false);
        chkCasado.setSelected(false);
        txtNome.requestFocus();
    }

}
