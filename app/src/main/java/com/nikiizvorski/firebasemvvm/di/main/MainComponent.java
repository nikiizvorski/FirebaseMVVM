package com.nikiizvorski.firebasemvvm.di.main;

import com.nikiizvorski.firebasemvvm.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModel.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
