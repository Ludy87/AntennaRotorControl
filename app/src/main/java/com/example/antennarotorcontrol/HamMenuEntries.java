package com.example.antennarotorcontrol;

public class HamMenuEntries {

    //Basic attributes
    private String id;
    private String hamName;
    private String hamHoehe;
    private String hamUDLink;
    private String hamTimeMaxHeight;
    private String hamAOSEOS;
    private String image;

    //Constructor
    HamMenuEntries(String id, String hamName, String hamHoehe, String hamUDLink, String hamTimeMaxHeight, String hamAOSEOS, String image){
        this.id = id;
        this.hamName = hamName;
        this.hamHoehe = hamHoehe;
        this.hamUDLink = hamUDLink;
        this.hamTimeMaxHeight = hamTimeMaxHeight;
        this.hamAOSEOS = hamAOSEOS;
        this.image = image;
    }

    //Getters
    public String getId() {return id;}
    public String getHamName() {return hamName;}
    public String getHamHoehe() {return hamHoehe;}
    public String getHamUDLink() {return hamUDLink;}
    public String getHamTimeMaxHeight() {return hamTimeMaxHeight;}
    public String getHamAOSEOS() {return hamAOSEOS;}
    public String getImage() {return image;}
}
