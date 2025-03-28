package campaignGUI.tools;

import campaignTools.advertisingCampaigns.AdvertisingCampaign;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Class that holds the method to load different views and the method to do the same but with an advertising Campaign
public class LoadingTool
{
    public static void loadView(Stage stage, Scene scene)
    {
        stage.setScene(scene);
    }

    public static void loadView(Stage stage, Scene scene, AdvertisingCampaign advertisingCampaign)
    {
        stage.setScene(scene);

        // add the advertising campaign to an AdvertisingCampaignManager
    }
}