package com.example.antennarotorcontrol.helper;

import android.os.AsyncTask;
import android.util.Log;

import com.example.antennarotorcontrol.interfaces.DownloadInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadHelper extends AsyncTask<String, Boolean, Boolean> {

    private DownloadInterface downloadInterface;
    private File file;

    public DownloadHelper(DownloadInterface dInterface, File file) {
        this.downloadInterface = dInterface;
        this.file = file;
    }

    @Override
    protected Boolean doInBackground(String[] objects) {
        if (file.delete()) {
            Log.d("File delete: ", "true");
        }
        try {
            int count;
            URL url = new URL("https://www.celestrak.com/NORAD/elements/amateur.txt");
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            OutputStream output = new FileOutputStream(file);
            byte[] data = new byte[1024];
            while ((count = input.read(data)) != -1) {
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean b) {
        if (b)
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
