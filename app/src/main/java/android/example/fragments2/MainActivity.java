package android.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener,FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentA=new FragmentA();
        fragmentB=new FragmentB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_a,fragmentA).replace(R.id.container_b,fragmentB).commit();
    }

    @Override
    public void onInputASentence(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    @Override
    public void onInputBSentence(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}
