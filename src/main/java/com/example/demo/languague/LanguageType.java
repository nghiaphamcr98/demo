package com.example.demo.languague;


public enum LanguageType {
    
    VI(1),
    EN(2),
    CAM(3);
    
    private int value;
    LanguageType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public static LanguageType getDefault(){
        return VI;
    }
    
}
