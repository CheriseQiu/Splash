package com.example.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ParallaxFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        int layoutId = args.getInt("layoutId");

        ParallaxLayoutInflater inflater1 = new ParallaxLayoutInflater(inflater,getActivity(),this);
        //null 表示不会挂载到父容器
        return inflater1.inflate(layoutId,null);
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
