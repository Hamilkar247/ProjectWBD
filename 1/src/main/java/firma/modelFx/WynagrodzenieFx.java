package firma.modelFx;

import javafx.beans.property.*;
import javafx.css.SimpleStyleableObjectProperty;

import java.time.LocalDate;

/**
 * Created by   on 2017-06-08.
 */
public class WynagrodzenieFx {
    private IntegerProperty id_wynagrodzenie = new SimpleIntegerProperty();
    private StringProperty data_wyplaty = new SimpleStringProperty();
    private IntegerProperty kwota_bazowa = new SimpleIntegerProperty();
    private IntegerProperty przelicznik_etatu = new SimpleIntegerProperty();
    private IntegerProperty przelicznik_stanowiska = new SimpleIntegerProperty();
    private IntegerProperty premia = new SimpleIntegerProperty();
    private IntegerProperty id_pracownik = new SimpleIntegerProperty();

    public WynagrodzenieFx() {
    }

    public int getId_wynagrodzenie() {
        return id_wynagrodzenie.get();
    }

    public IntegerProperty id_wynagrodzenieProperty() {
        return id_wynagrodzenie;
    }

    public void setId_wynagrodzenie(int id_wynagrodzenie) {
        this.id_wynagrodzenie.set(id_wynagrodzenie);
    }

    public String getData_wyplaty() {
        return data_wyplaty.get();
    }

    public StringProperty data_wyplatyProperty() {
        return data_wyplaty;
    }

    public void setData_wyplaty(String data_wyplaty) {
        this.data_wyplaty.set(data_wyplaty);
    }

    public int getKwota_bazowa() {
        return kwota_bazowa.get();
    }

    public IntegerProperty kwota_bazowaProperty() {
        return kwota_bazowa;
    }

    public void setKwota_bazowa(int kwota_bazowa) {
        this.kwota_bazowa.set(kwota_bazowa);
    }

    public int getPrzelicznik_etatu() {
        return przelicznik_etatu.get();
    }

    public IntegerProperty przelicznik_etatuProperty() {
        return przelicznik_etatu;
    }

    public void setPrzelicznik_etatu(int przelicznik_etatu) {
        this.przelicznik_etatu.set(przelicznik_etatu);
    }

    public int getPrzelicznik_stanowiska() {
        return przelicznik_stanowiska.get();
    }

    public IntegerProperty przelicznik_stanowiskaProperty() {
        return przelicznik_stanowiska;
    }

    public void setPrzelicznik_stanowiska(int przelicznik_stanowiska) {
        this.przelicznik_stanowiska.set(przelicznik_stanowiska);
    }

    public int getPremia() {
        return premia.get();
    }

    public IntegerProperty premiaProperty() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia.set(premia);
    }

    public int getId_pracownik() {
        return id_pracownik.get();
    }

    public IntegerProperty id_pracownikProperty() {
        return id_pracownik;
    }

    public void setId_pracownik(int id_pracownik) {
        this.id_pracownik.set(id_pracownik);
    }

    @Override
    public String toString() {
        return "WynagrodzenieFx{" +
                "id_wynagrodzenie=" + id_wynagrodzenie +
                ", data_wyplaty=" + data_wyplaty +
                ", kwota_bazowa=" + kwota_bazowa +
                ", przelicznik_etatu=" + przelicznik_etatu +
                ", przelicznik_stanowiska=" + przelicznik_stanowiska +
                ", premia=" + premia +
                ", id_pracownik=" + id_pracownik +
                '}';
    }
}
