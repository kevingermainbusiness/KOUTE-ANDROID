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
import ht.koute.android.MainActivity
import ht.koute.android.R
import ht.koute.android.adapters.SermonsAdapter
import ht.koute.android.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_sermons.*
import javax.inject.Inject

/**
 * A fragment containing a simple view that displays the list of new sermons.
 */
@AndroidEntryPoint
class SermonsFragment : Fragment(R.layout.fragment_sermons) {
    private lateinit var sermonsRecyclerView: RecyclerView

    @Inject
    lateinit var sermonsAdapter: SermonsAdapter

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.isVisible = true
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true

    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }

    private fun initializeObservers() {
        mainViewModel.apply { setSermonsList() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sermonsRecyclerView = view.findViewById(R.id.sermons_recycler_view)
        progress_circular.isVisible = true
        initializeObservers()
        subscribeToObservers()
        setupRecyclerView()
    }

    private fun subscribeToObservers() {
        mainViewModel.sermonsList.observe(viewLifecycleOwner) {
            sermonsAdapter.shows = it
            progress_circular.isVisible = false
        }
    }

    private fun setupRecyclerView() {
        sermonsRecyclerView.apply {
            adapter = sermonsAdapter; layoutManager = LinearLayoutManager(requireContext())
        }
    }


}