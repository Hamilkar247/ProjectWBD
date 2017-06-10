package firma;

import firma.utils.FxmlUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by   on 2017-06-07.
 */
public class Main extends Application{


    public static final String BORDER_PANEL_MAIN_FXML = "/fxml/BorderPanelMain.fxml";

    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANEL_MAIN_FXML);


        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primaryStage.show();
    }
}
