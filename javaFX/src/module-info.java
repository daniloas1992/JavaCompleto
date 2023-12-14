//Project -> Propertes -> Java Build Path -> Libraries -> Add Lbrary -> JRE System Library -> Execution environment -> JavaSE-11(jre).
module exerciciosfx {
	
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires org.controlsfx.controls;
	
	opens basico;
	opens layout;
	opens fxml;
	
}