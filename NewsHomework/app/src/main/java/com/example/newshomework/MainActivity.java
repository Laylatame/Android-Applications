package com.example.newshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterNoticia mAdapterNoticia;
    private ArrayList<Noticia> mNoticiaList;
    private RequestQueue mRequestQueue;

    private String API_KEY = "fb8be7e28a1b4027aecb317decabbc6b";


    EditText editTextSearchTerm;
    Button buttonSearch;
    TextView showTotalResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearchTerm = findViewById(R.id.editTextSearchTerm);
        buttonSearch = findViewById(R.id.buttonSearch);
        showTotalResults = findViewById(R.id.totalResults);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNoticiaList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);



        buttonSearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String searchTerm = editTextSearchTerm.getText().toString();
                String parsedSearchTerm = searchTerm.replace(' ', '-');

                mNoticiaList.clear();
                parseNoticias(parsedSearchTerm);

            }
        });
    }

    public void parseNoticias(String searchTerm){

        String url = "https://newsapi.org/v2/everything?q=" + searchTerm + "&apiKey=" + API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray articles = response.getJSONArray("articles");
                            showTotalResults.setText(response.getString("totalResults"));

                            for(int i=0; i<articles.length(); i++){
                                JSONObject noticia = articles.getJSONObject(i);
                                String noticiaTitulo = noticia.getString("title");
                                String noticiaFecha = noticia.getString("publishedAt");
                                String noticiaDescripcion = noticia.getString("description");
                                String noticiaURL = noticia.getString("url");
                                String noticiaImgURL = noticia.getString("urlToImage");

                                mNoticiaList.add(new Noticia(noticiaTitulo, noticiaFecha, noticiaDescripcion, noticiaURL, noticiaImgURL));
                            }

                            mAdapterNoticia = new AdapterNoticia(MainActivity.this, mNoticiaList);
                            mRecyclerView.setAdapter(mAdapterNoticia);
                        } catch (JSONException e) {
                            //Toast.makeText(getApplicationContext(),
                            //        e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );


        mRequestQueue.add(request);
    }
}
