package campaignGUI.views;

import campaignGUI.mainStage.CampaignMainStage;
import campaignGUI.tools.LoadingTool;
import campaignGUI.tools.MenuTool;
import campaignTools.advertisingCampaigns.AdvertisingCampaign;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CreateCampaignView extends BorderPane {

    public CreateCampaignView(double spacing) {
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
                    // Put information gathered into a new instance of advertising campaign
                    AdvertisingCampaign placeHolder = new AdvertisingCampaign();
                    placeHolder.setName(nameCampaignText.getText());
                    placeHolder.setStartingDate(startDatePicker.getValue());
                    placeHolder.setEndingDate(endDatePicker.getValue());
                    placeHolder.setBudget(Double.parseDouble(budgetText.getText())); //I need to set verification to assure it's a double
                    placeHolder.setPlatformTarget(platformTargetComboBox.getValue());

                    // Once gathered and verified, load DisplayCurrentCampaignView and pass it the placeHolder data
                    // is it possible to load data after the page is loaded?
                    // if there is the first campaign, create a new scene, else, load the one that already exist)
                    LoadingTool.loadView(CampaignMainStage.getPrimaryStage(), new Scene(new DisplayCurrentCampaignView()));

                }
        );

        // Centering content
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(creationVBox);

        // Setting elements in the BorderPane
        this.setCenter(centerPane);
        this.setTop(mainMenu);   // Assure que le MenuBar est bien placé
    }
}
