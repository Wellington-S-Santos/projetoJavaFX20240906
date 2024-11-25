package etec.sp.gov.br.atividadeavaliativafinal;

import etec.sp.gov.br.atividadeavaliativafinal.model.Reserva;
import etec.sp.gov.br.atividadeavaliativafinal.model.dao.ReservaDao;
import etec.sp.gov.br.atividadeavaliativafinal.model.database.Database;
import etec.sp.gov.br.atividadeavaliativafinal.model.database.DatabaseFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HelloController {
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ReservaDao reservaDao = new ReservaDao();

    @FXML
    private TextField txtNumeroSala;
    @FXML
    private TextField txtCurso;
    @FXML
    private TextField txtDisciplina;
    @FXML
    private TextField txtProfessor;
    @FXML
    private  TextField txtData;
    @FXML
    private  TextField txtHoraEntrada;
    @FXML
    private TextField txtHoraSaida;
    @FXML
    private TextField txtId;
    @FXML
    private ToggleGroup grpTurno;
    @FXML
    private RadioButton rbManha;
    @FXML
    private RadioButton rbTarde;
    @FXML
    private RadioButton rbNoite;
    @FXML
    private CheckBox chkInformatica;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnDeletar;

    private Reserva reserva;

    private ObservableList<Reserva> listReservas;

    @FXML
    private TableView<Reserva>  tbvReservas;
    @FXML
    private  TableColumn<Reserva, Integer> tbcId;
    @FXML
    private TableColumn<Reserva, String> tbcNumeroSala;
    @FXML
    private TableColumn<Reserva, String> tbcCurso;
    @FXML
    private TableColumn<Reserva, String> tbcDisciplina;
    @FXML
    private TableColumn<Reserva, String> tbcProfessor;
    @FXML
    private TableColumn<Reserva, String> tbcData;
    @FXML
    private TableColumn<Reserva, String> tbcHoraEntrada;
    @FXML
    private TableColumn<Reserva, String> tbcHoraSaida;
    @FXML
    private TableColumn<Reserva, String> tbcTurno;
    @FXML
    private TableColumn<Reserva, Boolean> tbcInformatica;

    Integer id = null;





    @FXML
    public void initialize() {
        // Inicializa a ObservableList e a associa à TableView


        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcNumeroSala.setCellValueFactory(new PropertyValueFactory<>("numeroSala"));
        tbcCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        tbcDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        tbcProfessor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        tbcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tbcHoraEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        tbcHoraSaida.setCellValueFactory(new PropertyValueFactory<>("horaSaida"));
        tbcTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        tbcInformatica.setCellValueFactory(new PropertyValueFactory<>("informatica"));

        reservaDao.setConnection(connection);
        tbvReservas.setItems(FXCollections.observableArrayList(reservaDao.getReservas()));


    }
    public void carregarReservas(List<Reserva> reservas) {
        tbvReservas.setItems(FXCollections.observableArrayList(reservas));
    }

    @FXML
    protected void onClickCadastrar() {
        id = null;

        if (txtNumeroSala.getText().equals(" ")) {
            campoVazio("Número da sala está vazio");
            txtNumeroSala.requestFocus();
        } else if (txtCurso.getText().equals("")) {
            campoVazio("O Curso está vazio");
            txtCurso.requestFocus();
        } else if (txtDisciplina.getText().equals("")) {
            campoVazio("A Disciplina está vazia");
            txtDisciplina.requestFocus();
        } else if (txtProfessor.getText().equals("")) {
            campoVazio("O campo Professor está vazio");
            txtProfessor.requestFocus();
        } else if (txtData.getText().equals("")) {
            campoVazio("A data não foi informada");
            txtData.requestFocus();
        } else if (txtHoraEntrada.getText().equals("")) {
            campoVazio("Hora de Entrada não informada");
            txtHoraEntrada.requestFocus();
        } else if (txtHoraSaida.getText().equals("")) {
            campoVazio("Hora de Saída não informada");
            txtHoraSaida.requestFocus();
        } else {
            String turno = rbManha.isSelected() ? "Manhã" : rbTarde.isSelected() ? "Tarde" : "Noite";
            //int id = listReservas.size() + 1;

            reserva = new Reserva(txtNumeroSala.getText(), txtCurso.getText(), txtDisciplina.getText(), txtProfessor.getText(), txtData.getText(), txtHoraEntrada.getText(), txtHoraSaida.getText(), chkInformatica.isSelected(), turno);

        }

        if (reserva.getId() != null){
            txtId.setText(String.valueOf(reserva.getId()));
            id = reserva.getId();
        }

        reservaDao.setConnection(connection);
        if (id != null) {
            reserva.setId(id);
            if (reservaDao.update(reserva)) {
                aviso("Registro Atualizado", "Atualização da Reserva", "Reserva atualizada com sucesso");
            } else {
                aviso("Erro", "Erro ao atualizar a Reserva", "Atualização da Reserva mal sucedido");
            }
        } else {
            if (reservaDao.inserir(reserva)) {
                aviso("Registro Salvo", "Cadastro da Reserva", "Reserva cadastrada com sucesso");
            } else {
                aviso("Erro", "Erro ao cadastrar a Reserva", "Cadastro da Reserva mal sucedido");
            }
        }

        limparCampos();
        initialize();
    }



    private void populaCampos(Reserva rsv){

        txtNumeroSala.setText(rsv.getNumeroSala());
        txtCurso.setText(rsv.getCurso());
        txtDisciplina.setText(rsv.getDisciplina());
        txtProfessor.setText(rsv.getProfessor());
        txtData.setText(rsv.getData());
        txtHoraEntrada.setText(rsv.getHoraEntrada());
        txtHoraSaida.setText(rsv.getHoraSaida());

        if (rsv.getId() != null){
            txtId.setText(String.valueOf(rsv.getId()));
            id = rsv.getId();
        }

        if (rsv.getTurno().equals("Noite")){
            rbNoite.setSelected(true);
            rbTarde.setSelected(false);
            rbManha.setSelected(false);
        } else if (rsv.getTurno().equals("Tarde")) {
            rbNoite.setSelected(false);
            rbTarde.setSelected(true);
            rbManha.setSelected(false);
        }else{
            rbNoite.setSelected(false);
            rbTarde.setSelected(false);
            rbManha.setSelected(true);
        }


        if (rsv.getInformatica()){
            chkInformatica.setSelected(true);
        }else{
            chkInformatica.setSelected(false);
        }
    }

    @FXML
    protected void onClickBuscar() {
        Integer idBuscar;
        try {
            idBuscar = Integer.parseInt(txtCodigo.getText());
        } catch (Exception erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("Erro de Conversão");
            alerta.setContentText("Verifique se foi informado o código corretamente");
            alerta.show();
            return;
        }

        reservaDao.setConnection(connection);
        reserva = reservaDao.getReservaById(idBuscar);

        if (reserva != null && reserva.getId() != null) {
            populaCampos(reserva);
        } else {
            aviso("Buscar reserva", "Busca da Reserva", "Erro ao realizar a busca da reserva");
        }
    }

    @FXML
    protected void onClickDelete(){
        Reserva rsv = new Reserva();
        limparCampos();
        Integer idBuscar;
        Reserva reservaDeletada = null;

        try{
            if (!txtCodigo.getText().isEmpty()) {
                idBuscar = Integer.parseInt(txtCodigo.getText());
            }else if (id == null) {
                aviso("Erro", "Selecione uma reserva antes de excluir.","Erro");
                return;
            }else{
                idBuscar = id;
            }


        }catch (Exception erro){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("Erro de Conversão");
            alerta.setContentText("Verifique se foi informado o código corretamente");
            return;
        }
        reservaDao.setConnection(connection);


        reservaDeletada = reserva;
        if (reservaDao.delete(idBuscar)){
            aviso("Deletar","Deletar Reserva","Reserva da disciplina : "+ reservaDeletada.getDisciplina() + " do Turno da " + reservaDeletada.getTurno() + " deletada com sucesso");
            id=null;
        }else {
            aviso("Deletar","Deletar Reserva","Erro ao deletar a Reserva !!");
        }
        initialize();
    }



    private void limparCampos() {
        txtId.setText("");
        txtNumeroSala.setText("");
        txtCurso.setText("");
        txtDisciplina.setText("");
        txtProfessor.setText("");
        txtData.setText("");
        txtHoraEntrada.setText("");
        txtHoraSaida.setText("");
        rbManha.setSelected(false);
        rbTarde.setSelected(false);
        rbNoite.setSelected(false);
        chkInformatica.setSelected(false);
        txtNumeroSala.requestFocus();
    }


    private void campoVazio(String msg){
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erro");
        alert.setHeaderText("Campo Vasio");
        alert.setContentText(msg);
        alert.show();
        return;

    }
    private void aviso(String title,String hearder,String content){
        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
        aviso.setTitle(title);
        aviso.setHeaderText(hearder);
        aviso.setContentText(content);
        aviso.show();
        return;
    }

    @FXML
    protected void onMouseClick(){
        TablePosition pos = tbvReservas.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        Reserva rev= tbvReservas.getItems().get(row);
        populaCampos(rev);
    }



}