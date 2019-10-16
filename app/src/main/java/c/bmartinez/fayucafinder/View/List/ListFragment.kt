package c.bmartinez.fayucafinder.View.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import c.bmartinez.fayucafinder.R
import c.bmartinez.fayucafinder.ViewModel.ListViewModel

class ListFragment : Fragment() {

    private lateinit var dashboardViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(ListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}