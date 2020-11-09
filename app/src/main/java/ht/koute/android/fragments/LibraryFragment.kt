package ht.koute.android.fragments

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ht.koute.android.R

class LibraryFragment : Fragment(R.layout.fragment_library) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().findViewById<Toolbar>(R.id.toolbar).isVisible = true
    }
}