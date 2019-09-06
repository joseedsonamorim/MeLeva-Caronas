package com.meleva;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.meleva.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class TabDadosPessoaisFragment extends Fragment {


    private FirebaseAuth mAuth;
    FirebaseUser userD;

    private static final String TAG = "TabDefinicoesPessoais";
    private Button btnTeste;
    TextView nome, faculdade, curso, nib, telemovel;
    User userLogged;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dados_pessoais,container,false);


        mAuth = FirebaseAuth.getInstance();
        userD = mAuth.getCurrentUser();

        nome = view.findViewById(R.id.txtNomeCondutor);
        faculdade = view.findViewById(R.id.txtEscola);
        curso=view.findViewById(R.id.txtCurso);
        nib = view.findViewById(R.id.txtNib);
        telemovel = view.findViewById(R.id.txtContacto);


        //Puxar os dados do utilizador para a frame DadosPessoais
        userLogged = HomeActivity.userLogged;

        //Ve se o nome está vazio, se não estiver escreve todos os campos
        //basta fazer o if com o nome, uma vez que para o nome estar preenchido os outros campos também tem que estar
        if(!nome.equals("")){
            nome.setText("Joyce");
            faculdade.setText("Nada");
            curso.setText("ok");
            nib.setText("jjjj");
            telemovel.setText("kkkk");
        }


        return view;
    }


}
