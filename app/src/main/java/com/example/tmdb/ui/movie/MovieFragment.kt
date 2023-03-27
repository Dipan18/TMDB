package com.example.tmdb.ui.movie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieBinding
import com.example.tmdb.ui.di.Injector
import javax.inject.Inject

class MovieFragment : Fragment(), MenuProvider {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        activity?.addMenuProvider(this, viewLifecycleOwner)

        (activity?.application as Injector).createMovieSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(activity)
        adapter = MovieAdapter()
        binding.rvMovies.adapter = adapter

        displayMovies()
    }

    private fun displayMovies() {
        binding.pbMovies.visibility = View.VISIBLE
        viewModel.getMovies().observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbMovies.visibility = View.GONE
        }
    }

    private fun updateMovies() {
        binding.pbMovies.visibility = View.VISIBLE
        viewModel.updateMovies().observe(this) {
            if (it != null) {
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbMovies.visibility = View.GONE
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