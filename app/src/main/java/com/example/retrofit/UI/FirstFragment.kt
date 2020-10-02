//c9 m:26
package com.example.retrofit.UI

import com.example.retrofit.ViewModel.GeneralViewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.R


class FirstFragment : Fragment() {

    lateinit var mViewmodel: GeneralViewModel
// 1 declaro la variable del view model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewmodel = ViewModelProvider(this).get(GeneralViewModel::class.java)
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
        mViewmodel.exposeLiveDataFromServer().observe(viewLifecycleOwner, Observer {
//      Observo que la funcion retorne un live data desde el viewmodel
            Log.d("prueba", it.toString())
        })
//        view.findViewById<Button>(R.id.button_first).setOnContextClickListener{
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
}
// luego crear el recycler view,
// comenzando por el item_list_view en c9 m:53
// luego el adapter en  c9 m 1:01