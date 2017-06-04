package com.sharma.shubham.quoteking;

/**
 * Created by hp on 9/29/2016.
 */

public class Quote {
    private String quote;
    private String author;

    public Quote(){

    }

    public Quote(String quote, String author){
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

}
