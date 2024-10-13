package com.example.cp2herois

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    private lateinit var nameInput: EditText
    private lateinit var ageInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Inicializando os componentes
        nameInput = view.findViewById(R.id.nome)
        ageInput = view.findViewById(R.id.idade)
        emailInput = view.findViewById(R.id.email)
        submitButton = view.findViewById(R.id.submitButton)

        // Configurando o OnClickListener do botão
        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val age = ageInput.text.toString()
            val email = emailInput.text.toString()

            // Criando um bundle com os dados
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("age", age)
            bundle.putString("email", email)

            // Criando e substituindo o fragmento
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, secondFragment)?.commit()
        }

        return view
    }

    companion object {
        // O resto do código permanece igual
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}