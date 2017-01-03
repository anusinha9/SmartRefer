package com.example.aakash.smartrefer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;



public class addthings extends AppCompatActivity {
    Button photo;
    ImageView imageView;
    public static final int CONTENT_REQUEST = 1337;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addthings);
        photo = (Button) findViewById(R.id.photo);
        imageView = (ImageView) findViewById(R.id.imagephoto);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CONTENT_REQUEST);

            }
        });

    }

    private File getFile() {
        File folder = new File("sdcard/smartrefer");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "campic1.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String path = "sdcard/smartrefer/campic1.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}

