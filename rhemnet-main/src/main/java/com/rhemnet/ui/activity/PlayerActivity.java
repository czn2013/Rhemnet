package com.rhemnet.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.rhemnet.R;
import com.rhemnet.model.RecomendItem;
import com.rhemnet.ui.adapter.RecommendAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends Activity {
    GridView mRecommendGridView;
    List<RecomendItem> mRecommendList;
    RecommendAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        mRecommendGridView = (GridView) findViewById(R.id.media_player_recommend_list);
        mRecommendList = new ArrayList<RecomendItem>();
        for (int i=0; i<10;i++){
            mRecommendList.add(new RecomendItem());
        }
        if (findViewById(R.id.media_player_portrait) != null){
            float dpValue = getResources().getDimension(R.dimen.media_player_recommend_horizontal_width);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    mRecommendList.size() * (int)dp2px(dpValue), ViewGroup.LayoutParams.MATCH_PARENT);
            mRecommendGridView.setLayoutParams(params);
        }

        mAdapter = new RecommendAdapter(this,mRecommendList);
        mRecommendGridView.setAdapter(mAdapter);
    }

    private float dp2px(float dpValue){
        float scale  = getResources().getDisplayMetrics().density;
        return  (dpValue * scale + 0.5f);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
