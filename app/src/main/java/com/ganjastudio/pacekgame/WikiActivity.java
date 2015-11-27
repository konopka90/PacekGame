package com.ganjastudio.pacekgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WikiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);

        final ListView listVeiw = (ListView) findViewById(R.id.listView);

        List<String> wikiItems = Arrays.asList(this.getResources().getStringArray(R.array.wiki_array));
        Collections.sort(wikiItems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wikiItems);
        listVeiw.setAdapter(adapter);

        listVeiw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txt = (TextView)parent.getChildAt(position - listVeiw.getFirstVisiblePosition());

                Intent intent = new Intent(WikiActivity.this, WikiItemActivity.class);
                intent.putExtra("title", txt.getText());
                startActivity(intent);
            }
        });
    }


}
