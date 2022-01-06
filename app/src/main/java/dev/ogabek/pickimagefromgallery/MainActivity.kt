package dev.ogabek.pickimagefromgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.io.InputStream

import android.app.Activity

import android.content.Intent

import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.app.ActivityCompat.startActivityForResult
import android.net.Uri

class MainActivity : AppCompatActivity() {

    private lateinit var pickPhoto: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        pickPhoto = findViewById(R.id.pickPhoto)
        imageView = findViewById(R.id.loadedImage)
        pickPhoto.setOnClickListener {
            getPhotoFromGallery()
        }
    }

    private fun getPhotoFromGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 123)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                val selectedImageUri = data!!.data
                if (null != selectedImageUri) {
                    imageView.setImageURI(selectedImageUri)
                }
            }
        }
    }

}