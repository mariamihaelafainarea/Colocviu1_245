package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    public Button addButton;
    public EditText allTerms;
    public EditText nextTerms;
    public Button compute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        addButton = findViewById(R.id.Add);
        addButton.setOnClickListener(callImageButtonClickListener);

        allTerms = findViewById(R.id.Allterms);

        nextTerms = findViewById(R.id.NextTerm);

        compute = findViewById(R.id.compute);
        compute.setOnClickListener(calculateClickListener);

    }

    private ConcatenateClickListener callImageButtonClickListener = new ConcatenateClickListener();
    private class ConcatenateClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int number = -10000;
            boolean isNumeric = true;
            try {
                number = Integer.parseInt(nextTerms.getText().toString());
                isNumeric = true;
            } catch (NumberFormatException e) {
                isNumeric = false;
            }

            if(nextTerms.length() > 0 && isNumeric == true && number >= 0  ) {
                String terms = allTerms.getText().toString();
                if (terms.length() > 0) {
                    terms = terms + "+" + nextTerms.getText().toString();
                    nextTerms.setText("");
                } else {
                    terms = terms + nextTerms.getText().toString();
                    nextTerms.setText("");

                }
                allTerms.setText(terms);
            }else {
                nextTerms.setText("");
            }
        }
    }
    private CalculateClickListener calculateClickListener = new CalculateClickListener();
    private class CalculateClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Colocviu1_245MainActivity.this,Colocviu1_245SecondaryActivity.class);
            intent.putExtra("allterms",allTerms.getText().toString());
            startActivityForResult(intent,1234);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode) {
            case(1234):

                Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();

        }
    }
}
