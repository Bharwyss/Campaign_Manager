package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.tools.LoadingTool;
import campaignGUI.tools.MenuTool;
import campaignTools.advertisingCampaigns.AdvertisingCampaign;
import campaignTools.advertisingCampaigns.AdvertisingCampaignManager;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayCurrentCampaignView extends BorderPane
{

    /** Field */
    // The list of advertising campaign and the listview to display it
    private final static AdvertisingCampaignManager campaignsListView = new AdvertisingCampaignManager();
    private final ListView<String> campaignsListViewDisplay = new ListView<>();

    /** Methods */
    public DisplayCurrentCampaignView()
    {
        // Main menu
        MenuBar mainMenu = MenuTool.createMenuBar();
        this.setTop(mainMenu);  // Keep the menu on top

        // Vbox that will hold elements of the view
        VBox vbox = new VBox();

        // Add listview to vbox
        vbox.getChildren().add(campaignsListViewDisplay);

        // Add new campaign button and test button, and delete campaign
        Button addButton = new Button("Add a Campaign");
        Button addNewCampaign = new Button("Create a Campaign");
        Button modifyCampaign = new Button("Modify a Campaign");
        Button deleteCampaign = new Button("Delete selected Campaign");
        vbox.getChildren().addAll(addButton, addNewCampaign, modifyCampaign, deleteCampaign);

        // Action to buttons
        addButton.setOnAction(event ->
        {
            // Test Campaign
            AdvertisingCampaign newCampaign = new AdvertisingCampaign();
            newCampaign.setName("Test1");
            newCampaign.setStartingDate(LocalDate.of(2054, 10, 2));
            campaignsListView.addNew(newCampaign);
            updateCampaignList(campaignsListView.getElementsList());
        });

        // Create a new campaign by loading the createCampaignView
        addNewCampaign.setOnAction(event ->
        {
            LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), ViewHolder.getCreateCampaignScene());
        });

        // Modify the selected campaign by charging its data to the CreateCampaignView and deleting it from the list to create it again
        modifyCampaign.setOnAction(event ->
        {
            modifyCampaign();
        });

        // Delete the selected cell from the list
        deleteCampaign.setOnAction(event -> {
            deleteCampaign();
        });

        // Defining a Combobox for sorting
        String[] sortingOption = {"Names Up", "Dates Up", "Names Down", "Dates Down"};
        ComboBox<String> sortingComboBox = new ComboBox<>(FXCollections.observableArrayList(sortingOption));
        vbox.getChildren().add(sortingComboBox);

        // ComboBox events
        // For different options, call the sorting method and use the proper type, and display it to the list
        sortingComboBox.setOnAction(event ->
        {
            switch (sortingComboBox.getValue())
            {
                case "Names Up":
                    campaignsListView.sortByAttribute(AdvertisingCampaign::getName, true);
                    break;

                case "Dates Up":
                    campaignsListView.sortByAttribute(AdvertisingCampaign::getStartingDate, true);
                    break;

                case "Names Down":
                    campaignsListView.sortByAttribute(AdvertisingCampaign::getName, false);
                    break;

                case "Dates Down":
                    campaignsListView.sortByAttribute(AdvertisingCampaign::getStartingDate, false);
                    break;
            }
            updateCampaignList(campaignsListView.getElementsList());
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

    public void modifyCampaign()
    {
        // Check if there is a selected element
        int selectedIndex = campaignsListViewDisplay.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // Retrieve the selected campaign
            AdvertisingCampaign selectedCampaign = campaignsListView.getElementsList().get(selectedIndex);

            // Erase the campaign from the list
            campaignsListView.removeByIndex(selectedIndex);
            updateCampaignList(campaignsListView.getElementsList());

            // Access the view to load data and load the scene
            ViewHolder.getCreateCampaignView().loadCampaignData(selectedCampaign);
            LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), ViewHolder.getCreateCampaignScene());
        }
    }

    public void deleteCampaign()
    {
        if (campaignsListViewDisplay.getSelectionModel().getSelectedItem() != null)
        {
            campaignsListView.removeByIndex(campaignsListViewDisplay.getSelectionModel().getSelectedIndex());
            updateCampaignList(campaignsListView.getElementsList());
        }
    }
}