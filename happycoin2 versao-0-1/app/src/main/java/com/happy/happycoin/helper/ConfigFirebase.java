package com.happy.happycoin.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfigFirebase {
    private static DatabaseReference referenceDatabase;
    private static FirebaseAuth referenceAuth;
    private static StorageReference referenceStorage;

    public static DatabaseReference getfirebase(){
        if (referenceDatabase == null){
            referenceDatabase = FirebaseDatabase.getInstance().getReference();
    }
        return referenceDatabase;
    }

    public static FirebaseAuth getFirebaseAuth (){
        if (referenceAuth == null){
            referenceAuth = FirebaseAuth.getInstance();
        }
        return referenceAuth;
    }

    public static StorageReference getStorageFirebase(){
        if (referenceStorage == null){
            referenceStorage = FirebaseStorage.getInstance().getReference();
        }
        return referenceStorage;
    }




}
