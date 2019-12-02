package com.example.kelvinlopeztorres.tcgshoppr.Model;

import java.util.List;



public class WebSite {


    private String status;
    private List<Source> sources;


    public WebSite(String status) {
        this.status = status;
    }

    public WebSite(List<Source> sources) {
        this.sources = sources;
    }




    //Status S&G

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    //Source S&G

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
