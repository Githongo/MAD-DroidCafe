package com.jeffreykingori.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "KEY FOR ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toOrder = new Intent(MainActivity.this, OrderActivity.class);
                toOrder.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(toOrder);

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case R.id.action_order:
                Intent toOrder = new Intent(MainActivity.this, OrderActivity.class);
                toOrder.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(toOrder);
                return true;

            case R.id.action_call_us:
                //Call number
                Uri myUri = Uri.parse("tel:0710113242");
                Intent myIntent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(myIntent);
                break;

            case R.id.action_about_us:
                //redirect to web page
                String url = "https://jeffreykingori.dev/#about";
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(url));
                startActivity(webIntent);
                break;

            case R.id.action_status:
                displayToast("Your have no pending orders");
                break;

            case R.id.action_location:
                //redirect to g-maps
                Uri gmmIntentUri = Uri.parse("geo:-1.286389,36.817223?q=java house");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;


            default:
                break;



        }

        return super.onOptionsItemSelected(item);
    }

    //Toast display method
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void showDonutMessage(View view) {
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showLollipopMessage(View view) {
        mOrderMessage = getString(R.string.lollipop_order);
        displayToast(mOrderMessage);
    }

    public void showCupcakeMessage(View view) {
        mOrderMessage = getString(R.string.cupcake_order);
        displayToast(getString(R.string.cupcake_order));
    }
}
