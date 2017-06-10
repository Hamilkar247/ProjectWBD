package firma.controllers;

import firma.modelFx.PracownikModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Created by Matball on 2017-06-10.
 */
public class AddEmployeeController {

    /** Left VBox */
    @FXML
    private TextField imie_pracownikaTF;
    @FXML
    private TextField nazwisko_pracownikaTF;
    @FXML
    private TextField stanowisko_pracownikaTF;
    @FXML
    private TextField plec_pracownikaTF;
    @FXML
    private TextField pesel_pracownikaTF;
    @FXML
    private TextField data_zatrudnienia_pracownikaTF;
    @FXML
    private TextField nr_konta_pracownikaTF;

    /** Right VBox */
    @FXML
    private TextField nr_telefonu_pracownikaTF;
    @FXML
    private TextField email_pracownikaTF;
    @FXML
    private CheckBox  czy_pracuje_aktualnieCB;
    @FXML
    private TextField id_centrala_pracownikaTF;
    @FXML
    private TextField id_placowka_sprzedarzy_pracownikaTF;
    @FXML
    private TextField id_placowka_naprawcza_idTF;


    private PracownikModel pracownikModel;

    @FXML
    public void initialize() {this.pracownikModel = new PracownikModel();}


    @FXML
    void AddEmployee(){

        /**Left VB */
        String imiePracownika=imie_pracownikaTF.getText();
        String nazwiskoPracownika=nazwisko_pracownikaTF.getText();
        String stanowiskoPracownika=stanowisko_pracownikaTF.getText();
        String plecPracownika=plec_pracownikaTF.getText();
        String peselPracownika=pesel_pracownikaTF.getText();
        String dataZatrudnianiaPracownika=data_zatrudnienia_pracownikaTF.getText();
        String nrKontaPracownika=nr_konta_pracownikaTF.getText();

        /**Right VB */
        String nrTelefonuPracownika=nr_telefonu_pracownikaTF.getText();
        String emailPracownika=email_pracownikaTF.getText();

        String czyPracujeAktualnie="0";
        if(czy_pracuje_aktualnieCB.isSelected()==true){czyPracujeAktualnie="1";}
        else{czyPracujeAktualnie="0";}

        String idCentralaPracownika=id_centrala_pracownikaTF.getText();
        String idPlacowkaSprzedarzyPracownika=id_placowka_sprzedarzy_pracownikaTF.getText();
        String idPlacowkaNaprawcza=id_placowka_naprawcza_idTF.getText();


        String dataUrodzeniaPracownika="1948-08-03"; // tymczasowo - data urodzin macierewicza

        //String data_urodzenia - w sumie mialem robic metode ktora to bierze po prostu z pesela, ale
        // okazalo sie ze potencalne dzieciaki maja jakies powalone pesele
        //http://polki.pl/praca-i-finanse/porady-prawne,pesel-dzieci-urodzonych-od-2000-roku,10042611,artykul.html


        pracownikModel.savePracownikInDateBase(imiePracownika,nazwiskoPracownika,stanowiskoPracownika,plecPracownika,peselPracownika,dataZatrudnianiaPracownika
                    ,dataUrodzeniaPracownika,czyPracujeAktualnie,nrKontaPracownika,nrTelefonuPracownika,emailPracownika,idCentralaPracownika
                    ,idPlacowkaSprzedarzyPracownika,idPlacowkaNaprawcza);

    }

}
