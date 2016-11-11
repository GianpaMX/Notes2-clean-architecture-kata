package mx.segundamano.android.notes2;

/**
 * Created by pablo on 11/11/16.
 */
public interface AddEditNoteView {
    void onNoteSaved(NoteViewModel noteViewModel);
    void onError(Throwable error);
}
