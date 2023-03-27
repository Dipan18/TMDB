package com.example.tmdb.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentTvShowBinding
import com.example.tmdb.ui.di.Injector
import javax.inject.Inject

class TVShowFragment : Fragment(), MenuProvider {
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var viewModel: TVShowViewModel
    private lateinit var adapter: TVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        activity?.addMenuProvider(this, viewLifecycleOwner)

        (activity?.application as Injector).createTvShowSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvTvShows.layoutManager = LinearLayoutManager(activity)
        adapter = TVShowAdapter()
        binding.rvTvShows.adapter = adapter
        displayTvShows()
    }

    private fun displayTvShows() {
        binding.pbTvShows.visibility = View.VISIBLE
        viewModel.getTvShows().observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setTvShows(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbTvShows.visibility = View.GONE
        }
    }

    private fun updateMovies() {
        binding.pbTvShows.visibility = View.VISIBLE
        viewModel.updateTvShows().observe(this) {
            if (it != null) {
                adapter.setTvShows(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbTvShows.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.update, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> false
        }
    }
}