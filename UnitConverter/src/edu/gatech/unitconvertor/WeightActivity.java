package edu.gatech.unitconvertor;

import edu.gatech.unitconverter.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class WeightActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {//initialize activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);
	}
	
	public String lbToKg(double lb){//convert pounds to kilograms
		double kg = lb * 0.45359237;
		return String.valueOf(String.format("%.2f", kg));// format with two decimals only
	}
	
	public String kgToLb(double kg){//convert kilograms to pounds
		double lb = kg / 0.45359237 ;
		return String.valueOf(String.format("%.2f",lb));// format with two decimals only
	}	
	
	public void handleClick(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		
		try {
			
		EditText txt = (EditText) findViewById(R.id.editText1);
		double distance = Double.parseDouble(txt.getText().toString());// get user input
		
		switch(view.getId()){// apply the appropriate conversion factor depending on user button selection
		
		case R.id.radioButton1:
			if(checked){
						txt.setText(kgToLb(distance));
				((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);//reset other button
			}
			break;
		case R.id.radioButton2:
			if (checked){
				 txt.setText(lbToKg(distance));
			((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);//reset other button
			}
			break;
		}
		}
		catch (NullPointerException e){ //handle not input from user and button selection
			e.printStackTrace();
			((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);//reset other button
			((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);//reset other button
		}
		catch (Exception e) {//handle not input from user and button selection
			e.printStackTrace();
			((RadioButton) findViewById(R.id.radioButton2)).setChecked(false);//reset other button
			((RadioButton) findViewById(R.id.radioButton1)).setChecked(false);//reset other button
	}
}
}
