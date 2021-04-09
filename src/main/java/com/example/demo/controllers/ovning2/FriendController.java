package com.example.demo.controllers.ovning2;

import com.example.demo.models.ovning2.Friend;
import com.example.demo.repos.ovning2.Friend_Dao;
import com.example.demo.models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendController {


    Friend_Dao db = new Friend_Dao();
    List<Friend> myFriends = db.getAllFriends();


    @RequestMapping("/friends")
    public List<Friend> friends(){
        return myFriends;
    }

    @RequestMapping("/friends/{id}")
    public Friend getSpecificFriend(@PathVariable("id") int id){

        for (Friend f : myFriends) {
            if (f.getId() == id){
                return f;
            }
        }
        return null;
    }



    @RequestMapping("/friends/{id}/delete")
    public String deleteFriendById(@PathVariable int id){
        for (int i = 0; i < myFriends.size(); i++) {
            if (myFriends.get(i).getId() == id){
                myFriends.remove(i);
                return "Kompisen med id " + id + " är borttagen";
            }
        }
        return "Kompisen med " + id + " finns inte";
    }


    // Lektion 2
    @PostMapping("friends/add")
    public String addFriend(@RequestBody Friend f){
        myFriends.add(f);
        return "Friend added";
    }

    @PostMapping("friends/upsert")
    public Message friendUpsert(@RequestBody Friend f){
        int indexToUpdate = -1;
        for (int i = 0; i < myFriends.size(); i++) {
            if (myFriends.get(i).getId() == f.getId()){
                indexToUpdate = i;
            }
        }
        if (indexToUpdate == -1){
            myFriends.add(f);
            Message m = new Message(true, "Friend was created");
            return m;
        } else {
            myFriends.set(indexToUpdate, f);
            Message m = new Message(true, "Friend was updated");
            return m;
        }
    }

}
