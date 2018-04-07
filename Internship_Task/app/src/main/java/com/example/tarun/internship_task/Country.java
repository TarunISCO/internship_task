package com.example.tarun.internship_task;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("rank")
    private int countryRank;

    @SerializedName("country")
    private String countryName;

    @SerializedName("population")
    private String countryPopulation;

    @SerializedName("flag")
    private String flagUrl;

    public Country(int countryRank, String countryName, String countryPopulation, String flagUrl) {
        this.countryRank = countryRank;
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
        this.flagUrl = flagUrl;
    }

    public int getCountryRank(){
        return countryRank;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}
