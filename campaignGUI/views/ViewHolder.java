package campaignGUI.views;

import javafx.scene.Scene;

public class ViewHolder
{
    private static final LoginView loginView = new LoginView(20);
    private static final CreateCampaignView createCampaignView = new CreateCampaignView(20);
    private static final DisplayCurrentCampaignView displayCurrentCampaignView = new DisplayCurrentCampaignView();

    // Encapulsating scenes
    private static final Scene loginScene = new Scene(loginView);
    private static final Scene createCampaignScene = new Scene(createCampaignView);
    private static final Scene displayCurrentCampaignScene = new Scene(displayCurrentCampaignView);

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
