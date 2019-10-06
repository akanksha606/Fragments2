package android.example.fragments2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button buttonOk;
     public interface FragmentAListener{
         void onInputASentence(CharSequence input);
     }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_b,container,false);
        editText=view.findViewById(R.id.edit_text);
        buttonOk=view.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CharSequence input=editText.getText();
                listener.onInputASentence(input);
            }
        });


        return view;
    }
    public void updateEditText(CharSequence newText){
         editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener=(FragmentAListener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"implement FragmaentAaListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}

