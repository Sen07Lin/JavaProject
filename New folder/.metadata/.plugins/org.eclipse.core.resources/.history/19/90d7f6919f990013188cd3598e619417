package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.models.UserList;
import com.nickelheim.views.AbstractLoginActivity;

public class LoginButtonListener {
    private Context context;
    private AbstractLoginActivity view;
    private UserList model;
    
    public LoginButtonListener(AbstractLoginActivity view, Context context, UserList model) {
        this.view = view;
        this.model = model;
        this.context = context;
        
    }
     
    public void loginSuccess() {
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isValidUser = model.isValidUser(username, password);
        if(isValidUser) {
            Intent intent  = new Intent(view, LoginSuccessActivity.class);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Login not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
}
