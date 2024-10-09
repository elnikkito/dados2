package com.example.dados2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int contadorU1 = 0;
    private int contadorU2 = 0;
    private int contadorGeneralInt= 0;
    private boolean turno=true;
    private int valorTemporal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonlanzar = findViewById(R.id.lanzar);
        Button botonturno = findViewById(R.id.turno);
        Button botonnuevo = findViewById(R.id.nuevo);
        TextView contadoru1 = findViewById(R.id.ContadorU1);
        TextView contadoru2 = findViewById(R.id.ContadorU2);
        TextView contadorGeneral = findViewById(R.id.ContadorGeneral);
        ImageView imagen = findViewById(R.id.imageView);
        View view1=findViewById(R.id.view1);
        View view2=findViewById(R.id.view2);


        botonlanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valorRandom;
                int valorU1,valorU2;
                int colorFondo=Color.argb(255,133 ,204,192);
                int colorFondo2=Color.argb(255,34,138,121);
                valorRandom = (int) (Math.random() * 6) + 1;

                if (valorRandom != 1) {
                    contadorGeneralInt =contadorGeneralInt+ valorRandom;
                    valorTemporal=valorTemporal+valorRandom;
                } else {
                    contadorGeneralInt = 0;
                    valorTemporal=0;
                }

                contadorGeneral.setTextSize(25);
                contadorGeneral.setGravity(Gravity.CENTER);
                contadorGeneral.setText(String.valueOf(contadorGeneralInt));

                if(turno){
                    view1.setBackgroundTintList(ColorStateList.valueOf(colorFondo));
                    view2.setBackgroundTintList(ColorStateList.valueOf(colorFondo2));

                    contadoru1.setTextSize(25);
                    contadoru1.setGravity(Gravity.CENTER);
                    contadoru1.setText(String.valueOf(contadorU1));

                    if (valorRandom==1){
                        turno=false;
                    }
                    if(contadorU1>=100){
                        Toast.makeText(MainActivity.this,"Player1 WIN",Toast.LENGTH_LONG).show();
                    }
                }else{
                    view1.setBackgroundTintList(ColorStateList.valueOf(colorFondo2));
                    view2.setBackgroundTintList(ColorStateList.valueOf(colorFondo));

                    contadoru2.setTextSize(25);
                    contadoru2.setGravity(Gravity.CENTER);
                    contadoru2.setText(String.valueOf(contadorU2));

                    if(valorRandom==1){
                        turno=true;
                    }
                    if(contadorU2>=100){
                        Toast.makeText(MainActivity.this,"Player2 WIN",Toast.LENGTH_LONG).show();
                    }
                }

                switch (valorRandom){
                    case 1:
                        imagen.setImageResource(R.drawable.dice_one);
                        break;
                    case 2:
                        imagen.setImageResource(R.drawable.dice_two);
                        break;
                    case 3:
                        imagen.setImageResource(R.drawable.dice_three);
                        break;
                    case 4:
                        imagen.setImageResource(R.drawable.dice_four);
                        break;
                    case 5:
                        imagen.setImageResource(R.drawable.dice_five);
                        break;
                    case 6:
                        imagen.setImageResource(R.drawable.dice_six);
                        break;
                }

            }
        });

        botonturno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (turno) {
                    contadorU1 =contadorU1+ valorTemporal;
                    contadoru1.setText(String.valueOf(contadorU1));
                } else {
                    contadorU2 =contadorU2+ valorTemporal;
                    contadoru2.setText(String.valueOf(contadorU2));
                }
                valorTemporal=0;
                turno=!turno;
                contadorGeneralInt=0;
                contadorGeneral.setText(String.valueOf(contadorGeneralInt));
            }
        });

        botonnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadoru1.setText(""+0);
                contadoru2.setText(""+0);
                contadorU1=0;
                contadorU2=0;
                contadorGeneral.setText(""+0);
                contadorGeneralInt=0;
                valorTemporal=0;
            }
        });

    }

}