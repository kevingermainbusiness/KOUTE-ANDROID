package ht.koute.android.fragments

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ht.koute.android.R

/**
 * A fragment that will contain buttons that redirect to the user's
 * Favorites, Archives
 * & Albums
 * */
class LibraryFragment : Fragment(R.layout.fragment_library) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().findViewById<Toolbar>(R.id.toolbar)?.isVisible = true
        requireActivity().findViewById<LinearLayout>(R.id.now_playing_layout)?.isVisible = true
    }
}