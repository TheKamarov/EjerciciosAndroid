package com.example.ciclodevidaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //En el onCreate se realizan tareas que deben ocurrir una sola vez en todo el ciclo de vida de una activity
    //Son cosas que solo queremos que ocurran una ves

    //El seteo de la vista se hace con el setContentView

    //Luego que el sistema invoca al metodo onStart el activity estara visible para el usuario y
    //el sistema empieza a prepararlo para que el usuario pueda interactuar con los componentes que
    //tiene dicha actividad
    //En el onStart no debemos realizar tareas pesadas como por ejemplo cosas viculadas con bases de
    //datos, ya que este metodo debe ocurrir de manera rapida, ya que necesitamos que el user tenga
    //la posibilidad de interaccion lo mas pronto posible

    //En el metodo onResume la actividad ya esta visible para el user y ademas ya puede interactuar
    //con los componentes.Puede apretar botones, llenar textos, etx...
    //A partir del onResume se dice que el user tiene capacidad de interaccion, y quedara en este
    //estado hasta que ocurra algun evento de pausa

    //A los metodos onStart y onResume el sistema los invocara si por ejemplo minimizamos nuestra
    //app para ir al home de celular y luego la reanudamos
    //Al reanudar el sistema invocara a onStart y acto seguido al onResume
    //Ambos metodos pueden ser invocados mas de una ves, a diferencia del onCreate que se invoca una
    //sola ves

    //Al metodo onPause lo invoca el sistema si un evento interrumpe nuestra activity y perdemos el
    //foco parcial de la misma, tambien se puede dar el caso de que otra activity pase a ser la que
    //este en primer plano, por lo que nuestra activity perderia el foco, por este caso se invocara
    //a este metodo antes que se cree la nueva activity
    //En el onPause no debemos hacer tareas pesadas porque este metodo debe ser muy rapido, porque
    //sino estaria atrasando el inicio de la segunda activity
    //Las operciones costosas para salvar cosas debemos hacerlas en el onStop

    //Al metodo onStop se llega si nuestra activity perdio el foco por completo
    //Aqui es un buen momento para liberar recursos que no se necesitan

    //Al metodo onDestroy se lo invoca justo antes de que el sistema destruya nuestra activity
    //Puede ser que sea destruida porque el sistema necesita liberar memoria o porque nosotros
    //mismos invocamos a un metodo llamado finish()
    //En el metodo onDestroy se terminan de liberar todos los recurso que no han sido liberados
    //anteriormente por ejemplo en los metodos opPause o en el onStop
    //El metodo onDestroy es invocado por el sistema cuando apretamose el boton back de android y
    //nuestra activity es destruida


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
