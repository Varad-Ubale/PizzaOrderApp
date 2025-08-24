package com.vktech.pizzaorderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, quantityInput;
    RadioGroup sizeGroup;
    CheckBox checkCheese, checkOlives, checkPeppers, checkMushrooms;
    Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        quantityInput = findViewById(R.id.quantityInput);
        sizeGroup = findViewById(R.id.sizeGroup);
        checkCheese = findViewById(R.id.checkCheese);
        checkOlives = findViewById(R.id.checkOlives);
        checkPeppers = findViewById(R.id.checkPeppers);
        checkMushrooms = findViewById(R.id.checkMushrooms);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString().trim();
                String quantity = quantityInput.getText().toString().trim();

                int selectedSizeId = sizeGroup.getCheckedRadioButtonId();
                String size = "";
                if (selectedSizeId != -1) {
                    RadioButton selectedRadio = findViewById(selectedSizeId);
                    size = selectedRadio.getText().toString();
                }

                StringBuilder toppings = new StringBuilder();
                if (checkCheese.isChecked()) toppings.append("Extra Cheese, ");
                if (checkOlives.isChecked()) toppings.append("Olives, ");
                if (checkPeppers.isChecked()) toppings.append("Bell Peppers, ");
                if (checkMushrooms.isChecked()) toppings.append("Mushrooms, ");

                if (toppings.length() > 0)
                    toppings.setLength(toppings.length() - 2); // remove last comma

                // Show the final toast message
                String confirmationMessage = name + ", Your order is placed!";
                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();
            }
        });

    }
}
