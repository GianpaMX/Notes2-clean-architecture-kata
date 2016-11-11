package mx.segundamano.android.notes2;

import java.util.Date;

import io.realm.Realm;

public class RealmRepository implements NotesRepository {
    private Realm realm;

    public RealmRepository(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void persist(Note note, final RepositoryCallback repositoryCallback) {
        final NoteRealm noteRealm = new NoteRealm();
        noteRealm.body = note.body;
        noteRealm.timestamp = note.date.getTime();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.insertOrUpdate(noteRealm);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Note result = new Note();
                result.body = noteRealm.body;
                result.date = new Date(noteRealm.timestamp);

                repositoryCallback.onSuccess(result);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                repositoryCallback.onError(error);
            }
        });
    }
}
