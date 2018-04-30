package com.moremoregreen.recyclerviewstaggered;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: Preparing bitmaps.");

        mImageUrls.add("https://i.ytimg.com/vi/aCxF4U5Q9Xo/maxresdefault.jpg");
        mNames.add("世界十大最貴超級跑車公司你認識多少?");

        mImageUrls.add("https://pic.pimg.tw/twrc/1510024202-52541857_l.jpg");
        mNames.add("能夠自我修復的未來超級跑車");

        mImageUrls.add("http://www.twgreatdaily.com/imgs/image/43/4323163.jpg");
        mNames.add("10大著名跑車你知多少?");

        mImageUrls.add("http://teepr.com/wp-content/uploads/2017/02/589d936ee1d8d.jpg");
        mNames.add("世界最「自私」1.2億跑車！");

        mImageUrls.add("http://fortuneinsight.com/web/wp-content/uploads/2018/02/%E6%97%A5%E6%9C%AC%E8%B6%85%E8%B7%910-100%E5%83%85%E9%9C%801.92%E7%A7%92%EF%BC%81cover.jpg");
        mNames.add("日本車廠Aspark電動超級跑車");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView:  initializing staggered recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(this, mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}
