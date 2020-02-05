package io.felipeandrade.marvelchars.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.felipeandrade.marvelchars.R
import io.felipeandrade.marvelchars.domain.MarvelCharacter
import kotlinx.android.synthetic.main.char_list_item.view.*

class CharSelectionAdapter : RecyclerView.Adapter<CharSelectionAdapter.ViewHolder>() {

    private var elements: List<MarvelCharacter> = listOf()

    var onCharacterClicked: (MarvelCharacter) -> Unit = {}

    override fun getItemCount(): Int = elements.size
    override fun getItemViewType(position: Int): Int = R.layout.char_list_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(viewType))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(elements[position], onCharacterClicked)

    fun setData(newElements: List<MarvelCharacter>?) {
        elements = newElements?: listOf()
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            character: MarvelCharacter,
            onCharacterClicked: (MarvelCharacter) -> Unit
        ) {
            itemView.apply {
                Glide.with(context).load(character.portraitUrl).into(img_portrait)
                tv_character_name.text = character.name

                setOnClickListener { onCharacterClicked(character) }
            }
        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}