package com.meleva;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.meleva.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class TabDadosVeiculosFragment extends Fragment {

    private FirebaseAuth mAuth;
    FirebaseUser userD;
    private static final String TAG = "TabDadosVeiculos";

    private SeekBar seekBarLugaresVeiculo;
    private TextView lugares, marca, modelo, cor, matricula;



    User userLogged;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dados_veiculo,container,false);



        mAuth = FirebaseAuth.getInstance();
        userD = mAuth.getCurrentUser();


        marca = (TextView) view.findViewById(R.id.txtMarca);
        modelo = (TextView) view.findViewById(R.id.txtModelo);
        cor = (TextView) view.findViewById(R.id.txtCor);
        matricula = (TextView) view.findViewById(R.id.txtMatricula);

        //Definir lugares do veiculo na seekbar
        seekBarLugaresVeiculo = (SeekBar) view.findViewById(R.id.seekBarVeiculo);
        lugares = (TextView) view.findViewById(R.id.txtVeiculoLugares);



        //Passar da Seekbar para a textview
        seekBarLugaresVeiculo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lugares.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Puxar os dados do utilizador para a frame DadosdoVeiculo
        userLogged = HomeActivity.userLogged;

        if(!marca.equals("")){
            marca.setText("chevrolet");
            modelo.setText("S10");
            cor.setText("Branco");
            matricula.setText("1524614");
            lugares.setText("3");
        }

        return view;
    }
}
