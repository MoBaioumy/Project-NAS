package com.example.moham.zaker.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moham.zaker.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatRoomActivity extends AppCompatActivity {

    private Button sendMessageButton;
    private EditText messageInput;
    private TextView chatText;

    private String userName,roomName;
    private DatabaseReference root ;
    private String tempRandomKey;
    private String chatMessage,chatUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        // Get widgets
        sendMessageButton = (Button) findViewById(R.id.btn_send);
        messageInput = (EditText) findViewById(R.id.msg_input);
        chatText = (TextView) findViewById(R.id.txt_chat);

        // Get the username and and Chat Room Name from the previous Activity
        userName = getIntent().getExtras().get("user_name").toString();
        roomName = getIntent().getExtras().get("room_name").toString();
        setTitle(" Room - " + roomName);

        // Set the current room to be the temporary root and the messages will become the children
        root = FirebaseDatabase.getInstance().getReference().child(roomName);

        // Allow sending messages
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // generate a unique key
                Map<String,Object> map = new HashMap<String, Object>();
                tempRandomKey = root.push().getKey();
                root.updateChildren(map);

                // Add the name and message
                DatabaseReference messageRoot = root.child(tempRandomKey);
                Map<String,Object> messageMap = new HashMap<String, Object>();
                messageMap.put("name", userName);
                messageMap.put("msg", messageInput.getText().toString());

                messageRoot.updateChildren(messageMap);

                // clear entered text
                messageInput.setText("");
            }
        });

        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // When a chile is created
                appendChatConversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // When the values are changes
                appendChatConversation(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    // Iterate though all the new children and set then in the view
    private void appendChatConversation(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()){
            chatMessage = (String) ((DataSnapshot)i.next()).getValue();
            chatUserName = (String) ((DataSnapshot)i.next()).getValue();
            chatText.append(chatUserName +": "+chatMessage +" \n");
        }

    }
}
