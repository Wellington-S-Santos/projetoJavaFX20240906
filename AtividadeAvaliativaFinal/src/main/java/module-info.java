module etec.sp.gov.br.atividadeavaliativafinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens etec.sp.gov.br.atividadeavaliativafinal to javafx.fxml;
    exports etec.sp.gov.br.atividadeavaliativafinal;
}