package com.rhemnet.ui.activity;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rhemnet.R;
import com.rhemnet.util.FontUtils;
import com.rhemnet.util.HttpUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistrationActivity extends FragmentActivity {
    //basic
    EditText mUsernameEdit, mPasswordEdit, mRepeatPasswordEdit, mEmailEdit, mFirstNameEdit, mSecondNameEdit, mCityEdit, mCountryEdit;
    String mUsername, mPassword, mRepeatPassword, mEmail , mFirstName, mSecondName, mCity, mCountry;
    //Location
    EditText  mAddressEdit , mHouseNoEdit,mZipcodeEdit, mProvinceEdit;
    String mAddress,mHouseNo, mZipcode,  mProvince;
    //Communications
    EditText mTelephoneEdit, mFacebookEdit, mTwitterEdit, mWebsiteEdit, mFaxEdit;
    String mTelephone, mFacebook, mTwitter , mWebSite, mFax;
    //work
    EditText mOrganisationEdit, mOrganisationRoleEdit;
    String mOrganisation, mOrganisationRole;

    CheckBox mAcceptCheck;
    Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initUi();

        //initFont();
    }

    private void initUi(){
        //basic
        mUsernameEdit = (EditText) findViewById(R.id.register_edit_username);
        mPasswordEdit = (EditText) findViewById(R.id.register_edit_password);
        mRepeatPasswordEdit = (EditText) findViewById(R.id.register_edit_repeat_password);
        mEmailEdit = (EditText) findViewById(R.id.register_edit_email);
        mFirstNameEdit = (EditText) findViewById(R.id.register_edit_first_name);
        mSecondNameEdit = (EditText) findViewById(R.id.register_edit_second_name);
        mCityEdit = (EditText) findViewById(R.id.register_edit_city);
        mCountryEdit = (EditText) findViewById(R.id.register_edit_country);

        //Locations
        mAddressEdit = (EditText) findViewById(R.id.register_edit_address);
        mHouseNoEdit = (EditText) findViewById(R.id.register_edit_house_no);
        mZipcodeEdit = (EditText) findViewById(R.id.register_edit_zip_code);
        mProvinceEdit = (EditText) findViewById(R.id.register_edit_province);

        //Communications E mTelephoneEdit, mFacebookEdit, mTwitterEdit , mWebsiteEdit, mFaxEdit;
        mTelephoneEdit  = (EditText) findViewById(R.id.register_edit_phone);
        mFacebookEdit = (EditText) findViewById(R.id.register_edit_facebook);
        mTwitterEdit = (EditText) findViewById(R.id.register_edit_twitter);
        mWebsiteEdit = (EditText) findViewById(R.id.register_edit_website);
        mFaxEdit = (EditText) findViewById(R.id.register_edit_fax);

        //career || work  mOrganisationEdit, mOrganisationRoleEdit;
        mOrganisationEdit = (EditText) findViewById(R.id.register_edit_organisation_id);
        mOrganisationRoleEdit = (EditText) findViewById(R.id.register_edit_organisation_role);

        mAcceptCheck = (CheckBox) findViewById(R.id.register_check_accept);
        mAcceptCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mSendButton.setEnabled(true);
                }else{
                    mSendButton.setEnabled(false);
                }

            }
        });
        mSendButton= (Button) findViewById(R.id.register_btn_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RegisterAsyncTask().execute();

            }
        });
    }

    private void getData(){
        //mCity, mCountry;mHouseNo, mZipcode,  mProvince;mFacebook, mTwitter , mWebSite, mFax;mOrganisation, mOrganisationRole;
        mUsername= mUsernameEdit.getText().toString().trim();
        mPassword = mPasswordEdit.getText().toString().trim();
        mRepeatPassword= mRepeatPasswordEdit.getText().toString().trim();
        mEmail = mEmailEdit.getText().toString().trim();
        mFirstName= mFirstNameEdit.getText().toString().trim();
        mSecondName = mSecondNameEdit.getText().toString().trim();
        mAddress= mAddressEdit.getText().toString().trim();
        mTelephone = mTelephoneEdit.getText().toString().trim();
        mCity = mCityEdit.getText().toString().trim();
        mCountry = mCountryEdit.getText().toString().trim();
        mHouseNo = mHouseNoEdit.getText().toString().trim();
        mZipcode = mZipcodeEdit.getText().toString().trim();
        mProvince = mProvinceEdit.getText().toString().trim();
        mFacebook = mFacebookEdit.getText().toString().trim();
        mTwitter = mTwitterEdit.getText().toString().trim();
        mFax = mFaxEdit.getText().toString().trim();
        mOrganisation = mOrganisationEdit.getText().toString().trim();
        mOrganisationRole = mOrganisationRoleEdit.getText().toString().trim();
    }

    private boolean validateFields(){

        //first_name,last_name,email,user_name, password, city, country_code
        if (mFirstName== null || mFirstName.equals("")){
            Toast.makeText(this,"The field First Name can not be empty!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (mSecondName == null || mSecondName.equals("")){
            Toast.makeText(this,"The field Second Name can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }
        if (mEmail == null || mEmail.equals("")){
            Toast.makeText(this,"The field Email can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }
        if(mUsername == null || mUsername.equals("")){
            Toast.makeText(this,"The field Username can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }

        if(mPassword == null || mPassword.equals("")){
            Toast.makeText(this,"The field Password can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }

        if(mRepeatPassword == null || mRepeatPassword.equals("")){
            Toast.makeText(this,"The field Password can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }else if (!mPassword.equals(mRepeatPassword)){
            Toast.makeText(this,"The Password does not match", Toast.LENGTH_LONG).show();
            return  false;
        }

        if (mCity== null || mCity.equals("")){
            Toast.makeText(this,"The field City can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }

        if (mCountry== null || mCountry.equals("")){
            Toast.makeText(this,"The field Country can not be empty!", Toast.LENGTH_LONG).show();
            return  false;
        }
        return true;
    }


    private String register(){
        String result = null;
        getData();
        if (validateFields()){
            try{
                String url = "http://www.gen1e.com/rhemnet_api/api/v1/signup/";
                JSONObject json = new JSONObject();
                //,,,, , ,
                json.put("first_name","abc");
                json.put("last_name","def");
                json.put("email","123@hotmail.com");
                json.put("user_name","rhemnet123");
                json.put("password","123321");
                json.put("city","Guangzhou");
                json.put("country_code","86");

                Map<String,String> header = new HashMap<String,String>();
                header.put("API_KEY","911e5cdaaa76548e7fdc5b09745075d8");
                result = HttpUtil.postJson(url, json.toString(), header);

                Log.i("supertank","the result is : " + result.toString());

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return result;
    }


    private void initFont() {
        TextView textView = (TextView) findViewById(R.id.text_register_form);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_username);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_repeat_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_email);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_name);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_address);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.edit_phone);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_accept_terms);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_username);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_repeat_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_email);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_name);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_second_name);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_address);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_phone);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);


    }

    class RegisterAsyncTask extends AsyncTask<Object[],String, String>{

        @Override
        protected String doInBackground(Object[]... params) {
            return register();
        }



        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
             Log.i("supertank",o);

        }
    }
}
