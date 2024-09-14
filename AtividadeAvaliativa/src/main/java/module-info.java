module etec.sp.gov.br.atividadeavaliativa {
    requires javafx.controls;
    requires javafx.fxml;


    opens etec.sp.gov.br.atividadeavaliativa to javafx.fxml;
    exports etec.sp.gov.br.atividadeavaliativa;
}