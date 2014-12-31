package com.rhemnet.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.rhemnet.R;
import com.rhemnet.ui.activity.base.FrameActivity;
import com.rhemnet.ui.fragment.BoardCurrentFragment;
import com.rhemnet.ui.fragment.BoardMyFragment;
import com.rhemnet.ui.fragment.BoardRhemnetFragment;

public class BoardActivity extends FrameActivity implements View.OnClickListener{

    Button mSidebarMyboard, mSidebarRhemnetBoard, mSidebarCurrentNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindSidebar(R.layout.sidebar_notice_board);
        initSidebar();
        bindMain(R.layout.activity_board);
        initMain();
        showAsHome(false);
    }

    private void initSidebar() {
        mSidebarMyboard = (Button) findViewById(R.id.sidebar_notice_board_my_board);
        mSidebarMyboard.setOnClickListener(this);
        mSidebarRhemnetBoard= (Button) findViewById(R.id.sidebar_notice_board_rhemnet_board);
        mSidebarRhemnetBoard.setOnClickListener(this);
        mSidebarCurrentNews= (Button) findViewById(R.id.sidebar_notice_board_current_news);
        mSidebarCurrentNews.setOnClickListener(this);
    }

    private void initMain(){

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.sidebar_notice_board_my_board:
                ft.replace(R.id.board_fragment, BoardMyFragment.newInstance("",""));
                break;
            case R.id.sidebar_notice_board_rhemnet_board:
                ft.replace(R.id.board_fragment, BoardRhemnetFragment.newInstance("",""));
                break;
            case R.id.sidebar_notice_board_current_news:
                ft.replace(R.id.board_fragment, BoardCurrentFragment.newInstance("",""));
                break;
            default:
                break;
        }
        ft.commit();
    }
}
