package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button,esit,topla,button5,button6,button7,cikarma,button9,button10,button11,carp,button13,button14,button15,divide,clear,hKayit,hEkle,hCikar,mod;
    EditText ekran;
    EditText result;
    float mValueOne , mValueTwo ;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision,myMod,myMekle ;
    public float result1 ;
    float depo;
    float saved;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("package com.example.calculator", Context.MODE_PRIVATE);
        button1=findViewById(R.id.button1);
        button = findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        esit = (Button) findViewById(R.id.esittir);
        topla = (Button) findViewById(R.id.topla);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        cikarma = (Button) findViewById(R.id.cikar);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        carp = (Button) findViewById(R.id.carp);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        divide = (Button) findViewById(R.id.divide);
        clear= (Button) findViewById(R.id.button17);
        hKayit=findViewById(R.id.button18);
        hEkle=findViewById(R.id.button19);
        hCikar=findViewById(R.id.button20);
        mod=findViewById(R.id.button21);
        ekran=findViewById(R.id.editText);
        result=findViewById(R.id.editText2);
        result.setText(getSaved() + "");
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   /*butonlar basıldıgında rakamları test bolgesine yazıyolar*/
                ekran.setText(ekran.getText()+".");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"0");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(depo + "");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+".");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"1");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"2");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"3");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"4");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"5");
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"6");
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"7");
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"8");
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekran.setText(ekran.getText()+"9");
            }
        });
        topla.setOnClickListener(new View.OnClickListener() {           /* topla butonuna basıldıgında ekran null sa  bos yazıyor degilse ise ilk sayıyı mvalue one alıp maddtion degıskenımızı true yapıyor ki  sayiyi aldıktan sonra esittir basinca 2. sayiyi alip gerekli işlemi yapabilmesini saglamak için boyle bir kontrol yapıyoruz.*/
            @Override
            public void onClick(View v) {

                if (ekran == null){
                    ekran.setText("");
                }else {
                    mValueOne = Float.parseFloat(ekran.getText() + "");
                    mAddition = true;
                    ekran.setText(null);

                }
            }
        });
        cikarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(ekran.getText() + "");
                mSubtract = true ;
                ekran.setText(null);
            }
        });
        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(ekran.getText() + "");
                mMultiplication = true ;
                ekran.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(ekran.getText()+"");
                mDivision = true ;
                ekran.setText(null);
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(ekran.getText()+"");
                myMod = true ;
                ekran.setText(null);
            }
        });
        hKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ekran.getText().toString().matches(""))
                {
                    /*depo=Float.parseFloat(ekran.getText().toString());
                    sharedPreferences.edit().putFloat("saved",depo).apply();
                    saved=  sharedPreferences.getFloat("saved",0);
                    result.setText("Saklanan--->"+saved);*/
                    depo = Float.parseFloat(ekran.getText().toString());
                    result.setText(depo + "");
                }
            }
        });
        hEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mValueOne = Float.parseFloat(ekran.getText()+"");
                result1=depo+mValueOne;
                myMekle=true;
                ekran.setText(null);*/
                depo += Float.parseFloat(ekran.getText().toString());
                result.setText(depo + "");
            }
        });
        hCikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depo -= Float.parseFloat(ekran.getText().toString());
                result.setText(depo + "");
            }
        });


        esit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(ekran.getText() + "");//esittir butonu her basıldıgına kullanıcının yazmis oldugu degeri 2. degiskene atıp gerekli islemi yapıyor.Daha sonra kontrol ettigimiz boolean degiskeni tersine cevirip islemi sonlandırıyor ki o islemden baska isleme basınca devam edebilsin.*/

                if (mAddition == true){

                    ekran.setText(mValueOne + mValueTwo +"");
                    mAddition=false;
                }


                if (mSubtract == true){
                    ekran.setText(mValueOne - mValueTwo+"");
                    mSubtract=false;
                }

                if (mMultiplication == true){
                    ekran.setText(mValueOne * mValueTwo+"");
                    mMultiplication=false;
                }

                if (mDivision == true){
                    ekran.setText(mValueOne / mValueTwo+"");
                    mDivision=false;
                }
                if (myMod== true){

                    ekran.setText(mValueOne % mValueTwo +"");
                    myMod=false;
                }
                if (myMekle== true){

                    result.setText(result1+mValueTwo+"");
                    myMekle=false;
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/* butona bastıgımızda rakamlari girdigimiz edittextin textini temizler.*/
                ekran.setText("");
            }
        });
    }
    @Override
    protected void onPause() {
        setSaved(depo);
        super.onPause();
    }
    private float getSaved(){
        return sharedPreferences.getFloat("saved", 0.0f);
    }
    private void setSaved(float value){
        sharedPreferences.edit().putFloat("saved", depo).apply();
    }
}
