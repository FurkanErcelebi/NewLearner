package FileOperations;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;  

public class Downloader extends Application {
 
    @Override
    public void start(final Stage primaryStage) {
        final String sampleText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut \n"
                + "labore et dolore magna aliqua.\n"
                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n"
                + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n"
                + "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
 
        Text sample = new Text(sampleText);
        sample.setFont(new Font(14));
 
        Button btnSave = new Button("Save");
 
        btnSave.setOnAction(event -&amp;amp;gt; {
            FileChooser fileChooser = new FileChooser();
 
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
 
            //Show save file dialog
            File file = fileChooser.showSaveDialog(primaryStage);
 
            if (file != null) {
                saveTextToFile(sampleText, file);
            }
        });
 
        VBox vBox = new VBox(sample, btnSave);
        vBox.setAlignment(Pos.CENTER);
 
        primaryStage.setScene(new Scene(vBox, 800, 300));
        primaryStage.setTitle("www.genuinecoder.com");
        primaryStage.show();
 
    }
 
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveFileWithFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}