package ht.koute.android.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ht.koute.android.R

class NowPlayingFragment : Fragment(R.layout.fragment_now_playing) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.isVisible = true
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = false
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.now_playing_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reference -> {
                AvailableReferencesFragment().show(
                    requireActivity().supportFragmentManager,
                    "AvailableReferenceFrag"
                )
                true
            }
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }
            else -> true
        }
    }
}