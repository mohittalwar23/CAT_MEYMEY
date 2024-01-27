/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.catmeymey.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catmeymey.R
import com.example.catmeymey.data.DataSource
import com.example.catmeymey.data.DataSource.cats
import com.example.catmeymey.model.Cat
import kotlinx.coroutines.NonDisposableHandle.parent

class CatCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<CatCardAdapter.CatCardViewHolder>() {

    // Initialize the data using the List found in data/DataSource
    private val cats: List<Cat> = DataSource.cats

    /**
     * Initialize view elements
     */
    class CatCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView? = view.findViewById(R.id.cat_image)
        val nameTextView: TextView? = view.findViewById(R.id.cat_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)


        val itemView: View = inflater.inflate(R.layout.vertical, parent, false)


        return CatCardViewHolder(itemView)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: CatCardViewHolder, position: Int) {
        val currentCat = cats[position]

        // Set the image resource for the current dog
        holder.imageView?.setImageResource(currentCat.imageResourceId)

        // Set the text for the current dog's name
        holder.nameTextView?.text = currentCat.name

    }
}
