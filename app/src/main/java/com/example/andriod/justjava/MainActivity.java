package com.example.andriod.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Amount Due " + "$" + (numberOfCoffee * 5) + "\n Thank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        numberOfCoffee++;
        displayQuantity(numberOfCoffee);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        numberOfCoffee--;
        displayQuantity(numberOfCoffee);
    }

    /**
     * This method displays the given numberOfCoffee value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}


