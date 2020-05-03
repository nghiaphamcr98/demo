package com.example.demo.enums;

public enum EnumUserVoteStatus {
    NONE("NONE","none", 0),
    DOWNVOTE("DOWNVOTE","down vote", -1),
    UPVOTE("UPVOTE","up vote", 1),
    ;
    
    private String key;
    private String name;
    private int value;
 

    EnumUserVoteStatus(String key, String name, int value){
        this.key = key;
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
