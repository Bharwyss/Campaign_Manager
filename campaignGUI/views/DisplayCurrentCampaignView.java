package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.tools.LoadingTool;
import campaignTools.advertisingCampaigns.AdvertisingCampaign;
import campaignTools.advertisingCampaigns.AdvertisingCampaignManager;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayCurrentCampaignView extends BorderPane
{
    private final static AdvertisingCampaignManager campaignsListView = new AdvertisingCampaignManager();
    private final ListView<String> campaignsListViewDisplay = new ListView<>();
    // When clicked on an element, show data
    // When selected, can modify a campaign by loading a modify view with data of the selected campaign

    public DisplayCurrentCampaignView()
    {
        // Vbox that will hold elements of the view
        VBox vbox = new VBox();

        // Add listview to vbox
        vbox.getChildren().add(campaignsListViewDisplay);

        // Add new campaign button and test button
        Button addButton = new Button("Add a Campaign");
        Button addNewCampaign = new Button("Create Campaign");

        vbox.getChildren().addAll(addButton, addNewCampaign);

        // Action to buttons
        addButton.setOnAction(event -> {
            // Test Campaign
            AdvertisingCampaign newCampaign = new AdvertisingCampaign();
            newCampaign.setName("Test1");
            campaignsListView.addNew(newCampaign);
            updateCampaignList(campaignsListView.getElementsList());
        });

        // Create a new campaign by loading the createCampaignView
        addNewCampaign.setOnAction(event ->
        {
            LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), ViewHolder.getCreateCampaignScene());
        });

        // Defining the listView size
        campaignsListViewDisplay.setPrefHeight(300);
        campaignsListViewDisplay.setPrefWidth(200);

        // making Vbox centering the page
        this.setCenter(vbox);
    }

    // Getter for the ListView
    public static AdvertisingCampaignManager getCampaignsListView()
    {
        return campaignsListView;
    }

    // Update the listView display
    public void updateCampaignList(List<AdvertisingCampaign> campaigns)
    {
        // Change campaign list into a name list
        List<String> campaignNames = campaigns.stream()
                .map(AdvertisingCampaign::getName)
                .collect(Collectors.toList());

        // Updating the listView with new elements
        campaignsListViewDisplay.setItems(FXCollections.observableArrayList(campaignNames));
    }
}


//public static AdvertisingCampaignManager getCampaignsListView()
////    {
////        return campaignsListView;
////    }