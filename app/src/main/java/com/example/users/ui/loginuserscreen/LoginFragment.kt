package com.example.users.ui.loginuserscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.users.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private  lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Login.setOnClickListener {
        //    startActivity(Intent(this@LoginFragment, SecondActivity::class.java))
            val action=LoginFragmentDirections.actionLoginFragmentToListFragment()
            findNavController().apply {
                navigate(action)
            }
        }

    }


}
/*
 if(isConnectedToWifi()){
             Toast.makeText( context,"WiFi on", Toast.LENGTH_SHORT).show()
         }
        else{
             Toast.makeText( context,"WiFi of", Toast.LENGTH_SHORT).show()
        }
 */