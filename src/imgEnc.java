import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class imgEnc extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(25);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 0, 0, 15));
        Scene sc = new Scene(gp, 350, 300);
//        sc.getStylesheets().add("style.css");
        mainStage.setResizable(false);
        mainStage.setScene(sc);
        mainStage.setTitle("Image Encryptor");
        mainStage.show();

        Label lb = new Label("Add Image and Provide key to encrypt");
        gp.add(lb, 1, 0);

        TextField key = new TextField();
        key.setPromptText("Enter Image Key:");
        gp.add(key, 1, 1);

        Button imgEnc = new Button("Encrpyt\nDecrypt");
        gp.add(imgEnc, 1, 2);
        Label info = new Label("Provide Image here");
        gp.add(info, 2, 2);

        imgEnc.setOnAction(e -> {
            try {
                String text = key.getText();
                int temp=Integer.parseInt(text);

                JFileChooser fileChooser=new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file=fileChooser.getSelectedFile();
                FileInputStream fis=new FileInputStream(file);

                byte []data=new byte[fis.available()];
                fis.read(data);
                int i=0;
                for(byte b:data)
                {
                    System.out.println(b);
                    data[i]=(byte)(b^temp);
                    i++;
                }

                FileOutputStream fos=new FileOutputStream(file);
                fos.write(data);
                fos.close();
                fis.close();
                JOptionPane.showMessageDialog(null, "Done");

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}