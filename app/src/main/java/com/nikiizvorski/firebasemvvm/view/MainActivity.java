package com.nikiizvorski.firebasemvvm.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.nikiizvorski.firebasemvvm.R;
import com.nikiizvorski.firebasemvvm.databinding.ActivityDetailsBinding;
import com.nikiizvorski.firebasemvvm.databinding.ActivityMainBinding;
import com.nikiizvorski.firebasemvvm.di.main.DaggerMainComponent;
import com.nikiizvorski.firebasemvvm.di.main.MainModel;
import com.nikiizvorski.firebasemvvm.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject MainViewModel mainViewModel;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
    }

    private void initData() {
        DaggerMainComponent.builder().mainModel(new MainModel(this)).build().inject(this);
        binding.setMainViewModel(mainViewModel);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mainViewModel.getAuthListener());
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mainViewModel.getAuthListener());
    }

    public static Intent navigateToHome(Context context) {
        Intent home = new Intent(context, DetailActivity.class);
        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return home;
    }
}
