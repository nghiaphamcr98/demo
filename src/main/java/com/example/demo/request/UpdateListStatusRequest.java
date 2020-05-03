package com.example.demo.request;

import java.util.List;

public class UpdateListStatusRequest {

    private List<Integer> list_id;
    private int status;

    public List<Integer> getList_id() {
        return list_id;
    }

    public void setList_id(List<Integer> list_id) {
        this.list_id = list_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}