package android.com.tutorial.groupie

import android.com.tutorial.R
import android.com.tutorial.groupie.entities.User
import android.com.tutorial.groupie.viewholder.ViewItem
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

// https://www.materialpalette.com/light-blue/cyan
// https://material.io/design/color/the-color-system.html
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemAdapter = GroupAdapter<GroupieViewHolder>()

        itemAdapter.addAll(MutableList(10) {
            val rand = Random.nextInt(90)+10
            ViewItem(User("Emma Wilson", "$rand years old", R.drawable.camera))
        })

        recycler_view.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter = itemAdapter
        }

        fab.setOnClickListener{
            itemAdapter.update(MutableList(5) {
                val rand = Random.nextInt(50)+20
                ViewItem(User("Luis is writing", "$rand years old", R.drawable.camera))
            })
//            itemAdapter.update(generateViewItems(null));
        }
    }

    private fun generateViewItems(list : List<User>): MutableList<ViewItem> {
        val mutableList = mutableListOf<ViewItem>()
        for (i in 0..list.size) {
            mutableList.add(ViewItem(list[i]))
        }
        return mutableList
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
