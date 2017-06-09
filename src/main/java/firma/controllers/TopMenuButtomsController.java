package firma.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by   on 2017-06-07.
 */
public class TopMenuButtomsController {


    public static final String FXML_TABLE = "/fxml/Table.fxml";
    public static final String FXML_ADD_WYNAGRODZENIE = "/fxml/AddWynagrodzenie.fxml";
    private MainController mainController;
    /**
     * Funkcja "przekazuje sterowanie nad menu przycisków
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openTable() {
       // mainController.setCenter(FXML_TABLE);
    }

    @FXML
    public void openSortProperties() {
    }

    @FXML
    public void openSearchByPhraze() {
    }

    @FXML
    public void openAddTable() {
        mainController.setLeft(FXML_ADD_WYNAGRODZENIE);
    }
}
