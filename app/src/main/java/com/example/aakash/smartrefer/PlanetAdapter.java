package com.example.aakash.smartrefer;

/**
 * Created by aakash on 16/10/16.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

class Planet {

    String name;
    int weight;
    boolean selected = false;

    public Planet(String name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return weight;
    }

    public void setDistance(int weight) {
        this.weight = weight;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

public class PlanetAdapter extends ArrayAdapter<Planet>{

    private List<Planet> planetList;
    private Context context;

    public PlanetAdapter(List<Planet> planetList, Context context) {
        super(context, R.layout.activity_shoppinglist, planetList);
        this.planetList = planetList;
        this.context = context;
    }

    private static class PlanetHolder {
        public TextView planetName;
        public TextView distView;
        public CheckBox chkBox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        PlanetHolder holder = new PlanetHolder();

        if(convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_shoppinglist, null);

            holder.planetName = (TextView) v.findViewById(R.id.name);
            holder.distView = (TextView) v.findViewById(R.id.dist);
            holder.chkBox = (CheckBox) v.findViewById(R.id.chk_box);

            holder.chkBox.setOnCheckedChangeListener((shoppinglist) context);

        } else {
            holder = (PlanetHolder) v.getTag();
        }

        Planet p = planetList.get(position);
        holder.planetName.setText(p.getName());
        holder.distView.setText("" + p.getDistance());
        holder.chkBox.setChecked(p.isSelected());
        holder.chkBox.setTag(p);

        return v;
    }
}