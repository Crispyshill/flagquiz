package com.example.flagquiz;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.ZipUtils;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

class couchBaseReader {


    couchBaseReader(Context context) {
        Database database;

        AssetManager mgr = context.getResources().getAssets();
        try {
            Manager manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            String[] directoryListing = mgr.list("");
            for (String child : directoryListing) {
                System.out.println("Child = " + child);
                if (child.toLowerCase().contains("quiz.zip")) {
                    System.out.println("quiz child: " + child);
                    database = manager.getExistingDatabase(FilenameUtils.removeExtension(child.toLowerCase()));
                    if (database == null) {
                        ZipUtils.unzip(mgr.open(child), manager.getContext().getFilesDir());
                        System.out.println("Putting the file in " + manager.getContext().getFilesDir());
                    }
                }
            }
            } catch(CouchbaseLiteException | IOException | NullPointerException e){
                Log.e("Damn", Log.getStackTraceString(e));
            }



    }
}

