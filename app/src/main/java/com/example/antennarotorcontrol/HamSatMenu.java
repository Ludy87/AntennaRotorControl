package com.example.antennarotorcontrol;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.antennarotorcontrol.adapter.HamMenuEntriesArrayAdapter;
import com.example.antennarotorcontrol.helper.DownloadHelper;
import com.example.antennarotorcontrol.helper.ReadTxtFile;
import com.example.antennarotorcontrol.helper.SortById;
import com.example.antennarotorcontrol.interfaces.DownloadInterface;
import com.example.antennarotorcontrol.model.Model;
import com.example.antennarotorcontrol.model.Models;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class HamSatMenu extends AppCompatActivity {

    String[] SatData;

    private ArrayList<HamMenuEntries> hamArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamsatmenu);
        getSupportActionBar().setTitle("Amateur Radio Satellites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //create our new array adapter
        final ArrayAdapter<HamMenuEntries> adapter = new HamMenuEntriesArrayAdapter(this, R.layout.satellite_list_layout, hamArrayList);

        final File file = new File(getExternalFilesDir(null), "amateur.txt");
        DownloadHelper downloadHelper = new DownloadHelper(new DownloadInterface() {
            @Override
            public void onResult() {
                Models models = new ReadTxtFile(getBaseContext()).readFile();
                for (Model m : models.getModels()) {
                    hamArrayList.add(new HamMenuEntries(m.getId(), m.getSatName(), "0°", "Up: 08.15 / Down: 15.08", "08:15:08", m.getSatDate(), "ic_hamsat_white_48dp"));
                }
                Collections.sort(hamArrayList, new SortById());
                adapter.notifyDataSetChanged();
            }
        }, file);
        downloadHelper.execute();
        ListView listView = (ListView) findViewById(R.id.hamSatListView);
        listView.setAdapter(adapter);
    }
}


