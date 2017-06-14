package com.example.linh.realmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.linh.realmsample.models.Task;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Task task = realm.createObject(Task.class, UUID.randomUUID().toString());
                task.setTitle("Hello");
                task.setDescription("This is a description");
            }
        });
//        realm.beginTransaction();
//
//        realm.commitTransaction();

        RealmResults<Task> results = realm.where(Task.class).findAll();
        for (Task t : results){
            Timber.d("title %s", t.getTitle());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
