package firma.modelFx;


import firma.utils.DialogsUnits;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Class.forName("oracle.jdbc.Oracle.Driver");

/**
 * Created by   on 2017-06-09.
 */
public class WynagrodzenieModel {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:";
    private static final String USER = "SYSTEM";
    private static final String PASS = "oracle";

    private ObservableList<WynagrodzenieFx> wynagrodzenieFxObservableList = FXCollections.observableArrayList();

    /**
     * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
     * observable list który jest zbindowany z tabelą w TableEmployee
     */
    public void init(){
        /**
         *  odczytanie danych o wynagrodzeniu i przekazanie ich do listy a tę liste do tabeli
         */
        List<WynagrodzenieFx> wynagrodzenieFxList= new ArrayList<WynagrodzenieFx>();

        /**
         * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
         * observable list który jest zbindowany z tabelą w TableEmployee
         */
        try {
            Connection connection = null;
            String sql = "Select * from wynagrodzenie";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();


            while (rs.next()) {
                WynagrodzenieFx wynagrodzenieFxTmp = new WynagrodzenieFx();
                wynagrodzenieFxTmp.setId_wynagrodzenie(rs.getInt("id_wynagrodzenie"));
                wynagrodzenieFxTmp.setData_wyplaty(rs.getString("data_zaplaty"));
                wynagrodzenieFxTmp.setKwota_bazowa(rs.getInt("kwota_bazowa"));
                wynagrodzenieFxTmp.setPrzelicznik_etatu(rs.getInt("przelicznik_etatu"));
                wynagrodzenieFxTmp.setPrzelicznik_stanowiska(rs.getInt("przelicznik_stanowiska"));
                wynagrodzenieFxTmp.setPremia(rs.getInt("premia"));
                wynagrodzenieFxTmp.setId_pracownik(rs.getInt("id_pracownik"));

                wynagrodzenieFxList.add(wynagrodzenieFxTmp);
            }



        }catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());
        }


        //Przekazanie listy do listy obserwowalniej powiazanej z tabela
        this.wynagrodzenieFxObservableList.addAll(wynagrodzenieFxList);

    }


    public void saveWynagrodzenieInDataBase(String data_wyplaty, String kwota_bazowa, String przelicznik_etatu, String przelicznik_stanowiska, String premia, String id_pracownik) {
        int numberOfRecords=0;

        /**
         * Niżej blok try catch w kótrym jest wysłane polecenie select count(*) from wynagrodzenie które zwraca aktualna liczbę krotek
         * w relacji poto by móc dodać kolejną krotkę o odpowiednim id
         */
        try {
            Connection connection = null;
            String sql= "Select count(*) from wynagrodzenie";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Pętla która przechodzi przez wszystkie krotki relacji zlicza ich licznę i zapisuję ją numberOfRecords
            while (rs.next())
            {
                for (int i=1;i<=rsmd.getColumnCount();i++)
                {
                    numberOfRecords = rs.getInt(i);
                }
            }
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
        }
        System.out.println("liczba rekordów: "+numberOfRecords);
        /**
         * niżej blok try catch w którym następuje wysłanie polecenia insert do bazy danych w kórym jest wstawiany rekord którego pola są wczytywane
         * z odpowiednich textField w AddWynagrodzenie.fxml pole id_wynagrodzenie jest ustawiane automatycznie poprzez wcześniejsze zapytanie do bazy
         * danych (patrz wyżej) i zczytanie aktualnej liczby rekordów a następnie dodanie rekordu o id o jeden większym
         */
        try {

                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
                Statement stmt = conn.createStatement();

                String sql;
                sql = "insert into wynagrodzenie values ("+(numberOfRecords+1)+",'"+data_wyplaty+"',"+kwota_bazowa+","+przelicznik_etatu+","+przelicznik_stanowiska+","+premia+","+id_pracownik+")";
                System.out.println(sql);

                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();
                DialogsUnits.acceptDialog();
            }
            catch (SQLException e){
                System.out.println("Connection to DataBase failed ! Check output consloe");
                DialogsUnits.errorDialog(e.getMessage());
            }
    }

    public ObservableList<WynagrodzenieFx> getWynagrodzenieFxObservableList(){return wynagrodzenieFxObservableList;}

    public void setWynagrodzenieFxObservableList(ObservableList<WynagrodzenieFx> wynagrodzenieFxObservableList) {
        this.wynagrodzenieFxObservableList = wynagrodzenieFxObservableList;
    }
}
