package com.example.awaistrail.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.awaistrail.ui.dashboard.adapter.DashboardAdapter
import com.example.awaistrail.ui.dashboard.api.ApiInterface
import com.example.awaistrail.ui.dashboard.api.RetrofitClient
import com.example.awaistrail.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment() {

    private var _binding: FragmentDashBoardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root

    }

    var count = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pullToRefresh.setOnRefreshListener(OnRefreshListener {

            if (count==1){
                count =2
                getAllData2()
            }else if (count==2)
            {
                count =3
                getAllData3()
            }
            else{
                count = 1
                getAllData()
            }

        })


        getAllData()
        count =1

    }


    private fun getAllData() {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData()
                if (response.isSuccessful) {
                    //your code for handaling success response


                    val myData = response.body()?.data


                    val dashboardAdapter = myData?.let { DashboardAdapter(it) }
                    binding.recyclerViewAll.adapter=dashboardAdapter

                    binding.pullToRefresh.isRefreshing = false



                } else {
                    Toast.makeText(
                        requireContext(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }
    private fun getAllData2() {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData2()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                    val myData = response.body()?.data

                   /* myData?.forEach {

                        Log.d(TAG, "getAllData: ${it.id}")
                        if (it.type=="banner_small"){
                             val item = (jsonToAny(it.items, BannerSmall::class.java) as BannerSmall)
                            Log.d(TAG, "getAllData: ${item.image}")
                        }else if (it.type=="banner_large"){
                            val item = (jsonToAny(it.items, BannerLarge::class.java) as BannerLarge)
                            Log.d(TAG, "getAllData: ${item.image}")
                        }else if (it.type=="category"){
                            val item = (jsonToAny(it.items, Categories::class.java) as  Collection<Categories>)
                            item.forEach {
                                Log.d(TAG, "getAllData: ${it.name}")
                            }
                        }else if (it.type=="brand"){
                             brand.addAll(jsonToAny(it.items, Brand::class.java) as Collection<Brand>)
                            brand.forEach {
                                Log.d(TAG, "getAllData: ${it.name}")
                            }
                        }





                    }*/

                    val dashboardAdapter = myData?.let { DashboardAdapter(it) }
                    binding.recyclerViewAll.adapter=dashboardAdapter

                    binding.pullToRefresh.isRefreshing = false



                } else {
                    Toast.makeText(
                        requireContext(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }
    private fun getAllData3() {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData3()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                    val myData = response.body()?.data

                    val dashboardAdapter = myData?.let { DashboardAdapter(it) }
                    binding.recyclerViewAll.adapter=dashboardAdapter

                    binding.pullToRefresh.isRefreshing = false



                } else {
                    Toast.makeText(
                        requireContext(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}