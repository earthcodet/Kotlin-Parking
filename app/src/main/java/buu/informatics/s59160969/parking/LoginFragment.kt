package buu.informatics.s59160969.parking


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160969.parking.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        binding.LoginButton.setOnClickListener{checkInput(it)}
        return binding.root
    }

    fun checkInput(view: View) {
        binding.apply {
            alertText.visibility  = View.GONE
            var check = usernameEditText.text.toString().equals("admin") && passwordEditText.text.toString().equals("password")

            if(check){
                    view.findNavController().navigate(R.id.action_loginFragment_to_parkingFragment)
                }
            else{
                alertText.text  = "user or password incorrect"
                alertText.visibility  = View.VISIBLE
            }
            }
        //val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }



