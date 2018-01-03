package com.vrishankgupta.jsoncheck;

import android.os.AsyncTask;

import com.vrishankgupta.jsoncheck.Model.myClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vrishankgupta on 03/01/18.
 */

public class myTask extends AsyncTask<Void,Void,ArrayList<myClass>> {

    @Override
    protected ArrayList<myClass> doInBackground(Void... voids) {
        ArrayList<myClass> myarr = new ArrayList<>();
        try {
                URL url = new URL("https://api.myjson.com/bins/6a1bn");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String buf = reader.readLine();
                while (buf != null)
                {
                    stringBuilder.append(buf);
                    buf = reader.readLine();
                }

               String ans = stringBuilder.toString();

            JSONArray arr = new JSONArray(ans);

            for (int i=0;i<arr.length();i++)
            {
                JSONObject obj = (JSONObject) arr.get(i);
                myClass det = new myClass();
                det.setName(obj.getString(myClass.NAME));
                det.setBranch(obj.getString(myClass.BRANCH));
                det.setCollege(obj.getString(myClass.COLLEGE));
                det.setCourse(obj.getString(myClass.COURSE));
                det.setRoll_number(obj.getInt(myClass.ROLL_NUMBER));
                myarr.add(det);

            }

            } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


        return myarr;
    }

    @Override
    protected void onPostExecute(ArrayList<myClass> myClasses) {
        super.onPostExecute(myClasses);
        MainActivity.array.clear();
        MainActivity.array.addAll(myClasses);
        MainActivity.adapter.notifyDataSetChanged();
    }
}
