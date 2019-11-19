package c.bmartinez.fayucafinder.View.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import c.bmartinez.fayucafinder.R
import c.bmartinez.fayucafinder.ViewModel.ListViewModel

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = DataBindingUtil.inflate<ViewDataBinding>(inflater,R.layout.fragment_list,container,false).root
        return view
    }
}