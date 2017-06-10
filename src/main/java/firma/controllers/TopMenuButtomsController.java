package firma.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by   on 2017-06-07.
 */
public class TopMenuButtomsController {

    @FXML
    private ComboBox<String> comboBox;

    public static final String FXML_ADD_EMPLOYEE = "/fxml/AddEmployee.fxml";
    public static final String FXML_TABLE = "/fxml/Table.fxml";
    public static final String FXML_ADD_WYNAGRODZENIE = "/fxml/AddWynagrodzenie.fxml";

    private MainController mainController;

    /**
     * Na poczatku metody tworze liste z Encjami dostepnymi w programie
     */
    public void initialize(){
        List<String> arrayList =  new ArrayList<String>();
        arrayList.add(new String("Pracownik"));
        arrayList.add(new String("Wynagrodzenie"));
        arrayList.add(new String("Umowa"));

        comboBox.getItems().addAll(arrayList);

    }

    /**
     * Funkcja "przekazuje sterowanie nad menu przycisków
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openTable() {
       // mainController.setCenter(FXML_TABLE);
    }

    @FXML
    public void openSortProperties() {
        String cos = comboBox.getSelectionModel().getSelectedItem();
        System.out.println(cos);

    }

    @FXML
    public void openSearchByPhraze() {

        String numberOfRecords = new String();
        try {
            Connection connection = null;
            String sql= "Select count(*) from wynagrodzenie";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            //for (int i=1;i<=rsmd.getColumnCount();i++)
           // {
            //    System.out.println(rsmd.getColumnLabel(i));
            //}


            while (rs.next())
            {
                for (int i=1;i<=rsmd.getColumnCount();i++)
                {
                    System.out.println(rs.getString(i));
                    numberOfRecords = rs.getString(i);
                }
            }
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
        }
    }

    @FXML
    public void openAddTable() {
        if((comboBox.getSelectionModel().getSelectedItem()).equals("Wynagrodzenie"))
        mainController.setCenter(FXML_ADD_WYNAGRODZENIE);
        if((comboBox.getSelectionModel().getSelectedItem()).equals("Pracownik"))
        mainController.setCenter(FXML_ADD_EMPLOYEE);
    }
}
