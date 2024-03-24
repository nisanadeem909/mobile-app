package com.example.myapplication;
import com.example.myapplication.BlankFragment;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        
        loadFragment(new BlankFragment());
        loadFragment(new BlankFragment2());

        // Set click listeners for the icons
        findViewById(R.id.icon1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new BlankFragment());
            }
        });

        findViewById(R.id.icon2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new BlankFragment2());
            }
        });


        findViewById(R.id.backArrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SignupActivity
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity to prevent going back to it from the SignupActivity
            }
        });
    }

    // Method to load a fragment into the contentLayout FrameLayout
    private void loadFragment(androidx.fragment.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contentLayout, fragment);
        transaction.addToBackStack(null); // Add the transaction to the back stack
        transaction.commit();
    }
}