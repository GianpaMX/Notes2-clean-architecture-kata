package mx.segundamano.android.notes2;

public interface AddEditCallback {
    void onSuccess(Note note);
    void onError(Throwable error);
}
