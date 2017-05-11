package com.prolink.loundry;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class Tab2_Laundary_service extends Fragment {

    GridView grid;
   // Button confirmation;
    String[] web = {"Shirt","Pant","T-Shirt","cafiry","Towel","Bedsheet","Suit", "Blezer", "Saree" } ;

    int[] imageId = {R.drawable.shirt, R.drawable.jeans, R.drawable.tshirt, R.drawable.cafiry, R.drawable.towel, R.drawable.bedsheets, R.drawable.suit, R.drawable.blezer, R.drawable.saree };
    String[] price = {"Rs 35","Rs 50","Rs 35","Rs 75","Rs 150","Rs 150","Rs 180","Rs 250","Rs 150"};



    private LayoutInflater layoutInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //Inflate the fragement layout


        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab2_laundary_service, container, false);



        CustomGrid_service_laundary adapter = new CustomGrid_service_laundary(getActivity(), web, imageId, price);
        grid=(GridView)rootView.findViewById(R.id.laundryGridView);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FragmentManager manager = getActivity().getFragmentManager();
                laundary_service_popup laundary_service_popup = new laundary_service_popup();
                laundary_service_popup.show(manager, "MyDialog");
//                Toast.makeText(getActivity(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

//        confirmation = (Button)rootView.findViewById(R.id.order_preconfirm);
//        confirmation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),activity_bill_to_confirmed.class);
//                startActivity(intent);
//            }
//        });

        return  rootView;
    }






}
