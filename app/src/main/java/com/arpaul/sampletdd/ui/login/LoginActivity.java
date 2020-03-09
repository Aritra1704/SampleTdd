package com.arpaul.sampletdd.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arpaul.sampletdd.R;
import com.arpaul.sampletdd.databinding.ActivityLoginBinding;
import com.arpaul.sampletdd.ui.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginVM loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginVM = new ViewModelProvider(this).get(LoginVM.class);
        loginVM.getOpenActivity().observe(this, intent -> {
            Intent activityIntent = new Intent(LoginActivity.this, DashboardActivity.class);
            activityIntent.putExtra("username", intent.getStringExtra("username"));
            activityIntent.putExtra("password", intent.getStringExtra("password"));
            startActivity(intent);
        });
    }
}
