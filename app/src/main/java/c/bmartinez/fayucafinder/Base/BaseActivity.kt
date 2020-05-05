package c.bmartinez.fayucafinder.Base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<V: BaseViewModel<S>, S: ViewState>: AppCompatActivity(), {

}