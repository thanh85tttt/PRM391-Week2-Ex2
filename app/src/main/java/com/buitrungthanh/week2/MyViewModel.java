package com.buitrungthanh.week2;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private ArrayList<String> listHistory = new ArrayList<>();

    public ArrayList<String> getListHistory() {
        if (listHistory == null) {
            listHistory = new ArrayList<String>();
        }
        return listHistory;
    }

    public void addToList(String number){
        listHistory.add(number);
    }

    public void removeFromList(int position){
        listHistory.remove(position);
    }
}
