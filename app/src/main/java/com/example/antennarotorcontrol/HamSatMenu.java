package com.example.antennarotorcontrol;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.antennarotorcontrol.adapter.HamMenuEntriesArrayAdapter;
import com.example.antennarotorcontrol.helper.DownloadHelper;
import com.example.antennarotorcontrol.helper.ReadTxtFile;
import com.example.antennarotorcontrol.interfaces.DownloadInterface;
import com.example.antennarotorcontrol.model.Model;
import com.example.antennarotorcontrol.model.Models;

import java.io.File;
import java.util.ArrayList;

public class HamSatMenu extends AppCompatActivity {

    String[] SatData;

    private ArrayList<HamMenuEntries> hamArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamsatmenu);
        getSupportActionBar().setTitle("Amateur Radio Satellites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        hamArrayList.add(new HamMenuEntries("OSCAR 7 (AO-7)", "43°", "Up: 145.840 / Down: 435.103", "17:32:49", "17:30:26 - 17:35:49", "ic_hamsat_white_48dp"));
        hamArrayList.add(new HamMenuEntries("UOSAT 2 (UO-11)", "27°", "Up: 145.827 / Down: 145.827", "18:02:35", "17:59:23 - 18:04:49", "ic_hamsat_white_48dp"));

        //create our new array adapter
        final ArrayAdapter<HamMenuEntries> adapter = new HamMenuEntriesArrayAdapter(this, R.layout.satellite_list_layout, hamArrayList);

        final File file = new File(getExternalFilesDir(null), "amateur.txt");
        DownloadHelper downloadHelper = new DownloadHelper(new DownloadInterface() {
            @Override
            public void onResult() {
                Models models = new ReadTxtFile(getBaseContext()).readFile();
                for (Model m : models.getModels()) {
                    hamArrayList.add(new HamMenuEntries(m.getSatName(), "0°", "Up: 08.15 / Down: 15.08", "08:15:08", "08:15:08 - 15:08:15", "ic_hamsat_white_48dp"));
                }
                adapter.notifyDataSetChanged();
            }
        }, file);
        downloadHelper.execute();
        ListView listView = (ListView) findViewById(R.id.hamSatListView);
        listView.setAdapter(adapter);
    }
}


