package ht.koute.android.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ht.koute.android.R

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.isVisible = false
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }
}