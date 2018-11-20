package ru.sorokin.dev.fitkittest.ui.home

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.delegateadapter.delegate.KDelegateAdapter
import com.example.delegateadapter.delegate.diff.IComparableItem
import kotlinx.android.synthetic.main.item_lesson.*
import org.w3c.dom.Text
import ru.sorokin.dev.fitkittest.R
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson

class LessonItem(val data: Lesson): IComparableItem {
    override fun id() = data.appointmentId

    override fun content(): Any = data.name + data.description + data.startTime
}

class LessonDelegateAdapter(val daysOfWeek: List<String>)
    : KDelegateAdapter<LessonItem>() {


    override fun onBind(item: LessonItem, viewHolder: KViewHolder) = with(viewHolder) {
        tv_lesson_name.text = item.data.name
        tv_teacher_name.text = item.data.teacher
        tv_place_name.text = item.data.place
        tv_start_time.text = item.data.startTime
        tv_end_time.text = item.data.endTime
        tv_day_of_week.text = daysOfWeek[maxOf(daysOfWeek.count()-1,item.data.weekDay+1)].capitalize()
    }

    override fun isForViewType(items: List<*>, position: Int) = items[position] is LessonItem

    override fun getLayoutId(): Int = R.layout.item_lesson
}
