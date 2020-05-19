package com.jeffreykingori.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //get the intent sent from Main Activity
        Intent intent = getIntent();
        String displayMessage = intent.getStringExtra(MainActivity.EXTRA_ORDER_KEY);

        TextView orderDisplay = findViewById(R.id.display_order);
        orderDisplay.setText(displayMessage);

    }

    //handles radio input
    public void onRadioButtonSelected(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.same_day:
                if(checked){
                    displayToast(getString(R.string.same_day_delivery));
                    break;
                }

            case R.id.next_day:
                if(checked){
                    displayToast(getString(R.string.next_day_delivery));
                    break;
                }

            case R.id.pick_up:
                if(checked){
                    displayToast(getString(R.string.pick_up));
                    break;
                }

            default:
                //do something
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
