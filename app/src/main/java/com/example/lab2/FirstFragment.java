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

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
                BigDecimal cena = new BigDecimal(mCena.getText().toString());
                EditText mNap = (EditText) getActivity().findViewById(R.id.sug_nap_cena);
                BigDecimal napiwek = new BigDecimal(mNap.getText().toString());
                TextView suma = (TextView)getActivity().findViewById(R.id.suma);
                BigDecimal procent = new BigDecimal("100");
                BigDecimal zaplata = cena.add(cena.multiply(napiwek.divide(procent))) ;
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);
                suma.setText(df.format(zaplata));
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
