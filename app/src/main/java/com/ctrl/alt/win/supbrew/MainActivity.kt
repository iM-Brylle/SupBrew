package com.ctrl.alt.win.supbrew  // Replace with your actual package name

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_method_layout)

        val recyclerView = findViewById<RecyclerView>(R.id.payment_methods_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val paymentMethods = listOf(
            PaymentMethod(R.drawable.ic_placeholder, "Gcash", "+63 945 188 4373"),
            PaymentMethod(R.drawable.ic_placeholder, "Cash on Delivery", "Pay when you receive"),
            // Add more payment methods here
        )

        val adapter = PaymentMethodAdapter(paymentMethods)
        recyclerView.adapter = adapter

        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener {
            val selectedMethod = adapter.getSelectedPaymentMethod()
            if (selectedMethod != null) {
                Toast.makeText(this, "Selected: ${selectedMethod.title}", Toast.LENGTH_SHORT).show()
                // Handle the confirmation here (e.g., start a new activity, process payment)
            } else {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            }
        }
    }
}