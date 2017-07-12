package com.somaznasi.hannesv.perceptionradio.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.somaznasi.hannesv.perceptionradio.Fragments.DetailsFragment;
import com.somaznasi.hannesv.perceptionradio.Fragments.MainFragment;
import com.somaznasi.hannesv.perceptionradio.Model.Station;
import com.somaznasi.hannesv.perceptionradio.R;

public class MainActivity extends AppCompatActivity {

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance("blah","kah");
            fm.beginTransaction()
                    .add(R.id.container_main, mainFragment)
                    .commit();
        }
    }

    public void loadDetailScreen(Station selectedStation){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
