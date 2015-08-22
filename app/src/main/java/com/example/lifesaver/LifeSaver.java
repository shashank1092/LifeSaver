package com.example.lifesaver;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class LifeSaver extends Activity {
	EditText username,password;
	Button btn_login,btn_register;
	 
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_saver);
		username=(EditText)findViewById(R.id.et_username_main);
		password=(EditText)findViewById(R.id.et_password_main);
		btn_login=(Button)findViewById(R.id.btn_login_main);
		btn_register=(Button)findViewById(R.id.btn_register_main);

		
	}
	  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	  public void Registration(View v) {
		Intent  i=new Intent(LifeSaver.this,Registration.class);
		startActivity(i);
	}
	public void Login(View v){
		//Intent j=new Intent(LifeSaver.this,Login.class);
	}
}