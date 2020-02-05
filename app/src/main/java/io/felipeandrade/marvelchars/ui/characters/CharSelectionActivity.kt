package io.felipeandrade.marvelchars.ui.characters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.felipeandrade.marvelchars.R
import kotlinx.android.synthetic.main.char_search_fragment.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharSelectionActivity : AppCompatActivity() {

    private val charSelectionAdapter: CharSelectionAdapter by inject()
    private val charSelectionViewModel: CharSelectionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.char_search_fragment)

        initRecyclerView()

//charSelectionViewModel.uiData.observe(this, )
    }

    private fun initRecyclerView() {
        list_character_selection.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        charSelectionAdapter.onCharacterClicked = {
            charSelectionViewModel.characterClicked(it)
        }

        list_character_selection.adapter = charSelectionAdapter
    }
}