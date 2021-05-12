package com.example.internthread2;

import android.content.Intent;
import android.view.View;
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

    public void onISS(View view) {
        Intent intent = new Intent(this, ISSActivity.class).putExtra("adress", adrIss);
        startActivity(intent);
    }

    public void onMoon(View view) {
        Intent intent = new Intent(this, MoonActivity.class).putExtra("adress", adrMoon);
        startActivity(intent);
    }

    public void onSun(View view) {
        Intent intent = new Intent(this, SunActivity.class).putExtra("adress", adrSun);
        startActivity(intent);
    }
}