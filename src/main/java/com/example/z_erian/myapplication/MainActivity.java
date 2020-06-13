package com.example.z_erian.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num;
    TextView nameD,phD,addD,numD,emailD;
    Vehicle v[] = new Vehicle[5];
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.e_number);
        nameD = findViewById(R.id.name_t);
        phD = findViewById(R.id.con_t);
        addD = findViewById(R.id.address_t);
        numD = findViewById(R.id.number_t);
        emailD = findViewById(R.id.email_t);



        // Vehicle(String name, String number, String address, int ph)
        v[0] = new Vehicle("Ayan Naresh Gadpal","MH12BX1267","Dhankawadi,Pune","775725466","ayangadpal2@gmail.com");
        v[1] = new Vehicle("Anvesh Mahindra Inamdar","MH09DX1999","Kolhapur","9881766558","ayanbest001@gmail.com");
        v[2] = new Vehicle("Zaid Sheik","MH20KX9629","Aurangabad","9003321223","mzaid0055@gmail.com");
        v[3] = new Vehicle("Aman Sharma","MH02DX9932","Nashik","8007737139","sharmaaman4320@gmail.com");
        v[4] = new Vehicle("Shivani sanjay Kasar","MH14DX1342","Nagpur","8003348204","Shivanikasar61299@gmail.com");




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dummy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.dummy:
                Toast.makeText(this,"Dummy Database",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,dummy.class));

                break;


            case R.id.dev:
                Toast.makeText(this,"Our Team",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,devlopers.class));
            break;
        }


        return true;
    }

    public void findby(View view) {
        int i;
        String key = num.getText().toString();


        //Checking The Input Number
        if(key.length() == 10)
        {
            key = key.toUpperCase();
            for (i=0;i<5;i++)
            {
                //Linear Search
                if(v[i].search(key))
                {
                    nameD.setText(v[i].getName());
                    numD.setText(v[i].getNumber());
                    addD.setText(v[i].getAddress());
                    phD.setText(v[i].getPh());
                    emailD.setText(v[i].getEmail());
                    flag = true;
                    if(R.id.email_b == view.getId())
                    {
                        Intent in = new Intent(Intent.ACTION_SEND);
                        in.setType("message/rfc822");

                        in.putExtra(Intent.EXTRA_EMAIL,new String[]{v[i].getEmail()});
                        in.putExtra(Intent.EXTRA_SUBJECT,"Number Plate");
                        in.putExtra(Intent.EXTRA_TEXT,"You Got Fine of Cold Coffee");
                        try
                        {
                            startActivity(Intent.createChooser(in,"Send Fine..."));
                        }
                        catch (android.content.ActivityNotFoundException ex)
                        {
                            Toast.makeText(this,"No Email Client Found",Toast.LENGTH_SHORT).show();
                        }

                    }
                    break;
                }

            }
            if(i==5)
            {
                Toast.makeText(this,"Not Found",Toast.LENGTH_SHORT).show();
            }


        }
        else
        {
            Toast.makeText(this,"Enter Proper Vehicle Number",Toast.LENGTH_SHORT).show();
        }



    }


}
