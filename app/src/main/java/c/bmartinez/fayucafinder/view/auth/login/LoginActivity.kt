package c.bmartinez.fayucafinder.view.auth.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import c.bmartinez.fayucafinder.R
import dagger.android.support.DaggerAppCompatActivity


class LoginActivity : DaggerAppCompatActivity(){
    private lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_holder)

        nav = Navigation.findNavController(this, R.id.navHostFragment)
    }

}

