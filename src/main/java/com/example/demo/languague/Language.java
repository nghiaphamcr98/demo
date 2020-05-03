package com.example.demo.languague;


public class Language {
    private String vi = "";
    private String en = "";
    private String cam = "";

    public Language(){
        this.vi = "";
        this.en = "";
        this.cam = "";
    }
    
    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCam() {
        return cam;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }
    
    public String getContent(int languageType){
        String result = "";
        if(languageType==LanguageType.VI.getValue())
            result = this.vi;
        else if(languageType==LanguageType.EN.getValue())
            result = this.en;
        else if(languageType==LanguageType.CAM.getValue())
            result = this.cam;
        return result;
    }
    
    public void setContent(int languageType, String value){
        if(languageType==LanguageType.VI.getValue())
            this.vi = value;
        else if(languageType==LanguageType.EN.getValue())
            this.en = value;
        else if(languageType==LanguageType.CAM.getValue())
            this.cam = value;
    }
    
}
