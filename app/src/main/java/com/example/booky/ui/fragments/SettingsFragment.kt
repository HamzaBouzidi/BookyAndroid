package com.example.booky.ui.fragments

<<<<<<< Updated upstream
<<<<<<< Updated upstream
import android.content.Context
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booky.MainActivity
import com.example.booky.R
import com.example.booky.data.api.RestApiService
import com.example.booky.data.api.RetrofitInstance
import com.example.booky.data.models.Book
import com.example.booky.data.models.User
import com.example.booky.ui.adapter.BookAdapter
import com.example.booky.ui.view.LoginActivity
import com.example.booky.ui.view.MyBook
import com.example.booky.ui.view.PREF_NAME
import com.example.booky.ui.view.myuser
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
=======
=======
>>>>>>> Stashed changes
import com.bumptech.glide.Glide
import com.example.booky.R
import com.example.booky.data.models.User
import com.example.booky.ui.view.LoginActivity
import com.example.booky.ui.view.PREF_NAME
import com.example.booky.ui.view.UpdateProfile
import com.example.booky.ui.view.UploadImageUser
import com.example.booky.ui.view.myuser
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes


class SettingsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_settings, container, false)


        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<TextView>(R.id.profileUsernameINPT)
        val email = view.findViewById<TextView>(R.id.profileEmailINPT)
        val logoutButton = view.findViewById<Button>(R.id.logout_btn)
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        val Button = view.findViewById<Button>(R.id.logout_btn_mylist)


=======
=======
>>>>>>> Stashed changes
        val ButtonUpdateuser = view.findViewById<Button>(R.id.logout_btn_Updateuser)
        val ButtonuploadImage = view.findViewById<Button>(R.id.logout_btn_uploadImage)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        val gson = Gson()

        val sharedPreferences  =this.requireActivity()?.getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        val  us =  sharedPreferences?.getString(myuser, "")

        val nowuser = gson.fromJson(us, User::class.java)
<<<<<<< Updated upstream
<<<<<<< Updated upstream



=======
=======
>>>>>>> Stashed changes
        var imagee =""
        if( nowuser.profilPic!=null && nowuser.profilPic.length > 14){
            imagee = "img/"+ nowuser.profilPic.subSequence(14,nowuser.profilPic.length)

        }
        Glide.with(image).load("http://10.0.2.2:9090/" +imagee).placeholder(R.drawable.user).circleCrop()
            .error(R.drawable.user).into(image)
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        email.text=nowuser.email
        name.text= "${nowuser.firstName} ${nowuser.lastName}"

        logoutButton.setOnClickListener {

            sharedPreferences?.edit()?.clear()?.apply();
            Toast.makeText(requireContext(), "Log out!", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)


        }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        Button.setOnClickListener {


            val intent = Intent(requireContext(), MyBook::class.java)
=======
=======
>>>>>>> Stashed changes
        ButtonUpdateuser.setOnClickListener {


           // val intent = Intent(requireContext(), MyBook::class.java)
             val intent = Intent(requireContext(), UpdateProfile::class.java)
            startActivity(intent)

        }
        ButtonuploadImage.setOnClickListener {


            val intent = Intent(requireContext(), UploadImageUser::class.java)
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
            startActivity(intent)

        }





    }


}