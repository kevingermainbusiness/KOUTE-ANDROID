package ht.koute.android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ht.koute.android.MainActivity
import ht.koute.android.R

class AvailableReferencesFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_available_references, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        val frag = ViewReferenceFragment()
        view.findViewById<LinearLayout>(R.id.ref_one_layout).setOnClickListener {
            bundle.putString("fromWhere", "firstExample")
            frag.arguments = bundle
            frag.show(
                requireActivity().supportFragmentManager,
                "ViewRefFrag1"
            )
            dismiss()
        }

        view.findViewById<LinearLayout>(R.id.ref_two_layout).setOnClickListener {
            bundle.putString("fromWhere", "secondExample")
            frag.arguments = bundle
            frag.show(
                requireActivity().supportFragmentManager,
                "ViewRefFrag2"
            )
            dismiss()
        }
    }
}