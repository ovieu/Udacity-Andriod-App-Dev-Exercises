package com.example.andriod.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String customerName = nameField.getText().toString();
        int price = calculatePrice(numberOfCoffee);
        String priceMessage = createOrderSummary(price,
                                                hasWhippedCream,
                                                hasChocolate,
                                                customerName);
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
     *@param addWhippedCream indicates whether the user wants whipped cream
     *@return order message
     */
    public String createOrderSummary(int priceOfOrder,
                                     boolean addWhippedCream,
                                     boolean addChocolate,
                                     String customerName) {
        String orderMessage = "Name: " + customerName + "\n"
                            + "Quantity: " + numberOfCoffee + "\n"
                            + "Add Whipped Cream? " + addWhippedCream + "\n"
                            + "Add Whipped Cream? " + addChocolate + "\n"
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
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}


