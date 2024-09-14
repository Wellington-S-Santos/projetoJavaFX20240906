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
    @FXML
    private  TextField txtBusca;
    @FXML
    private Button btnPesquisar;



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

    @FXML
    protected void onBuscarCliente () {
        Integer idBusca;

        try {
            idBusca = Integer.parseInt(txtBusca.getText());
        } catch (Exception err){
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de conversão");
            alertError.setContentText("O campo não é um número valido");
            alertError.show();
            return;
        }

        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == idBusca){
                Cliente cliente1 = listaClientes.get(i);
                populaCampos(cliente1);
            } else if (listaClientes.size()< Integer.parseInt(txtBusca.getText())) {
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Erro");
                alertError.setHeaderText("Erro de busca.");
                alertError.setContentText("O campo não encontrado.");
                alertError.show();
                return;

            }
        }
    }

    private void populaCampos(Cliente cli){
        txtNome.setText(cli.getNome());
        txtEmail.setText(cli.getEmail());
        txtTelefone.setText(cli.getTelefone());

        if(cli.getSexo().equals("Feminino")){
            rbFeminino.setSelected(true);
            rbMasculino.setSelected(false);
        }else {
            rbFeminino.setSelected(false);
            rbMasculino.setSelected(true);
        }
        if (cli.getCasado()){
            chkCasado.setSelected(true);
        }else {
            chkCasado.setSelected(false);
        }
    }

}
