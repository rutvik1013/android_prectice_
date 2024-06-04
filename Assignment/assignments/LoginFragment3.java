package com.example.assignments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignments.databinding.FragmentLogin3Binding;


public class LoginFragment3 extends Fragment {

    FragmentLogin3Binding binding;

    public LoginFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLogin3Binding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        View view=binding.getRoot();

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.edtemail.getText().toString();
                String password=binding.edtpassword.getText().toString();


                if (email.length()==0&&password.length()==0){
                    binding.edtemail.setError("Please Enter Valid Email Adress");
                    binding.edtpassword.setError("Please Enter Valid Password");

                }
                if (email.length()==0){
                    binding.edtemail.setError("Please Enter Valid Email Adress");
                }
                else if(password.length()==0)
                {
                    binding.edtpassword.setError("Please Enter Valid Password");
                }
                else
                {
                    if (email.equals("kumarrutvik24@gmail.com")&&password.equals("1013")){
                        Toast.makeText(getActivity(), "Login", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getActivity(), WelcomeScreen.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        return view;



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}