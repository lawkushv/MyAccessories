package com.example.lawkushprasad.myaccessories;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.print.PrintAttributes;
import android.provider.MediaStore;
import android.service.chooser.ChooserTarget;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculatorIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconcalculator);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("calcul")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void cameraIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconcamera);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("camera")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }
    File file;
    public void onCamera(View v){
        Intent cameraClicked =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent chooser;
         file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test"+Math.random()+".jpg");
        Uri tempuri=Uri.fromFile(file);
        cameraClicked.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);
        cameraClicked.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        chooser=Intent.createChooser(cameraClicked,"Open camera");
        //startActivity(chooser);
       startActivityForResult(chooser,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0)
        {
            switch (resultCode){
                case Activity.RESULT_OK:{
                    if(file.exists()){
                        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case Activity.RESULT_CANCELED:{
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void calendarIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconcalendar);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("calendar")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }
    public void onCalender(View view){
        if (view.getId()==R.id.iconcalendar)
        {
            Intent intent =new Intent(Intent.ACTION_EDIT);
            intent.setType("vnd.android.cursor.item/");
            Intent chooser =Intent.createChooser(intent,"Open Calender");
            startActivity(chooser);
        }

    }

    public void galleryIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.icongallery);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("gallery")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void clockIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconclock);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("clock")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void browserIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconbrowser);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("chrome")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void youtubeIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconyoutube);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("youtube")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void filemanagerIconClicked(View view) {
        imageButton = (ImageButton)findViewById(R.id.iconfilemanager);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm=getPackageManager();
                List<PackageInfo> packs =pm.getInstalledPackages(0);
                for (PackageInfo pi:packs){
                    if(pi.packageName.toString().toLowerCase().contains("file manager")){
                        HashMap<String,Object> map=new HashMap<String,Object>();
                        map.put("appName",pi.applicationInfo.loadLabel(pm));
                        map.put("packageName",pi.packageName);
                        items.add(map);
                    }
                }

                if(items.size()>=1){
                    String packageName= (String)items.get(0).get("packageName");
                    Intent i=pm.getLaunchIntentForPackage(packageName);
                    if(i!=null){
                        startActivity(i);
                    }
                }
            }
        });
    }
    public void onFilemanager(View view){
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        Intent chooser=Intent.createChooser(intent,"Open File Manager");
        startActivity(chooser);
    }
}
