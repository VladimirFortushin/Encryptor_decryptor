package javaFx;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

import encryptor.Reader;
import encryptor.Writer;
import files.FileCreator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import language.Eng;
import language.Language;
import language.Rus;

public class Controller {

    private String operation;
    private String filePath;
    private String filePathInstance;
    private Integer key;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField filePathFx;

    @FXML
    public String getFilePathFx() {
        return String.valueOf(filePathFx);
    }

    @FXML
    private TextField keyFx;

    public int getKeyFx() {
        return Integer.parseInt(String.valueOf(keyFx));
    }

    @FXML
    private ChoiceBox<String> operations;

    @FXML
    private void getOperation(MouseEvent event){
        String operation = operations.getSelectionModel().getSelectedItem();
    }


    @FXML
    private Button start;

    @FXML
    void initialize() {

        operations.getItems().addAll("encode", "decode", "bruteForce");


        operation = operations.getValue();
        System.out.println(operation);
        filePath = getFilePathFx();
        System.out.println(filePath);
        key = getKeyFx();
        System.out.println(key);



    }

}
