package com.bluehomestudio.adaptredelegatesdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.bluehomestudio.adaptredelegatesdemo.adapter.FeedsAdapter
import com.bluehomestudio.adaptredelegatesdemo.databinding.ActivityMainBinding
import com.bluehomestudio.adaptredelegatesdemo.models.Responses


class MainActivity : AppCompatActivity() , FeedsAdapter.OnItemClicked {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupFeedsRecycler()
    }

    private fun setupFeedsRecycler() {
        val adapter = FeedsAdapter(listener = this)
        adapter.items = Responses.mixItems()
        binding.feeds.adapter = adapter
        binding.feeds.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onFeedClicked(id: String) {

    }

    override fun onAdClicked(id: String) {

    }
}