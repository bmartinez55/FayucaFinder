package c.bmartinez.fayucafinder.View.map

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import c.bmartinez.fayucafinder.DataInjection.Components.AppComponent
import c.bmartinez.fayucafinder.DataInjection.ViewModelFactory
import c.bmartinez.fayucafinder.R
import c.bmartinez.fayucafinder.Utilities.ActivityUtilities
import com.google.firebase.FirebaseApp
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

//HasSupportFragmentInjector
class MapActivity :DaggerAppCompatActivity()  {
    private var mapFragment: MapsFragment = MapsFragment()
    lateinit var components: AppComponent

//    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        return super.supportFragmentInjector()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )

        noActionBar()
        setupBottomNavBar(navController)
        setUpActivity()
        //testFragment()
    }

    private fun testFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.main_container, MapsFragment()).commit()
    }

    private fun setupBottomNavBar(navController: NavController){
        nav_view?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun noActionBar(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    private fun setUpActivity(){
        var fragment = supportFragmentManager.findFragmentById(R.id.map)
        //fragment = supportFragmentManager.beginTransaction().replace(R.id.main_container, R.id.map )

        if(fragment == null){
            fragment = mapFragment
            ActivityUtilities.addFragmentToActivity(supportFragmentManager,fragment,
            R.id.map)
        }
    }
}

