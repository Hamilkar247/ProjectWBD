package firma.modelFx;

import firma.utils.DialogsUnits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matball on 2017-06-10.
 */
public class UmowaModel {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:";
    private static final String USER = "SYSTEM";
    private static final String PASS = "oracle";

    private ObservableList<UmowaFx> umowaFxObservableList = FXCollections.observableArrayList();


    /**
     * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
     * observable list który jest zbindowany z tabelą w TableEmployee
     */
    public void init(){
        /**
         *  odczytanie danych o wynagrodzeniu i przekazanie ich do listy a tę liste do tabeli
         */
        List<UmowaFx> umowaFxList=new ArrayList<UmowaFx>();
        /**
         * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
         * observable list który jest zbindowany z tabelą w TableEmployee
         */
        try {
            Connection connection = null;
            String sql = "Select * from umowa";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();


            while (rs.next()) {
                UmowaFx umowaFxTmp = new UmowaFx();
                umowaFxTmp.setId_umowy(rs.getInt("id_umowy"));
                umowaFxTmp.setData_zawarcia(rs.getString("data_zawarcia"));
                umowaFxTmp.setData_konca(rs.getString("data_konca"));
                umowaFxTmp.setOpis(rs.getString("opis"));
                umowaFxTmp.setZnizka_na_telefon(rs.getInt("znizka_na_telefon"));
                umowaFxTmp.setKara_za_zerwanie(rs.getInt("kara_za_zerwanie"));

                umowaFxTmp.setOpcjonalny_telefon(rs.getBoolean("opcjonalny_telefon"));//jak nie dziala to sprobuj opcojnalny_telefon
                umowaFxTmp.setId_centrala(rs.getInt("id_centrala"));
                umowaFxTmp.setId_pracownik(rs.getInt("id_pracownik"));
                umowaFxTmp.setId_klienta(rs.getInt("id_klienta"));

                umowaFxList.add(umowaFxTmp);
            }



        }catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());
        }


        //Przekazanie listy do listy obserwowalniej powiazanej z tabela
        this.umowaFxObservableList.addAll(umowaFxList);
    }

    public void saveUmowaInDateBase(String data_zawarcia_umowa,String data_konca_umowa,String opis_umowa,String znizka_na_telefon
            ,String kara_za_zerwanie_umowa,String opcjonalny_telefon_komorka,String id_centrala_umowa,String id_pracownik,String id_klienta){

        int numberOfRecord=0;
        /**
         * Niżej blok try catch w kótrym jest wysłane polecenie select count(*) from wynagrodzenie które zwraca aktualna liczbę krotek
         * w relacji po to by móc dodać kolejną krotkę o odpowiednim id
         */
        try {
            Connection connection = null;
            String sql= "Select count(*) from umowa";
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
                    numberOfRecord = rs.getInt(i);
                }
            }
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());
        }
        System.out.println("liczba rekordów: "+numberOfRecord);

        /**
         * niżej blok try catch w którym następuje wysłanie polecenia insert do bazy danych w kórym jest wstawiany rekord którego pola są wczytywane
         * z odpowiednich textField w AddWynagrodzenie.fxml pole id_wynagrodzenie jest ustawiane automatycznie poprzez wcześniejsze zapytanie do bazy
         * danych (patrz wyżej) i zczytanie aktualnej liczby rekordów a następnie dodanie rekordu o id o jeden większym
         */
        try{


            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = conn.createStatement();

            String sql;
            sql= "insert into umowa values ("+(numberOfRecord+1)+",'"+data_zawarcia_umowa+"','" +data_konca_umowa+"','"+opis_umowa+"',"+znizka_na_telefon
                    +","+kara_za_zerwanie_umowa+","+opcjonalny_telefon_komorka+","+id_centrala_umowa+","+id_pracownik+","+id_klienta+")";


            System.out.println(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            DialogsUnits.acceptDialog();

        }catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());
        }
    }

    public ObservableList<UmowaFx> getUmowaFxObservableList() {
        return umowaFxObservableList;
    }

    public void setUmowaFxObservableList(ObservableList<UmowaFx> umowaFxObservableList) {
        this.umowaFxObservableList = umowaFxObservableList;
    }
}
