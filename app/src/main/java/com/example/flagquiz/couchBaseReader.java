package com.example.flagquiz;


import android.content.Context;
import android.content.res.AssetManager;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.ZipUtils;

import java.io.IOException;

public class couchBaseReader {
    private Manager manager = null;
    private Context myContext;
   private Database database;
   AssetManager mgr = null;


    public couchBaseReader(Context context)  {
        mgr = context.getResources().getAssets();
        this.myContext = context;
        try{
            manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            database = manager.getExistingDatabase("countrylist");




        } catch (IOException e) {
            e.printStackTrace();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }

        if (database == null){
            try {
                ZipUtils.unzip(mgr.open("countrylist.zip"),manager.getContext().getFilesDir() );
                database = manager.getDatabase("countrylist");
            } catch (CouchbaseLiteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("FAILED");
                e.printStackTrace();
            }
        }
    }


}
