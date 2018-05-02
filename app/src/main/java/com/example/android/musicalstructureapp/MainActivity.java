/*
 * PROJECT LICENSE
 *
 * This project was submitted by Tarek Bohdima as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018  Tarek Bohdima
 *
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the ArrayList of Song Objects
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song(getString(R.string.song1), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song2), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song3), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song4), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song5), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song6), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song7), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song8), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song9), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song10), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song11), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song12), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song13), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song14), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song15), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song16), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song17), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song18), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song19), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song20), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song21), getString(R.string.artist_name), R.drawable.ic_play));
        songs.add(new Song(getString(R.string.song22), getString(R.string.artist_name), R.drawable.ic_play));


        /**
         * Create an {@link SongAdapter}, whose data source is a list of
         * {@link SongAdapter}s. The adapter knows how to create list item views for each item
         * in the list.
         */

        final SongAdapter songAdapter = new SongAdapter(this, songs);

        // Get a reference to the ListView, and attach the adapter to the listView. 
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(songAdapter);

        /*
        sets onItemClickListener to send intent
        carrying variables (song title and artist name) to the other Activity(PlayingNow)
        */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String artist = songAdapter.getItem(position).getArtistName();
                String song = songAdapter.getItem(position).getSongTitle();

                Intent i = new Intent(MainActivity.this, PlayingNow.class);
                i.putExtra("song", song);
                i.putExtra("artist", artist);

                startActivity(i);
            }
        });

    }


}
