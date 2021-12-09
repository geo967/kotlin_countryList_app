package com.example.retrofit_countrylist_kotlin.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_countrylist_kotlin.R
import com.example.retrofit_countrylist_kotlin.data.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryListAdapter(private val activity:Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private lateinit var countryList:List<CountryModel>

    fun setCountryList(countryList:List<CountryModel>){
        this.countryList=countryList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(countryList[position],activity)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     //   private val flagImage:ImageView=itemView.findViewById(R.id.image_id)
        private val flagName:TextView=itemView.findViewById(R.id.album_id)
        private val flagCapital:TextView=itemView.findViewById(R.id.id_id)
        private val flagRegion:TextView=itemView.findViewById(R.id.title_id)

        fun bind(data:CountryModel,activity:Activity){
                flagName.text="Album Id"+data.id
            flagCapital.text="Id"+data.name
            flagRegion.text="Title"+data.gender

          //  GlideToVectorYou.justLoadImage(activity, Uri.parse(data.url),flagImage)
        }
    }
}