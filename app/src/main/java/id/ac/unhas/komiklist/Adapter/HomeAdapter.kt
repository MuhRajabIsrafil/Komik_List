package id.ac.unhas.komiklist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.unhas.komiklist.R
import id.ac.unhas.komiklist.komik
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val listKomik: ArrayList<komik>, val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    interface OnItemClickListener {
        fun onClick(komik: komik)
    }

    class Homeholder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(komik: komik, listener: OnItemClickListener){
            with(itemView){
                Picasso.get()
                    .load(komik.image_url)
                    .into(imagetv)
                titletv.text = komik.title
                scoretv.text = "Score : "+komik.score.toString()
            }
            itemView.setOnClickListener(){
                listener.onClick(komik)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Homeholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return Homeholder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.Homeholder, position: Int) {
        holder.bind(listKomik[position], listener)
    }

    override fun getItemCount(): Int {
        return listKomik.size
    }
}