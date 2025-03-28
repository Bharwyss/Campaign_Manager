package campaignTools.advertisingCampaigns;

import campaignTools.advertisements.Advertisement;
import campaignTools.datas.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AdvertisingCampaign extends ListManager<Advertisement>// Class that defines what an Advertising Campaign is.
{
    /** Constructor */
    public AdvertisingCampaign() {}

    public AdvertisingCampaign(String name, LocalDate startingDate, LocalDate endingDate, double budget, String platformTarget, String publicTarget)
    {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.budget = budget;
        this.platformTarget = platformTarget;
        this.publicTarget = publicTarget;
    }

    /** Attributes of an Advertising Campaign */
    protected String name;
    protected LocalDate startingDate;
    protected LocalDate endingDate;
    protected double budget;
    protected String platformTarget;
    protected String publicTarget;

    /** Methods to set or get attributes or an Advertising Campaign */

    // name attribute
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}

    // startingDate attribute
    public void setStartingDate(LocalDate date) {this.startingDate = date;}
    public LocalDate getStartingDate() {return this.startingDate;}

    // endingDate attribute
    public void setEndingDate (LocalDate date) {this.endingDate = date;}
    public LocalDate getEndingDate() {return this.endingDate;}

    // budget attribute
    public void setBudget (double budget) {this.budget = budget;}
    public double getBudget() {return this.budget;}

    // publicTarget attribute
    public void setPublicTarget(String publicTarget) {this.publicTarget = publicTarget;}
    public String getPublicTarget() {return this.publicTarget;}

    // platformTarget attribute
    public void setPlatformTarget(String platformTarget) {this.platformTarget = platformTarget;}
    public String getPlatformTarget() {return this.platformTarget;}


    @Override
    public void showAllElements() // Display all current campaigns in the list by name and date
    {
        for (int i = 0; i < elementsList.size(); i++)
        {
            System.out.println(elementsList.get(i).getNameAd());
        }
    }

    @Override
    public void removeByName(String elementName) // Remove an element from the list by its name
    {
        Iterator<Advertisement> iterator = elementsList.iterator();
        while (iterator.hasNext()) {
            Advertisement element = iterator.next();
            if (element.getNameAd().equals(elementName)) {
                iterator.remove(); // This safely removes the element from the list
                System.out.println("Removed: " + element.getNameAd());
                return; // Exit after the first match
            }
        }
        System.out.println("No element found with name: " + elementName);
    }


    public double calculateROI() // Calculate return of investment
    {
        return 10;
    }
}


/** Methods to manage the advertisement list */

/**

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
 */