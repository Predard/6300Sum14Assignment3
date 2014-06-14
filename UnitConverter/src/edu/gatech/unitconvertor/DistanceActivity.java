package edu.gatech.unitconvertor;

import edu.gatech.unitconverter.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DistanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) { //initialize activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
	}
	
	public String milesToKm(double miles){ // convert miles to kilometers
		double km = miles * 1.609;
		return String.valueOf(String.format("%.2f",km)); // format with two decimals only
	}
	
	public String kmToMiles(double km){ // convert kilometers to miles
		double miles = km / 1.609;
		return String.valueOf(String.format("%.2f", miles)); // format with two decimals only
	}	
	
	public void handleClick(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		
		try {
			
		EditText txt = (EditText) findViewById(R.id.editText1);

		double distance = Double.parseDouble(txt.getText().toString()); //get decimal number from user
		
		switch(view.getId()){ // apply the appropriate conversion factor depending on user button selection
		
		case R.id.radioButton1:
			if(checked) {
				txt.setText(kmToMiles(distance));
				((RadioButton) findViewById(R.id.radioButton2)).setChecked(false); //reset other button
			}
			break;
		case R.id.radioButton2:
			if (checked){
				 txt.setText(milesToKm(distance));
				((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);//reset other button
			}
			break; 
		}
		}
		
		catch (NullPointerException e){//handle not input from user and button selection
			e.printStackTrace();
			((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);//reset other button
			((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);
		}
		catch (Exception e) {//handle not input from user and button selection
			e.printStackTrace();
			((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);//reset other button
			((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);
		}
	} 
}
