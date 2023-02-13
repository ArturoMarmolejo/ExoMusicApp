import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturomarmolejo.exomusicapp.R
import com.arturomarmolejo.exomusicapp.databinding.RvTrackItemBinding
import com.arturomarmolejo.exomusicapp.model.items.TrackResponse
import com.arturomarmolejo.exomusicapp.viewmodel.ExoMusicViewModel
import com.bumptech.glide.Glide

class ExoMusicAdapter(
    private val itemSet: MutableList<TrackResponse> = mutableListOf(),
    private val onItemClick: (previewUrl: String) -> Unit
) :  RecyclerView.Adapter<ExoMusicViewModel1>() {

    fun updateItems(newItems: List<TrackResponse>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExoMusicViewModel1 =
       ExoMusicViewModel1(
           RvTrackItemBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )

    override fun onBindViewHolder(holder: ExoMusicViewModel1, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class ExoMusicViewModel1(
    private val binding: RvTrackItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TrackResponse, onItemClick: (String) -> Unit) {
        binding.musicAlbumImage.setImageResource(R.drawable.baseline_library_music_24)
        binding.trackTitle.text = item.trackName ?: "NO NAME PROVIDED"
        binding.artistName.text = item.artistName ?: "NO NAME PROVIDED"
        val trackPrice = // Validation for a track having individual price. It it does not, displays de price of the whole album.
            if(item.trackName != null) {
                item.trackPrice?.toString()
            }
            else {
                item.collectionPrice?.toString()
            }

       binding.priceFee.text = "$trackPrice USD"
        itemView.setOnClickListener {
            item.previewUrl?.let(onItemClick)
        }
        Glide
            .with(binding.root)
            .load(item.artworkUrl60)
            .centerCrop()
            .placeholder(R.drawable.baseline_image_search_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.musicAlbumImage)
    }
}