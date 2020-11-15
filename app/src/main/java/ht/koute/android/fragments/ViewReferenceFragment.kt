package ht.koute.android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ht.koute.android.R
import ht.koute.android.utils.Util

class ViewReferenceFragment : BottomSheetDialogFragment() {

    private val refTitleToShow = listOf("Psaumes 23: 3", "Genese 3 : 1-3")

    private lateinit var refToShow: List<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_reference, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString("fromWhere")
        refToShow =
            listOf(getString(R.string.reference_exemple_1), getString(R.string.reference_exemple_2))
        data?.let {
            if (it == "firstExample") {
                view.findViewById<TextView>(R.id.tvReferenceTitle).text = refTitleToShow[0]
                view.findViewById<TextView>(R.id.tvReference).text = refToShow[0]
            } else if (it == "secondExample") {
                view.findViewById<TextView>(R.id.tvReferenceTitle).text = refTitleToShow[1]
                view.findViewById<TextView>(R.id.tvReference).text = refToShow[1]
            }
        }
    }
}