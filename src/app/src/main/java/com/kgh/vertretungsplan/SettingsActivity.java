package com.kgh.vertretungsplan;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import java.util.ArrayList;
import android.content.SharedPreferences;
import android.widget.AdapterView;

public class SettingsActivity extends Activity {
	
	
	private ArrayList<String> Language = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private LinearLayout linear8;
	private ImageView imageview3;
	private LinearLayout linear6;
	private TextView textview1;
	private Spinner spinner1;
	private ImageView imageview5;
	private LinearLayout linear12;
	private LinearLayout linear19;
	private TextView textview11;
	private TextView textview12;
	private ImageView imageview6;
	private LinearLayout linear15;
	private TextView textview7;
	private ImageView imageview4;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview3;
	private TextView textview4;
	
	private SharedPreferences language;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview1 = (TextView) findViewById(R.id.textview1);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		language = getSharedPreferences("language", Activity.MODE_PRIVATE);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 1) {
					language.edit().putString("language", "").commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Starte die App neu, damit die Änderungen übernommen werden.");
					textview1.setText("Sprache");
					textview11.setText("Quelltext");
					textview7.setText("Einen Fehler melden");
				}
				if (_position == 2) {
					language.edit().putString("language", "en").commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Restart the app for the changes to take effect.");
					textview1.setText("Language");
					textview11.setText("Source code");
					textview7.setText("Report an issue");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
	}
	private void initializeLogic() {
		if (language.getString("language", "").equals("")) {
			textview1.setText("Sprache");
			textview11.setText("Quelltext");
			textview7.setText("Einen Fehler melden");
			Language.add("Deutsch");
			Language.add("Englisch");
			spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Language));
			spinner1.setSelection((int)(1));
		}
		else {
			Language.add("German");
			Language.add("English");
			spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Language));
			spinner1.setSelection((int)(2));
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
