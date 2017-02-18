package com.nikiizvorski.firebasemvvm.di.main;

import android.content.Context;

import com.nikiizvorski.firebasemvvm.viewmodel.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModel {
    private Context context;

    public MainModel(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context getContext() {
        return context;
    }

    @Singleton
    @Provides
    MainViewModel mainViewModel(Context context){
        return new MainViewModel(context);
    }
}
