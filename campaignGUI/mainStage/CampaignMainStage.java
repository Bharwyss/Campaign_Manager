package campaignGUI.mainStage;

import campaignGUI.views.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CampaignMainStage extends Application
{
    private static Stage primaryStage;
    private final String WINDOW_TITLE = "Campaign Manager";
    private final double WINDOW_WIDTH = 1280;
    private final double WINDOW_HEIGHT = 720;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        primaryStage = stage;
        Scene loginViewScene = new Scene(new LoginView(20));
        primaryStage.setScene(loginViewScene);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.show();
    }

    public static Stage getPrimaryStage()
    {
        return primaryStage;
    }
}