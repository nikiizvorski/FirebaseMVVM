package com.nikiizvorski.firebasemvvm.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nikiizvorski.firebasemvvm.view.MainActivity;

import javax.inject.Inject;

public class MainViewModel {
    @Inject Context context;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private ObservableField<String> username;
    private ObservableField<String> password;

    @Inject
    public MainViewModel(Context context) {
        this.context = context;
        username = new ObservableField<>();
        password = new ObservableField<>();
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(ObservableField<String> password) {
        this.password = password;
    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void setUsername(ObservableField<String> username) {
        this.username = username;
    }

    public FirebaseAuth.AuthStateListener getAuthListener() {
        return new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("MVVM", "onAuthStateChanged:signed_in:" + user.getUid());
                    context.startActivity(MainActivity.navigateToHome(context));
                } else {
                    // User is signed out
                    Toast.makeText(context, "Signed Out!", Toast.LENGTH_SHORT).show();
                    Log.d("MVVM", "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    public void registerUser(View view){
        if (getUsername().get() != null && !getUsername().get().isEmpty() && getPassword().get() != null && !getPassword().get().isEmpty())
        auth.createUserWithEmailAndPassword(getUsername().get().trim(), getPassword().get().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(context, "Problem with Register!: " + getUsername().get().trim() + " : " + getPassword().get().trim(), Toast.LENGTH_SHORT).show();
                } else {
                    context.startActivity(MainActivity.navigateToHome(context));
                    Toast.makeText(context, "Register", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void loginUser(View view){
        if (getUsername().get() != null && !getUsername().get().isEmpty() && getPassword().get() != null && !getPassword().get().isEmpty())
        auth.signInWithEmailAndPassword(getUsername().get().trim(), getPassword().get().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(context, "Login Failed!: " + getUsername().get().trim() + " : " + getPassword().get().trim(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    context.startActivity(MainActivity.navigateToHome(context));
                }
            }
        });
    }
}
