package campaignTools.advertisingCampaigns;

import campaignTools.advertisements.Advertisement;
import campaignTools.datas.PublicAudience;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdvertisingCampaign // Class that defines what an Advertising Campaign is.
{

    /** Attributes of an Advertising Campaign */
    protected String name;
    protected LocalDateTime startingDate;
    protected LocalDateTime endingDate;
    protected double budget;
    protected String platformTarget;
    protected PublicAudience publicTarget;
    protected List<Advertisement> advertisementList = new ArrayList<>();

    /** Methods to set or get attributes or an Advertising Campaign */

    // name attribute
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}

    // startingDate attribute
    public void setStartingDate(LocalDateTime date) {this.startingDate = date;}
    public LocalDateTime getStartingDate() {return this.startingDate;}

    // endingDate attribute
    public void setEndingDate (LocalDateTime date) {this.endingDate = date;}
    public LocalDateTime getEndingDate() {return this.endingDate;}

    // budget attribute
    public void setBudget (double budget) {this.budget = budget;}
    public double getBudget() {return this.budget;}

    // publicTarget attribute
    public void setPublicTarget(PublicAudience publicTarget) {this.publicTarget = publicTarget;}
    public PublicAudience getPublicTarget() {return this.publicTarget;}

    // platformTarget attribute
    public void setPlatformTarget(String platformTarget) {this.platformTarget = platformTarget;}
    public String getPlatformTarget() {return this.platformTarget;}

    /** Methods to manage the advertisement list */

    public void addAdvertisement(Advertisement ad) // Add an advertisement to the list
    {
        advertisementList.add(ad);
    }

    public void removeAdvertisementByName(Advertisement ad) // Remove an advertisement from the list by its name
    {
        advertisementList.remove(ad);
    }

    public void removeAdvertisementByIndex(int index) // Remove an advertisement from the list by its index
    {
        advertisementList.remove(index);
    }

    public void showAdvertisement() // Show the advertisement list and print their names
    {
        for (Advertisement advertisements : advertisementList)
        {
            System.out.println(advertisements.getName());
        }
    }

    public double calculateROI() // Calculate return of investment
    {
        return 10;
    }
}
