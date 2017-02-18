package com.nikiizvorski.firebasemvvm.di.detail;

import com.nikiizvorski.firebasemvvm.view.DetailActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DetailModel.class)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
