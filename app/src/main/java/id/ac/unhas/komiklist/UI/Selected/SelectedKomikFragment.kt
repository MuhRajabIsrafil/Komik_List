package id.ac.unhas.komiklist.UI.Selected

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import id.ac.unhas.komiklist.R
import id.ac.unhas.komiklist.Utilities.StaticData
import kotlinx.android.synthetic.main.fragment_selected_komik.*


class SelectedKomikFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_komik, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Picasso.get()
            .load(StaticData.image_url)
            .into(image_selected)
        title_selected.text = StaticData.title
        type_selected.text = "Type : "+StaticData.type
        volumes_selected.text = "Jumlah Volume : "+StaticData.volumes.toString()
        startdate_selected.text = "Start Date : "+StaticData.start_date
        score_selected.text = "Score : "+StaticData.score
        rank_selected.text = "Rank : "+StaticData.rank
        url_selected.text = "Sumber : "+StaticData.url

        shareBtn.setOnClickListener{
            val title = StaticData.title.toUpperCase()
            val score = StaticData.score
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nama Anime : $title \nScore : $score")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectedKomikFragment()
    }
}