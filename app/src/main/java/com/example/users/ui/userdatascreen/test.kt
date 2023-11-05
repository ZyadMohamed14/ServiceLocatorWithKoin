package com.example.users.ui.userdatascreen

/*
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.users.data.local.User
import com.example.users.data.local.UserDataBase
import com.example.users.data.local.LocalDataBaseRepoImpl
import com.example.users.ui.UserAdapter
import com.example.users.ui.UserViewModel
import com.example.users.ui.OnItemClickListener
import com.example.users.databinding.FragmentListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragment : Fragment(), OnItemClickListener {
    private lateinit var useradapter: UserAdapter
    private lateinit var binding: FragmentListBinding
    private lateinit var localDataBaseRepoImpl: LocalDataBaseRepoImpl
    private lateinit var userDataBase: UserDataBase
    private lateinit var viewModel: UserViewModel
    private var userList = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        userDataBase = UserDataBase.getInstance(requireContext())
        localDataBaseRepoImpl = LocalDataBaseRepoImpl(userDataBase)
        useradapter = UserAdapter(this as OnItemClickListener)
        binding.rc.adapter = useradapter
        binding.rc.layoutManager = LinearLayoutManager(context)

        binding.add1.setOnClickListener {
            val user = User(title = binding.addEdittext.text.toString())
            viewModel.addUsers(user)
            userList.add(user)
            addUeserToDataBase(user)
        }

        viewModel.remoteUserLivedata.observe(viewLifecycleOwner, Observer { remoteUserList ->
            if (remoteUserList != null) {
                useradapter.setList(remoteUserList)
                binding.ProgressBar.visibility = View.GONE
            }
        })

        // Check if the device is connected to Wi-Fi and load data accordingly
        if (isConnectedToWifi()) {
            getApiUsers()
        } else {
            getAllUsers()
        }
    }

    override fun onItemClicked(user: User) {
        viewModel.deleteUsers(user)
        Toast.makeText(context, "The User is deleted Successfully", Toast.LENGTH_SHORT).show()
        getAllUsers()
    }

    private fun addUeserToDataBase(user: User) {
        lifecycleScope.launch(Dispatchers.IO) {
            localDataBaseRepoImpl.insertUserOrUpdate(user)
        }
    }

    private fun getAllUsers() {
        viewModel.getUsers()
        binding.ProgressBar.visibility = View.VISIBLE
    }

    private fun getApiUsers() {
        viewModel.getUserFromRemote()
        binding.ProgressBar.visibility = View.VISIBLE
    }

    private fun isConnectedToWifi(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
    }
}

 */