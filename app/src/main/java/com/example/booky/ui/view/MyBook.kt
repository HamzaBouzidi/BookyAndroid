package com.example.booky.ui.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
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
import com.example.booky.data.models.User
import com.example.booky.ui.adapter.BookAdapter
import com.example.booky.ui.adapter.BookAdapterMyList
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyBook : AppCompatActivity() {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    var champList2 : MutableList<Book> = ArrayList()
=======
    var champList2 : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
=======
    var champList2 : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
    lateinit  var recherche : TextView

    lateinit var recylcerChampion: RecyclerView
    lateinit var recylcerChampionAdapter: BookAdapterMyList
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    var champList : MutableList<Book> = ArrayList()
=======
    var champList : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
=======
    var champList : MutableList<BookList> = ArrayList()
>>>>>>> Stashed changes
    lateinit var nowuser: User
    private lateinit var mSharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_book)
        //toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        val gson = Gson()
        val  us =  mSharedPref.getString(myuser, "")

        nowuser = gson.fromJson(us,User::class.java)

        toolbar.setNavigationOnClickListener {


            finish()
        }
        recylcerChampion = findViewById(R.id.listViewbook)
        recherche = findViewById(R.id.rechercheBook)




        doLogin(nowuser.id)

        recherche.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
              champList=  champList.filter  { book -> book.userId==nowuser.id } as MutableList<Book>
                champList2 =     champList.filter { book ->  book.title.contains(s.toString())  } as MutableList<Book>
                if(champList2.size == 0){
                    champList2 = champList.filter { book ->  book.description.contains(s.toString())  } as MutableList<Book>
=======
=======
>>>>>>> Stashed changes
              champList=  champList.filter  { book -> book.userId.id==nowuser.id } as MutableList<BookList>
                champList2 =     champList.filter { book ->  book.title.contains(s.toString())  } as MutableList<BookList>
                if(champList2.size == 0){
                    champList2 = champList.filter { book ->  book.description.contains(s.toString())  } as MutableList<BookList>
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
                }
                recylcerChampionAdapter = BookAdapterMyList(ArrayList(champList2.asReversed()))
                recylcerChampion.adapter = recylcerChampionAdapter
            }
        })
        recylcerChampionAdapter = BookAdapterMyList(champList)
        recylcerChampion.adapter = recylcerChampionAdapter
        recylcerChampion.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL ,false)
    }

    private fun doLogin(id:String){

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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
                    recylcerChampionAdapter = BookAdapterMyList(ArrayList(champList.asReversed().filter { book -> book.userId==id }))
=======
                    recylcerChampionAdapter = BookAdapterMyList(ArrayList(champList.asReversed().filter { book -> book.userId.id==id }))
>>>>>>> Stashed changes
=======
                    recylcerChampionAdapter = BookAdapterMyList(ArrayList(champList.asReversed().filter { book -> book.userId.id==id }))
>>>>>>> Stashed changes
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