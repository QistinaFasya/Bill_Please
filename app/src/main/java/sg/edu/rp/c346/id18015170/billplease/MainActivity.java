package sg.edu.rp.c346.id18015170.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etAmount;
    EditText etPax;
    ToggleButton tbSVS;
    ToggleButton tbGST;
    EditText etDiscount;
    double totalBill = 0;
    double eachPerson = 0;
    Button buttonSplit;
    Button buttonReset;
    TextView totalBillMessage;
    TextView eachPaysMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etAmount=findViewById(R.id.amount);
        etPax=findViewById(R.id.noOfPax);
        tbSVS=findViewById(R.id.tbtnSVS);
        tbGST=findViewById(R.id.tbtnGST);
        etDiscount = findViewById(R.id.discount);
        buttonSplit = findViewById(R.id.btnSplit);
        buttonReset = findViewById(R.id.btnReset);
        totalBillMessage = findViewById(R.id.textTotalBill);
        eachPaysMessage = findViewById(R.id.textEachPay);


        tbSVS.setOnClickListener(new View.OnClickListener() {


            double amount = Double.parseDouble(String.valueOf(etAmount));
            int pax = Integer.parseInt(String.valueOf(etPax));
            @Override
            public void onClick(View v) {
                if (tbSVS.isChecked()){
                    totalBill = (totalBill + amount) * 110;

                }
                totalBillMessage.setText("Total Bill: $" + totalBill);
                eachPaysMessage.setText("Each Pays: $" + eachPerson);

            }
        });

        tbGST.setOnClickListener(new View.OnClickListener() {

            double amount = Double.parseDouble(String.valueOf(etAmount));
            int pax = Integer.parseInt(String.valueOf(etPax));
            @Override
            public void onClick(View v) {

                if (tbGST.isChecked()){
                    totalBill = (totalBill + amount) * 108;
                    eachPerson = totalBill / pax;
                }
                totalBillMessage.setText("Total Bill: $" + totalBill);
                eachPaysMessage.setText("Each Pays: $" + eachPerson);
            }

        });
        buttonSplit.setOnClickListener(new View.OnClickListener() {
            int pax = Integer.parseInt(String.valueOf(etPax));
            @Override

            public void onClick(View v) {
                eachPerson = totalBill / pax;
                totalBillMessage.setText("Total Bill: $" + totalBill);
                eachPaysMessage.setText("Each Pays: $" + eachPerson);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAmount.setText("");
                etPax.setText("");
                etDiscount.setText("");

            }
        });
        
    }
}
