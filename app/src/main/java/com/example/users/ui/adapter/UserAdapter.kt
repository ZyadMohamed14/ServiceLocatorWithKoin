package com.example.users.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.users.databinding.UserListItemBinding
import com.example.users.model.User

class UserAdapter( var listener: OnItemClickListener?=null): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
private var  userList:List<User> = ArrayList()
fun setList( uList:List<User>){
    userList=uList
    notifyDataSetChanged()
}


    inner class UserViewHolder(itemview: UserListItemBinding):RecyclerView.ViewHolder(itemview.root) { val binding:UserListItemBinding=itemview }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // var view =LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false)
        var binding=UserListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return UserViewHolder(binding)
    }
    override fun getItemCount(): Int = userList.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     val user=userList.get(position)

        holder.binding.apply {
            username.text=user.name
            titel.text=user.title
            userid.text=user.userId.toString()
            root.setOnClickListener {
                listener?.onItemClicked(user)
            }
        }
    }


}
