package com.example.booky.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booky.R
import com.example.booky.data.api.RestApiService
import com.example.booky.data.api.RetrofitInstance
import com.example.booky.data.models.Book
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import com.example.booky.data.models.BookList
>>>>>>> Stashed changes
=======
import com.example.booky.data.models.BookList
>>>>>>> Stashed changes
import com.example.booky.ui.adapter.BookAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var recylcerChampion: RecyclerView
    lateinit var recylcerChampionAdapter: BookAdapter
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    var champList : MutableList<Book> = ArrayList()
    var champList2 : MutableList<Book> = ArrayList()
=======
    var champList : MutableList<BookList> = ArrayList()
    var champList2 : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
=======
    var champList : MutableList<BookList> = ArrayList()
    var champList2 : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
    lateinit  var recherche :TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)



        recylcerChampion = rootView.findViewById(R.id.listView)
        recherche = rootView.findViewById(R.id.recherche)



        doLogin()
        var text=""

        recherche.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


<<<<<<< Updated upstream
<<<<<<< Updated upstream
                champList2 =     champList.filter { book ->  book.title.contains(s.toString())  } as MutableList<Book>
             if(champList2.size == 0){
                 champList2 = champList.filter { book ->  book.description.contains(s.toString())  } as MutableList<Book>
=======
                champList2 =     champList.filter { book ->  book.title.contains(s.toString())  } as MutableList<BookList>
             if(champList2.size == 0){
                 champList2 = champList.filter { book ->  book.description.contains(s.toString())  } as MutableList<BookList>
>>>>>>> Stashed changes
=======
                champList2 =     champList.filter { book ->  book.title.contains(s.toString())  } as MutableList<BookList>
             if(champList2.size == 0){
                 champList2 = champList.filter { book ->  book.description.contains(s.toString())  } as MutableList<BookList>
>>>>>>> Stashed changes
             }
                recylcerChampionAdapter = BookAdapter(ArrayList(champList2.asReversed()))
                recylcerChampion.adapter = recylcerChampionAdapter
            }
        })

        recylcerChampionAdapter = BookAdapter(champList)
        recylcerChampion.adapter = recylcerChampionAdapter
        recylcerChampion.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)


        return rootView
    }
    private fun doLogin(){

        val apiInterface = RetrofitInstance.getRetrofitInstance().create(RestApiService::class.java)



<<<<<<< Updated upstream
<<<<<<< Updated upstream
        apiInterface.AllBooks().enqueue(object : Callback<MutableList<Book>> {

            override fun onResponse(call: Call<MutableList<Book>>, response: Response<MutableList<Book>>) {
=======
        apiInterface.AllBooks().enqueue(object : Callback<MutableList<BookList>> {

            override fun onResponse(call: Call<MutableList<BookList>>, response: Response<MutableList<BookList>>) {
>>>>>>> Stashed changes
=======
        apiInterface.AllBooks().enqueue(object : Callback<MutableList<BookList>> {

            override fun onResponse(call: Call<MutableList<BookList>>, response: Response<MutableList<BookList>>) {
>>>>>>> Stashed changes

                val user = response.body()

                if (user != null) {
                    champList=user

                    recylcerChampionAdapter = BookAdapter(ArrayList(champList.asReversed()))
                    recylcerChampion.adapter = recylcerChampionAdapter

                }



            }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
            override fun onFailure(call: Call<MutableList<Book>>, t: Throwable) {
=======
            override fun onFailure(call: Call<MutableList<BookList>>, t: Throwable) {
>>>>>>> Stashed changes
=======
            override fun onFailure(call: Call<MutableList<BookList>>, t: Throwable) {
>>>>>>> Stashed changes

            }

        })


    }
}