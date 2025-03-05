package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.tools.LoadingTool;
import campaignGUI.tools.MenuTool;
import campaignTools.advertisingCampaigns.AdvertisingCampaign;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import static campaignGUI.views.ViewHolder.getDisplayCurrentCampaignScene;

public class CreateCampaignView extends BorderPane
{
    public CreateCampaignView(double spacing)
    {
        // Main menu
        MenuBar mainMenu = MenuTool.createMenuBar();
        this.setTop(mainMenu);  // Assure que le MenuBar reste en haut

        // Label for campaign creation
        Label creationLabel = new Label("Create a campaign");
        creationLabel.setMaxWidth(Double.MAX_VALUE);
        creationLabel.setAlignment(Pos.CENTER);

        // VBox for campaign creation inputs
        VBox creationVBox = new VBox(20);
        creationVBox.setAlignment(Pos.CENTER);
        creationVBox.setMaxWidth(300);
        creationVBox.setBorder(Border.stroke(javafx.scene.paint.Color.BLUEVIOLET));

        Label nameCampaignLabel = new Label("Choose a name for the Campaign");
        TextField nameCampaignText = new TextField();
        Label startDateLabel = new Label("Choose a starting date");
        DatePicker startDatePicker = new DatePicker();
        Label endDateLabel = new Label("Choose an ending date");
        DatePicker endDatePicker = new DatePicker();
        Label budgetLabel = new Label("Choose a budget");
        TextField budgetText = new TextField();
        Label platformTargetLabel = new Label("Choose a platform target");
        ComboBox<String> platformTargetComboBox = new ComboBox<>();
        platformTargetComboBox.getItems().addAll("Option A", "Option B", "Option C");
        Label publicTargetLabel = new Label("Choose a public target");
        ComboBox<String> publicTargetComboBox = new ComboBox<>();
        publicTargetComboBox.getItems().addAll("Option A", "Option B", "Option C");
        Button createCampaignButton = new Button("Create");

        // Adding event control
        creationVBox.getChildren().addAll(
                nameCampaignLabel, nameCampaignText, startDateLabel, startDatePicker,
                endDateLabel, endDatePicker, budgetLabel, budgetText,
                platformTargetLabel, platformTargetComboBox,
                publicTargetLabel, publicTargetComboBox, createCampaignButton
        );

        createCampaignButton.setOnAction(event ->
        {
            // Create a new campaign and add it to the ListView thanks to ListManager method
            DisplayCurrentCampaignView.getCampaignsListView().addNew(
                    new AdvertisingCampaign(nameCampaignText.getText(),startDatePicker.getValue(), endDatePicker.getValue(),
                            Double.parseDouble(budgetText.getText()), platformTargetComboBox.getValue(), publicTargetComboBox.getValue()));

            // Update ListView of the current instantiation with the new list
            ViewHolder.getDisplayCurrentCampaignView().updateCampaignList(DisplayCurrentCampaignView.getCampaignsListView().getElementsList());

            // Load the scene where campaigns are displayed
            LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), getDisplayCurrentCampaignScene());

            // Reset the TextField after adding the campaign
            nameCampaignText.clear();  // Clears the name campaign field
            startDatePicker.setValue(null); // Resets the date picker
            endDatePicker.setValue(null); // Resets the date picker
            budgetText.clear(); // Clears the budget field
            platformTargetComboBox.setValue(null); // Resets the platform combo box
            publicTargetComboBox.setValue(null); // Resets the public target combo box
        });

        // Centering content
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(creationVBox);

        // Setting elements in the BorderPane
        this.setCenter(centerPane);
        this.setTop(mainMenu);   // Assure que le MenuBar est bien placé
    }
}
