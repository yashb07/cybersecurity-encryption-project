import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class homepage extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(25);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 0, 0, 15));
        Scene sc = new Scene(gp, 250, 100);
//        sc.getStylesheets().add("style.css");
        mainStage.setResizable(false);
        mainStage.setScene(sc);
        mainStage.setTitle("Java Encryptor");
        mainStage.show();

        Button text = new Button("Text\nEncryption");
        text.getStyleClass().add("text-btn");
        gp.add(text, 2, 0);
        Button image = new Button("Image\nEncryption");
        image.getStyleClass().add("image-btn");
        gp.add(image, 5, 0);

        text.setOnAction(e -> {
            try {
                textEnc textEnc = new textEnc();
                textEnc.start(mainStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        image.setOnAction(e -> {
            try {
                imgEnc imgEnc = new imgEnc();
                imgEnc.start(mainStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
