package com.ganjastudio.pacekgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WikipediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikipedia);

        setupToolbar();
        setupListView();
    }

    private void setupToolbar()
    {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        String title = getResources().getString(R.string.title_wiki_activity);
        getSupportActionBar().setTitle(title);
    }

    private void setupListView() {

        final ListView listView = (ListView) findViewById(R.id.listView);

        List<String> wikiItems = Arrays.asList(this.getResources().getStringArray(R.array.wiki_array));
        Collections.sort(wikiItems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wikiItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txt = (TextView) parent.getChildAt(position - listView.getFirstVisiblePosition());



                Intent intent = new Intent(WikipediaActivity.this, WikiItemActivity.class);
                intent.putExtra("title", txt.getText());
                startActivity(intent);
            }
        });
    }
}
