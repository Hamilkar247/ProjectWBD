package firma.modelFx;


import firma.utils.DialogsUnits;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;
import java.sql.ResultSet;

//Class.forName("oracle.jdbc.Oracle.Driver");

/**
 * Created by   on 2017-06-09.
 */
public class WynagrodzenieModel {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:";
    private static final String USER = "SYSTEM";
    private static final String PASS = "oracle";

    public void saveWynagrodzenieInDataBase(String data_wyplaty, String kwota_bazowa, String przelicznik_etatu
            , String przelicznik_stanowiska, String premia, String id_pracownik) {

        int numberOfRecords=0;
        /**
         * Niżej blok try catch w kótrym jest wysłane polecenie select count(*) from wynagrodzenie które zwraca aktualna liczbę krotek
         * w relacji po to by móc dodać kolejną krotkę o odpowiednim id
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
            rs.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output console");
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
}
