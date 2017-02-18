package com.nikiizvorski.firebasemvvm.viewmodel;

import android.content.Context;
import android.view.View;

import com.nikiizvorski.firebasemvvm.view.DetailActivity;

import javax.inject.Inject;

public class DetailViewModel {
    @Inject Context context;

    @Inject
    public DetailViewModel(Context context) {
        this.context = context;
    }

    public void logOut(View view){
        context.startActivity(DetailActivity.navigateToLogin(context));
    }
}
