package com.example.lifesaver;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Registration extends Activity{
	//ListView lv_register;
	TextView tv_DOB_view;
	EditText et_username,et_password,et_name,et_area,et_pincode,et_contactno,et_email;
	RadioGroup rg_gender;
	Button btn_submit;
    ImageButton ib_DOB;
	String username,password,name,area,email,is_interested_to_donate_blood,gender,blood_group,date_of_birth;
	Integer pincode,contactno;
	Spinner spinner_blood_group,spinner_is_interested_to_donate_blood;
    int Year,Month,Day;
    Calendar calendar=Calendar.getInstance();
    java.text.DateFormat dateFormat=java.text.DateFormat.getDateInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		//lv_register=(ListView)findViewById(R.id.);
		// instantiatinf the layout components
		et_username=(EditText)findViewById(R.id.et_username_register);
		et_password=(EditText)findViewById(R.id.et_password_register);
		et_name=(EditText)findViewById(R.id.et_name_register);
		//et_dob=(EditText)findViewById(R.id.et_dob_register);
		et_area=(EditText)findViewById(R.id.et_area_register);
		et_pincode=(EditText)findViewById(R.id.et_pincode_register);
		et_contactno=(EditText)findViewById(R.id.et_phone_register);
		et_email=(EditText)findViewById(R.id.et_email_register);
        tv_DOB_view=(TextView)findViewById(R.id.tv_dobview_register);
		rg_gender=(RadioGroup)findViewById(R.id.rg_gender_register);
		btn_submit=(Button)findViewById(R.id.btn_submit_register);
        ib_DOB=(ImageButton)findViewById(R.id.ib_dob_register);
		spinner_blood_group=(Spinner)findViewById(R.id.blood_group);
        spinner_is_interested_to_donate_blood=(Spinner)findViewById(R.id.interested_or_not_register);

		username=et_username.getText().toString();
		password=et_password.getText().toString();
		name=et_name.getText().toString();
		area=et_area.getText().toString();
		pincode=Integer.parseInt(et_pincode.getText().toString());
		contactno=Integer.parseInt(et_contactno.getText().toString());
		email=et_email.getText().toString();
		//is_interested_to_donate_blood=et_is_interested_to_donate_blood.getText()

        Is_Interested_to_Donate_Blood(); // calling methods to add list in the Is interested to donate blood and Blood group options
        Select_Blood_Group();

        //method for selecting gender
		rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_male_register:
                        gender = "Male";
                        break;

                    case R.id.rb_female_register:
                        gender = "Female";
                        break;
                }
            }
        });

        //method for selecting option is interested to donate blood
        spinner_is_interested_to_donate_blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                is_interested_to_donate_blood=String.valueOf(spinner_is_interested_to_donate_blood.getSelectedItem());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                is_interested_to_donate_blood="Null";
                Toast.makeText(Registration.this,"Please select Yes or No in the 'Is Interested to donate Blood Option'",Toast.LENGTH_SHORT).show();
            }
        });

        //Method to select blood group
        spinner_blood_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                blood_group = String.valueOf(spinner_blood_group.getSelectedItem());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                blood_group = "Null";
                Toast.makeText(Registration.this, "Please select a Blood Group from the list", Toast.LENGTH_SHORT).show();

            }
        });




        // Setting Listener to Date Picker
        final DatePickerDialog.OnDateSetListener DateListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Year=year;
                Month=monthOfYear;
                Day=dayOfMonth;
                tv_DOB_view.setText(dateFormat.format(calendar.getTime()));

            }
        };

        // Method to select Date Of Birth Date Picker dialog Box
        ib_DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Registration.this,DateListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });








	}

// adding list yes no to the interested to donate blood or not dropdown option
   public void Is_Interested_to_Donate_Blood (){
       List<String>list=new ArrayList<String>();
       list.add("Yes");
       list.add("No");

       ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
       spinner_is_interested_to_donate_blood.setAdapter(arrayAdapter);

   }

    public void Select_Blood_Group(){
        List<String>blood_Group_List=new ArrayList<>();
        blood_Group_List.add("O+");
        blood_Group_List.add("O-");
        blood_Group_List.add("A+");
        blood_Group_List.add("A-");
        blood_Group_List.add("B+");
        blood_Group_List.add("B-");
        blood_Group_List.add("AB+");
        blood_Group_List.add("Ab-");
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
        spinner_blood_group.setAdapter(arrayAdapter);

    }
}