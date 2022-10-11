package javaFx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.ResourceBundle;

import encryptor.Reader;
import encryptor.Writer;
import files.FileCreator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import language.Eng;
import language.Language;
import language.Rus;


public class Controller {

    private String operation;
    private String filePath;
    private String filePathInstance;
    private Integer key;
    private String leftText;
    private String rightText;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField filePathFx;
    @FXML
    private String getFilePath(){
        return String.valueOf(filePathFx.getCharacters());
    }
    @FXML
    private String getFilePathInstance(){
        return String.valueOf(keyFx.getCharacters());
    }


    @FXML
    private TextArea leftArea;

    @FXML
    private TextArea rightArea;
    @FXML
    private Button start;


    @FXML
    private String getleftText(){
        return leftArea.getText();
    }

    @FXML
    private String getRightText(){
        return rightArea.getText();
    }

    @FXML
    private TextField keyFx;

    @FXML
    private int setKey(){
        return Integer.parseInt(String.valueOf(keyFx.getCharacters()));
    }

    @FXML
    private void fillLeftArea(String text){
        leftArea.setText((text));
    }

    @FXML
    private void fillRightArea(String text){
        rightArea.setText((text));
    }

    @FXML
    private ChoiceBox<String> operations;

    @FXML
    private String setOperation(){
        return operations.getSelectionModel().getSelectedItem();
    }

    @FXML
    private Label bruteForceKey;

    @FXML
    private Label labelFileCreated;

    @FXML
    private Button moveButton;

    @FXML
    private ImageView arrowLabel;

    @FXML
    void initialize() {
        operations.getItems().addAll("encrypt", "decrypt", "bruteForce");



        start.setOnAction(e ->{
            operation = setOperation();
            if (operation.equals("bruteForce")) {filePathInstance = getFilePathInstance();}else{key = setKey();}


            Language eng = new Eng();
            Language rus = new Rus();

            filePath = getFilePath();
            Path resultFilePath;


            try {
                if(operation.equals("bruteForce")){
                    if(!filePath.isBlank() && !filePathInstance.isBlank()) {
                        Reader.setFilePath(filePath);
                        leftText = Reader.readTextFromFile();
                        fillLeftArea(leftText);
                        Reader.setFilePath(filePathInstance);
                        rightText = Reader.readTextFromFile();
                        key = eng.getKey(leftText, rightText);
                        bruteForceKey.setText("Key (Brute Force): " + key);
                        operation = "decrypt";
                        rightText = eng.encode(leftText, key, operation);
                        fillRightArea(rightText);
                        resultFilePath = FileCreator.createNewFile(Path.of(filePath.replace(".txt", "(decrypted key-" + key + ").txt")) + "");
                        labelFileCreated.setText(resultFilePath.getFileName() + " created in your directory");


                        Writer.writeNewTextToNewFile(rightText, resultFilePath);
                    }else{
                        leftText = getleftText();
                        rightText = getRightText();
                        key = eng.getKey(leftText, rightText);
                        bruteForceKey.setText("Key (Brute Force): " + key);
                        operation = "decrypt";
                        rightText = eng.encode(leftText, key, operation);
                        fillRightArea(rightText);

                    }
                }else if(operation.equals("encrypt") || operation.equals("decrypt")){
                    if(!filePath.isBlank()) {
                        Reader.setFilePath(filePath);
                        leftText = Reader.readTextFromFile();
                        fillLeftArea(leftText);
                        rightText = eng.encode(leftText, key, operation);
                        fillRightArea(rightText);
                            if(operation.equals("decrypt")){
                                resultFilePath = FileCreator.createNewFile(Path.of(filePath.replace("encrypted", "decrypted"))+"");
                            }else{
                                resultFilePath = FileCreator.createNewFile(Path.of(filePath.replace(".txt", "(encrypted).txt")) + "");
                            }
                        labelFileCreated.setText(resultFilePath.getFileName() + " created in your directory");
                        Writer.writeNewTextToNewFile(rightText, resultFilePath);
                    }else{

                            leftText = getleftText();
                            rightText = eng.encode(leftText, key, operation);
                            rightArea.setText(rightText);

                    }


                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }




        });

            moveButton.setOnAction(i ->{
                fillLeftArea(rightText);
                fillRightArea("");
            });






    }
}
