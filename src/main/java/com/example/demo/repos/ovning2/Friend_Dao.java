package com.example.demo.repos.ovning2;


import com.example.demo.models.ovning2.Friend;

import java.util.LinkedList;
import java.util.List;

public class Friend_Dao {

    public List<Friend> getAllFriends(){
        Friend f1 = new Friend(1, "Obi", "obivägen", "123");
        Friend f2 = new Friend(2, "Valle", "vallevägen", "456");
        Friend f3 = new Friend(3, "Lili", "lilivägen", "789");
        Friend f4 = new Friend(4, "Master", "mastervägen", "012");
        Friend f5 = new Friend(5, "Bravo", "bravovägen", "345");

        List<Friend> friendList = new LinkedList<>();
        friendList.add(f1);
        friendList.add(f2);
        friendList.add(f3);
        friendList.add(f4);
        friendList.add(f5);



        return friendList;

    }
}
