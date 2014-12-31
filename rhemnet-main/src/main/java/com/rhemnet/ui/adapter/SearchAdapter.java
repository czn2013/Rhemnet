package com.rhemnet.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rhemnet.R;
import com.rhemnet.model.SearchItem;

import java.util.List;

/**
 * Created by user on 14-12-28.
 */
public class SearchAdapter extends BaseAdapter {
    Context mContext;
    List<SearchItem> mList;
    public SearchAdapter(Context context, List list){
        mContext = context;
        mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder= null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.otg_search_list_item,null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.list_item_title);
            holder.description = (TextView) convertView.findViewById(R.id.list_item_description);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        SearchItem item = (SearchItem)getItem(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        return convertView;
    }

    class ViewHolder{
        public TextView title;
        public TextView description;
    }
}
