package etec.sp.gov.br.atividadeavaliativafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
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
    private Button btnBuscar;
    @FXML
    private Button btnDeletar;

    public TextField getTxtNumeroSala() {
        return txtNumeroSala;
    }

    public void setTxtNumeroSala(TextField txtNumeroSala) {
        this.txtNumeroSala = txtNumeroSala;
    }

    public TextField getTxtCurso() {
        return txtCurso;
    }

    public void setTxtCurso(TextField txtCurso) {
        this.txtCurso = txtCurso;
    }

    public TextField getTxtDisciplina() {
        return txtDisciplina;
    }

    public void setTxtDisciplina(TextField txtDisciplina) {
        this.txtDisciplina = txtDisciplina;
    }

    public TextField getTxtProfessor() {
        return txtProfessor;
    }

    public void setTxtProfessor(TextField txtProfessor) {
        this.txtProfessor = txtProfessor;
    }

    public TextField getTxtData() {
        return txtData;
    }

    public void setTxtData(TextField txtData) {
        this.txtData = txtData;
    }

    public TextField getTxtHoraEntrada() {
        return txtHoraEntrada;
    }

    public void setTxtHoraEntrada(TextField txtHoraEntrada) {
        this.txtHoraEntrada = txtHoraEntrada;
    }

    public TextField getTxtHoraSaida() {
        return txtHoraSaida;
    }

    public void setTxtHoraSaida(TextField txtHoraSaida) {
        this.txtHoraSaida = txtHoraSaida;
    }

    public RadioButton getRbManha() {
        return rbManha;
    }

    public void setRbManha(RadioButton rbManha) {
        this.rbManha = rbManha;
    }

    public RadioButton getRbTarde() {
        return rbTarde;
    }

    public void setRbTarde(RadioButton rbTarde) {
        this.rbTarde = rbTarde;
    }

    public RadioButton getRbNoite() {
        return rbNoite;
    }

    public void setRbNoite(RadioButton rbNoite) {
        this.rbNoite = rbNoite;
    }

    public CheckBox getChkInformatica() {
        return chkInformatica;
    }

    public void setChkInformatica(CheckBox chkInformatica) {
        this.chkInformatica = chkInformatica;
    }

    public TextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(TextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public Button getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(Button btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public Button getBtnDeletar() {
        return btnDeletar;
    }

    public void setBtnDeletar(Button btnDeletar) {
        this.btnDeletar = btnDeletar;
    }
}