package com.rhemnet.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhemnet.R;
import com.rhemnet.model.RecomendItem;


import java.util.List;

/**
 * Created by user on 14-12-29.
 */
public class RecommendAdapter extends BaseAdapter{
    Context mContext;
    List<RecomendItem> mRecommendItems;

    public RecommendAdapter(Context context, List<RecomendItem> list) {
        mContext = context;
        mRecommendItems = list;
    }

    @Override
    public int getCount() {
        return mRecommendItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mRecommendItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder= null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.player_recommend_list_item,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.media_player_recommend_list_text);
            holder.img = (ImageView) convertView.findViewById(R.id.media_player_recommend_list_image);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        RecomendItem item = (RecomendItem)getItem(position);
        holder.name.setText(item.getName());
        holder.img.setImageResource(R.drawable.ic_launcher);
//        Bitmap bm=BitmapFactory.decodeFile(item.getImagePath());
//        holder.img.setImageBitmap(bm);
        return convertView;
    }

    class ViewHolder{
        public TextView name;
        public ImageView img;
    }

}
