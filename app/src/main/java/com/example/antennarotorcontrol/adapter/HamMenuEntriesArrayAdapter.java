package com.example.antennarotorcontrol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.antennarotorcontrol.HamMenuEntries;
import com.example.antennarotorcontrol.R;

import java.util.List;

//custom ArrayAdapter
public class HamMenuEntriesArrayAdapter extends ArrayAdapter<HamMenuEntries> {

    private Context context;
    private int resourceLayout;

    //constructor, call on creation
    public HamMenuEntriesArrayAdapter(@NonNull Context context, int resource, @NonNull List<HamMenuEntries> objects) {
        super(context, resource, objects);
        this.context = context;
        resourceLayout = resource;
    }

    //called when rendering the list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }
        //get the property we are displaying
        HamMenuEntries hamMenuEntries = getItem(position);
        if (hamMenuEntries != null) {
            TextView satName = (TextView) v.findViewById(R.id.textName);
            TextView hoehe = (TextView) v.findViewById(R.id.textHoehe);
            TextView udLink = (TextView) v.findViewById(R.id.textUDLink);
            TextView timeMaxHeight = (TextView) v.findViewById(R.id.textTimeMaxHeight);
            TextView aosEos = (TextView) v.findViewById(R.id.textAOSEOS);
            ImageView image = (ImageView) v.findViewById(R.id.imageView3);

            satName.setText(String.valueOf(hamMenuEntries.getHamName()));
            hoehe.setText(String.valueOf(hamMenuEntries.getHamHoehe()));
            udLink.setText(String.valueOf(hamMenuEntries.getHamUDLink()));
            timeMaxHeight.setText(hamMenuEntries.getHamAOSEOS().split(" ")[0]);
            aosEos.setText(hamMenuEntries.getHamAOSEOS().split(" ")[1]);

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(hamMenuEntries.getImage(), "drawable", context.getPackageName());
            image.setImageResource(imageID);
        }
        return v;
    }
}
