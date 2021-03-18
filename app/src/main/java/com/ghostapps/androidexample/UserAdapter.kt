package com.ghostapps.androidexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.androidexample.model.UserModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserAdapter (
    private val users: List<UserModel>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: UserModel) {
            view.userListName.text = user.name
            Picasso.get().load(user.thumb).into(view.userListImage)
        }
    }


}