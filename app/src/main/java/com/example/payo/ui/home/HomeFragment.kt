package com.example.payo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.payo.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.data.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility = View.GONE
            Log.d("LISTSSSSS", it.toString())

            recycler_view.layoutManager = LinearLayoutManager(context)
            val adapter = HomeAdapter(it)
            recycler_view.visibility = View.VISIBLE
            recycler_view.adapter = adapter
        })
        return root
    }
}