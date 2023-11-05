package com.example.users.ui.userdatascreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.users.databinding.FragmentListBinding
import com.example.users.model.User
import com.example.users.ui.adapter.OnItemClickListener
import com.example.users.ui.adapter.UserAdapter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() ,OnItemClickListener{
    private lateinit var useradapter: UserAdapter
    private  lateinit var binding: FragmentListBinding
    private val viewModel :UserViewModel by lazy { getViewModel() }
    private var userList=ArrayList<User>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        useradapter=UserAdapter(this as OnItemClickListener)
        binding.rc.adapter=useradapter
        // getAllUsers()
        getApiUsers()
        binding.add1.setOnClickListener {
            val user= User(title = binding.addEdittext.text.toString())
            viewModel.addUsers(user)
            userList.add(user)
            // getAllUsers()
        }
        /*
        viewModel.LocaluserLivedata.observe(viewLifecycleOwner, Observer { usersList->
            if(!usersList.isNullOrEmpty()){
                useradapter.setList(usersList)
                binding.ProgressBar.visibility= View.GONE
            }
        })

         */
        viewModel.remoteUserLivedata.observe(viewLifecycleOwner, Observer { remoteUserList->
            if(remoteUserList!=null){
                useradapter.setList(remoteUserList)
                binding.ProgressBar.visibility= View.GONE
            }
        })
    }
    override fun onItemClicked(user: User) {
        viewModel.deleteUsers(user)
        Toast.makeText( context,"The User is deleted Sucssfully", Toast.LENGTH_SHORT).show()
        getAllUsers()
    }

    fun getAllUsers(){
        viewModel.getUsers()
        binding.ProgressBar.visibility= View.VISIBLE
    }
    fun getApiUsers(){
        viewModel.getUserFromRemote()
        binding.ProgressBar.visibility= View.VISIBLE
    }


}


















/*
 fun addUeserToDataBase(user: User){
        lifecycleScope.launch (Dispatchers.IO){
            localDataBaseRepoImpl.insertUserOrUpdate(user)


        }
    }
   userDataBase= UserDataBase.getInstance(requireContext())//
        localDataBaseRepoImpl= LocalDataBaseRepoImpl(userDataBase)//
viewModel.getUsers()
         lifecycleScope.launch (Dispatchers.IO){
             var ReturnedusersList= async {
                 localDataBaseRepoImpl.getUsers()
             }
             withContext(Dispatchers.Main){
                 binding.ProgressBar.visibility= View.VISIBLE
                 userList=ReturnedusersList.await() as ArrayList<User>
                 binding.ProgressBar.visibility= View.GONE
                 useradapter.setList(userList)
             }
         }
 */