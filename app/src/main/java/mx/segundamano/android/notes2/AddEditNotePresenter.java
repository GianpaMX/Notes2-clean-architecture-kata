package mx.segundamano.android.notes2;

public class AddEditNotePresenter implements AddEditCallback {
    private AddEditNoteUseCase model;
    private AddEditNoteView view;

    public AddEditNotePresenter(AddEditNoteView view, AddEditNoteUseCase model) {
        this.view = view;
        this.model = model;
    }

    public void save(String body) {
        String requestModel = body;
        model.save(requestModel, this);
    }

    @Override
    public void onSuccess(Note note) {
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.body = note.body;
        noteViewModel.date = note.date.toString();

        view.onNoteSaved(noteViewModel);
    }

    @Override
    public void onError(Throwable error) {
        view.onError(error);
    }
}
