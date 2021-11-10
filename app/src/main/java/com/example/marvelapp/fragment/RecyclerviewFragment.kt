package com.example.marvelapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.MainViewModelFactory
import com.example.marvelapp.R
import com.example.marvelapp.SharedViewModel
import com.example.marvelapp.adapter.CharactersAdapter
import com.example.marvelapp.model.Character
import com.example.marvelapp.repository.Repository

/**
 * [Fragment] object that will display a RecyclerView
 */
class RecyclerviewFragment : Fragment(), CharactersAdapter.OnCharacterClickListener {
    private lateinit var charactersRecView: RecyclerView
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var viewModel: SharedViewModel

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * Inflates the layout for this fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    /**
     * @param view
     * @param savedInstanceState
     * Instantiates the heroesAdapter, creates heroesRecView and applies adapter and layoutManager, and
     * creates a list of Heroes
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        charactersAdapter = CharactersAdapter(Glide.with(this), this)
        charactersRecView = view.findViewById(R.id.heroes_rec_view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SharedViewModel::class.java)
        viewModel.getCharacters()
        viewModel.mResponse.observe(viewLifecycleOwner, { response ->
            charactersAdapter.setCharacters(response.results as ArrayList<Character>)
        })

        charactersRecView.apply {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onCharacterClick(character: Character) {
        createFragmentTransaction(character)
    }

    private fun createFragmentTransaction(character: Character) {
        val activity = view?.context
        val characterDetailsFragment = CharacterDetailsFragment.newInstance(character)
        val fragmentTransaction = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, characterDetailsFragment)
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "fragment transaction complete")
    }

    companion object {
        const val TAG = "RecyclerviewFragment"
        fun newInstance() = RecyclerviewFragment()
    }
}