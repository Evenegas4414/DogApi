package com.ervr.myapp.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.ervr.myapp.R
import com.ervr.myapp.adapter.BreedsAdapter
import com.ervr.myapp.database.AppDatabase
import com.ervr.myapp.model.Breed
import com.ervr.myapp.remote.RetroFitBuilder
import com.ervr.myapp.repository.DogRepository
import kotlinx.coroutines.launch


class BreedsFragment : Fragment(), BreedsAdapter.OnBreedClickListener {
    private lateinit var dogRepository: DogRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "db").build()
        val apiService = RetroFitBuilder.create()
        dogRepository = DogRepository(apiService, database.breedDao())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_breeds, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            val breeds = dogRepository.getAllBreeds()
            recyclerView.adapter = BreedsAdapter(breeds, this@BreedsFragment)
        }

        return view
    }

    override fun onBreedClick(breed: Breed) {
        val action = BreedsFragmentDirections.actionBreedsFragmentToBreedImagesFragment(breed.breed)
        findNavController().navigate(action)
    }
}
