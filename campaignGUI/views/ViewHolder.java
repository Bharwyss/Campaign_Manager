package campaignGUI.views;

import javafx.scene.Scene;

public class ViewHolder // Class that holds the views and scenes used for the application
{
    private static final LoginView loginView = new LoginView(20);
    private static final CreateCampaignView createCampaignView = new CreateCampaignView(20);
    private static final DisplayCurrentCampaignView displayCurrentCampaignView = new DisplayCurrentCampaignView();

    // Encapsulating view
    public static CreateCampaignView getCreateCampaignView()
    {
        return createCampaignView;
    }

    // Encapsulating scenes
    private static final Scene loginScene = new Scene(loginView);
    private static final Scene createCampaignScene = new Scene(createCampaignView);
    private static final Scene displayCurrentCampaignScene = new Scene(displayCurrentCampaignView);

    public static DisplayCurrentCampaignView getDisplayCurrentCampaignView()
    {
        return displayCurrentCampaignView;
    }

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
