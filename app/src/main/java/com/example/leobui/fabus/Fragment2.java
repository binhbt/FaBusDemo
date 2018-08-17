package com.example.leobui.fabus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vn.fa.bus.FaBus;
import com.vn.fa.bus.OnEventReceived;

public class Fragment2 extends Fragment {
    public static final String TAG ="fragment2";
    private TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        tvContent = view.findViewById(R.id.tv_content);
        FaBus.getDefault().registerEvent(new OnEventReceived() {
            @Override
            public void onEventReceived(Object event) {
                String content = (String)event;
                tvContent.setText("Fragment2 received "+content);
            }
        }, TAG);
        return view;
    }

    @Override
    public void onDestroyView() {
        FaBus.getDefault().unRegisterEvent(TAG);
        super.onDestroyView();
    }
}
