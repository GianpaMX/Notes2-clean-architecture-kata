package mx.segundamano.android.notes2;

public interface Callback {
    void onSuccess(Note note);
    void onError(Throwable error);
}
