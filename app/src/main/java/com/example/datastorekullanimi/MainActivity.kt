package com.example.datastorekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ap=AppPref(this)
        val job= CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("ahmet")
            //ap.sil()
            ap.kayitBekar(false)
            ap.kayitBoy(180.0)
            ap.kayitYas(28)
            val liste=HashSet<String>()
            liste.add("ali")
            liste.add("veli")
            ap.kayitArkadasListesi(liste)

            val gelenAd=ap.okuAd()
            val gelenBoy=ap.okuBoy()
            val gelenBekar=ap.okuBekar()
            val gelenYas=ap.okuYas()

            Log.e("gelen ad:",gelenAd)
            Log.e("gelen boy:",gelenBoy.toString())
            Log.e("gelen yas:",gelenYas.toString())
            Log.e("gelen bekar:",gelenBekar.toString())

            val gelenliste=ap.okuArkadasListesi()
            if(gelenliste!= null){
                for(a in gelenliste){
                    Log.e("gelen arkadaş",a)
                }
            }

            var gelensayac=ap.okuSayac()
            ap.kayitSayac(++gelensayac)

            binding.textViewSayac.text=gelensayac.toString()
        }
    }
}