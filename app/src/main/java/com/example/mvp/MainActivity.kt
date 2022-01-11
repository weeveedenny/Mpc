package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide



class MainActivity : AppCompatActivity(), Contract.View {
    // creating object of TextView class
    private lateinit var imageView: ImageView

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the TextView
        imageView = findViewById(R.id.ImageView)


        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        // operations to be performed when
        // user clicks the button
        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Course Detail TextView
    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        imageView.visibility = View.INVISIBLE
    }

    // method to hide the Course Detail TextView
    override fun hideProgress() {
        imageView.let {
            Glide.with(this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${Pos()}.png")
                .into(it)
            Log.d("checker","got here")
        }
        imageView.visibility = View.VISIBLE
        progressBar!!.visibility = View.GONE

    }

    private fun Pos(): Int{
        val list = listOf(1,2,3,4,5,6,7,8,9,10)
        val number = list.random()
        return number

    }

    override fun setString(string: String?) {

    }

//    // method to set random string
//    // in the Course Detail TextView
//    override fun setString(string: String?) {
//        textView!!.text = string
//    }
}
