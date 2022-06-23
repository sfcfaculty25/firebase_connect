package com.dawai.firebaseconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class map extends AppCompatActivity {

    EditText source, destination;
    Button btn_find;
    WebView wbview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        btn_find = findViewById(R.id.btn_find);
        wbview = findViewById(R.id.wbview);

        btn_find.setOnClickListener(view -> {

            wbview.getSettings().setJavaScriptEnabled(true);
            wbview.loadUrl("https://www.google.com/maps/dir/"+source.getText().toString()+"/"+destination.getText().toString()+"/@24.9627602,67.099647,14z");

        });


    }
}

//    String video_url = "android.resource://" +SplashScreen.this.getPackageName()+"/" + R.raw.abcde;
//    final VideoView videoView = findViewById(R.id.videoView);
//    Uri videoUri = Uri.parse(video_url);
//    MediaController mediaController= new MediaController(SplashScreen.this);
//        mediaController.setAnchorView(videoView);
//                videoView.setMediaController(mediaController);
//                videoView.setVideoURI(videoUri);
//                videoView.requestFocus();
//                videoView.start();