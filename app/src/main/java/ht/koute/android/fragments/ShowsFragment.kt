package ht.koute.android.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ht.koute.android.R
import ht.koute.android.adapters.CategoriesAdapter
import ht.koute.android.adapters.NewShowsAdapter
import ht.koute.android.adapters.RecomShowsAdapter
import ht.koute.android.adapters.SuggestionsAdapter
import ht.koute.android.utils.Util
import ht.koute.android.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_sermons.*
import javax.inject.Inject

@AndroidEntryPoint
class ShowsFragment : Fragment(R.layout.fragment_shows) {
    private lateinit var suggestionsRecyclerView: RecyclerView
    private lateinit var recommendedShowsRecyclerView: RecyclerView
    private lateinit var newShowsRecyclerView: RecyclerView
    private lateinit var faithShowsRecyclerView: RecyclerView

    @Inject
    lateinit var newShowsAdapter: NewShowsAdapter

    @Inject
    lateinit var recomShowsAdapter: RecomShowsAdapter

    @Inject
    lateinit var faithAdapter: CategoriesAdapter

    private lateinit var suggestionsAdapter: SuggestionsAdapter

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.isVisible = false
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }

    private fun initializeObservers() {
        mainViewModel.apply {
            setSuggestionsList(requireContext())
            setRecommendedShowsList()
            setNewShowsList()
            setFaithShowsList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        suggestionsRecyclerView = view.findViewById(R.id.suggestions_recycler_view)
        recommendedShowsRecyclerView = view.findViewById(R.id.recom_shows_recycler_view)
        newShowsRecyclerView = view.findViewById(R.id.new_shows_recycler_view)
        faithShowsRecyclerView = view.findViewById(R.id.faith_recycler_view)
        suggestionsAdapter = SuggestionsAdapter()
        initializeObservers()
        subscribeToObservers()
        setupRecyclerView()
    }

    private fun subscribeToObservers() {
        mainViewModel.suggestionsList.observe(viewLifecycleOwner) {
            suggestionsAdapter.suggestions = it
        }
        mainViewModel.recommendedShowsList.observe(viewLifecycleOwner) {
            recomShowsAdapter.shows = it
            progress_circular.isVisible = false
        }
        mainViewModel.newShowsList.observe(viewLifecycleOwner) {
            newShowsAdapter.shows = it
            progress_circular.isVisible = false
        }

        mainViewModel.faithShowsList.observe(viewLifecycleOwner) {
            faithAdapter.shows = it
            progress_circular.isVisible = false
        }
    }

    private fun setupRecyclerView() {
        suggestionsRecyclerView.apply {
            adapter = suggestionsAdapter; layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        recommendedShowsRecyclerView.apply {
            adapter = recomShowsAdapter; layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        newShowsRecyclerView.apply {
            adapter = newShowsAdapter; layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        faithShowsRecyclerView.apply {
            adapter = faithAdapter; layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        suggestionsAdapter.setItemClickListener { item ->
            Util.createToast(requireContext(), item.title)
        }
    }
}