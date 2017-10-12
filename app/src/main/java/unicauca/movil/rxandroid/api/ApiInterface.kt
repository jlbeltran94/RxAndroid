package unicauca.movil.rxandroid.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * Created by jlbel on 15/09/2017.
 */
interface ApiInterface {

    @GET("{section}.json")
    fun getArticleList(@Path("section") section: String, @Query("api-key") apikey: String) : Observable<ArticleResponse>
}