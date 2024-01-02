package com.example.travelplanning;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Travel2 extends AppCompatActivity {
    private TextView textView2;
    private Button button;
    private ListView lstTodos;
    private List<String> journeyResults;
    private RequestQueue requestQueue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        lstTodos = findViewById(R.id.lstTodos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkRequest();
            }
        });

        journeyResults = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
    }
    private void makeNetworkRequest() {
        String url = "https://api.tfl.gov.uk/Journey/JourneyResults/1000266/to/1000013";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        processJsonResponse(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Volley Error", error.toString());
                    }
                });

        requestQueue.add(request);
    }

    private void processJsonResponse(JSONObject jsonResponse) {
        // Clear the existing data
        journeyResults.clear();

        try {
            // Extract "toLocationDisambiguation" options
            JSONObject toLocationDisambiguation = jsonResponse.getJSONObject("toLocationDisambiguation");
            JSONArray toDisambiguationOptions = toLocationDisambiguation.getJSONArray("disambiguationOptions");

            for (int i = 0; i < toDisambiguationOptions.length(); i++) {
                JSONObject option = toDisambiguationOptions.getJSONObject(i);
                String commonName = option.getJSONObject("place").getString("commonName");
                int matchQuality = option.getInt("matchQuality");

                // Format the information
                String result = "To Location: " + commonName + ", Match Quality: " + matchQuality;
                journeyResults.add(result);
            }

            // Extract "fromLocationDisambiguation" options
            JSONObject fromLocationDisambiguation = jsonResponse.getJSONObject("fromLocationDisambiguation");
            JSONArray fromDisambiguationOptions = fromLocationDisambiguation.getJSONArray("disambiguationOptions");

            for (int i = 0; i < fromDisambiguationOptions.length(); i++) {
                JSONObject option = fromDisambiguationOptions.getJSONObject(i);
                String commonName = option.getJSONObject("place").getString("commonName");
                int matchQuality = option.getInt("matchQuality");

                // Format the information as needed
                String result = "From Location: " + commonName + ", Match Quality: " + matchQuality;
                journeyResults.add(result);
            }

            // Update the ListView with the new data
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, journeyResults);
            lstTodos.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
