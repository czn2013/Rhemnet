package com.rhemnet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rhemnet.R;
import com.rhemnet.ui.activity.base.FrameActivity;
import com.rhemnet.util.Constants;
import com.rhemnet.util.FontUtils;


public class HomeActivity extends FrameActivity {

    Button mSidebarTitleButton, mSidebarMinistryButton, mSidebarPreacherButton;

    Button mLibraryButton, mGoButton, mNoticeButton, mInviteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindMain(R.layout.home);
        bindSidebar(R.layout.sidebar_search);
        showAsHome(true);
        initSideBar();
        initMain();
        initFont();
    }

    private void initSideBar() {

        mSidebarTitleButton = (Button) findViewById(R.id.sidebar_search_title);
        mSidebarMinistryButton = (Button) findViewById(R.id.sidebar_search_ministry);
        mSidebarPreacherButton = (Button) findViewById(R.id.sidebar_search_preacher);
        mSidebarTitleButton.setOnClickListener(mListener);
        mSidebarMinistryButton.setOnClickListener(mListener);
        mSidebarPreacherButton.setOnClickListener(mListener);
    }

    private void initMain() {

        mLibraryButton = (Button) findViewById(R.id.home_library_btn);
        mLibraryButton.setOnClickListener(mListener);
        mGoButton = (Button) findViewById(R.id.home_on_the_go_btn);
        mGoButton.setOnClickListener(mListener);
        mNoticeButton = (Button) findViewById(R.id.home_notice_board_btn);
        mNoticeButton.setOnClickListener(mListener);
        mInviteButton = (Button) findViewById(R.id.home_invite_a_friend_btn);
        mInviteButton.setOnClickListener(mListener);
    }

    private void initFont() {
        TextView textView = (TextView) findViewById(R.id.text_library);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_go);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_board);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_invite_friend);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);
    }


    private View.OnClickListener mListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.sidebar_search_title:
                    Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                    intent.putExtra(Constants.Search.FROM_HOME_TO_SEARCH, Constants.Search.TO_TITLE);
                    startActivity(intent);
                    break;
                case R.id.sidebar_search_ministry:
                    Intent intent1 = new Intent(HomeActivity.this, SearchActivity.class);
                    intent1.putExtra(Constants.Search.FROM_HOME_TO_SEARCH, Constants.Search.TO_MINISTRY);
                    startActivity(intent1);
                    break;
                case R.id.sidebar_search_preacher:
                    Intent intent2 = new Intent(HomeActivity.this, SearchActivity.class);
                    intent2.putExtra(Constants.Search.FROM_HOME_TO_SEARCH, Constants.Search.TO_PREACHER);
                    startActivity(intent2);
                    break;
                case R.id.home_library_btn:
                    Intent libraryIntent = new Intent(HomeActivity.this, SearchActivity.class);
                    startActivity(libraryIntent);
                    break;
                case R.id.home_on_the_go_btn:
                    Intent goIntent = new Intent(HomeActivity.this, SearchActivity.class);
                    goIntent.putExtra(Constants.Search.FROM_HOME_TO_SEARCH, Constants.Search.TO_GO);
                    startActivity(goIntent);
                    break;
                case R.id.home_notice_board_btn:
                    Intent boardIntent = new Intent(HomeActivity.this, BoardActivity.class);
                    startActivity(boardIntent);
                    break;
                case R.id.home_invite_a_friend_btn:
                    Intent inviteIntent = new Intent(HomeActivity.this, InviteActivity.class);
                    startActivity(inviteIntent);
                    break;
                default:
                    break;
            }
        }
    };
}
