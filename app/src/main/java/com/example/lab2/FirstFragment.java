package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.wylicz).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText mCena = (EditText) getActivity().findViewById(R.id.koszt_cena);
                String cena = mCena.getText().toString();
                EditText mNap = (EditText) getActivity().findViewById(R.id.sug_nap_cena);
                String napiwek = mNap.getText().toString();
                TextView suma = (TextView)getActivity().findViewById(R.id.suma);
//                Integer zaplata = Integer.getInteger(cena) + Integer.getInteger(cena) * (Integer.getInteger(napiwek)/100);
                suma.setText(napiwek);
            }
        } );

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
