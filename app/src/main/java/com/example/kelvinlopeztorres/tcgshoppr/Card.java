package com.example.kelvinlopeztorres.tcgshoppr;

public class Card {
    //private String imgUrl;
    private String title;
    private String body;

    public Card(String title , String body) {
        //this.imgUrl = imgUrl;
        this.title = title;
        this.body = body;

    }

//    public String getImgUrl() {
//        return imgUrl;
//    }
//
//    public void setImgUrl(String imgUrl) {
//        this.imgUrl = imgUrl;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
