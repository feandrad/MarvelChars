package io.felipeandrade.marvelchars.ui.characters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import io.felipeandrade.marvelchars.R
import kotlinx.android.synthetic.main.activity_char_details.*
import kotlinx.android.synthetic.main.activity_char_details.img_portrait
import kotlinx.android.synthetic.main.char_list_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsActivity : AppCompatActivity() {

    private val viewModel: CharDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_char_details)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.characterData.observe(this, Observer {
            it?.let { character ->
                Glide.with(this).load(character.portraitUrl).into(img_portrait)
                tv_character_name.text = character.name
                tv_id.text = character.id.toString()
            }
        })
    }
}