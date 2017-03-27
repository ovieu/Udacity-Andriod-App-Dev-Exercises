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
        int price = calculatePrice(numberOfCoffee);
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
        //String priceMessage = "Amount Due " + "$" + price + "\n Thank you!";
        //displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *@return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method creates an order summary
     *@param priceOfOrder is the total price of an order
     *@return order message
     */
    public String createOrderSummary(int priceOfOrder) {
        String orderMessage = "Name: Kaptain Kunal " + "\n"
                            + "Quantity: " + numberOfCoffee + "\n"
                            + "Total: $" + priceOfOrder + "\n"
                            + "Thank You!";
        return orderMessage;
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
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
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


