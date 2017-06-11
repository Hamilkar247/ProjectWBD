package firma.controllers;

import firma.modelFx.UmowaFx;
import firma.modelFx.UmowaModel;
import firma.modelFx.WynagrodzenieFx;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Matball on 2017-06-11.
 */
public class TableUmowaController {

    @FXML
    private TableView<UmowaFx> umowaTableViev;
    @FXML
    private TableColumn<UmowaFx, Number > id_umowyColumn;
    @FXML
    private TableColumn<UmowaFx, String> data_zawarciaColumn;
    @FXML
    private TableColumn<UmowaFx, String> data_koncaColumn;
    @FXML
    private TableColumn<UmowaFx, String> opisColumn;
    @FXML
    private TableColumn<UmowaFx, Number> znizka_na_telefonColumn;
    @FXML
    private TableColumn<UmowaFx, Number> kara_za_zerwanieColumn;
    @FXML
    private TableColumn<UmowaFx, Boolean> opcjonalny_telefonColumn;
    @FXML
    private TableColumn<UmowaFx, Number> id_centralaColumn;
    @FXML
    private TableColumn<UmowaFx, Number> id_pracownikColumn;
    @FXML
    private TableColumn<UmowaFx, Number> id_klientaColumn;

    private UmowaModel umowaModel;

    public void initialize(){
        this.umowaModel = new UmowaModel();
        this.umowaModel.init();
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy pracownik fx która będzie wysietlana w tabeli.
         */
        this.umowaTableViev.setItems(this.umowaModel.getUmowaFxObservableList());
        this.id_umowyColumn.setCellValueFactory(cellData -> cellData.getValue().id_umowyProperty());
        this.data_zawarciaColumn.setCellValueFactory(cellData -> cellData.getValue().data_zawarciaProperty());
        this.data_koncaColumn.setCellValueFactory(cellData -> cellData.getValue().data_koncaProperty());
        this.opisColumn.setCellValueFactory(cellData -> cellData.getValue().opisProperty());
        this.znizka_na_telefonColumn.setCellValueFactory(cellData -> cellData.getValue().znizka_na_telefonProperty());
        this.kara_za_zerwanieColumn.setCellValueFactory(cellData -> cellData.getValue().kara_za_zerwanieProperty());
        this.opcjonalny_telefonColumn.setCellValueFactory(cellData -> cellData.getValue().opcjonalny_telefonProperty());
        this.id_centralaColumn.setCellValueFactory(cellData -> cellData.getValue().id_centralaProperty());
        this.id_pracownikColumn.setCellValueFactory(cellData -> cellData.getValue().id_pracownikProperty());
        this.id_klientaColumn.setCellValueFactory(cellData -> cellData.getValue().id_klientaProperty());


    }

}
