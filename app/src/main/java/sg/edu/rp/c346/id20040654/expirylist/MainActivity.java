package sg.edu.rp.c346.id20040654.expirylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // declare variables
    Button btnApp;
    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnApp = findViewById(R.id.buttonApp);
        btnWebsite = findViewById(R.id.buttonWebsite);

        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RPKennethPoh"));
                startActivity(intentWebsite);
            }
        });

    }
}