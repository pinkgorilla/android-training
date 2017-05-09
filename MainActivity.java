package com.moonlay.android.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.moonlay.android.training.fragment.MainMenuFragment;
import com.moonlay.android.training.content.MainMenuContent;
import com.moonlay.android.training.model.MainMenuItem;

public class MainActivity extends AppCompatActivity implements MainMenuFragment.OnMainMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null)
                return;

            MainMenuFragment mainMenuFragment = new MainMenuFragment();
            this.getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, mainMenuFragment)
                    .commit();
        }
    }

    @Override
    public void onMainMenuItemClick(MainMenuItem item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }
}
