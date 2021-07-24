package com.ingenieriaydesarrollo.gpsstarklogan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class principal extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    plataforma fragment = new plataforma();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content,fragment);
                    fragmentTransaction1.commit();
                    return true;

                case R.id.navigation_dashboard:


                            try {
                                Intent sendIntent = new Intent("android.intent.action.MAIN");
                                sendIntent.putExtra("jid", "57" + "3148727425" + "@s.whatsapp.net");
                                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola, solitamos soporte para ");
                                sendIntent.setAction(Intent.ACTION_SEND);
                                sendIntent.setPackage("com.whatsapp");
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);

                            }catch (Exception ex){
                                Toast.makeText(principal.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                                return false;
                            }


                    return false;







            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        plataforma FragmentPlataforma = new plataforma();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.content,FragmentPlataforma);
        fragmentTransaction1.commit();





    }
    @Override
    public void onBackPressed() {
        // Do nothing
    }

    private void openWhatsApp() {
        String smsNumber = "+573148727425"; // E164 format without '+' sign
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
        sendIntent.setPackage("com.whatsapp");

        startActivity(sendIntent);
    }
}