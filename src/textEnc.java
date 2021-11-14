import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class textEnc extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(25);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 0, 0, 15));
        Scene sc = new Scene(gp, 300, 300);
//        sc.getStylesheets().add("style.css");
        mainStage.setResizable(false);
        mainStage.setScene(sc);
        mainStage.setTitle("Text Encryptor");
        mainStage.show();

        Label lb = new Label("Text");
        gp.add(lb, 1, 0);
        TextField text = new TextField();
        text.setPromptText("Enter Text:");
        gp.add(text, 2, 0);

        Button XOR = new Button("XOR\nEncrypt");
        gp.add(XOR, 1, 1);

        Button Caeser = new Button("Caeser\nEncrypt");
        gp.add(Caeser, 2, 1);

        Button Affine = new Button("Affine\nEncrypt");
        gp.add(Affine, 1, 2);

        Button OneTime = new Button("One Time Pad\nEncrypt");
        gp.add(OneTime, 2, 2);

        Button Back = new Button("Back");
        gp.add(Back, 2, 3);

        XOR.setOnAction(e -> {
            try {
                String textEnc = text.getText();

                char xorKey = 'P';
                String outputString = "";
                int len = textEnc.length();
                System.out.println(textEnc);
                for (int i = 0; i < len; i++)
                    outputString = outputString + Character.toString((char) (textEnc.charAt(i) ^ xorKey));

                AlertBox.display("XOR Encryption", outputString);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Caeser.setOnAction(e -> {
            try {
                String textEnc = text.getText();
                StringBuffer outputString= new StringBuffer();
                int s = 4;
                for (int i=0; i<textEnc.length(); i++) {
                    if (Character.isUpperCase(textEnc.charAt(i))) {
                        char ch = (char)(((int)textEnc.charAt(i) +
                                s - 65) % 26 + 65);
                        outputString.append(ch);
                    }
                    else {
                        char ch = (char)(((int)textEnc.charAt(i) +
                                s - 97) % 26 + 97);
                        outputString.append(ch);
                    }
                }

                AlertBox.display("Caeser Encryption", outputString.toString());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Affine.setOnAction(e -> {
            try {
                String textEnc = text.getText();
                int a = 17;
                int b = 20;

                String outputString = "";
                for (int i = 0; i < textEnc.length(); i++) {
                    if (textEnc.charAt(i) != ' ') {
                        outputString = outputString + (char) ((((a * (textEnc.charAt(i) - 'A')) + b) % 26) + 'A');
                    } else
                        outputString += textEnc.charAt(i);
                }

                AlertBox.display("Affine Encryption", outputString);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        OneTime.setOnAction(e -> {
            try {
                String textEnc = text.getText();
                String key = textEnc;
                String outputString = "";
                int cipher[] = new int[key.length()];

                for (int i = 0; i < key.length(); i++) {
                    cipher[i] = textEnc.charAt(i) - 'A' + key.charAt(i) - 'A';
                }

                for (int i = 0; i < key.length(); i++) {
                    if (cipher[i] > 25)
                        cipher[i] = cipher[i] - 26;
                }
                for (int i = 0; i < key.length(); i++) {
                    int x = cipher[i] + 'A';
                    outputString += (char)x;
                }

                AlertBox.display("One Time Pad Encryption", outputString);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
