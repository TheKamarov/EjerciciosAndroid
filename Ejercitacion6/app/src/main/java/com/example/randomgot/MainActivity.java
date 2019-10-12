package com.example.randomgot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagenRey;
    private TextView nombreRey;
    private Button botonDescubrirRey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenRey = findViewById(R.id.activityMain_imageView_imagenRey);
        nombreRey = findViewById(R.id.activityMain_textView_nombreRey);
        botonDescubrirRey = findViewById(R.id.activityMain_button_descubrirRey);

        botonDescubrirRey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarImagenYNombreAlNuevoRey();
            }
        });
    }

    private void agregarImagenYNombreAlNuevoRey(){
        Random numeroAleatorio = new Random();
        Integer integerAleatorio = numeroAleatorio.nextInt(5);

        if(integerAleatorio == 0){
            imagenRey.setImageDrawable(getDrawable(R.drawable.cersei));
            nombreRey.setText("Cersei");
        }else if(integerAleatorio == 1){
            imagenRey.setImageDrawable(getDrawable(R.drawable.daenerys));
            nombreRey.setText("Daenerys");
        }else if(integerAleatorio == 2){
            imagenRey.setImageDrawable(getDrawable(R.drawable.jonsnow));
            nombreRey.setText("Jon snow");
        }else if(integerAleatorio == 3){
            imagenRey.setImageDrawable(getDrawable(R.drawable.nightking));
            nombreRey.setText("Night King");
        }else{
            imagenRey.setImageDrawable(getDrawable(R.drawable.tyrion));
            nombreRey.setText("Tyrion");
        }
    }

}
