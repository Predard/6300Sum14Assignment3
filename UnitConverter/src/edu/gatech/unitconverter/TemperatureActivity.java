package edu.gatech.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {// initialize activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temperature);
	}
	
	public String farToCen(double far){ //convert centigrade to farenheit
		double cen = (far-32)/(9.0/5); //make sure 9.0 is used
		return String.valueOf(String.format("%.2f", cen));// format with two decimals only
	}
	
	public String cenToFar(double cen){//convert farenheit to centigrade
		double far = (9.0/5)*cen+32;
		return String.valueOf(String.format("%.2f", far));// format with two decimals only
	}	
	
	public void handleClick(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		
		try {
			
		EditText txt = (EditText) findViewById(R.id.editText1);
		double distance = Double.parseDouble(txt.getText().toString()); //get user input
		
		switch(view.getId()){// apply the appropriate conversion factor depending on user button selection
		
		case R.id.radioButton1:
			if(checked){
				txt.setText(cenToFar(distance));
				((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);
			}
			break;
		case R.id.radioButton2:
			if (checked){
				 txt.setText(farToCen(distance));
					 ((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);
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