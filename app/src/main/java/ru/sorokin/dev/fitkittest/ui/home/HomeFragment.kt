package ru.sorokin.dev.fitkittest.ui.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.delegateadapter.delegate.diff.DiffUtilCompositeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import ru.sorokin.dev.fitkittest.R
import ru.sorokin.dev.fitkittest.model.DataResource
import ru.sorokin.dev.fitkittest.model.Error
import ru.sorokin.dev.fitkittest.model.Success
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson
import ru.sorokin.dev.fitkittest.ui.base.BaseFragment
import timber.log.Timber
import java.text.DateFormatSymbols

class HomeFragment: BaseFragment<HomeViewModel>(HomeViewModel::class){

    override fun getLayoutRes(): Int = R.layout.fragment_home

    lateinit var compositeAdapter: DiffUtilCompositeAdapter


    val scheduleObserver = Observer<DataResource<List<Lesson>>> { dataRes ->
        when(dataRes){
            is Success -> {
                dataRes.data?.let {
                    compositeAdapter.swapData(it.sortedBy { x ->
                        x.weekDay.toString() + x.startTime.toString()
                    }.map { x ->
                        LessonItem(x)
                    })
                    layout_no_connection.visibility = View.GONE
                }
            }
            is Error -> {
                layout_no_connection.visibility = View.VISIBLE
            }
        }

    }

    override fun initUI() {
        val dateFormatSymbols = DateFormatSymbols.getInstance(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            requireContext().resources.configuration.locales.get(0)
        } else{
            requireContext().resources.configuration.locale
        })
        compositeAdapter = DiffUtilCompositeAdapter.Builder()
                .add(LessonDelegateAdapter(dateFormatSymbols.shortWeekdays.toList()))
                .build()
        fab_contact.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(VK_DEV_LINK)))
        }
        rv_schedule.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_schedule.adapter = compositeAdapter
        rv_schedule.addItemDecoration(DividerItemDecoration(rv_schedule.context, DividerItemDecoration.VERTICAL))

        rv_schedule.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fab_contact.visibility == View.VISIBLE) {
                    fab_contact.hide()
                } else if (dy < 0 && fab_contact.visibility != View.VISIBLE) {
                    fab_contact.show()
                }
            }
        })

        layout_no_connection.setOnClickListener {
            viewModel.scheduleLiveData.removeObservers(this)
            viewModel.getSchedule().observe(this, scheduleObserver)
        }


    }


    override fun initObservers() {
        viewModel.getSchedule().observe(this, scheduleObserver)
    }

    companion object {
        const val VK_DEV_LINK = "https://vk.me/sorokin_dev"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}