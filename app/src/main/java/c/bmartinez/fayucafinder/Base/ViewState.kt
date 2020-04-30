package c.bmartinez.fayucafinder.Base

import android.os.Bundle
import kotlin.reflect.KClass

open class ViewState (
    var newActivity: KClass<*>? = null,
    var clearActivityIntent: Boolean = false,
    var intentExtras: Bundle = Bundle()
)