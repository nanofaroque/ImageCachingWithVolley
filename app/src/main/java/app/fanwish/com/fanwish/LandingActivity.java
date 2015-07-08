package app.fanwish.com.fanwish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.toolbox.ImageLoader;
import com.fanwish.app.adapter.RecyclerImageListAdapter;
import com.fanwish.app.controller.ApplicationController;
import com.fanwish.app.model.ImageModel;

import java.util.ArrayList;


public class LandingActivity extends AppCompatActivity {
    ArrayList<ImageModel> imagelist = new ArrayList<>(100);
    RecyclerImageListAdapter adapter;
    RecyclerView mRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO-It was used for image caching, We will use it later
        mRecylerView=(RecyclerView)findViewById(R.id.imageList);
        ImageLoader loader= ApplicationController.getInstance().getImageLoader();
        for (int i = 0; i < 100; i++) {
            imagelist.add(new ImageModel("http://api.androidhive.info/volley/volley-image.jpg"));
        }

        mRecylerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(linearLayoutManager);
        adapter=new RecyclerImageListAdapter(imagelist,loader);
        mRecylerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
