package com.example.awaistrail.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.awaistrail.adapter.RecordsAdapter
import com.example.awaistrail.api.ApiInterface
import com.example.awaistrail.api.RetrofitClient
import com.example.awaistrail.data.BannerLarge
import com.example.awaistrail.data.BannerSmall
import com.example.awaistrail.data.Brand
import com.example.awaistrail.data.Categories
import com.example.awaistrail.databinding.FragmentDashBoardBinding
import com.google.gson.Gson
import java.util.regex.Matcher
import java.util.regex.Pattern


class DashBoardFragment : Fragment() {

    private val TAG="DashBoardFragment"


    private var bannerSmall=ArrayList<BannerSmall>()
    private val bannerLarge=ArrayList<BannerLarge>()
    private val brand=ArrayList<Brand>()

    private lateinit var binding : FragmentDashBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater, container, false)
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
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                    val myData = response.body()?.data

                    myData?.forEach {

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





                    }

                    val recordsAdapter = myData?.let { RecordsAdapter(it) }
                    binding.recyclerViewAll.adapter=recordsAdapter

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
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData2()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                    val myData = response.body()?.data

                    myData?.forEach {

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





                    }

                    val recordsAdapter = myData?.let { RecordsAdapter(it) }
                    binding.recyclerViewAll.adapter=recordsAdapter

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
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getData3()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                    val myData = response.body()?.data

                    myData?.forEach {

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





                    }

                    val recordsAdapter = myData?.let { RecordsAdapter(it) }
                    binding.recyclerViewAll.adapter=recordsAdapter

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




    companion object{

        public  fun jsonToAny(`object`: Any?, type: Class<*>): Any? {
            if (`object` == null)
                return null
            val gsn = Gson()
            var gsnString = gsn.toJson(`object`)
            var any: Any?
            val clazz = type.javaClass
            if (`object` is ArrayList<*>) {
                val objects = ArrayList<Any>()
                for (objectA in (`object` as ArrayList<*>?)!!) {
                    gsnString = gsn.toJson(objectA)
                    any = gsn.fromJson<Any>(gsnString, type)
                    objects.add(any)
                }
                return objects
            } else {
                any = gsn.fromJson<Any>(gsnString, type)
            }
            return any
        }

        fun isValidHexaCode(str: String?): Boolean {
            // Regex to check valid hexadecimal color code.
            val regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"

            // Compile the ReGex
            val p: Pattern = Pattern.compile(regex)

            // If the string is empty
            // return false
            if (str == null) {
                return false
            }

            // Pattern class contains matcher() method
            // to find matching between given string
            // and regular expression.
            val m: Matcher = p.matcher(str)

            // Return if the string
            // matched the ReGex
            return m.matches()
        }

    }

}