package kr.co.diordna.simplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by ryans on 2018-04-03.
 */

public class SSP {

    private static SharedPreferences mPref;

    private SSP(){}

    public static void init(Context context) {
        mPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static Editor openEdit() {
        return new Editor(mPref);
    }

    public static String getString(String key, String def) {
        return mPref.getString(key, def);
    }

    public static class Editor {

        private SharedPreferences.Editor mEditor;

        public Editor(SharedPreferences pref) {
            mEditor = pref.edit();
        }

        public Editor put(String key, String val) {
            mEditor.putString(key, val);
            return this;
        }

        public Editor put(String key, int val) {
            mEditor.putInt(key, val);
            return this;
        }

        public Editor put(String key, boolean val) {
            mEditor.putBoolean(key, val);
            return this;
        }

        public Editor put(String key, float val) {
            mEditor.putFloat(key, val);
            return this;
        }

        public Editor put(String key, long val) {
            mEditor.putLong(key, val);
            return this;
        }

        public Editor put(String key, Set<String> val) {
            mEditor.putStringSet(key, val);
            return this;
        }

        public void commit() {
            mEditor.commit();
        }

        public void apply() {
            mEditor.apply();
        }
    }

}
