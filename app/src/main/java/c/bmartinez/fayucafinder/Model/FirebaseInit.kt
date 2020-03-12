package c.bmartinez.fayucafinder.Model

import android.app.ProgressDialog
import android.content.Context
import c.bmartinez.fayucafinder.BuildConfig
import c.bmartinez.fayucafinder.R
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
//import java.util.logging.Handler as

class FirebaseInit {
    private var remoteConfig: FirebaseRemoteConfig? = null
    private var mProgressBar: ProgressDialog? = null
    private var mTrucks = ""
    private var mContext: Context? = null
    private var mCount: Int = 0

    /*fun getTrucks(context: Context): String {
        mContext = context
        mProgressBar = ProgressDialog(mContext)
        mProgressBar!!.setCancelable(false)
        mProgressBar!!.setMessage("Please wait ...")
        mProgressBar!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        val remoteConfigSettings = FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(
            BuildConfig.DEBUG).build()

        remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig!!.setConfigSettings(remoteConfigSettings)
        remoteConfig!!.setDefaults(R.remote_config)

        var cacheExpiration: Long = 0

        if(remoteConfig!!.info.configSettings.isDeveloperModeEnabled){ cacheExpiration = 0 }

        mProgressBar!!.show()

        val handler: Handler

        remoteConfig!!.activateFetched()

        mTrucks = remoteConfig!!.getString()


    }*/
}