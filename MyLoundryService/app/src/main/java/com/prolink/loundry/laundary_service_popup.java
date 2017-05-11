package com.prolink.loundry;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Sabbi on 06-03-2016.
 */
public class laundary_service_popup extends DialogFragment implements View.OnClickListener {

    Button ok, cancel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.laundary_service_popup, container,false);

        ok = ( Button)view.findViewById(R.id.btn_ok_popup);
        cancel = ( Button)view.findViewById(R.id.btn_cancel_popup);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);

        setCancelable(false);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_ok_popup)
        {
            dismiss();
            Toast.makeText(getActivity(),"Ok",Toast.LENGTH_SHORT).show();
        }
        else
        {
            dismiss();
        }
    }
}
