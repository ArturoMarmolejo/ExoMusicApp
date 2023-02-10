import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturomarmolejo.exomusicapp.R
import com.arturomarmolejo.exomusicapp.databinding.RvTrackItemBinding
import com.arturomarmolejo.exomusicapp.model.items.TrackResponse

class ExoMusicAdapter(
    private val itemSet: MutableList<com.arturomarmolejo.exomusicapp.model.items.TrackResponse> = mutableListOf(),
    private val onItemClick: (previewUrl: String) -> Unit
) :  RecyclerView.Adapter<ExoMusicViewHolder>() {

    fun updateItems(newItems: List<com.arturomarmolejo.exomusicapp.model.items.TrackResponse>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExoMusicViewHolder =
        ExoMusicViewHolder(
            RvTrackItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ExoMusicViewHolder, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class ExoMusicViewHolder(
    private val binding: RvTrackItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun Double.format(digits: Int) = "%. ${digits}f".format(this)

    fun bind(item: TrackResponse, onItemClick: (String) -> Unit) {
        binding.musicAlbumImage.setImageResource(R.drawable.baseline_library_music_24)
        binding.trackTitle.text = item.trackName ?: "NO NAME PROVIDED"
        binding.artistName.text = item.artistName ?: "NO NAME PROVIDED"
        val trackPrice = // Validation for a track having individual price. It it does not, displays de price of the whole album.
            if(item.trackName != null) {
                "${item.trackPrice?.format(2).toString()} USD"
            } else {
                "${item.collectionPrice?.format(2).toString()} USD"
            }
        binding.priceFee.text = trackPrice
        itemView.setOnClickListener {
            item.previewUrl?.let(onItemClick)
        }
    }
}