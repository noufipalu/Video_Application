package com.example.videoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    ListView lv;
    ArrayList<String> videoList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv = findViewById(R.id.videoView);
        lv = findViewById(R.id.lview);
        videoList = new ArrayList<>();
        videoList.add("part1");
        videoList.add("part2");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, videoList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        vv.setVideoURI(Uri.parse(Uri.parse("android.resource://")+getPackageName()+"/"+R.raw.part1));
                    break;

                    case 1:
                        vv.setVideoURI(Uri.parse(Uri.parse("android.resource://")+getPackageName()+"/"+R.raw.part2));
                        break;

                    default:
                        break;
                }

                vv.setMediaController(new MediaController(MainActivity.this));
                vv.requestFocus();
                vv.start();
            }
        });
    }
}