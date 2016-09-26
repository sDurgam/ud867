package durga.sph.com.createjavalibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.getJoke;

public class MainActivity extends AppCompatActivity {

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeTextView = (TextView)  findViewById(R.id.jokeTxt);
        getJoke jokeObj = new getJoke();
        jokeTextView.setText(jokeObj.getjoke());
    }
}
