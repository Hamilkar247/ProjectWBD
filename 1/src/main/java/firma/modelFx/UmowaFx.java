package firma.modelFx;

import javafx.beans.property.*;
import javafx.css.SimpleStyleableObjectProperty;

import java.time.LocalDate;

/**
 * Created by   on 2017-06-08.
 */
public class UmowaFx {
    private IntegerProperty id_umowy = new SimpleIntegerProperty();
    private StringProperty data_zawarcia = new SimpleStringProperty();
    private StringProperty data_konca = new SimpleStringProperty();
    private StringProperty opis = new SimpleStringProperty();
    private IntegerProperty znizka_na_telefon = new SimpleIntegerProperty();
    private IntegerProperty kara_za_zerwanie = new SimpleIntegerProperty();
    private BooleanProperty opcojnalny_telefon = new SimpleBooleanProperty();
    private IntegerProperty id_centrala = new SimpleIntegerProperty();
    private IntegerProperty id_pracownik = new SimpleIntegerProperty();
    private IntegerProperty id_klienta = new SimpleIntegerProperty();

    public UmowaFx() {
    }

    public int getId_umowy() {
        return id_umowy.get();
    }

    public IntegerProperty id_umowyProperty() {
        return id_umowy;
    }

    public void setId_umowy(int id_umowy) {
        this.id_umowy.set(id_umowy);
    }

    public String getData_zawarcia() {
        return data_zawarcia.get();
    }

    public StringProperty data_zawarciaProperty() {
        return data_zawarcia;
    }

    public void setData_zawarcia(String data_zawarcia) {
        this.data_zawarcia.set(data_zawarcia);
    }

    public String getData_konca() {
        return data_konca.get();
    }

    public StringProperty data_koncaProperty() {
        return data_konca;
    }

    public void setData_konca(String data_konca) {
        this.data_konca.set(data_konca);
    }

    public String getOpis() {
        return opis.get();
    }

    public StringProperty opisProperty() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }

    public int getZnizka_na_telefon() {
        return znizka_na_telefon.get();
    }

    public IntegerProperty znizka_na_telefonProperty() {
        return znizka_na_telefon;
    }

    public void setZnizka_na_telefon(int znizka_na_telefon) {
        this.znizka_na_telefon.set(znizka_na_telefon);
    }

    public int getKara_za_zerwanie() {
        return kara_za_zerwanie.get();
    }

    public IntegerProperty kara_za_zerwanieProperty() {
        return kara_za_zerwanie;
    }

    public void setKara_za_zerwanie(int kara_za_zerwanie) {
        this.kara_za_zerwanie.set(kara_za_zerwanie);
    }

    public boolean isOpcojnalny_telefon() {
        return opcojnalny_telefon.get();
    }

    public BooleanProperty opcojnalny_telefonProperty() {
        return opcojnalny_telefon;
    }

    public void setOpcojnalny_telefon(boolean opcojnalny_telefon) {
        this.opcojnalny_telefon.set(opcojnalny_telefon);
    }

    public int getId_centrala() {
        return id_centrala.get();
    }

    public IntegerProperty id_centralaProperty() {
        return id_centrala;
    }

    public void setId_centrala(int id_centrala) {
        this.id_centrala.set(id_centrala);
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

    public int getId_klienta() {
        return id_klienta.get();
    }

    public IntegerProperty id_klientaProperty() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta.set(id_klienta);
    }

    @Override
    public String toString() {
        return "UmowaFx{" +
                "id_umowy=" + id_umowy +
                ", data_zawarcia=" + data_zawarcia +
                ", data_konca=" + data_konca +
                ", opis=" + opis +
                ", znizka_na_telefon=" + znizka_na_telefon +
                ", kara_za_zerwanie=" + kara_za_zerwanie +
                ", opcojnalny_telefon=" + opcojnalny_telefon +
                ", id_centrala=" + id_centrala +
                ", id_pracownik=" + id_pracownik +
                ", id_klienta=" + id_klienta +
                '}';
    }
}

