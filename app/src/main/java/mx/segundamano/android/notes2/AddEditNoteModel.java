package mx.segundamano.android.notes2;

import io.realm.Realm;

public class AddEditNoteModel implements RepositoryCallback {
    private NotesRepository repository;
    private AddEditCallback addEditCallback;

    public AddEditNoteModel(NotesRepository repository) {
        this.repository = repository;
    }

    public void save(final Note note, final AddEditCallback addEditCallback) {
        this.addEditCallback = addEditCallback;

        /**
         * Here would be bussines rules
         */

        repository.persist(note, this);
    }

    @Override
    public void onSuccess(Note result) {
        addEditCallback.onSuccess(result);
    }

    @Override
    public void onError(Throwable error) {
        addEditCallback.onError(error);
    }
}
