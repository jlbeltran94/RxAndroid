package unicauca.movil.rxandroid.utils

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by jlbel on 15/09/2017.
 */
fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)
