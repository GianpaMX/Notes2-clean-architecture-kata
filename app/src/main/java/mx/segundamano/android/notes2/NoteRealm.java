package mx.segundamano.android.notes2;

import io.realm.RealmObject;

public class NoteRealm extends RealmObject {
    public String body;
    public long timestamp;
}
