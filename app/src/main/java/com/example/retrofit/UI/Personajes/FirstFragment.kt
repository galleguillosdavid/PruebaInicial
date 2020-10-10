//c9 m:26
package com.example.retrofit.UI.Personajes

import com.example.retrofit.ViewModel.ViewModelPersonajes
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.R
import com.example.retrofit.model.Personajes.RecyclerViewPersonajes.AdapterPersonajes
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.DcEntityResultP
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(), AdapterPersonajes.EnviarDatos {

    lateinit var mViewmodel: ViewModelPersonajes
// 1 declaro la variable del view model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewmodel = ViewModelProvider(this).get(ViewModelPersonajes::class.java)
//    Inflo el layaut para este fragmento
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_first,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = recyclerView1 //c7 m1:22 instancio el elemento visual Rv
        val mAdapter = AdapterPersonajes(this)//c7 m1:23 instancio el objeto de la clase adapter
        mRecyclerView.adapter = mAdapter //c7 m1:25
        mRecyclerView.layoutManager = GridLayoutManager(context,3) //c7 m1:25

        mViewmodel.exposeLiveDataFromServer().observe(viewLifecycleOwner, Observer {
//      Observo que la funcion retorne un live data desde el viewmodel
            Log.d("prueba", it.toString())
            mAdapter.updatelistRM(it)
        })

    }

    override fun enviardatos(mdcPersonajesRAM: DcEntityResultP) { //c7,2 m46, aqui traemos el objeto seleccionado
            val mBundle = Bundle()
            mBundle.putString("creado", mdcPersonajesRAM.created)
            mBundle.putString("especie", mdcPersonajesRAM.species)
            mBundle.putString("nombre", mdcPersonajesRAM.name)
            mBundle.putString("estado", mdcPersonajesRAM.status)
            mBundle.putString("genero", mdcPersonajesRAM.gender)
            mBundle.putString("imagen", mdcPersonajesRAM.image)
            mBundle.putString("type", mdcPersonajesRAM.type)
            mBundle.putString("url", mdcPersonajesRAM.url)
            mBundle.putString("episode", mdcPersonajesRAM.episode.toString())
            mBundle.putString("location", mdcPersonajesRAM.location.toString())
            mBundle.putString("locationName", mdcPersonajesRAM.location.name)
        Toast.makeText(context, "Seleccionaste ${mdcPersonajesRAM.name}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)//c 7,2 m43 pasar bundle de un fragmento a otro

    }
}
// luego crear el recycler view,
// comenzando por el item_list_view en c9 m:53
// luego el adapter en  c9 m 1:01