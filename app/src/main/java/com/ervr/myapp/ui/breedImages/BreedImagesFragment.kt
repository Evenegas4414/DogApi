package com.ervr.myapp.ui.breedImages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ervr.myapp.R
import com.ervr.myapp.adapter.ImagesAdapter
import com.ervr.myapp.remote.RetroFitBuilder
import kotlinx.coroutines.launch

class BreedImagesFragment : Fragment() {
    private var breed: String? = null
    private val apiService = RetroFitBuilder.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        breed = arguments?.let { BreedImagesFragmentArgs.fromBundle(it).breed }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breed_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        breed?.let {
            lifecycleScope.launch {
                val response = apiService.getBreedImages(it)
                recyclerView.adapter = ImagesAdapter(response.message)
            }
        }
    }
}