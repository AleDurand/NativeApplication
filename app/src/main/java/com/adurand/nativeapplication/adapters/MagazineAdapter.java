package com.adurand.nativeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adurand.nativeapplication.R;
import com.adurand.nativeapplication.models.MagazineModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by adurand on 31/01/17.
 */
public class MagazineAdapter extends ArrayAdapter<MagazineModel> {

    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView description;
    }

    public MagazineAdapter(Context context, List<MagazineModel> magazines) {
        super(context, R.layout.fragment_magazine, magazines);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MagazineModel magazine = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_magazine, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.magazine_view_image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.magazine_view_name);
            viewHolder.description = (TextView) convertView.findViewById(R.id.magazine_view_description);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(getContext()).load(magazine.getImages().get(0).getUrl()).into(viewHolder.image);
        viewHolder.name.setText(magazine.getName());
        viewHolder.description.setText(magazine.getDescription());
        return convertView;
    }


}
