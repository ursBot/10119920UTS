package com.apps.a10119920myselfapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * Tanggal  : 20 MEI 2022
 * NAMA     : UMAR SAID ADI PRANOTO
 * NIM      : 10119920
 * KELAS    : IF10
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.dialog_title)
    String dialogTitle;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.dialog_desc)
    String dialogDesc;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.dialog_type)
    String dialogType;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        TextView whatsapp = view.findViewById(R.id.text_whatsapp);
        TextView instagram = view.findViewById(R.id.text_instagram);
        TextView email = view.findViewById(R.id.text_email);
        TextView about_apps = view.findViewById(R.id.text_about_apps);

        // whatsapp
        whatsapp.setOnClickListener(view1 -> myWhatsapp());
        // instagram
        instagram.setOnClickListener(view1 -> myInstagram());
        // email
        email.setOnClickListener(view1 -> myEmail());
        // about apps
        about_apps.setOnClickListener(view1 -> alert());

        return view;
    }


    //my whatsapp
    private void myWhatsapp() {
        String url = "https://wa.me/6282317716910";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //my instagram
    private void myInstagram() {
        String url = "https://www.instagram.com/urs_698/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //my email
    private void myEmail() {
        String url = "mailto:umar.10119920@mahasiswa.unikom.ac.id";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    // costum dialog
    private void alert() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.activity_profile_dialog);
        dialog.setTitle(dialogType);

        TextView textTitle = dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(dialogTitle);
        text.setText(dialogDesc);

        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}