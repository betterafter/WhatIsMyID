package com.example.whatismyid;

public class item {

    private String siteName;
    private String IDNumber;
    private int Logo;

    public String getSiteName(){
        return siteName;
    }

    public String getIDNumber(){
        return IDNumber;
    }

    public int getLogo(){
        return Logo;
    }

    public void setSiteName(String sitename){
        this.siteName = sitename;
    }

    public void setIDNumber(String idNumber){
        this.IDNumber = idNumber;
    }

    public void setLogo(int logo){
        this.Logo = logo;
    }

}
