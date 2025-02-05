package com.ctrl.alt.win.supbrew  // Replace with your actual package name

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentMethodAdapter(private val paymentMethods: List<PaymentMethod>) :
    RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {

    private var selectedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.payment_icon)
        val title: TextView = itemView.findViewById(R.id.payment_title)
        val description: TextView = itemView.findViewById(R.id.payment_description)
        val radio: RadioButton = itemView.findViewById(R.id.payment_radio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_method_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paymentMethod = paymentMethods[position]
        holder.icon.setImageResource(paymentMethod.icon)
        holder.title.text = paymentMethod.title
        holder.description.text = paymentMethod.description
        holder.radio.isChecked = position == selectedPosition

        holder.itemView.setOnClickListener {
            if (selectedPosition != position) {
                val previousSelection = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousSelection)
                notifyItemChanged(selectedPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return paymentMethods.size
    }

    fun getSelectedPaymentMethod(): PaymentMethod? {
        if (selectedPosition != -1) {
            return paymentMethods[selectedPosition]
        }
        return null
    }
}