package com.example.moham.zaker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TeacherCommunityActivity extends AppCompatActivity {


    private Button addRoomButton;
    private EditText roomNameInput;

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> roomList = new ArrayList<>();
    private String name;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_teacher);

        //Get Widgets
        addRoomButton = (Button) findViewById(R.id.btn_add_room);
        roomNameInput = (EditText) findViewById(R.id.input_txt_room_name);
        listView = (ListView) findViewById(R.id.listView);

        // Set adapter for the list view
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,roomList);
        listView.setAdapter(arrayAdapter);

        // preset teacher name
        name = "Philip";

        // prompt the user to enter a name
        //request_user_name();

        /**
         * In this DataBase, there is a root. In this root we can add children with (Key, value).
         * Those children will be chat rooms. Within them we will have more children. These
         * will have the user name and the message as Key and Value.
         */

        // Listener for creating a rooms
        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,Object> map = new HashMap<String, Object>();
                map.put(roomNameInput.getText().toString(),"");
                root.updateChildren(map);
            }
        });

        // listeners for when the RealTime Database changes
        root.addValueEventListener(new ValueEventListener() {
            @Override
            // once adding an entry
            public void onDataChange(DataSnapshot dataSnapshot) {
                // has SET is used in order not to have duplicate chat rooms
                Set<String> chatRoomsSet = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();

                // go through the whole database and add the new
                while (i.hasNext()){
                    chatRoomsSet.add(((DataSnapshot)i.next()).getKey());
                }
                // clear the old list and add the new ones
                roomList.clear();
                roomList.addAll(chatRoomsSet);
                arrayAdapter.notifyDataSetChanged();

                // clear entered text
                roomNameInput.setText("");
            }
            // when deleting an entry
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // listen to open up chat rooms
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),ChatRoomActivity.class);
                // keep the room name and user name for the next Activity
                intent.putExtra("room_name",((TextView)view).getText().toString() );
                intent.putExtra("user_name",name);
                startActivity(intent);
            }
        });

    }



    // Prompt the user to enter a name
//    private void request_user_name() {
//        // Show an alert to ask for the name
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Enter name:");
//
//        final EditText input_field = new EditText(this);
//
//        builder.setView(input_field);
//
//        // If a name is provided, let the user pass after pressing Ok
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                name = input_field.getText().toString();
//            }
//        });
//        // If a no name is provided, prompt again
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//                request_user_name();
//            }
//        });
//
//        builder.show();
//    }
}
