package com.example.lifesaver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Registration extends Activity{
	ListView lv_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.s);
		lv_register=(ListView)findViewById(R.id.ListView_Registration);

	}

}
