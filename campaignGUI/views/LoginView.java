package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.data.AuthManager;
import campaignGUI.tools.LoadingTool;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class LoginView extends VBox
{
    public LoginView(double spacing)
    {
        super(spacing);

        // Labels

        Label welcomeLabel = new Label("Welcome to C.M.");
        Label userLabel = new Label("User");
        Label passwordLabel = new Label("Password");
        Label deniedLabel = new Label("Acces Denied");

        // Text field and password field and enter button

        TextField userField = new TextField();
        PasswordField passwordUserField = new PasswordField();

        Button enterLoginButton = new Button("Enter");

        this.getChildren().addAll(welcomeLabel, userLabel, userField, passwordLabel, passwordUserField, enterLoginButton);

        // if the username/password mapping is recognized, load the CreateCampaign view

        enterLoginButton.setOnAction(event -> {
            if (AuthManager.isUserValid(userField.getText(), passwordUserField.getText()))
            {
                LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), ViewHolder.getCreateCampaignScene());
            }
            else if (!this.getChildren().contains(deniedLabel))
            {
                this.getChildren().addAll(deniedLabel);
            }
        });
    }
}
