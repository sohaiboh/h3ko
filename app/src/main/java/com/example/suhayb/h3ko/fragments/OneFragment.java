package com.example.suhayb.h3ko.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suhayb.h3ko.R;
import com.example.suhayb.h3ko.Utils.Constants;

import static com.example.suhayb.h3ko.Utils.Constants.CAPTURE_PHOTO;
import static com.example.suhayb.h3ko.Utils.Constants.REQUEST_PERM_CAMERA;


public class OneFragment extends Fragment {

    ImageView photo;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        photo = view.findViewById(R.id.imgPhoto);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCameraPermissionGranted()){
//                    takePhoto();
                }
            }
        });

    }

    private void takePhoto() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAPTURE_PHOTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERM_CAMERA){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                takePhoto();
            }
        }
    }

    public boolean isCameraPermissionGranted(){
//        TODO: Cross check for more
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Handling when user deny permission
            if(ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_PERM_CAMERA);
                return false;
            } else{
                return true;
            }
        } else{
            return true;
        }
    }
}
