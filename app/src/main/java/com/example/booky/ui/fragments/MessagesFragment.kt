package com.example.booky.ui.fragments

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import android.content.Context
>>>>>>> Stashed changes
=======
import android.content.Context
>>>>>>> Stashed changes
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import com.example.booky.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MessagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessagesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
=======
=======
>>>>>>> Stashed changes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booky.R
import com.example.booky.data.api.ChatAPIService
import com.example.booky.data.api.ChatService
import com.example.booky.data.api.RestApiService
import com.example.booky.data.api.RetrofitInstance
import com.example.booky.data.models.Conversation
import com.example.booky.data.models.User
import com.example.booky.ui.adapter.ConversationAdapter
import com.example.booky.ui.view.PREF_NAME
import com.example.booky.ui.view.myuser
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MessagesFragment : Fragment() {
    private var conversationsRV: RecyclerView? = null
    private var shimmerFrameLayout: ShimmerFrameLayout? = null
    private var conversationAdapter: ConversationAdapter? = null

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MessagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
=======
=======
>>>>>>> Stashed changes
        val view = inflater.inflate(R.layout.fragment_messages, container, false)
        // VIEW BINDING
        shimmerFrameLayout = view?.findViewById(R.id.shimmerLayout)
        conversationsRV = view?.findViewById(R.id.conversationsRV)


        shimmerFrameLayout!!.startShimmer();
        conversationsRV!!.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        conversationAdapter = ConversationAdapter(mutableListOf())
        conversationsRV?.adapter = conversationAdapter


        val sharedPreferences  = this.requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val  us =  sharedPreferences?.getString(myuser, "")
        val gson = Gson()
        val nowuser = gson.fromJson(us, User::class.java)
        val userID = nowuser.id
        // val retIn = RetrofitInstance.getRetrofitInstance().create(RestApiService::class.java)

        ChatAPIService.chatService.getMyConversations(
            ChatService.MyConversationsBody(
                userID
            )
        ).enqueue(
            object : Callback<ChatService.ConversationsResponse> {
                override fun onResponse(
                    call: Call<ChatService.ConversationsResponse>,
                    response: Response<ChatService.ConversationsResponse>
                ) {
                    if (response.code() == 200) {
                        conversationsRV!!.adapter =
                            ConversationAdapter(response.body()?.conversations as MutableList<Conversation>)

                        shimmerFrameLayout!!.stopShimmer()
                        shimmerFrameLayout!!.visibility = View.GONE
                    } else {
                        println("status code is " + response.code())
                    }
                }

                override fun onFailure(
                    call: Call<ChatService.ConversationsResponse>,
                    t: Throwable
                ) {
                    println("HTTP ERROR")
                    t.printStackTrace()
                }
            }
        )
        return view





    }


<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}