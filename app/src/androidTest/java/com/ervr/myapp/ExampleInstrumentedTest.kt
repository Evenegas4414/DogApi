package com.ervr.myapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ervr.myapp.database.AppDatabase
import com.ervr.myapp.database.BreedDao
import com.ervr.myapp.model.Breed
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    // referencias
    private lateinit var daoTest : BreedDao
    private lateinit var db: AppDatabase




    @Before
    fun setUp(){
        val context= ApplicationProvider.getApplicationContext<Context>()
        db= Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        daoTest= db.breedDao()

    }



    @After
    fun shutDown(){
        db.close()
    }
    @Test
    fun insertDogList()= runBlocking {

        val itemsEntity= listOf(

            Breed(1, "Akita"),

            )
        daoTest.insertAll(itemsEntity)
        val itemLiveData = daoTest.getAllBreeds()
        val itemList : List<Breed> = itemLiveData?: emptyList()


        MatcherAssert.assertThat(itemList, CoreMatchers.not(emptyList()))
        MatcherAssert.assertThat(itemList.size, CoreMatchers.equalTo(1))
    }
}