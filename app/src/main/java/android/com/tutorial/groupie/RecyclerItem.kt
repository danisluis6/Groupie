package android.com.tutorial.groupie

import androidx.annotation.ColorInt
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import android.com.tutorial.R
import kotlinx.android.synthetic.main.expandable_item_layout.*
import kotlinx.android.synthetic.main.expandable_item_layout.view.*

/**
 * Created by ${KhalidToak} on 3/10/2019.
 */
class RecyclerItem(@ColorInt private val color : Int, private val num: Int) : Item(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            cardView.setCardBackgroundColor(color)
            cardView.number.text = num.toString()
        }
    }

    override fun getLayout(): Int  = R.layout.expandable_item_layout

    override fun getSpanSize(spanCount: Int, position: Int): Int  = spanCount / 2

}