package campaignTools.advertisements;

import campaignTools.datas.Statistics;

public class Advertisement // Define the blueprint of an advertisement. It has 3 children that inherit its characteristics
{
    /** Attributes of an Advertisement */

    String nameAd;
    String type;
    double baseCost;
    Statistics statistics;

    /** Methods to set or get attributes of an Advertisement */

    // name Attribute
    public void setNameAd(String nameAd) {this.nameAd = nameAd;}
    public String getNameAd() {return this.nameAd;}

    // type Attribute
    public void setType(String type) {this.type = type;}
    public String getType() {return this.type;}

    // baseCost attribute
    public void setBaseCost(double baseCost) {this.baseCost = baseCost;}
    public double getBaseCost() {return this.baseCost;}

    // statistics Attribute
    public void setStatistics(Statistics stats) {this.statistics = stats;}
    public Statistics getStatistics() {return this.statistics;}

    public void display()
    {

    }
}
