package com.example.antennarotorcontrol;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTxtFile extends MainActivity{

    private Context context;

    private String TLE1;
    private String TLE2;
    private String TLE3;
    String threeLineElement;


    public ReadTxtFile(Context c){

        this.context = c;
        this.TLE1 = TLE1;
        this.TLE2 = TLE2;
        this.TLE3 = TLE3;
        this.threeLineElement = threeLineElement;
    }

    /***
     *
     * GETTER
     */

    private String getTLE1() {return TLE1;}
    private String getTLE2() {return TLE2;}
    private String getTLE3() {return TLE3;}
    private String getThreeLineElement() {return threeLineElement;}

    // READ TLE-SAT DATA FILE
    public void readFile() throws IOException {
        if (isExternalStorageReadable()) {
            try {
                StringBuilder sb = new StringBuilder(69);
                File textfile = new File(context.getExternalFilesDir(null).getAbsolutePath(), "amateur.txt");

                if (textfile.exists()) {

                    FileInputStream fis = new FileInputStream(textfile);

                    if (fis != null) {
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader buff = new BufferedReader(isr);
                        String line = null;

                        while ((line = buff.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        fis.close();
                    }
                } else {
                    Log.i("mylog", "File not found");
                }

                String[] sbLines = sb.toString().split("\n");
                TLE1 = sbLines[0];
                Log.d("myLog", "TLE1: " + TLE1);
                TLE2 = sbLines[1];
                Log.d("myLog", "TLE2: " + TLE2);
                TLE3 = sbLines[2];
                Log.d("myLog", "TLE3: " + TLE3);
                threeLineElement = TLE1 + "\n" + TLE2 + "\n" + TLE3 + "\n";

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //SharedFunctions.threeLineElement = TLE1 + "\n" + TLE2 + "\n" + TLE3 + "\n";
            //Log.d("myLog","threeLineElement: "+SharedFunctions.threeLineElement);
            //threeLineElement = "SAUDISAT 1C (SO-50)\n" +
            //        "1 27607U 02058C   20106.54414103  .00000007  00000-0  21737-4 0  9999\n" +
            //        "2 27607  64.5556 206.7081 0055918 193.7297 166.2289 14.75625318931442\n";
            //tvHamSatMenu.setText(sbLines[3]);
            //tvTestBox.setText(line[3]);
            //char test = sb.charAt(3);
            //String sTest = String.valueOf(test);
            //tvTestBox.setText(sb);

    }

    private boolean isExternalStorageReadable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
            Log.i("State", "Is readable!");
            return true;
        }
        else {
            return false;
        }
    }
}

