package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.apiservice.ServiceBulder
import com.example.myapplication.apiservice.UserAPIService
import com.example.myapplication.model.User
import com.example.myapplication.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    var users : ArrayList<User> = ArrayList()
    var adapter: UserAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.home, container, false)

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val request = ServiceBulder.buildService(UserAPIService::class.java)
        val call = request.getUsers()
        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UserAdapter(context, users)
        recyclerView.adapter = adapter

        call.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                println(response.body())
                users.clear()
                response.body()?.let { users.addAll(it) }
                adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}