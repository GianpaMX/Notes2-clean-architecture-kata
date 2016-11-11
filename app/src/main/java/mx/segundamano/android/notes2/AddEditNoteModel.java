package mx.segundamano.android.notes2;

import io.realm.Realm;

public class AddEditNoteModel {
    private Realm realm;

    public AddEditNoteModel(Realm realm) {
        this.realm = realm;
    }

    public void save(final Note note, final Callback callback) {
        final NoteRealm noteRealm = new NoteRealm();
        noteRealm.note = note.body;

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.insertOrUpdate(noteRealm);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                NoteViewModel viewModel = new NoteViewModel();
                viewModel.body = note.body;

                callback.onSuccess(note);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
    }
}
