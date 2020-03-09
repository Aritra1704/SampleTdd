package com.arpaul.sampletdd.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arpaul.sampletdd.ui.dashboard.DashboardActivity;

public class LoginVM extends ViewModel {
    LiveData<String> obsUsername = new MutableLiveData();
    LiveData<String> obsPassword = new MutableLiveData();

    MutableLiveData<Intent> mldOpenActivity = new MutableLiveData<>();

    public LiveData<String> getObsUsername() {
        return obsUsername;
    }

    public LiveData<String> getObsPassword() {
        return obsPassword;
    }

    public LiveData<Intent> getOpenActivity() {
        return mldOpenActivity;
    }

    public void performLogin(View view) {
        Intent intent = new Intent();
        intent.putExtra("username", obsUsername.getValue());
        intent.putExtra("password", obsPassword.getValue());
        mldOpenActivity.postValue(intent);
    }
}
