package com.example.workman.View.Group

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.GroupAdapter
import com.example.workman.R
import com.example.workman.View.Add_Group.AddGroupActivity
import com.example.workman.View.Detail_Group.DetailGroupActivity
import kotlinx.android.synthetic.main.activity_group.*

class GroupActivity : AppCompatActivity(),GroupContract.IGroupView, View.OnClickListener {

    private var presenter: GroupPresenter? = null
    private var layoutmanager: LinearLayoutManager? = null
    private var groupAdapter:GroupAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        initialize()
        presenter?.callGroups()
    }

    private fun initialize()
    {
        groupAdapter = GroupAdapter(this,0)
        layoutmanager = LinearLayoutManager(this)

        presenter = GroupPresenter(this, this).apply {
            adapterModel = groupAdapter
            adapterView = groupAdapter
        }

        G_recyclerview.run {
            layoutManager = layoutmanager
            adapter = groupAdapter
        }

        G_fab.setOnClickListener(this)
    }

    override fun addGroup() {
        startActivity(Intent(this, AddGroupActivity::class.java))
    }

    override fun finishActivity() {
        finish()
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun progressVisible(boolean: Boolean) {
        if(boolean)
        {
            G_progressBar.visibility = View.VISIBLE
        }else
        {
            G_progressBar.visibility = View.INVISIBLE
        }
    }

    override fun detailGroup(idx:Int)
    {
        startActivity(Intent(this, DetailGroupActivity::class.java).putExtra("idx", idx))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.G_fab -> {
                presenter?.fabClick()
            }
        }
    }
}
