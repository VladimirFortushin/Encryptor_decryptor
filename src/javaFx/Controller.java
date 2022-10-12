package javaFx;

import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

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

import static encryptor.Reader.readTextFromFile;
import static encryptor.Reader.setFilePath;
import static encryptor.Writer.writeNewTextToNewFile;
import static files.FileCreator.createNewFile;
import static language.Language.setLanguage;
import static language.Language.getLanguage;


public class Controller {

    private String operation;
    private String filePath;
    private String filePathInstance;
    private Integer key;
    private String leftText;
    private String rightText;
    private final Language eng = new Eng();
    private final Language rus = new Rus();

    private Language language;

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
    private ChoiceBox<String> languages;

    @FXML
    private Language setLanguage(){
        if(languages.getSelectionModel().getSelectedItem().equals("Eng")){
            return eng;
        }else if(languages.getSelectionModel().getSelectedItem().equals("Rus")){
            return rus;
        }
        return null;
    }

    @FXML
    void initialize() {
        operations.getItems().addAll("encrypt", "decrypt", "bruteForce");
        languages.getItems().addAll("Eng", "Rus");

        start.setOnAction(e ->{
            labelFileCreated.setText("");
            bruteForceKey.setText("");
            language = setLanguage();
            operation = setOperation();

            if (operation.equals("bruteForce")) {filePathInstance = getFilePathInstance();}else{key = setKey();}

            filePath = getFilePath();
            Path resultFilePath;

            try {
                if(operation.equals("bruteForce")){
                    if(!filePath.isBlank() && !filePathInstance.isBlank()) {
                        setFilePath(filePath);
                        leftText = readTextFromFile();
                        fillLeftArea(leftText);
                        setFilePath(filePathInstance);
                        rightText = readTextFromFile();
                        key = language.getKey(leftText, rightText);
                        bruteForceKey.setText("Key (Brute Force): " + key);
                        operation = "decrypt";
                        rightText = language.encode(leftText, key, operation);
                        fillRightArea(rightText);
                        resultFilePath = createNewFile(Path.of(filePath.replace(".txt", "(decrypted key-" + key + ").txt")) + "");
                        labelFileCreated.setText(resultFilePath.getFileName() + " created in your directory");


                        writeNewTextToNewFile(rightText, resultFilePath);
                    }else{
                        leftText = getleftText();
                        rightText = getRightText();
                        key = language.getKey(leftText, rightText);
                        bruteForceKey.setText("Key (Brute Force): " + key);
                        operation = "decrypt";
                        rightText = language.encode(leftText, key, operation);
                        fillRightArea(rightText);

                    }
                }else if(operation.equals("encrypt") || operation.equals("decrypt")){
                    if(!filePath.isBlank()) {
                        setFilePath(filePath);
                        leftText = readTextFromFile();
                        fillLeftArea(leftText);
                        rightText = language.encode(leftText, key, operation);
                        fillRightArea(rightText);
                            if(operation.equals("decrypt")){
                                resultFilePath = createNewFile(Path.of(filePath.replace("encrypted", "decrypted"))+"");
                            }else{
                                resultFilePath = createNewFile(Path.of(filePath.replace(".txt", "(encrypted).txt")) + "");
                            }
                        labelFileCreated.setText(resultFilePath.getFileName() + " created in your directory");
                        writeNewTextToNewFile(rightText, resultFilePath);
                    }else{

                            leftText = getleftText();
                            rightText = language.encode(leftText, key, operation);
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
