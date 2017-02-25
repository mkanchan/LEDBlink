package com.mukesh.kanchan.ledblink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.calit2.mooc.iot_db410c.db410c_gpiolib.GpioProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                GpioProcessor gpioProcessor = new GpioProcessor();

                GpioProcessor.Gpio led = gpioProcessor.getPin34();
                led.out();

                for (int i=0; i<20; i++) {
                    led.high();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    led.low();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
