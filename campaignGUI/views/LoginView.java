package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.data.AuthManager;
import campaignGUI.tools.LoadingTool;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class LoginView extends BorderPane
{
    public LoginView(double spacing)
    {
        // Welcome Label
        Label welcomeLabel = new Label("Welcome to C.M.");
        welcomeLabel.setMaxWidth(Double.MAX_VALUE);
        welcomeLabel.setAlignment(Pos.CENTER);

        // VBox for textField and buttons
        VBox loginVBox = new VBox(20);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setMaxWidth(300);
        loginVBox.setBorder(Border.stroke(javafx.scene.paint.Color.BLUEVIOLET));

        // Labels and textFields
        Label userLabel = new Label("User");
        TextField userField = new TextField();
        Label passwordLabel = new Label("Password");
        PasswordField passwordUserField = new PasswordField();
        Button enterLoginButton = new Button("Enter");

        // Adding elements to the vBox
        loginVBox.getChildren().addAll(welcomeLabel, userLabel, userField, passwordLabel, passwordUserField, enterLoginButton);

        // Adding the vBox to a centered StackPane
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(loginVBox);
        this.setCenter(centerPane);

        // Label for denied access
        Label deniedLabel = new Label("Access Denied");

        // Checking if user is authorized
        enterLoginButton.setOnAction(event ->
        {
            if (AuthManager.isUserValid(userField.getText(), passwordUserField.getText()))
            {
                LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), ViewHolder.getDisplayCurrentCampaignScene());
            }
            else if (!loginVBox.getChildren().contains(deniedLabel))
            {
                loginVBox.getChildren().addAll(deniedLabel);
            }
        });
    }
}
