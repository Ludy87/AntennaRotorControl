package com.example.antennarotorcontrol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    String qthLocator;
    ListView list2;
    String[] titles2 = {"Home Location"};
    String[] titles3 = {"QTH-Locator: "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        list2 = findViewById(R.id.list2);
        MyAdapter adapter2 = new MyAdapter(this, titles2, titles3);
        list2.setAdapter(adapter2);

        // von MainActivity erhalten
        if (getIntent().hasExtra("strLocator")) {
            qthLocator = getIntent().getExtras().getString("strLocator");
        }
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] myTitles2;
        String[] myTitles3;

        MyAdapter (Context c, String[] titles2, String[] titles3){
            super(c, R.layout.activity_listview2, R.id.text2, titles2);
            this.context = c;
            this.myTitles2 = titles2;
            this.myTitles3 = titles3;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row3 = layoutInflater.inflate(R.layout.activity_listview2, parent, false);
            TextView myTitle2 = row3.findViewById(R.id.text2);
            TextView myTitle3 = row3.findViewById(R.id.text3);
            titles3[position] = titles3[position]+qthLocator;
            myTitle2.setText(titles2[position]);
            myTitle3.setText(titles3[position]);
            return row3;
        }
    }

}
