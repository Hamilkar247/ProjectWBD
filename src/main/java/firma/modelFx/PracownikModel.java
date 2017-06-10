package firma.modelFx;

import firma.utils.DialogsUnits;

import java.sql.*;

/**
 * Created by   on 2017-06-08.
 */
public class PracownikModel {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:";
    private static final String USER = "SYSTEM";
    private static final String PASS = "oracle";

    public void savePracownikInDateBase(String imie_pracownika,String nazwisko_pracownika,String stanowisko_pracownika, String plec_pracownika
            ,String pesel_pracownika,String data_zatrudnienia_pracownika,String data_urodzenia_pracownika,String czy_pracuje_aktualnie
            ,String nr_konta_pracownika,String nr_telefonu_pracownika,String email_pracownika,String id_centrala
            ,String id_placowka_sprzedarzy,String id_placowka_naprawacza){

        int numberOfRecord=0;
        /**
         * Niżej blok try catch w kótrym jest wysłane polecenie select count(*) from wynagrodzenie które zwraca aktualna liczbę krotek
         * w relacji po to by móc dodać kolejną krotkę o odpowiednim id
         */
        try{
            Connection connection =null;
            String sql= "Select count(*) from pracownik";
            System.out.println(sql);

            connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:","SYSTEM","oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Petla ktora przechodzi przez wszystkie krotki relacji zlicza ich liczne i zapisuje ja w numberOfRecords
            while(rs.next()){
                for(int i=0;i<=rsmd.getColumnCount();i++){
                    numberOfRecord = rs.getInt(i);
                }
            }

            rs.close();
            stmt.close();
            connection.close();


        }catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output console");
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
            sql = "insert into pracownik values ("+(numberOfRecord+1)+","+imie_pracownika+","+nazwisko_pracownika+","+stanowisko_pracownika+","+plec_pracownika
                +","+pesel_pracownika+",'"+data_zatrudnienia_pracownika+"','"+data_urodzenia_pracownika+"',"+czy_pracuje_aktualnie+"'"+nr_konta_pracownika
                +","+nr_telefonu_pracownika+","+email_pracownika+","+id_centrala+","+id_placowka_sprzedarzy+","+id_placowka_naprawacza+")";
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
}
