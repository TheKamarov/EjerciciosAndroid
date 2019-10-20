package com.example.randomgot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewGanadorDelTrono;
    private TextView textViewNombreDelGanadorDelTrono;
    private Button buttonDescubrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encontrarComponentesPorId();

        buttonDescubrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Genero un numero aleatorio que voy a usar para elegir el personaje que gana el trono

                Random randomNumeroAleatorio = new Random();
                int intAleatorio = randomNumeroAleatorio.nextInt(5);

                if(intAleatorio == 0){
                    //busco la imagen en drawable y la coloco en el componente imageView
                    imageViewGanadorDelTrono.setImageDrawable(getDrawable(R.drawable.cersei));
                    textViewNombreDelGanadorDelTrono.setText("Cersei");
                }else if(intAleatorio == 1){
                    //busco la imagen en drawable y la coloco en el componente imageView
                    imageViewGanadorDelTrono.setImageDrawable(getDrawable(R.drawable.daenerys));
                    textViewNombreDelGanadorDelTrono.setText("Daenerys");
                }else if(intAleatorio == 2){
                    //busco la imagen en drawable y la coloco en el componente imageView
                    imageViewGanadorDelTrono.setImageDrawable(getDrawable(R.drawable.jonsnow));
                    textViewNombreDelGanadorDelTrono.setText("Jonsnow");
                }else if(intAleatorio == 3){
                    //busco la imagen en drawable y la coloco en el componente imageView
                    imageViewGanadorDelTrono.setImageDrawable(getDrawable(R.drawable.nightking));
                    textViewNombreDelGanadorDelTrono.setText("Night king");
                }else{
                    //busco la imagen en drawable y la coloco en el componente imageView
                    imageViewGanadorDelTrono.setImageDrawable(getDrawable(R.drawable.tyrion));
                    textViewNombreDelGanadorDelTrono.setText("Tyrion");
                }
            }
        });
    }

    private void encontrarComponentesPorId(){
        imageViewGanadorDelTrono = findViewById(R.id.MainActivity_ImageView_GanadorDelTrono);
        textViewNombreDelGanadorDelTrono = findViewById(R.id.MainActivity_TextView_NombreDelGanadorDelTrono);
        buttonDescubrir = findViewById(R.id.MainActivity_Button_Descubrir);
    }
}
