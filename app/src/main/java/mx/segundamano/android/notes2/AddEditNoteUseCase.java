package mx.segundamano.android.notes2;

import java.util.Date;

import io.realm.Realm;

public class AddEditNoteUseCase implements RepositoryCallback {
    private NotesRepository repository;
    private AddEditCallback addEditCallback;

    public AddEditNoteUseCase(NotesRepository repository) {
        this.repository = repository;
    }

    public void save(String requestModel, final AddEditCallback addEditCallback) {
        this.addEditCallback = addEditCallback;

        /**
         * When saving a note, current date should be used
         */

        Note note = new Note();
        note.body = requestModel;
        note.date = new Date();

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
