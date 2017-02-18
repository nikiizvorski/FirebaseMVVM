package com.nikiizvorski.firebasemvvm.di.detail;

import android.content.Context;

import com.nikiizvorski.firebasemvvm.viewmodel.DetailViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DetailModel {
    private Context context;

    public DetailModel(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context getContext() {
        return context;
    }

    @Singleton
    @Provides
    DetailViewModel detailViewModel(Context context){
        return new DetailViewModel(context);
    }
}
