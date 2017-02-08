package com.example.android.tripcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int passengers = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "+" button is clicked.
     */
    public void increment(View view) {
        if (passengers == 7) {
            Toast.makeText(this, "Are you driving some kind of a bus", Toast.LENGTH_SHORT).show();
            return;
        }
        passengers = passengers + 1;
        displayQuantity(passengers);
    }

    /**
     * This method is called when the "-" button is clicked.
     */
    public void decrement(View view) {
        if (passengers == 1) {
            Toast.makeText(this, "You cannot have less than 1 passenger. Someone should drive ;)", Toast.LENGTH_LONG).show();
            return;
        }
        passengers = passengers - 1;
        displayQuantity(passengers);
    }

    /**
     * This method displays the number of passengers traveling.
     */
    private void displayQuantity(int numberOfPassengers) {
        TextView quantityTextView = (TextView) findViewById(R.id.passengersCount);
        quantityTextView.setText(String.valueOf(numberOfPassengers));
    }

    /**
     * This method is called when the "CALCULATE" button in SHARED TRAVEL section is clicked.
     */
    public void calculatePrice(View view) {


        EditText tripDistance = (EditText) findViewById(R.id.tripDistanceField);
        EditText fuelConsumption = (EditText) findViewById(R.id.fuelConsumptionField);
        EditText fuelPrice = (EditText) findViewById(R.id.fuelPriceField);

        /**
         * checks if the fields are empty
         */
        if (tripDistance.getText().toString().trim().length() == 0 ||
                fuelConsumption.getText().toString().trim().length() == 0 ||
                fuelPrice.getText().toString().trim().length() == 0) {

            Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show();

        } else {

            double distance = Double.parseDouble(tripDistance.getText().toString());
            double consumption = Double.parseDouble(fuelConsumption.getText().toString());
            double fuel_price = Double.parseDouble(fuelPrice.getText().toString());


            /**
             * Calculates the price per passenger of the trip.
             *
             * @param distance    is trip distance
             * @param consumption is vehicle consumption for 100 km
             * @param fuel_price  is the fuel price per litre
             * @return total price
             */
            double result = (((distance * consumption) / 100) * fuel_price) / passengers;
            displayPricePerPerson(String.valueOf(result));
        }
    }

    /**
     * This method is for displaying the result in SHARED TRAVEL section.
     */
    private void displayPricePerPerson(String result) {
        TextView resultTextView = (TextView) findViewById(R.id.pricePerPersonResult);
        resultTextView.setText(result);
    }

    /**
     * This method is called when the "CALCULATE" button in FUEL CONSUMPTION section is clicked.
     */
    public void fuelConsumed(View view) {

        EditText distanceTraveled = (EditText) findViewById(R.id.distanceTraveledField);
        EditText fuelConsumed = (EditText) findViewById(R.id.fuelConsumedField);

        if (distanceTraveled.getText().toString().trim().length() == 0 ||
                fuelConsumed.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Fill all the fields!", Toast.LENGTH_SHORT).show();

        } else {
            double distance = Double.parseDouble(distanceTraveled.getText().toString());
            double consumption = Double.parseDouble(fuelConsumed.getText().toString());

            /**
             * Calculates the price per passenger of the trip.
             *
             * @param distance    is trip distance traveled
             * @param consumption is the fuel consumed through the above distance
             * @return total price
             */
            double result = (consumption * 100) / distance;
            displayFuelConsumption(String.valueOf(result));
        }
    }

    /**
     * This method is for displaying the result in FUEL CONSUMPTION section.
     */
    private void displayFuelConsumption(String result) {
        TextView resultTextView = (TextView) findViewById(R.id.fuelConsumptionResult);
        resultTextView.setText(result);
    }

    /**
     * Resets SHARED TRAVEL fields.
     */
    public void resetSharedTravel(View v) {

        EditText tripDistance = (EditText) findViewById(R.id.tripDistanceField);
        tripDistance.setText("");

        EditText fuelConsumption = (EditText) findViewById(R.id.fuelConsumptionField);
        fuelConsumption.setText("");

        EditText fuelPrice = (EditText) findViewById(R.id.fuelPriceField);
        fuelPrice.setText("");

        TextView displayResult = (TextView) findViewById(R.id.pricePerPersonResult);
        displayResult.setText("0");
    }

    /**
     * Resets FUEL CONSUMPTION fields.
     */
    public void resetFuelConsumption(View v) {

        EditText fuelConsumed = (EditText) findViewById(R.id.fuelConsumedField);
        fuelConsumed.setText("");

        EditText distanceTraveled = (EditText) findViewById(R.id.distanceTraveledField);
        distanceTraveled.setText("");

        TextView displayResult = (TextView) findViewById(R.id.fuelConsumptionResult);
        displayResult.setText("0");
    }


}




