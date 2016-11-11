package mx.segundamano.android.notes2;

/**
 * Created by pablo on 11/11/16.
 */
public interface RepositoryCallback {
    void onSuccess(Note result);
    void onError(Throwable error);
}
