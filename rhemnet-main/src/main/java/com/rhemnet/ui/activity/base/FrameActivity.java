package com.rhemnet.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.rhemnet.R;
import com.rhemnet.ui.activity.BoardActivity;
import com.rhemnet.ui.activity.InviteActivity;
import com.rhemnet.ui.activity.SearchActivity;
import com.rhemnet.util.Constants;
import com.rhemnet.util.FontUtils;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

public class FrameActivity extends FragmentActivity  {
    MenuDrawer mOverlayDrawer;

    Button mMenuToggleButton, mMenuExitButton;
    Button mMenuMyAccountButton, mMenuUpgradeButton, mMenuAboutButton, mMenuContactButton;

    Button mBodyToggleButton, mSignOutButton, mBodyLogoButton;

    FrameLayout mAnchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOverlayDrawer = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.LEFT);
        mOverlayDrawer.setDrawOverlay(false);

        mOverlayDrawer.setMenuView(R.layout.menu);
        mOverlayDrawer.setContentView(R.layout.activity_menu);
        mOverlayDrawer.setMenuSize((int) getResources().getDimension(R.dimen.menu_size));
        init();
    }
    protected void init(){
        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("supertank", "called" + v.getId() + v.toString());

                switch (v.getId()) {
                    case R.id.menu_settings_btn:
                    case R.id.sidebar_setting_btn:
                        mOverlayDrawer.toggleMenu();
                        break;
                    case R.id.menu_about_btn:
                        Log.i("supertank", "about us ");
                        break;
                    case R.id.menu_upgrade_btn:
                        Log.i("supertank", "menu_upgrade ");
                        break;
                    case R.id.menu_contact_us_btn:
                        Log.i("supertank", "menu_upgrade ");
                        break;
                    case R.id.menu_sign_out_btn:
                    case R.id.sidebar_sign_out:
                        Log.i("supertank", "menu_upgrade ");
                        break;
                    case R.id.activity_menu_logo:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };

        initMenu(mListener);
        initBody(mListener);

    }

    protected void initMenu(View.OnClickListener mListener) {
        Log.i("supertank", "initMenu() ");

        mMenuToggleButton = (Button) findViewById(R.id.menu_settings_btn);
        mMenuToggleButton.setOnClickListener(mListener);

        mMenuExitButton = (Button) findViewById(R.id.menu_sign_out_btn);
        mMenuExitButton.setOnClickListener(mListener);


        mMenuMyAccountButton = (Button) findViewById(R.id.menu_my_account_btn);
        mMenuMyAccountButton.setOnClickListener(mListener);

        mMenuUpgradeButton = (Button) findViewById(R.id.menu_upgrade_btn);
        mMenuUpgradeButton.setOnClickListener(mListener);

        mMenuAboutButton = (Button) findViewById(R.id.menu_about_btn);
        mMenuAboutButton.setOnClickListener(mListener);
        Log.i("supertank", "initMenu() 5");
        mMenuContactButton = (Button) findViewById(R.id.menu_contact_us_btn);
        mMenuContactButton.setOnClickListener(mListener);


    }

    protected void initBody(View.OnClickListener mListener) {
        Log.i("supertank", "initBody() ");
        mBodyToggleButton = (Button) findViewById(R.id.sidebar_setting_btn);
        mBodyToggleButton.setOnClickListener(mListener);
        mSignOutButton = (Button) findViewById(R.id.sidebar_sign_out);
        mSignOutButton.setOnClickListener(mListener);
        mBodyLogoButton = (Button) findViewById(R.id.activity_menu_logo);
        mBodyLogoButton.setOnClickListener(mListener);
    }

    //TODO call this method when use
    protected void bindSidebar(int layoutId) {
        mAnchor = (FrameLayout) findViewById(R.id.sidebar_anchor);
        View mainView = getLayoutInflater().inflate(layoutId, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mAnchor.addView(mainView, layoutParams);
    }

    protected void bindMain(int layoutId) {
        mAnchor = (FrameLayout) findViewById(R.id.activity_menu_anchor);
        View mainView = getLayoutInflater().inflate(layoutId, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mAnchor.addView(mainView, layoutParams);
    }

    protected void showAsHome(boolean isHome) {
        if (isHome) {
            findViewById(R.id.activity_menu_logo).setVisibility(View.INVISIBLE);
        }
    }



}