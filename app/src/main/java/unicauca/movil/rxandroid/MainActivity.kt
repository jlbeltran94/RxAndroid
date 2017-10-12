package unicauca.movil.rxandroid

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import unicauca.movil.rxandroid.adapters.ArticleAdapter
import unicauca.movil.rxandroid.databinding.ActivityMainBinding
import unicauca.movil.rxandroid.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    var adapter: ArticleAdapter = ArticleAdapter()
    var subscription: CompositeDisposable = CompositeDisposable()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerArticle.adapter = adapter
        viewModel = MainViewModel()

        subscription.addAll(

                viewModel.getArticles("home")
                        .subscribeBy(
                                onNext = {
                                    adapter.item = it
                                    binding.progressBar.visibility = ProgressBar.INVISIBLE
                                },
                                onError = {
                                    Log.e("ERROR", "Error de conexion",it)
                                }
                        ),
                adapter.articleSelected.subscribeBy (
                        onNext = {
                            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
                        }
                )
        )




    }
}
