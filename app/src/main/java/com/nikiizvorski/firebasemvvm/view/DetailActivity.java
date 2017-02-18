package com.nikiizvorski.firebasemvvm.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.nikiizvorski.firebasemvvm.R;
import com.nikiizvorski.firebasemvvm.databinding.ActivityDetailsBinding;
import com.nikiizvorski.firebasemvvm.di.detail.DaggerDetailComponent;
import com.nikiizvorski.firebasemvvm.di.detail.DetailModel;
import com.nikiizvorski.firebasemvvm.viewmodel.DetailViewModel;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {
    @Inject DetailViewModel detailViewModel;
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        initData();
    }

    private void initData() {
        DaggerDetailComponent.builder().detailModel(new DetailModel(this)).build().inject(this);
        binding.setDetails(detailViewModel);
    }

    public static Intent navigateToLogin(Context context) {
        FirebaseAuth.getInstance().signOut();
        Intent login = new Intent(context, MainActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return login;
    }
}
