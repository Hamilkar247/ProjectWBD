package firma.controllers;

import firma.database.models.Wynagrodzenie;
import firma.modelFx.WynagrodzenieFx;
import firma.modelFx.WynagrodzenieModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * Created by Matball on 2017-06-11.
 */
public class TableWynagrodzenieController {

    @FXML
    private TableView<WynagrodzenieFx> wynagrodzenieTableView;
    @FXML
    private TableColumn<WynagrodzenieFx, Number> id_wynagrodzenieColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> data_wyplatyColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, Number>kwota_bazowaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, Number> przelicznik_etatuColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, Number> przelicznik_stanowiskaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, Number> premiaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, Number> id_pracownikColumn;

    private WynagrodzenieModel wynagrodzenieModel;

    public void initialize(){
        this.wynagrodzenieModel = new WynagrodzenieModel();
        this.wynagrodzenieModel.init();
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy pracownik fx która będzie wysietlana w tabeli.
         */
        this.wynagrodzenieTableView.setItems(this.wynagrodzenieModel.getWynagrodzenieFxObservableList());

        this.id_wynagrodzenieColumn.setCellValueFactory(cellData -> cellData.getValue().id_wynagrodzenieProperty());
        this.data_wyplatyColumn.setCellValueFactory(cellData -> cellData.getValue().data_wyplatyProperty());
        this.kwota_bazowaColumn.setCellValueFactory(cellData -> cellData.getValue().kwota_bazowaProperty());
        this.przelicznik_etatuColumn.setCellValueFactory(cellData -> cellData.getValue().przelicznik_etatuProperty());
        this.przelicznik_stanowiskaColumn.setCellValueFactory(cellData -> cellData.getValue().przelicznik_etatuProperty());
        this.premiaColumn.setCellValueFactory(cellData -> cellData.getValue().premiaProperty());
    }

}
