package unicauca.movil.rxandroid.attrs

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by jlbel on 17/09/2017.
 */
@BindingAdapter("app:picassoImg")
fun setImage(img: ImageView, url:String){
    Picasso.with(img.context)
            .load(Uri.parse(url))
            .into(img)
}