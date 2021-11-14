import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
    public static void display(String tile , String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(tile);
        window.setMinWidth(300);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(message);

        Button closebutton = new Button("Close");
        closebutton.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closebutton);
        layout.setAlignment(Pos.CENTER);

        Scene root = new Scene(layout);
        window.setScene(root);
        window.show();
        window.setResizable(false);
    }
}