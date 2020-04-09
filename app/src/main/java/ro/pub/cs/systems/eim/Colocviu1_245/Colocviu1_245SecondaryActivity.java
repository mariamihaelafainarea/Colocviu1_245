package ro.pub.cs.systems.eim.Colocviu1_245;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    Intent intent;
    String allTerms;
    String result ="";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        allTerms = intent.getStringExtra("allterms");
        solveSum(allTerms);
    }
        public void solveSum(String allterms) {
            String[] numbers = allTerms.split("\\+");
            Log.d("aici",allterms);
            int sum  = 0;

            Log.d("of",String.valueOf(numbers.length));


            for (int i = 0; i < numbers.length; i++) {
                sum = sum + Integer.parseInt(numbers[i]);
                Log.d("aiici",numbers[i]);

            }
            result = String.valueOf(sum);

            Intent resultIntent = new Intent();
            setResult(sum,resultIntent);
            finish();

            Log.d("CE NAIBA","AICI");

}


}
