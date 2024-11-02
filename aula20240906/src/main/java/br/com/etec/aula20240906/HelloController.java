package br.com.etec.aula20240906;

import br.com.etec.aula20240906.model.dao.ClienteDao;
import br.com.etec.aula20240906.model.database.Database;
import br.com.etec.aula20240906.model.database.DatabaseFactory;
import br.com.etec.aula20240906.model.database.DatabaseMySQL;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import br.com.etec.aula20240906.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController {
    //atributos para manipulação do banco de dados.
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ClienteDao clienteDao = new ClienteDao();

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
    private TextField txtBusca;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnBuscarBD;

    @FXML
    private  Button btnDelete;


    private Cliente cliente;

    private List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    protected void onClickCadastrar() {
        if (txtNome.getText().equals("")) {
            campoVasio("Nome em branco");
            txtNome.requestFocus();
        } else if (txtEmail.getText().equals("")) {
            campoVasio("Email em branco");
            txtEmail.requestFocus();
        } else if (txtTelefone.getText().equals("")) {
            campoVasio("Telefone em branco");
            txtTelefone.requestFocus();
        } else {


            String sexo = rbMasculino.isSelected() ? "Masculino" : "Feminino";
            int id = listaClientes.size() + 1;

            cliente = new Cliente(id, txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), sexo, chkCasado.isSelected());

            listaClientes.add(cliente);
            txtAreaDados.setText(listaClientes.toString());

            clienteDao.setConnection(connection);
            if (clienteDao.inserir(cliente)) {
                aviso("Registro Salvo", "Cadastro do Cliente", "Salvo com Sucesso");
            } else {
                aviso("Salvar Registro", "Cadastro dop Cliente", "Erro ao Salvar");
            }

            limparCampos();
        }

    }

    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(false);
        chkCasado.setSelected(false);
        txtNome.requestFocus();
    }

    private void campoVasio(String msg) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("ERRO");
        alerta.setHeaderText("Campo em branco");
        alerta.setContentText(msg);
        alerta.show();
        return;
    }

    @FXML
    protected void onBuscarCliente() {
        Integer idBusca;

        try {
            idBusca = Integer.parseInt(txtBusca.getText());
        } catch (Exception err) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de conversão");
            alertError.setContentText("O campo não é um número valido");
            alertError.show();
            return;
        }

        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == idBusca) {
                Cliente cliente1 = listaClientes.get(i);
                populaCampos(cliente1);
            } else if (listaClientes.size() < Integer.parseInt(txtBusca.getText())) {
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Erro");
                alertError.setHeaderText("Erro de busca.");
                alertError.setContentText("O campo não encontrado.");
                alertError.show();
                return;

            }
        }
    }


    private void populaCampos(Cliente cli) {
        txtNome.setText(cli.getNome());
        txtEmail.setText(cli.getEmail());
        txtTelefone.setText(cli.getTelefone());

        if (cli.getSexo().equals("Feminino")) {
            rbFeminino.setSelected(true);
            rbMasculino.setSelected(false);
        } else {
            rbFeminino.setSelected(false);
            rbMasculino.setSelected(true);
        }
        if (cli.getCasado()) {
            chkCasado.setSelected(true);
        } else {
            chkCasado.setSelected(false);
        }
    }

    private void aviso(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
        return;
    }

    @FXML
    protected void onBuscarClienteBD() {
        Integer idBusca;

        try {
            idBusca = Integer.parseInt(txtBusca.getText());
        } catch (Exception err) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de conversão");
            alertError.setContentText("O campo não é um número valido");
            alertError.show();
            return;
        }
        clienteDao.setConnection(connection);
        cliente = clienteDao.getClienteById(idBusca);

        if (cliente.getId()!= null){
            populaCampos(cliente);
        }else {
            Alert alertError = new Alert(Alert.AlertType.INFORMATION);
            alertError.setTitle("Busca Cliente");
            alertError.setHeaderText("Busca de Cliente");
            alertError.setContentText("Não existe cliente com esse código");
            alertError.show();

        }

    }
    @FXML
    protected void onDeletarClienteBD() {
        Integer idBusca;

        try {
            idBusca = Integer.parseInt(txtBusca.getText());
        } catch (Exception err) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Erro");
            alertError.setHeaderText("Erro de conversão");
            alertError.setContentText("O campo não é um número valido");
            alertError.show();
            return;
        }
        clienteDao.setConnection(connection);


        if (clienteDao.delete(idBusca)) {
            aviso("Deletar Cliente", "Cliente deletado", "Cliente deletado com Sucesso");
        } else {
            aviso("Deletar Cliente", "Erro ", "Erro ao Deletar Cliente");
        }
        limparCampos();
    }


}
