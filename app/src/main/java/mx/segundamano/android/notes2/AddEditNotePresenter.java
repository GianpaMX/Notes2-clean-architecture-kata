package mx.segundamano.android.notes2;

import io.realm.Realm;

public class AddEditNotePresenter implements Callback {
    private AddEditNoteModel model;
    private Realm realm;
    private AddEditNoteView view;

    public AddEditNotePresenter(Realm realm, AddEditNoteView view, AddEditNoteModel model) {
        this.realm = realm;
        this.view = view;
        this.model = model;
    }

    public void save(final String noteViewString) {
        Note note = new Note();
        note.body = noteViewString;

        model.save(note, this);
    }

    @Override
    public void onSuccess(Note note) {
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.body = note.body;

        view.onNoteSaved(noteViewModel);
    }

    @Override
    public void onError(Throwable error) {
        view.onError(error);
    }
}
