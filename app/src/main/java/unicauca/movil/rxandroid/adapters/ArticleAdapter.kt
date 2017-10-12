package unicauca.movil.rxandroid.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject
import unicauca.movil.rxandroid.R
import unicauca.movil.rxandroid.databinding.ItemArticleBinding
import unicauca.movil.rxandroid.models.Article
import unicauca.movil.rxandroid.utils.inflate

/**
 * Created by jlbel on 15/09/2017.
 */
class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    val articleSelected = PublishSubject.create<Article>()

    var item: List<Article> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = item.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_article))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.article = item[position]
        holder.binding.articleSelected = articleSelected
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: ItemArticleBinding = DataBindingUtil.bind(itemView)

    }
}