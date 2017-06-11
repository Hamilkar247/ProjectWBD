package firma.controllers;

import firma.modelFx.PracownikFx;
import firma.modelFx.PracownikModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by   on 2017-06-10.
 */
public class TableEmployeeController {
    @FXML
    private TableView<PracownikFx> employeeTableViev;
    @FXML
    private TableColumn<PracownikFx, Number> id_pracownikColumn;
    @FXML
    private TableColumn<PracownikFx, String> imieColumn;
    @FXML
    private TableColumn<PracownikFx, String> nazwiskoColumn;
    @FXML
    private TableColumn<PracownikFx, String> stanowiskoColumn;
    @FXML
    private TableColumn<PracownikFx, String> plecColumn;
    @FXML
    private TableColumn<PracownikFx, String> peselColumn;
    @FXML
    private TableColumn<PracownikFx, String> data_zatrudnieniaColumn;
    @FXML
    private TableColumn<PracownikFx, String> data_urodzeniaColumn;
    @FXML
    private TableColumn<PracownikFx, Boolean> czy_pracuje_aktualnieColumn;
    @FXML
    private TableColumn<PracownikFx, String> nr_kataColumn;
    @FXML
    private TableColumn<PracownikFx, String> nr_telefonuColumn;
    @FXML
    private TableColumn<PracownikFx, String> emialColumn;
    @FXML
    private TableColumn<PracownikFx, Number> id_centralaColumn;
    @FXML
    private TableColumn<PracownikFx, Number> id_placowak_sprzedarzyColumn;
    @FXML
    private TableColumn<PracownikFx, Number> id_placowka_naprawczaColumn;

    private PracownikModel pracownikModel;

    public void initialize(){
        this.pracownikModel = new PracownikModel();
        this.pracownikModel.init(); // metoda z klasy pracownik model która inicjlizuje dane w tabeli pobrane z bazy danych
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy pracownik fx która będzie wysietlana w tabeli.
         */
        this.employeeTableViev.setItems(this.pracownikModel.getPracownikFxObservableList());
        this.id_pracownikColumn.setCellValueFactory(cellData -> cellData.getValue().id_pracownikProperty());
        this.imieColumn.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        this.nazwiskoColumn.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        this.stanowiskoColumn.setCellValueFactory(cellData -> cellData.getValue().stanowiskoProperty());
        this.plecColumn.setCellValueFactory(cellData -> cellData.getValue().plecProperty());
        this.peselColumn.setCellValueFactory(cellData -> cellData.getValue().peselProperty());
        this.data_zatrudnieniaColumn.setCellValueFactory(cellData -> cellData.getValue().data_zatrudnieniaProperty());
        this.data_urodzeniaColumn.setCellValueFactory(cellData -> cellData.getValue().data_urodzeniaProperty());
        this.czy_pracuje_aktualnieColumn.setCellValueFactory(cellData -> cellData.getValue().czy_pracuje_aktualnieProperty());
        this.nr_kataColumn.setCellValueFactory(cellData -> cellData.getValue().nr_kontaProperty());
        this.nr_telefonuColumn.setCellValueFactory(cellData -> cellData.getValue().nr_telefonuProperty());
        this.emialColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        this.id_centralaColumn.setCellValueFactory(cellData -> cellData.getValue().id_centralaProperty());
        this.id_placowak_sprzedarzyColumn.setCellValueFactory(cellData -> cellData.getValue().id_placowka_sprzedarzyProperty());
        this.id_placowka_naprawczaColumn.setCellValueFactory(cellData -> cellData.getValue().id_placowka_naprawczaProperty());
    }
}
