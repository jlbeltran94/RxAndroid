package unicauca.movil.rxandroid.api

import com.google.gson.annotations.SerializedName
import unicauca.movil.rxandroid.models.Article

/**
 * Created by jlbel on 15/09/2017.
 */
class ArticleResponse {

    @SerializedName("status")
    var estatus: String? = null

    @SerializedName("num_results")
    var numReults: Int? = null

    @SerializedName("results")
    var articleList: List<Article> = emptyList()
}