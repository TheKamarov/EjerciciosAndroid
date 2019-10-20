package com.example.mercadoabierto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewFragment recyclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new RecyclerViewFragment());

    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainActivity_FrameLayout_ContenedorDeFragments, fragment)
                .addToBackStack(null)
                .commit();
    }
}
