package com.example.alex.parallaxeffect;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.alex.parallaxeffect.entity.PreviewClipItem;
import com.example.alex.parallaxeffect.entity.TransferObject;
import com.nirhart.parallaxscroll.views.ParallaxListView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getCanonicalName();
    private Retrofit retrofit;
    private ServerApi serverApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_multiple_parallax);

        retrofit = new Retrofit.Builder().baseUrl("http://ellotv.bigdig.com.ua/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serverApi = retrofit.create(ServerApi.class);

        final Call<TransferObject> infoList = serverApi.getStr();
        infoList.enqueue(new Callback<TransferObject>() {
            @Override
            public void onResponse(Response<TransferObject> response) {

                addParalaxEffect(response.body().getDataObject().getItems());

            }

            @Override
            public void onFailure(Throwable t) {

                Log.d(LOG_TAG, t.getMessage());
            }
        });


    }

    private void addParalaxEffect(List<PreviewClipItem> previewClipItems) {
        ParallaxListView listView = (ParallaxListView) findViewById(R.id.list_view);
        CustomListAdapter adapter = new CustomListAdapter(this, previewClipItems);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_github) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nirhart/ParallaxScroll"));
            startActivity(browserIntent);
        }
        return true;
    }
}
