package com.example.retrofit.UI.Personajes

import android.app.PendingIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.ViewModel.ViewModelPersonajes
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SecondFragment : Fragment(){
//    class fragment_Arr :Fragment(), View.OnClickListener {

    lateinit var mViewModel: ViewModelPersonajes//c7 2:45
    private var creado: String? = null   //c7,2 m46
    private var especie: String? = null   //c7,2 m46
    private var nombre: String? = null   //c7,2 m46
    private var estado: String? = null   //c7,2 m46
    private var genero: String? = null//c7,2 m46
    private var imagen: String? = null//c7,2 m46
    private var type: String? = null//c7,2 m46
    private var url: String? = null//c7,2 m46
    private var locationName: String? = null//c7,2 m46

    private var location: List<String>? = null//c7,2 m46



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(ViewModelPersonajes::class.java)

        arguments?.let {//clase 5 m1:49   y c7,2 m46
            creado = it.getString("creado")
            especie = it.getString("especie")
            nombre = it.getString("nombre")
            estado = it.getString("estado")
            genero = it.getString("genero")
            imagen = it.getString("imagen")
            type = it.getString("type")
            url = it.getString("url")
            locationName = it.getString("locationName")
            location = it.getStringArrayList("location")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.exposeLiveDataFromServer().observe(viewLifecycleOwner, Observer {
            Creado.setText(creado)
            Especie.setText(especie)
            Nombre.setText(nombre)
            Estado.setText(estado)
            Genero.setText(genero)
            Glide.with(this).load(imagen).into(Imagen)
            Type.setText(type)
            LocationName.setText(locationName)
        })
        button_second.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        Inicio.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_fragmentZero)
        }

    }


}
