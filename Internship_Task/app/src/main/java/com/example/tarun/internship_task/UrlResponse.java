package com.example.tarun.internship_task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UrlResponse {

    @SerializedName("worldpopulation")
    private List<Country> countries;

    public UrlResponse(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
