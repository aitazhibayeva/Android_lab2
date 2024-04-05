package com.example.lab2.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.model.entity.Dog
import com.example.lab2.R
import com.example.lab2.databinding.ItemDogsBinding

class DogsAdapter : RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {

    private val dogsList: ArrayList<Dog> = arrayListOf()

    fun setItems(dogs: List<Dog>) {
        val diffUtil = DogsDiffUtil(dogsList, dogs)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        dogsList.clear()
        dogsList.addAll(dogs)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        return DogsViewHolder(
            ItemDogsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        holder.bind(dogsList[position])
    }

    inner class DogsViewHolder(private val binding: ItemDogsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog) {
            with(binding) {
                name.text = dog.name
                barking.text = "Barking: ${dog.barking}"
                trainability.text = "Trainability: ${dog.trainability}"
                protectiveness.text = "Protectiveness: ${dog.protectiveness}"
                playfulness.text = "Playfulness: ${dog.playfulness}"
                maxHeight.text = "Max Height: ${dog.maxHeight}"

                Glide.with(dogImage.context)
                    .load(dog.imageLink)
                    .placeholder(R.drawable.dog_icon)
                    .into(dogImage)
            }
        }
    }
}