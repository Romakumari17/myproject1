package com.romakumari.myproject1

import android.app.Dialog
import android.content.Intent
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.romakumari.myproject1.databinding.ActivityMainBinding
import com.romakumari.myproject1.databinding.CustomItemBinding
import com.romakumari.myproject1.databinding.CustomLayoutBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var itemList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            itemList = mutableListOf("Item 1", "Item 2", "Item 3")
            adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter

        binding.spinner.setOnItemSelectedListener(object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: android.widget.AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                showCustomDialog(position)
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        })

        // Add Item Button Click
        binding.btncrud.setOnClickListener {
            addNewItem()
        }
    }

    private fun showCustomDialog(position: Int) {
        val dialogBinding = CustomLayoutBinding.inflate(layoutInflater)
        val customDialog = Dialog(this)
        customDialog.setContentView(dialogBinding.root)

        // Set custom dialog parameters
        customDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        customDialog.setCancelable(true)

        // Pre-fill EditText with the selected item's text
        dialogBinding.etInput.setText(itemList[position])

        // Update Button Click
        dialogBinding.btnUpdate.setOnClickListener {
            val updatedItem = dialogBinding.etInput.text.toString()
            if (updatedItem.isNotEmpty()) {
                itemList[position] = updatedItem
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Item updated", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            } else {
                Toast.makeText(this, "Enter a valid item", Toast.LENGTH_SHORT).show()
            }
        }

        // Delete Button Click
        dialogBinding.btnDelete.setOnClickListener {
            itemList.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }

        customDialog.show()
    }

    private fun addNewItem() {
        val dialogBinding = CustomItemBinding.inflate(layoutInflater)
        val customDialog = Dialog(this)
        customDialog.setContentView(dialogBinding.root)

        // Set custom dialog parameters
        customDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )



        dialogBinding.btnAdd.setOnClickListener {
            val newItem = dialogBinding.etInput.text.toString()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            } else {
                Toast.makeText(this, "Enter a valid item", Toast.LENGTH_SHORT).show()
            }
        }

        customDialog.show()
    }
}







