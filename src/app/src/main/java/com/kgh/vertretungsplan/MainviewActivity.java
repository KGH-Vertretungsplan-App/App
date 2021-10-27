package com.kgh.vertretungsplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.webkit.WebViewClient;

public class MainviewActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private WebView webview1;
	private ImageView imageview2;
	private LinearLayout linear2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	
	private Intent i = new Intent();
	private SharedPreferences Download;
	private Intent screen = new Intent();
	private SharedPreferences language;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.mainview);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		Download = getSharedPreferences("Download", Activity.MODE_PRIVATE);
		language = getSharedPreferences("language", Activity.MODE_PRIVATE);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				if (_url.contains("subst_001")) {
					_normalize();
					button1.setBackgroundResource(R.drawable.kreis);
				}
				if (_url.contains("subst_002")) {
					_normalize();
					button2.setBackgroundResource(R.drawable.kreis);
				}
				if (_url.contains("subst_003")) {
					_normalize();
					button3.setBackgroundResource(R.drawable.kreis);
				}
				if (_url.contains("subst_004")) {
					_normalize();
					button4.setBackgroundResource(R.drawable.kreis);
				}
				if (_url.contains("subst_005")) {
					_normalize();
					button5.setBackgroundResource(R.drawable.kreis);
				}
				super.onPageFinished(_param1, _param2);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev");
				if (language.getString("language", "").equals("en")) {
					SketchwareUtil.showMessage(getApplicationContext(), "The plans have now been updated.");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Die Vertretungspläne wurden nun aktualisiert.");
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev/subst_001.htm");
				_normalize();
				button1.setBackgroundResource(R.drawable.kreis);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev/subst_002.htm");
				_normalize();
				button2.setBackgroundResource(R.drawable.kreis);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev/subst_003.htm");
				_normalize();
				button3.setBackgroundResource(R.drawable.kreis);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev/subst_004.htm");
				_normalize();
				button4.setBackgroundResource(R.drawable.kreis);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://kghv.byzero.dev/subst_005.htm");
				_normalize();
				button5.setBackgroundResource(R.drawable.kreis);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				screen.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(screen);
			}
		});
	}
	private void initializeLogic() {
		webview1.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		webview1.loadUrl("https://kghv.byzero.dev");
		button1.setBackgroundResource(R.drawable.kreis);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		
	}
	private void _normalize () {
		button1.setBackgroundResource(0);
		button2.setBackgroundResource(0);
		button3.setBackgroundResource(0);
		button4.setBackgroundResource(0);
		button5.setBackgroundResource(0);
	}
	
	
	private void _webviewDialog (final String _URL, final String _title, final String _btn1, final boolean _setC, final String _hexC) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this); 
		alert.setTitle(_title);
		
		WebView wv = new WebView(this);
		wv.loadUrl(_URL);
		wv.setBackgroundColor(Color.parseColor(_hexC));
		
		WebSettings webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true); webSettings.setUseWideViewPort(true);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setSupportZoom(false);
		webSettings.setBuiltInZoomControls(true);
		webSettings.setDisplayZoomControls(true);
		wv.setVerticalScrollBarEnabled(true);
		wv.setHorizontalScrollBarEnabled(true);
		
		wv.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				String cookies = CookieManager.getInstance().getCookie(url);
				request.addRequestHeader("cookie", cookies);
				request.addRequestHeader("User-Agent", userAgent);
				request.setDescription("Downloading file to downloads folder...");
				request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				java.io.File aatv = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/downloads/");
				
				if(!aatv.exists()){if (!aatv.mkdirs()){ Log.e("TravellerLog ::","Problem creating Image folder");}} request.setDestinationInExternalPublicDir("/downloads/", URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				manager.enqueue(request);
				
				showMessage("Downloading ...");
				
				//Notif if success
				
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download finished !");
						
						unregisterReceiver(this);
						
					}};
				
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
				
			}
			
		});
		
		wv.setWebViewClient(new WebViewClient() {
			    @Override
			    public boolean shouldOverrideUrlLoading(WebView view, String url) {
				        view.loadUrl(url);
				
				        return true;
				    }
		});
		
		alert.setView(wv);
		alert.setNegativeButton(_btn1, new DialogInterface.OnClickListener() {
			    @Override
			    public void onClick(DialogInterface dialog, int id) {
				        dialog.dismiss();
				    }
		});
		alert.setCancelable(_setC);
		alert.show();
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
