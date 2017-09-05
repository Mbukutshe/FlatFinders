package com.wiseman.flatfinders;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * Created by Wiseman on 2017-09-04.
 */

public class AskedQuestions extends Fragment implements View.OnClickListener{
    View myView;
    ScrollView scrollView;
    FrameLayout frame_call,frame_email,frame_map,first_frame_call,
            second_frame_call,third_frame_call,fourth_frame_call;
    Animation anim;
    Dialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.asked_questions,container,false);
        // Inflate the layout for this fragment
        scrollView = (ScrollView)myView.findViewById(R.id.asked_questions_background);
        scrollView.getBackground().setAlpha(190);
        frame_call = (FrameLayout)myView.findViewById(R.id.frame_call);
        frame_email = (FrameLayout)myView.findViewById(R.id.frame_email);
        frame_map = (FrameLayout)myView.findViewById(R.id.frame_map);

        frame_map.setOnClickListener(this);
        frame_email.setOnClickListener(this);
        frame_call.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch(id)
        {
            case R.id.frame_call:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                frame_call.startAnimation(anim);
                dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.question_calls_layout);
                first_frame_call = (FrameLayout)dialog.findViewById(R.id.first_frame_call);
                second_frame_call = (FrameLayout)dialog.findViewById(R.id.second_frame_call);
                third_frame_call = (FrameLayout)dialog.findViewById(R.id.third_frame_call);
                fourth_frame_call = (FrameLayout)dialog.findViewById(R.id.fourth_frame_call);

                first_frame_call.setOnClickListener(this);
                second_frame_call.setOnClickListener(this);
                third_frame_call.setOnClickListener(this);
                fourth_frame_call.setOnClickListener(this);
                alphaAll( first_frame_call);
                alphaAll( second_frame_call);
                alphaAll( third_frame_call);
                alphaAll( fourth_frame_call);
                dialog.show();
             /*   Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel","+27785411943",null));
                try
                {
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }*/
            break;
            case R.id.first_frame_call:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                first_frame_call.startAnimation(anim);
                makeCall("+27785411943");
            break;
            case R.id.second_frame_call:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                second_frame_call.startAnimation(anim);
                makeCall("+27785411943");
            break;
            case R.id.third_frame_call:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                third_frame_call.startAnimation(anim);
                makeCall("+27785411943");
            break;
            case R.id.fourth_frame_call:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                fourth_frame_call.startAnimation(anim);
                makeCall("+27785411943");
            break;
            case R.id.frame_email:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                frame_email.startAnimation(anim);
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"wisemanmbukutshe@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Enquiry");

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            break;
            case R.id.frame_map:
                anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
                frame_map.startAnimation(anim);
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=417 Anton Lembede Street, Sangro House Suite 411,Durban");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            break;
        }
    }
    public void makeCall(String number)
    {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel",number,null));
        try
        {
            dialog.dismiss();
            startActivity(intent);
        }
        catch (Exception e)
        {

        }
    }
    public void alphaAll(FrameLayout frame)
    {
        anim = AnimationUtils.loadAnimation(myView.getContext(),R.anim.alpha);
        frame.startAnimation(anim);
    }

}
