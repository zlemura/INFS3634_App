package com.example.android.googlemapsapp;

public class SpecialOffers {

    private String specialOfferPlace;
    private String specialOfferText;
    private String specialOfferModule;
    private String specialOfferName;


    public SpecialOffers(String specialOfferPlace, String specialOfferText, String specialOfferModule, String specialOfferName) {
        this.specialOfferPlace = specialOfferPlace;
        this.specialOfferText = specialOfferText;
        this.specialOfferModule = specialOfferModule;
        this.specialOfferName = specialOfferName;
    }

    public String getSpecialOfferPlace() {
        return specialOfferPlace;
    }

    public void setSpecialOfferPlace(String specialOfferPlace) {
        this.specialOfferPlace = specialOfferPlace;
    }

    public String getSpecialOfferText() {
        return specialOfferText;
    }

    public void setSpecialOfferText(String specialOfferText) {
        this.specialOfferText = specialOfferText;
    }

    public String getSpecialOfferModule() {
        return specialOfferModule;
    }

    public void setSpecialOfferModule(String specialOfferModule) {
        this.specialOfferModule = specialOfferModule;
    }

    public String getSpecialOfferName() {
        return specialOfferName;
    }

    public void setSpecialOfferName(String specialOfferName) {
        this.specialOfferName = specialOfferName;
    }
}
