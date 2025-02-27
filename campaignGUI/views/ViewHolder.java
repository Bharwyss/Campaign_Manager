package campaignGUI.views;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ViewHolder
{
    private static final LoginView loginView = new LoginView(20);
    private static final CreateCampaignView createCampaignView = new CreateCampaignView(20);
    private static final DisplayCurrentCampaignView displayCurrentCampaignView = new DisplayCurrentCampaignView();

    // Encapsulation des vues dans des Scenes
    private static final Scene loginScene = new Scene(loginView, 800, 600);
    private static final Scene createCampaignScene = new Scene(createCampaignView, 800, 600);
    private static final Scene displayCurrentCampaignScene = new Scene(displayCurrentCampaignView, 800, 600);

    public static Scene getLoginScene()
    {
        return loginScene;
    }

    public static Scene getCreateCampaignScene()
    {
        return createCampaignScene;
    }

    public static Scene getDisplayCurrentCampaignScene()
    {
        return displayCurrentCampaignScene;
    }
}
