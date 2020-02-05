package io.felipeandrade.marvelchars.ui.characters

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.felipeandrade.marvelchars.R
import kotlinx.android.synthetic.main.activity_char_search.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterSelectionActivity : AppCompatActivity() {

    companion object{
        const val SELECTED_CHAR_ID = "SELECTED_CHAR_ID"
    }


    private val charSelectionAdapter: CharSelectionAdapter by inject()
    private val charSelectionViewModel: CharSelectionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_char_search)
        initRecyclerView()
        observeLiveData()
    }

    private fun initRecyclerView() {
        list_character_selection.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        charSelectionAdapter.onCharacterClicked = { charSelectionViewModel.characterClicked(it) }
        list_character_selection.adapter = charSelectionAdapter
    }

    private fun observeLiveData() {
        charSelectionViewModel.characterList.observe(this, Observer {
            charSelectionAdapter.setData(it)
        })

        charSelectionViewModel.selectedCharacter.observe(this, Observer {
            it?.let {
                val intent = Intent(this, CharacterDetailsActivity::class.java)
                intent.putExtra(SELECTED_CHAR_ID, it.id)
                startActivity(intent)
            }
        })
    }
}