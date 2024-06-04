package com.example.assignments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignments.databinding.FragmentRegistration3Binding;


public class RegistrationFragment3 extends Fragment {

    FragmentRegistration3Binding binding;

    public RegistrationFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding=FragmentRegistration3Binding.inflate(inflater,container,false);
       View view=binding.getRoot();

       binding.btnsignin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                String name=binding.edtname.getText().toString();
                String phone=binding.edtphone.getText().toString();
                String adress=binding.edtaddress.getText().toString();
                String email=binding.edtemail.getText().toString();
                String password=binding.edtpassword.getText().toString();


                if (name.length()==0&&phone.length()==0&&adress.length()==0&&email.length()==0&&password.length()==0){
                    binding.edtname.setError("Please Enter Your Name");
                    binding.edtphone.setError("Please Enter Your Phone Number");
                    binding.edtaddress.setError("Please Enter Your Adress");
                    binding.edtemail.setError("Please Enter Your Email Adress");
                    binding.edtpassword.setError("You Have to Enter Your Email Password");
                }
                if (name.length()==0){
                    binding.edtname.setError("Please Enter Your Name");
                }
                else if (phone.length()==0){
                    binding.edtphone.setError("Please Enter Your Phone Number");
                }
                else if (adress.length()==0){
                    binding.edtaddress.setError("Please Enter Your Adress");
                }
                else if (email.length()==0){
                    binding.edtemail.setError("Please Enter Your Email Adress");
                }
                else if (password.length()==0){
                    binding.edtpassword.setError("You Have to Enter Your Email Password");
                }
                else
                {
                    LoginFragment3 loginFragment3=new LoginFragment3();

                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    FragmentTransaction ft= fm.beginTransaction();
                    ft.replace(R.id.FramLayout,loginFragment3);
                    ft.commit();
                }

           }
       });
       return  view;
    }
}