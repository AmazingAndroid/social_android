package com.example.lovekeshkumar.projectmvpbase.model;

import android.support.v4.view.ViewPager;

public class TransformerItem {

    public final String title;
   public final Class<? extends ViewPager.PageTransformer> clazz;

    public TransformerItem(Class<? extends ViewPager.PageTransformer> clazz) {
        this.clazz = clazz;
        title = clazz.getSimpleName();
    }

    @Override
    public String toString() {
        return title;
    }

}