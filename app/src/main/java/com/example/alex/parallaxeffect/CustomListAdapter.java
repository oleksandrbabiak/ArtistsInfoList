package com.example.alex.parallaxeffect;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.parallaxeffect.entity.PreviewClipItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Alex on 04.10.2015.
 */
public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private List<PreviewClipItem> previewClipItems;

    public CustomListAdapter(Context context, List<PreviewClipItem> previewClipItems) {
        this.context = context;
        this.previewClipItems = previewClipItems;
    }

    @Override
    public int getCount() {
        return previewClipItems.size();
    }

    @Override
    public Object getItem(int position) {
        return previewClipItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_view, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.image1);
            holder.nameClip = (TextView) view.findViewById(R.id.name_clip);
            holder.nameArtist = (TextView) view.findViewById(R.id.name_artist);
            holder.count = (TextView) view.findViewById(R.id.count);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (!previewClipItems.get(position).getArtists().isEmpty()) {
            holder.nameArtist.setText(previewClipItems.get(position).getArtists().get(0).getName());
        }
        holder.nameClip.setText(previewClipItems.get(position).getSlug());
        holder.count.setText(previewClipItems.get(position).getView_count());
        Picasso.with(context)
                .load(previewClipItems.get(position).getPicture())
                .error(R.drawable.logo)
                .into(holder.imageView);
        view.setTag(holder);

        return view;
    }

    private static class ViewHolder {
        public ImageView imageView;
        public TextView nameClip;
        public TextView nameArtist;
        public TextView count;
    }

}
