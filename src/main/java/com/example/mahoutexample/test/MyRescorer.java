package com.example.mahoutexample.test;

import org.apache.mahout.cf.taste.recommender.IDRescorer;

public class MyRescorer implements IDRescorer {

    public boolean isFiltered(long arg0) {
        return false;
    }

    public double rescore(long itemId, double originalScore) {
        if (bookIsNew(itemId)) {
            originalScore *= 1.3;
        }
        return Math.random();
    }

    private boolean bookIsNew(long itemId) {
        // TODO Auto-generated method stub
        return false;
    }
}
