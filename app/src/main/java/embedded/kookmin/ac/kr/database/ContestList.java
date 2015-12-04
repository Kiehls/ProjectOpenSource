package embedded.kookmin.ac.kr.database;

import android.provider.BaseColumns;

/**
 * Created by 승수 on 2015-11-22.
 */
public class ContestList {

    public static final class CreateDB implements BaseColumns {
        public static final String NAME = "name";
        public static final String TABLENAME = "address";
        public static final String CREATE =
                "CREATE TABLE " + TABLENAME + "("
                        + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT NULL, "
                + NAME + " name " + ");";
    }
}