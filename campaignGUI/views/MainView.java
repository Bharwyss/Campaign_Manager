package campaignGUI.views;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainView extends VBox
{
    public MainView(double spacing)
    {
        super(spacing);
        Label ouiLabel = new Label("Done");

        this.getChildren().addAll(ouiLabel);

    }
}
