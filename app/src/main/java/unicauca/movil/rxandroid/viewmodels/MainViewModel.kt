package unicauca.movil.rxandroid.viewmodels

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import unicauca.movil.rxandroid.api.ApiClient
import unicauca.movil.rxandroid.api.ApiInterface
import unicauca.movil.rxandroid.models.Article

/**
 * Created by jlbel on 15/09/2017.
 */
class MainViewModel{
    var apiClient: ApiInterface = ApiClient.getIntance()

    fun getArticles(section: String): Observable<List<Article>>{
        return apiClient.getArticleList(section, "46e3b5ff207148f487aaa049732448d9")
                .map { it.articleList }
                .observeOn(AndroidSchedulers.mainThread())
    }
}