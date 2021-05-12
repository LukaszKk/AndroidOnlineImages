package com.example.internthread2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SubActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Bundle bundle = getIntent().getExtras();
        String adr = bundle.getString("adress");
        String title = bundle.getString("title");
        setTitle(title);

        button = findViewById(R.id.btnRet);
        imageView = findViewById(R.id.img);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        ImgTransfer imgTransfer = new ImgTransfer();
        imgTransfer.execute(adr);
    }

    public void onReturn(View view) {
        finish();
    }

    private class ImgTransfer extends AsyncTask<String, Void, Boolean> {

        private Bitmap bitmap;

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(ProgressBar.VISIBLE);
            button.setEnabled(false);
            textView.setText(R.string.img_transfer);

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(0, 0, bitmap.getWidth() - 1, bitmap.getHeight() - 1, paint);
                Bitmap resized = Bitmap.createScaledBitmap(bitmap, imageView.getWidth(),
                        (int)(bitmap.getHeight() * (double) imageView.getWidth() / bitmap.getWidth()), true);
                imageView.setImageBitmap(resized);
                textView.setText(String.format(
                        getString(R.string.transfer_complete), resized.getWidth(), resized.getHeight()));
            } else {
                textView.setText(R.string.transfer_error);
            }
            button.setEnabled(true);
            progressBar.setVisibility(ProgressBar.INVISIBLE);

            super.onPostExecute(aBoolean);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openStream();
                Bitmap tmp = BitmapFactory.decodeStream(inputStream);
                bitmap = tmp.copy(Bitmap.Config.ARGB_8888, true);
            } catch (IOException e) {
                return false;
            }
            return true;
        }
    }
}