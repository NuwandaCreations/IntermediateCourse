package com.example.fragmentmanual.ui.compatibility

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentmanual.R
import kotlin.time.measureTime
/*
1.Lo primero es borrar todos los comentarios y reformatear el código con lo que vayamos a necesitar.
En este caso he metido los valores ctes dentro del fragment. Mediante un Bundle recuperaremos
los parámetros (mediante clave-valor) que queremos recoger de la activity.
2.A la hora de inflar la vista se hará desde onCreateView en vez de onCreate como las activities. He
incluido una variable "view" que contenga este inflado para poder acceder a las vistas desde ella.*/


class CompatibilityFragment : Fragment() {

    private var name: String? = null
    private var surname: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            surname = it.getString(SURNAME_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compatibility, container, false)

       /* val text1 = view.findViewById<TextView>(R.id.tv_parameter1)
        text1.text = name
        val text2 = view.findViewById<TextView>(R.id.tv_parameter2)
        text2.text = surname*/

        return view
    }

    companion object {
        const val NAME_BUNDLE = "param1"
        const val SURNAME_BUNDLE = "param2"

        @JvmStatic
        fun newInstance(name: String, surname: String) =
            CompatibilityFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_BUNDLE, name)
                    putString(SURNAME_BUNDLE, surname)
                }
            }
    }
}