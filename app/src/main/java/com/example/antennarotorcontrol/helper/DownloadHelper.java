package com.example.antennarotorcontrol.helper;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.antennarotorcontrol.ReadTxtFile;
import com.example.antennarotorcontrol.interfaces.DownloadInterface;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadHelper extends AsyncTask<String, String, String> {

    private DownloadInterface downloadInterface;
    private File file;

    public DownloadHelper(DownloadInterface dInterface, File file) {
        this.downloadInterface = dInterface;
        this.file = file;
    }

    @Override
    protected String doInBackground(String[] objects) {
        try {
            if (file.delete()) {
                Log.d("File delete: ", "true");
            }
            int count;
            URL url = new URL("https://www.celestrak.com/NORAD/elements/amateur.txt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            OutputStream output = new FileOutputStream(file);
            byte[] data = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
            return "Finish";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s.equals("Finish"))
            downloadInterface.onResult();
        else
            Log.d("Download", "fail");
    }

    private static String streamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
