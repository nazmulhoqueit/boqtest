package com.example.boqtest.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boqtest.boqtest.domain.models.Photo
import com.boqtest.boqtest.presentation.Interface.OnLoadMoreListener
import com.boqtest.boqtest.presentation.adapter.PhotoAdapter
import com.boqtest.boqtest.presentation.util.Constant.VIEW_TYPE_ITEM
import com.boqtest.boqtest.presentation.util.Constant.VIEW_TYPE_LOADING
import com.boqtest.boqtest.presentation.util.RecyclerViewLoadMoreScroll
import com.example.boqtest.Application
import com.example.boqtest.R
import com.example.boqtest.injection.components.DaggerActivityComponent
import com.example.boqtest.injection.modules.ComponentModule
import com.example.boqtest.presentation.presenters.PhotoPresenter
import kotlinx.android.synthetic.main.activity_photo.*
import javax.inject.Inject

class PhotoActivity : BaseActivity() , PhotoPresenter.ViewSurface
{
    companion object IntentBuilder {

        fun newIntent(launchContext: Context): Intent {
            val intent = Intent(launchContext, PhotoActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var presenter: PhotoPresenter
    lateinit var adapterGrid: PhotoAdapter
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    lateinit var mLayoutManager:RecyclerView.LayoutManager
    var photoCollection: ArrayList<Photo> =  ArrayList<Photo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        inject()
        setRVLayoutManager()
        setRVScrollListener()
        presenter.onCreate(this, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh -> {
                presenter.onRefreshClick()
            }
        }
        return true
    }

    private fun setRVLayoutManager() {
        mLayoutManager = GridLayoutManager(this, 3)
        recycler_photo.layoutManager = mLayoutManager
        recycler_photo.setHasFixedSize(true)
    }

    private fun setRVScrollListener() {
        scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as GridLayoutManager)
        scrollListener.setOnLoadMoreListener(object :
            OnLoadMoreListener {
            override fun onLoadMore() {
                presenter.loadMore()
            }
        })
        recycler_photo.addOnScrollListener(scrollListener)
    }

    fun onTryAgainClick(view: View){
        presenter.onRefreshClick()
    }

    private fun inject() {
        try {
            DaggerActivityComponent.builder()
                .applicationComponent(Application.applicationComponent)
                .componentModule(ComponentModule(this))
                .build()
                .inject(this)
        } catch (e: Exception) {
        }
    }

    override fun updatePhotoCollection(collections: List<Photo>, isNotify: Boolean) {
        if (!isNotify) {
            photoCollection.clear()
        }

        photoCollection.addAll(collections)

        if (!isNotify) {
            adapterGrid = PhotoAdapter(
                this,
                photoCollection
            )
            recycler_photo.adapter = adapterGrid
            (mLayoutManager as GridLayoutManager).spanSizeLookup =
                object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (adapterGrid.getItemViewType(position)) {
                            VIEW_TYPE_ITEM -> 1
                            VIEW_TYPE_LOADING -> 3 //number of columns of the grid
                            else -> -1
                        }
                    }
                }
        } else {
            recycler_photo.adapter?.notifyDataSetChanged()
        }
        scrollListener.setLoaded()
    }

    override fun showLoadingState(show: Boolean) {
        progress_loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showMoreLoadingState(show: Boolean) {
        idPBLoading.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showServerError(show: Boolean) {
        layout_server_error.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showNetworkError(show: Boolean) {
        layout_network_error.visibility = if (show) View.VISIBLE else View.GONE
    }
}
