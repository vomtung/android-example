package com.example.vmtung.example.notepad;

import android.provider.BaseColumns;

/**
 * Created by vmtung on 24/08/2017.
 */

public final class NoteContract {

    private NoteContract(){

    }

    public static class Note implements BaseColumns {
        public static final String TABLE_NAME = "Note";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
    }

}
