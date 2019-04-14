package eg.gov.iti.kotlin_project.Views

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList
import eg.gov.iti.kotlin_project.R

class MainViewAdapter(private val context: Context, private val athletes: List<Athlete>?) :
    RecyclerView.Adapter<MainViewAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val convertView: View)
        : RecyclerView.ViewHolder(convertView)
    {
        var nameTextView: TextView = convertView.findViewById(R.id.name_text_view)
        var imageView: ImageView = convertView.findViewById(R.id.image_view)
        var briefTextView: TextView = convertView.findViewById(R.id.brief_text_view)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MainViewAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list, parent, false) as View
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.text = athletes!!.get(position).name
//        Log.e("Amr", "${athletes.get(position).image} hopaaaaaaaaaaaaaaaaaaaaaaaaa")
        Glide.with(context).load(athletes.get(position).image).apply(RequestOptions().override(350, 500)).into(holder.imageView)
//        holder.imageTextView?.text = athletes.get(position).image
        holder.briefTextView.text = athletes.get(position).brief

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("name", holder.nameTextView.text.toString())
                putExtra("image", athletes.get(position).image)
                putExtra("brief", holder.briefTextView.text.toString())
            }
            context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = athletes!!.size
}