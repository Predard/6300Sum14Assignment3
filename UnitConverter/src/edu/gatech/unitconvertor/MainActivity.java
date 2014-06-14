package edu.gatech.unitconvertor;

import edu.gatech.unitconverter.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//initialize activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // setup activity_main layout xml file
        
        setupMessageButton(); //define buttons 
    }
    
    private void setupMessageButton(){
    	Button messageButton = (Button) findViewById(R.id.button1); // define button for Distance
    	Button messageButton2 = (Button) findViewById(R.id.button2); // define button for Weight
    	Button messageButton3 = (Button) findViewById(R.id.button3); // define button for temperature
    	
    	messageButton.setOnClickListener(new View.OnClickListener(){ // on button click, handle Distance activity
    		@Override
    		public void onClick(View v){
    				 startActivity(new Intent (MainActivity.this, DistanceActivity.class)); // link button with distance activity
    		}
    	});
    	messageButton2.setOnClickListener(new View.OnClickListener(){ //on button click, handle Weight activity
    		@Override
     		public void onClick(View v){
    				 startActivity(new Intent (MainActivity.this, WeightActivity.class));// link button with Weight activity
    		}
    	});
       	messageButton3.setOnClickListener(new View.OnClickListener(){ // on button click, handle temperature activity
    				    	
    		@Override
       		public void onClick(View v){
    				startActivity(new Intent (MainActivity.this, TemperatureActivity.class)); // link button with temperature activity
    		
    		}
    	});
    }
}
