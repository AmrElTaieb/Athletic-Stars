package eg.gov.iti.kotlin_project.Views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList
import eg.gov.iti.kotlin_project.R

class MainViewAdapter(private val athletes: List<Athlete>?) :
    RecyclerView.Adapter<MainViewAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val convertView: View)
        : RecyclerView.ViewHolder(convertView)
    {
        var nameTextView: TextView? = convertView.findViewById(R.id.name_text_view)
        var imageTextView: TextView? = convertView.findViewById(R.id.image_text_view)
        var briefTextView: TextView? = convertView.findViewById(R.id.brief_text_view)
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
        holder.nameTextView?.text = athletes!!.get(position).name
        holder.imageTextView?.text = athletes.get(position).image
        holder.briefTextView?.text = athletes.get(position).brief
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = athletes!!.size
}