package mx.segundamano.android.notes2;

import android.widget.Toast;

import io.realm.Realm;

public class AddEditNotePresenter {
    private Realm realm;
    private AddEditNoteView view;

    public AddEditNotePresenter(Realm realm, AddEditNoteView view) {
        this.realm = realm;
        this.view = view;
    }

    public void save(String note) {
        final NoteRealm noteRealm = new NoteRealm();
        noteRealm.note = note;
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.insertOrUpdate(noteRealm);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                view.onNoteSaved("Saved!");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                view.onError("Error");
            }
        });
    }
}
