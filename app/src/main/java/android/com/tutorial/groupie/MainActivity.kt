package android.com.tutorial.groupie

import android.com.tutorial.R
import android.com.tutorial.groupie.entities.User
import android.com.tutorial.groupie.viewholder.ViewItem
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemAdapter = GroupAdapter<GroupieViewHolder>()

        itemAdapter.add(ViewItem(User("Emma Wilson", "23 years old", R.drawable.camera)))
        itemAdapter.add(ViewItem(User("Emma Wilson", "23 years old", R.drawable.camera)))
        itemAdapter.add(ViewItem(User("Emma Wilson", "23 years old", R.drawable.camera)))

        recycler_view.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter = itemAdapter
        }
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
