package com.prolink.loundry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Lenovo on 28-May-16.
 */
public class ProfileActivity extends Fragment {
    ViewGroup view;
    ImageView img_edit;
    Button btn_update;
    EditText et_name, et_email, et_mob,et_pass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.profile_activity_layout, container, false);

        et_name = (EditText) view.findViewById(R.id.name);
        et_email = (EditText) view.findViewById(R.id.email);
        et_mob = (EditText) view.findViewById(R.id.mobile);
        et_pass = (EditText) view.findViewById(R.id.et_password);
        img_edit = (ImageView)view.findViewById(R.id.edit);
        btn_update = (Button)view.findViewById(R.id.updateProfile);
        btn_update.setVisibility(View.GONE);
        et_name.setEnabled(false);
        et_email.setEnabled(false);
        et_mob.setEnabled(false);
        et_pass.setEnabled(false);

        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_update.setVisibility(View.VISIBLE);
                et_name.setEnabled(true);
                et_email.setEnabled(true);
                et_mob.setEnabled(true);
                et_pass.setEnabled(true);


                btn_update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn_update.setVisibility(View.GONE);
                        et_name.setEnabled(false);
                        et_email.setEnabled(false);
                        et_mob.setEnabled(false);
                        et_pass.setEnabled(false);

                    }
                });


            }
        });

        return  view;

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainDrawer)getActivity()).getSupportActionBar().setTitle("Profile");
    }
}
