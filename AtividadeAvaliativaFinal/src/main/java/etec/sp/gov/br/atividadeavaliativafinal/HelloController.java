package etec.sp.gov.br.atividadeavaliativafinal;

import etec.sp.gov.br.atividadeavaliativafinal.model.Reserva;
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

    private Reserva reserva;


}