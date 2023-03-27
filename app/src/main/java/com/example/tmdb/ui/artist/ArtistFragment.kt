package com.example.tmdb.ui.artist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentArtistBinding
import com.example.tmdb.ui.di.Injector
import javax.inject.Inject

class ArtistFragment : Fragment(), MenuProvider {
    private var _binding: FragmentArtistBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ArtistViewModelFactory
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtistBinding.inflate(inflater, container, false)
        activity?.addMenuProvider(this, viewLifecycleOwner)

        (activity?.application as Injector).createArtistSubComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ArtistViewModel::class.java]

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvArtists.layoutManager = LinearLayoutManager(activity)
        adapter = ArtistAdapter()
        binding.rvArtists.adapter = adapter
        displayArtists()
    }

    private fun displayArtists() {
        binding.pbArtists.visibility = View.VISIBLE
        viewModel.getArtists().observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setArtists(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbArtists.visibility = View.GONE
        }
    }

    private fun updateArtists() {
        binding.pbArtists.visibility = View.VISIBLE
        viewModel.updateArtists().observe(this) {
            if (it != null) {
                adapter.setArtists(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
            }
            binding.pbArtists.visibility = View.GONE
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
                updateArtists()
                return true
            }
            else -> false
        }
    }
}