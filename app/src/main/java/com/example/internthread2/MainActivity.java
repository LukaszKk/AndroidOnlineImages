package com.example.internthread2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final String adrIss = "https://www.heavens-above.com/orbitdisplay" +
            ".aspx?icon=default&width=300&height=300&satid=25544";
    private final String adrMoon = "https://images-na.ssl-images-amazon.com/images/I/41cau0zUwDL._AC_.jpg";
    private final String adrSun = "https://sdo.gsfc.nasa.gov/assets/img/latest/latest_512_HMIBC.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ID_ISS: {
                Intent intent = new Intent(this, SubActivity.class)
                        .putExtra("title", "ISS")
                        .putExtra("adress", adrIss);
                startActivity(intent);
                break;
            }
            case R.id.ID_MOON: {
                Intent intent = new Intent(this, SubActivity.class)
                        .putExtra("title", "Moon")
                        .putExtra("adress", adrMoon);
                startActivity(intent);
                break;
            }
            case R.id.ID_SUN: {
                Intent intent = new Intent(this, SubActivity.class)
                        .putExtra("title", "Sun")
                        .putExtra("adress", adrSun);
                startActivity(intent);
                break;
            }
            default: {
                finish();
            }
        }

        return true;
    }

//    public void onISS(View view) {
//        Intent intent = new Intent(this, SubActivity.class)
//                .putExtra("title", "ISS")
//                .putExtra("adress", adrIss);
//        startActivity(intent);
//    }
//
//    public void onMoon(View view) {
//        Intent intent = new Intent(this, SubActivity.class)
//                .putExtra("title", "Moon")
//                .putExtra("adress", adrMoon);
//        startActivity(intent);
//    }
//
//    public void onSun(View view) {
//        Intent intent = new Intent(this, SubActivity.class)
//                .putExtra("title", "Sun")
//                .putExtra("adress", adrSun);
//        startActivity(intent);
//    }
}