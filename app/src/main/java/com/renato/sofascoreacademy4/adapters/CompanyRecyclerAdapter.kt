package com.renato.sofascoreacademy4.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.databinding.CompanyObjectBinding
import com.renato.sofascoreacademy4.entities.Company
import java.util.zip.Inflater
import kotlin.random.Random

class CompanyRecyclerAdapter(val context:Context, val listOfItems:ArrayList<Company>) : RecyclerView.Adapter<CompanyRecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = CompanyObjectBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.company_object, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val company = listOfItems[position]

        holder.binding.nameText.text = company.name
        holder.binding.addressText.text = company.address
        holder.binding.cityText.text = company.city
        holder.binding.imageView.load(company.website){
            transformations(CircleCropTransformation())
            crossfade(true)
            crossfade(2000)
        }
        //smanjio sam alpha da boje ne budu jako izrazene
        holder.binding.layout.setBackgroundColor(Color.argb(100, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
    }

    override fun getItemCount() = listOfItems.size

}