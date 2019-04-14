package eg.gov.iti.kotlin_project.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eg.gov.iti.kotlin_project.R

class DetailsActivity : AppCompatActivity() {

    var nameTextView : TextView? = null
    var imageView : ImageView? = null
    var briefTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        nameTextView = findViewById(R.id.details_name_text_view)
        imageView = findViewById(R.id.details_image_view)
        briefTextView = findViewById(R.id.details_brief_text_view)


        nameTextView!!.text = intent.getStringExtra("name")
        Glide.with(this)
            .load(intent.getStringExtra("image")).into(imageView!!)
//            .apply(RequestOptions()
//            .override(350, 500))
//            .into(imageView)
        briefTextView!!.text = intent.getStringExtra("brief")
    }
}
