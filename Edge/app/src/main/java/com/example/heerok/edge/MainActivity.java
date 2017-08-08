package com.example.heerok.edge;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    //Variables
    ImageView mimg;
    EditText mthreshval;
    Button mbutton,msave;
    Bitmap mbit;    //Bitmap obtained from camera activity

    //Tags for Log file
    private static final String TAG = "MainActivity";

    //Async Init for CV2 lib under /app/src/main/jnLibs
    static {
        if(!OpenCVLoader.initDebug()){
            Log.d(TAG, "OpenCV not loaded");
        } else {
            Log.d(TAG, "OpenCV loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mimg= (ImageView) findViewById(R.id.mimage);
        mbutton= (Button) findViewById(R.id.mbutton);
        msave=(Button) findViewById(R.id.msave);
        SeekBar mseek=(SeekBar)findViewById(R.id.seekb);
        mthreshval=(EditText)findViewById(R.id.thresval);

        mthreshval.setText("250");

        mbutton.setOnClickListener(this);
        mseek.setOnSeekBarChangeListener(this);

        msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Saving Image
                String root = Environment.getExternalStorageDirectory().toString();String filename="edge1.jpg";
                File dir = new File(root + "/edge");
                dir.mkdir();
                File file = new File (dir, filename);
                Log.e("File","Saving Directory:"+dir+"/"+filename);

                try {
                    FileOutputStream out = new FileOutputStream(file);
                    mbit.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.flush();
                    out.close();

                    Log.e("File","Image saved!");
                }catch(Exception e)
                {Log.e("File","Image not saved!");}
            }
        });
    }

    //Onclick Event for Button- Click photo//
    @Override
    public void onClick(View v) {
        Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam,0);
    }

    ///OpenCV Implementation
    //
    ///
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mbit=(Bitmap)data.getExtras().get("data");   //bitmap extracted after camera activity

        Mat rgb= new Mat();
        Mat canny=new Mat();

        //Getting threshold value
        String str;int threshold;
        str=mthreshval.getText().toString();
        threshold=Integer.parseInt(str);
        Log.e("Image","Threshold value: "+str);

        Utils.bitmapToMat(mbit,rgb);
        Mat greys=new Mat(rgb.size(), CvType.CV_8UC1);
        Imgproc.cvtColor(rgb,greys,Imgproc.COLOR_RGB2GRAY, 4);  //RGB2GRAY
        Imgproc.Canny(greys,canny,threshold,threshold);         //Canny Edge

        Utils.matToBitmap(canny,mbit);      //converting Matrix to Bimap

        mimg.setImageBitmap(mbit);
        Toast.makeText(getApplicationContext(),"Image is captured!!",Toast.LENGTH_SHORT).show();
        Log.e("Image:","Image captured");


        //Showing Save Button
        LayoutParams params= mbutton.getLayoutParams();
        params.width=LayoutParams.WRAP_CONTENT;
        params.height=LayoutParams.MATCH_PARENT;
        mbutton.setLayoutParams(params);
        Log.e("Button:","Buttons Cropped");

    }

    ///SeekBar Implementation
    //
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        mthreshval.setText(Integer.toString(progress));
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
    //
    ///
}
