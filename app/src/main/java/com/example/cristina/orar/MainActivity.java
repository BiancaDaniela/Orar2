package com.example.cristina.orar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ExpandableListView;
        import android.widget.ExpandableListView.OnChildClickListener;
        import android.widget.ExpandableListView.OnGroupClickListener;
        import android.widget.ExpandableListView.OnGroupCollapseListener;
        import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();


                return false;
            }


        });


        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) listAdapter.getChild(groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.

                Intent intent;
                switch(selected){
                    case "Linia 6":
                        intent = new Intent(MainActivity.this, Linia6.class);
                        startActivity(intent);
                        break;

                    case "Linia 35":
                        intent = new Intent(MainActivity.this, Linia35.class);
                        startActivity(intent);
                        break;

                    case "Linia 25":
                        intent = new Intent(MainActivity.this, Linia25.class);
                        startActivity(intent);
                        break;

                    case "Linia 24B":
                        intent = new Intent(MainActivity.this, Linia24b.class);
                        startActivity(intent);
                        break;

                    case "Linia 43P":
                        intent = new Intent(MainActivity.this, Linia43p.class);
                        startActivity(intent);
                        break;


                    case "Linia M42":
                        intent = new Intent(MainActivity.this, LiniaM42.class);
                        startActivity(intent);
                        break;

                    case "Linia M11":
                        intent = new Intent(MainActivity.this, LiniaM11.class);
                        startActivity(intent);
                        break;

                    case "Linia M32":
                        intent = new Intent(MainActivity.this, LiniaM32.class);
                        startActivity(intent);
                        break;

                    case "Linia M26":
                        intent = new Intent(MainActivity.this, LiniaM26.class);
                        startActivity(intent);
                        break;

                    case "Linia M16":
                        intent = new Intent(MainActivity.this,LiniaM16.class);
                        startActivity(intent);
                        break;


                    case "Linia Cora 1":
                        intent = new Intent(MainActivity.this, LiniaCora1.class);
                        startActivity(intent);
                        break;

                    case "Linia Cora 2":
                        intent = new Intent(MainActivity.this, LiniaCora2.class);
                        startActivity(intent);
                        break;

                    case "Linia Cora 3":
                        intent = new Intent(MainActivity.this, LiniaCora3.class);
                        startActivity(intent);
                        break;




                }

                return true;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Linii urbane");
        listDataHeader.add("Linii metropolitane");
        listDataHeader.add("Transport Supermarket-uri");

        // Adding child data
        List<String> lurb = new ArrayList<String>();
        lurb.add("Linia 6");
        lurb.add("Linia 35");
        lurb.add("Linia 25");
        lurb.add("Linia 24B");
        lurb.add("Linia 43P");


        List<String> lmet = new ArrayList<String>();
        lmet.add("Linia M42");
        lmet.add("Linia M11");
        lmet.add("Linia M32");
        lmet.add("Linia M26");
        lmet.add("Linia M16");


        List<String> lsup = new ArrayList<String>();
        lsup.add("Linia Cora 1");
        lsup.add("Linia Cora 2");
        lsup.add("Linia Cora 3");



        listDataChild.put(listDataHeader.get(0), lurb); // Header, Child data
        listDataChild.put(listDataHeader.get(1), lmet);
        listDataChild.put(listDataHeader.get(2), lsup);
    }



}
