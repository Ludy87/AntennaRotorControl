package com.example.antennarotorcontrol;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HamSatMenu extends AppCompatActivity {

    String[] SatData;

    private ArrayList<HamMenuEntries> hamArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamsatmenu);
        getSupportActionBar().setTitle("Amateur Radio Satellites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hamArrayList.add(new HamMenuEntries("OSCAR 7 (AO-7)","43°","Up: 145.840 / Down: 435.103","17:32:49","17:30:26 - 17:35:49", "ic_hamsat_white_48dp"));
        hamArrayList.add(new HamMenuEntries("UOSAT 2 (UO-11)","27°", "Up: 145.827 / Down: 145.827","18:02:35","17:59:23 - 18:04:49","ic_hamsat_white_48dp"));

        //create our new array adapter
        //ArrayAdapter<HamMenuEntriesArrayAdapter> adapter = new HamMenuEntriesArrayAdapter(this, 0, hamMenuEntries);
        ArrayAdapter<HamMenuEntries> adapter = new HamMenuEntriesArrayAdapter(this,0,hamArrayList);


        //ListView listView = (ListView) findViewById(R.id.hamSatListView);
        ListView listView = (ListView) findViewById(R.id.hamSatListView);
        listView.setAdapter(adapter);

    }
}

//custom ArrayAdapter
class HamMenuEntriesArrayAdapter extends ArrayAdapter<HamMenuEntries>{

    private Context context;
    private List<HamMenuEntries> hamArrayList;

    //constructor, call on creation
    public HamMenuEntriesArrayAdapter(Context context, int resource, ArrayList<HamMenuEntries> objects) {
        super(context, resource, objects);

        this.context = context;
        this.hamArrayList = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        HamMenuEntries hamMenuEntries = hamArrayList.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.satellite_list_layout, null);

        TextView satName = (TextView) view.findViewById(R.id.textName);
        TextView hoehe = (TextView) view.findViewById(R.id.textHoehe);
        TextView udLink = (TextView) view.findViewById(R.id.textUDLink);
        TextView timeMaxHeight = (TextView) view.findViewById(R.id.textTimeMaxHeight);
        TextView aosEos = (TextView) view.findViewById(R.id.textAOSEOS);
        ImageView image = (ImageView) view.findViewById(R.id.imageView3);

        satName.setText(String.valueOf(hamMenuEntries.getHamName()));
        hoehe.setText(String.valueOf(hamMenuEntries.getHamHoehe()));
        udLink.setText(String.valueOf(hamMenuEntries.getHamUDLink()));
        timeMaxHeight.setText(String.valueOf(hamMenuEntries.getHamTimeMaxHeight()));
        aosEos.setText(String.valueOf(hamMenuEntries.getHamAOSEOS()));


        //get the image associated with this property
        int imageID = context.getResources().getIdentifier(hamMenuEntries.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return view;
    }
}


