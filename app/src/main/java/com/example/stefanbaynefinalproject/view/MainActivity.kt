package com.example.stefanbaynefinalproject.view


/**
 * This app's purpose will be to display Digimon in multiple RecyclerViews.
 * The project will implement the architectural design patterns MVVM;
 * It implements Retrofit2 working with RESTful API using @GET and @Path;
 * It demonstrates the use of Coroutines for suspending threads off the main thread;
 * Implements navigation techniques from Activities to Activities(and eventually fragments);
 * Implements viewBinding for binding views;
 * Implements UI design techniques as well.
 */

/**
 * *************************************************************************************************
 * *************************************************************************************************
 *
 */


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.stefanbaynefinalproject.R
import com.example.stefanbaynefinalproject.adapter.DigimonCharacterAdapter
import com.example.stefanbaynefinalproject.adapter.RVMainAdapter
import com.example.stefanbaynefinalproject.recyclerviewlistitem.ListDigimonCharacters
import com.example.stefanbaynefinalproject.recyclerviewlistitem.RvMainListItem

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rvMainListItem: ArrayList<RvMainListItem>
    private lateinit var rvMainAdapter: RVMainAdapter

    private lateinit var imageForCharacters: ArrayList<ListDigimonCharacters>
    private lateinit var digimonCharacterAdapter: DigimonCharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        initAgain()
        addDataToList()

        val buttonOpenAll: Button = findViewById(R.id.btn_getall)

        /**
         * Will initialize these buttons to the new fragments later on...
        val buttonOpenName: Button = findViewById(R.id.btn_name)
        val buttonOpenLevel: Button = findViewById(R.id.btn_level)
        */

        // switch from main activity to fragment with all digimon
        buttonOpenAll.setOnClickListener {
            intent = Intent(this, ActivityTest::class.java)
            startActivity(intent)
        }
    }

    // Initializing the size and layout of the recyclerview;
    // Also initializes the list item in the recyclerview
    private fun init() {
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        rvMainListItem = ArrayList()

        rvMainAdapter = RVMainAdapter(rvMainListItem)
        recyclerView.adapter = rvMainAdapter
    }

    // Same as before but for the second recyclerview on the page
    private fun initAgain() {
        recyclerView = findViewById(R.id.rv_character)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        imageForCharacters = ArrayList()

        digimonCharacterAdapter = DigimonCharacterAdapter(imageForCharacters)
        recyclerView.adapter = digimonCharacterAdapter
    }

    // Method to add data to the list for the recyclerview
    private fun addDataToList() {
        rvMainListItem.add(RvMainListItem(R.drawable.thetismon_b))
        rvMainListItem.add(RvMainListItem(R.drawable._80px_aerovdramon))
        rvMainListItem.add(RvMainListItem(R.drawable.dianamon_dwno))
        rvMainListItem.add(RvMainListItem(R.drawable.digimonhome))
        rvMainListItem.add(RvMainListItem(R.drawable.dinohyumon_ra))
        rvMainListItem.add(RvMainListItem(R.drawable.gammamon_b))
        rvMainListItem.add(RvMainListItem(R.drawable.monodramon_dl))
        rvMainListItem.add(RvMainListItem(R.drawable.mudfrigimon_dl))
        rvMainListItem.add(RvMainListItem(R.drawable.beelzemon_bnew))
        rvMainListItem.add(RvMainListItem(R.drawable.belphemon_rage_mode_bnew))
        rvMainListItem.add(RvMainListItem(R.drawable.jellymon_tnew))
        rvMainListItem.add(RvMainListItem(R.drawable.lucemon_x_bnew))
        rvMainListItem.add(RvMainListItem(R.drawable.ogudomon_bnew))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.digimonc))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.digimonc3))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.digimonccc))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.digimoncharacters))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.trie))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.characterforrecyclerview))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.anotherimage))
        imageForCharacters.add(ListDigimonCharacters(R.drawable.lastimage))
    }
}
