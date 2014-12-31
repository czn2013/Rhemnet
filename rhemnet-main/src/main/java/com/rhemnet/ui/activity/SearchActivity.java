package com.rhemnet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.rhemnet.R;
import com.rhemnet.model.SearchItem;
import com.rhemnet.ui.adapter.SearchAdapter;
import com.rhemnet.ui.activity.base.FrameActivity;
import com.rhemnet.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends FrameActivity implements View.OnClickListener{
    //menu button
    Button  mMenuTitleButton,mMenuMinistryButton, mMenuPreacherButton;
    Button mSidebarMinistryButton, mSidebarKeywordButton, mSidebarPreacherButton;
    //body views
    TextView mTitleView;
    SearchView mSearchView;
    ListView mListView;
//    ImageButton mPlayerPlayButton, mPlayerVolumeButton, mPlayerFullscreenButton;
    ImageView mPlayerPlayButton,mPlayerVolumeButton, mPlayerFullscreenButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindMain(R.layout.activity_otg_search);
        initMain();

        int which = getIntent().getIntExtra(Constants.Search.FROM_HOME_TO_SEARCH, 1);
        if (which == Constants.Search.TO_GO){
            initGoSidebar();
        }else{
            initSearchSidebar();
        }
        initFont();

        switch (which){
            case Constants.Search.TO_GO:
                mSidebarMinistryButton.performClick();
                break;

            case Constants.Search.TO_TITLE:
                mMenuTitleButton.performClick();
                break;
            case Constants.Search.TO_MINISTRY:
                mMenuMinistryButton.performClick();
                break;
            case Constants.Search.TO_PREACHER:
                mMenuPreacherButton.performClick();
                break;
        }
    }

    private void initSearchSidebar() {
        bindSidebar(R.layout.sidebar_search);
        mMenuTitleButton =(Button)findViewById(R.id.sidebar_search_title);
        mMenuMinistryButton = (Button)findViewById(R.id.sidebar_search_ministry);
        mMenuPreacherButton =(Button)findViewById(R.id.sidebar_search_preacher);
        mMenuTitleButton.setOnClickListener(this);
        mMenuMinistryButton.setOnClickListener(this);
        mMenuPreacherButton.setOnClickListener(this);
    }

    private void initGoSidebar(){
        bindSidebar(R.layout.sidebar_on_the_go);
        mSidebarMinistryButton=(Button)findViewById(R.id.sidebar_on_the_go_ministry);
        mSidebarKeywordButton=(Button)findViewById(R.id.sidebar_on_the_go_keyword);
        mSidebarPreacherButton=(Button)findViewById(R.id.sidebar_on_the_go_preacher);
        mSidebarMinistryButton.setOnClickListener(this);
        mSidebarKeywordButton.setOnClickListener(this);
        mSidebarPreacherButton.setOnClickListener(this);
    }

    private void initMain(){
        mTitleView = (TextView) findViewById(R.id.activity_otg_search_tv_title);
        mSearchView = (SearchView) findViewById(R.id.activity_otg_search_sv_search);
        mListView = (ListView) findViewById(R.id.activity_otg_search_lv_list);
        List<SearchItem> resultList =new  ArrayList<SearchItem>();
        for (int i= 0 ; i <10; i++){
            SearchItem item = new SearchItem("Title" + i, "Europe");
            resultList.add(item);
        }
        BaseAdapter adapter = new SearchAdapter(this,resultList);
        mListView.setAdapter(adapter);

        mPlayerPlayButton = (ImageView) findViewById(R.id.small_player_play);
        mPlayerPlayButton.setOnClickListener(this);
        mPlayerVolumeButton = (ImageView) findViewById(R.id.small_player_sound);
        mPlayerVolumeButton.setOnClickListener(this);
        mPlayerFullscreenButton = (ImageView) findViewById(R.id.small_player_full_screen);
        mPlayerFullscreenButton.setOnClickListener(this);
    }

    private void initFont() {

    }

    @Override
    public void onClick(View v) {
        //check(v);

        switch (v.getId()){
            //the search side bar
            case R.id.sidebar_search_ministry:
                loadMinistryData();
                break;
            case R.id.sidebar_search_preacher:
                loadPreacherData();
                break;
            case R.id.sidebar_search_title:
                loadTitleData();
                break;
            // the on the go sidebar
            case R.id.sidebar_on_the_go_ministry:
                loadGoMinistryData();
                break;
            case R.id.sidebar_on_the_go_keyword:
                loadGoKeywordData();
                break;
            case R.id.sidebar_on_the_go_preacher:
                loadGoPreacherData();
                break;
            case R.id.small_player_play:

                break;
            case R.id.small_player_sound:

                break;
            case R.id.small_player_full_screen:
                Intent intent = new Intent(this,PlayerActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void loadMinistryData(){
        mTitleView.setText("Ministry");
        mSearchView.setQueryHint("Search By Ministry");
        //mListView;
    }

    private  void loadPreacherData(){
        mTitleView.setText("Preacher");
        mSearchView.setQueryHint("Search By Preacher");
        //mListView;
    }

    private void loadTitleData(){
        mTitleView.setText("Title");
        mSearchView.setQueryHint("Search By Title");
        //mListView;
    }

    private void loadGoMinistryData(){
        mTitleView.setText("Ministry");
        mSearchView.setQueryHint("Search By Mnistry");
    }

    private void loadGoKeywordData(){
        mTitleView.setText("Keyword");
        mSearchView.setQueryHint("Search By Mnistry");
    }

    private void loadGoPreacherData(){
        mTitleView.setText("Keyword");
        mSearchView.setQueryHint("Search By Mnistry");
    }
}
