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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class MainActivity extends Activity {
	
	
	private double secret = 0;
	
	private LinearLayout linear2;
	private LinearLayout linear4;
	private TextView textview1;
	private EditText edittext1;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	
	private Intent i = new Intent();
	private SharedPreferences ja;
	private SharedPreferences language;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview1 = (TextView) findViewById(R.id.textview1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		ja = getSharedPreferences("ja", Activity.MODE_PRIVATE);
		language = getSharedPreferences("language", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				secret++;
				if (secret == 150) {
					i.setClass(getApplicationContext(), EastereggActivity.class);
					startActivity(i);
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("CafePause")) {
					i.setClass(getApplicationContext(), LicenseActivity.class);
					startActivity(i);
				}
				else {
					if (edittext1.getText().toString().equals("EASTEREGG")) {
						SketchwareUtil.showMessage(getApplicationContext(), "wow, du hast das easter egg gefunden. zünde eine kerze an und fang an zu heulen, weil es noch ein zweites easter egg gibt.");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Das Passwort ist falsch, versuche es gleich noch einmal.");
					}
				}
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (language.getString("language", "").equals("en")) {
					SketchwareUtil.showMessage(getApplicationContext(), "If you forget the password of the substitution plan, ask a teacher to tell you the password.");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Falls du das Passwort des Vertretungsplans vergessen hast, bitte einen Lehrer, dir das Passwort mitzuteilen.");
				}
			}
		});
	}
	private void initializeLogic() {
		if (ja.getString("ja", "").equals("Joa")) {
			i.setClass(getApplicationContext(), HomeActivity.class);
			startActivity(i);
		}
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/tmo.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/tmo.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/tmo.ttf"), 0);
		if (language.getString("language", "").equals("en")) {
			textview1.setText("Please type in the Password.");
			textview2.setText("I forgot the password");
			edittext1.setHint("Password");
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
