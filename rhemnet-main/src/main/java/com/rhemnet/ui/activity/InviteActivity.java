package com.rhemnet.ui.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


import com.rhemnet.R;
import com.rhemnet.ui.activity.base.FrameActivity;
import com.rhemnet.ui.fragment.*;


public class InviteActivity extends FrameActivity implements View.OnClickListener{
    Button mInviteEmailButton, mInviteFacebookButton, mInviteTelephoneButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindSidebar(R.layout.sidebar_invite_a_friend);
        bindMain(R.layout.activity_invite);
        showAsHome(false);
        initSidebar();

    }

    protected void initSidebar() {
        mInviteEmailButton = (Button) findViewById(R.id.sidebar_invite_a_friend_email);
        mInviteEmailButton.setOnClickListener(this);
        mInviteFacebookButton = (Button) findViewById(R.id.sidebar_invite_a_friend_facebook);
        mInviteFacebookButton.setOnClickListener(this);
        mInviteTelephoneButton = (Button) findViewById(R.id.sidebar_invite_a_friend_telephone);
        mInviteTelephoneButton.setOnClickListener(this);
//        findViewById(R.id.sidebar_invite_a_friend_email).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                check(v);
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.activity_menu_fragment, InviteEmailFragment.newInstance("a", "b"));
//                ft.commit();
//
//            }
//        });
//
//        findViewById(R.id.sidebar_invite_a_friend_facebook).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                check(v);
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.activity_menu_fragment, InviteFacebookFragment.newInstance("a", "b"));
//                ft.commit();
//
//            }
//        });
//
//        findViewById(R.id.sidebar_invite_a_friend_telephone).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                check(v);
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.activity_menu_fragment, InviteTelephoneFragment.newInstance("a", "b"));
//                ft.commit();
//
//            }
//        });
    }

    private  void initBody(){
        findViewById(R.id.sidebar_setting_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initFont() {

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.sidebar_invite_a_friend_email:
                ft.replace(R.id.invite_fragment, InviteEmailFragment.newInstance("a", "b"));
            break;
            case R.id.sidebar_invite_a_friend_facebook:
                ft.replace(R.id.invite_fragment, InviteFacebookFragment.newInstance("a", "b"));
                break;
            case R.id.sidebar_invite_a_friend_telephone:
                ft.replace(R.id.invite_fragment, InviteTelephoneFragment.newInstance("a","b"));
                break;
        }

        ft.commit();
    }
}
