package android.com.tutorial.groupie.viewholder

import android.com.tutorial.R
import android.com.tutorial.groupie.entities.User
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.view_item.*

/**
 * Created by lorence on 14/Feb/2020.
 */
class ViewItem(private val user: User) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            viewHolder.person_photo.setImageResource(user.idRes)
            viewHolder.person_name.text = user.name
            viewHolder.person_age.text = user.age
        }
    }

    override fun getLayout(): Int  = R.layout.view_item

    override fun getSpanSize(spanCount: Int, position: Int): Int  = spanCount / 2

}